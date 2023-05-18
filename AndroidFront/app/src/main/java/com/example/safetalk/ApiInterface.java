package com.example.safetalk;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

  @GET("tasks")
  Call<TaskResponse> getTasks();

  @DELETE("/tasks/{id}")
  Call<Void> deleteTask(@Path("id") String  id);
}
