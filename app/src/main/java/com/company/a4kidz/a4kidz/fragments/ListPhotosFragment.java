package com.company.a4kidz.a4kidz.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.company.a4kidz.a4kidz.R;
import com.company.a4kidz.a4kidz.adapters.AdapterListPhotos;
import com.company.a4kidz.a4kidz.dtos.Memories;
import com.company.a4kidz.a4kidz.dtos.ResponseDataListDTO;
import com.company.a4kidz.a4kidz.dtos.ResponseLoginDTO;
import com.company.a4kidz.a4kidz.utils.IAPIClient;
import com.company.a4kidz.a4kidz.utils.SharedPref;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListPhotosFragment extends Fragment {

    private View view;
    private RecyclerView recyclerArtist;
    private LinearLayoutManager manager;

    public ListPhotosFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_list_photos, container, false);
        initGui(view);
        getRequestTask();
        return view;
    }

    private void initGui(View view) {
        recyclerArtist = (RecyclerView) view.findViewById(R.id.recycler_list);
        manager = new LinearLayoutManager(this.getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerArtist.setLayoutManager(manager);
    }

    private void getRequestTask() {
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Cargando");
        progressDialog.setCancelable(false);
        progressDialog.show();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(300, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS)
                .writeTimeout(300, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://api.4kidz.co/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        IAPIClient service = retrofit.create(IAPIClient.class);

        String token = "Bearer "+ SharedPref.getData(getContext(),"token");

        Call<ResponseDataListDTO> call = service.dataList(token);
        call.enqueue(new Callback<ResponseDataListDTO>() {
            @Override
            public void onResponse(Call<ResponseDataListDTO> call, Response<ResponseDataListDTO> response) {
                if(response.body() != null) {
                    recyclerArtist.setAdapter(new AdapterListPhotos(response.body().getMemories(), getActivity()));
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<ResponseDataListDTO> call, Throwable t) {
                Log.e("Error",""+t.toString());
                progressDialog.dismiss();
            }
        });

    }



}
