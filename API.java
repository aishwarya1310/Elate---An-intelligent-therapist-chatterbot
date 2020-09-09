package com.example.hp.elate;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by HP on 05-04-2018.
 */
public interface API
{
    String Base_URL = "http://192.168.43.227:9000/person/";

  //  @GET("all")
    //Call<List<Demo>> getPersons();

    @GET("demointent")
    Call<String> getStringResponse();

    @POST("posts")
    Call<JsonObject> getMessage(@Body JsonObject message);


}
