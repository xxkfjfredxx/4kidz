package com.company.a4kidz.a4kidz.utils;

import com.company.a4kidz.a4kidz.dtos.LoginDTO;
import com.company.a4kidz.a4kidz.dtos.ResponseDataListDTO;
import com.company.a4kidz.a4kidz.dtos.ResponseLoginDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Fred Rueda on 26/09/2018
 * Developer Fred Rueda
 * Email fredjruedao@gmail.com
 */
public interface IAPIClient {

    @POST(Endpoints.LOGIN)
    Call<ResponseLoginDTO> login(@Body LoginDTO loginDTO);

    @GET(Endpoints.GET_DATA)
    Call<ResponseDataListDTO> dataList(@Header("Authorization") String authHeader);


}
