package com.codekul.sonal.retrofit.rest;

import android.app.DownloadManager;

import com.codekul.sonal.retrofit.domain.DtoInfo;
import com.codekul.sonal.retrofit.domain.User;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by sonal on 6/12/17.
 */

public interface ApiService {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("user/RegisterUser")
    Call<ResponseBody>userRegister(@Body User user);
}
