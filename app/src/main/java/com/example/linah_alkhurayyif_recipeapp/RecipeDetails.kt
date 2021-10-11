package com.example.linah_alkhurayyif_recipeapp

import com.google.gson.annotations.SerializedName

class RecipeDetails {
    var data: List<Recipes>? =null
    class Recipes{
        @SerializedName("title")
        var title: String? =null
        @SerializedName("author")
        var author: String? =null
        @SerializedName("ingredients")
        var ingredients: String? =null
        @SerializedName("instructions")
        var instructions: String? =null
        constructor(title: String?, author: String?,ingredients: String?, instructions: String?) {
            this.title = title
            this.author = author
            this.ingredients = ingredients
            this.instructions = instructions
        }
    }
}