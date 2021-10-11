package com.example.linah_alkhurayyif_recipeapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_recipes.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class AddRecipes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipes)
        Viewbtn.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        Savebtn.setOnClickListener {
            var NewRecipes = RecipeDetails.Recipes(title_et.text.toString(), author_et.text.toString(),ingredients_et.text.toString(),instructions_et.text.toString())
            val progressDialog = ProgressDialog(this@AddRecipes)
            progressDialog.setMessage("Please wait")
            progressDialog.show()
            val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
            apiInterface!!.doaddRecipes(NewRecipes).enqueue(object : retrofit2.Callback<RecipeDetails.Recipes>{
                override fun onResponse(
                    call: retrofit2.Call<RecipeDetails.Recipes>,
                    response: Response<RecipeDetails.Recipes>
                ) {
                    progressDialog.dismiss()
                    title_et.setText("")
                    author_et.setText("")
                    ingredients_et.setText("")
                    instructions_et.setText("")
                    Toast.makeText(applicationContext, "Save Success!", Toast.LENGTH_SHORT).show();
                }

                override fun onFailure(call: retrofit2.Call<RecipeDetails.Recipes>, t: Throwable) {
                    progressDialog.dismiss()
                    Toast.makeText(applicationContext, ""+t.message, Toast.LENGTH_SHORT).show();
                }
            })

        }
    }
}