package com.company.a4kidz.a4kidz.actitys;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.company.a4kidz.a4kidz.utils.IAPIClient;
import com.company.a4kidz.a4kidz.dtos.LoginDTO;
import com.company.a4kidz.a4kidz.R;
import com.company.a4kidz.a4kidz.dtos.ResponseLoginDTO;
import com.company.a4kidz.a4kidz.utils.SharedPref;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout txInputEmail;
    TextInputLayout txInputPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txInputEmail = (TextInputLayout)findViewById(R.id.text_input_layout_email);
        txInputPass = (TextInputLayout)findViewById(R.id.text_input_layout_pass);

        Button buttonLogin = (Button)findViewById(R.id.btnLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txInputEmail.getEditText().getText().toString().equals("") && !txInputPass.getEditText().getText().toString().equals("")){
                    Login();
                }else{
                    Snackbar.make(v,"Campos vacios",Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    public void Login(){
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

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(txInputEmail.getEditText().getText().toString());
        loginDTO.setPassword(txInputPass.getEditText().getText().toString());

        IAPIClient service = retrofit.create(IAPIClient.class);
        Call<ResponseLoginDTO> call = service.login(loginDTO);

        call.enqueue(new Callback<ResponseLoginDTO>() {
            @Override
            public void onResponse(Call<ResponseLoginDTO> call, Response<ResponseLoginDTO> response) {
                if(response.body() != null) {
                    Log.e("llega", "" + response.body().toString());
                    if(response.code() == 200){
                        if(response.body().getId() != 0){
                            SharedPref.saveData(LoginActivity.this,"token",response.body().getToken());
                            Intent i = new Intent(LoginActivity.this,PrincipalActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseLoginDTO> call, Throwable t) {
                Log.e("Error ",""+t.toString());
            }
        });


    }

}
