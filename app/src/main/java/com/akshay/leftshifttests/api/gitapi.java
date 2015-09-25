package com.akshay.leftshifttests.api;

import com.akshay.leftshifttests.model.gitmodel;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Akshay on 25-09-2015.
 */
public interface gitapi {
    @GET("/users/{user}")
    public void getFeed(@Path("user") String user, Callback<gitmodel> response);
}
