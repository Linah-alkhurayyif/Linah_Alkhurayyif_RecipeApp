package com.example.linah_alkhurayyif_recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val recipeInfo: ArrayList<Recipe> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add_recipes.setOnClickListener {
            intent = Intent(applicationContext, AddRecipes::class.java)
            startActivity(intent)
        }
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        val call: Call<List<RecipeDetails.Recipes>>? = apiInterface!!.doGetListRecipes()
        call?.enqueue(object : Callback<List<RecipeDetails.Recipes>> {
            override fun onResponse(
                call: Call<List<RecipeDetails.Recipes>>,
                response: Response<List<RecipeDetails.Recipes>>
            ) {
                for (recipes in response.body()!!){
                    recipeInfo.add(Recipe(recipes.title.toString(),recipes.author.toString(),recipes.ingredients.toString(),recipes.instructions.toString()))
                    Log.d("TAG","${recipes.title.toString()} ${recipes.author.toString()} ${recipes.ingredients.toString()} ${recipes.instructions.toString()}")
                }
                initializeRV()
            }

            override fun onFailure(call: Call<List<RecipeDetails.Recipes>>, t: Throwable) {
                Toast.makeText(applicationContext, ""+t.message, Toast.LENGTH_SHORT).show();
            }
        })
    }
    private fun initializeRV(){
        recycler_view.adapter = RecipeAdapter(recipeInfo)
        recycler_view.layoutManager = LinearLayoutManager(this)

    }
}