package com.example.linah_alkhurayyif_recipeapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIInterface {
    @GET("/recipes/")
    fun doGetListRecipes(): Call<List<RecipeDetails.Recipes>>


    @POST("/recipes/")
   fun doaddRecipes(@Body userData: RecipeDetails.Recipes): Call<RecipeDetails.Recipes>
}