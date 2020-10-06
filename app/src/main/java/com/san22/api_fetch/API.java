package com.san22.api_fetch;

import com.san22.api_fetch.model.Images;
import com.san22.api_fetch.model.MyPojo;

import java.util.List;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

interface API {
    @Headers("Content-Type:application/json")
    @GET("/machine-task/machine-task.php")
    Call<MyPojo> getitems();
}
