package com.example.linah_alkhurayyif_recipeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recipes.view.*

class RecipeAdapter(private val recipeInfo: ArrayList<Recipe>): RecyclerView.Adapter<RecipeAdapter.ItemViewHolder>(){
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recipes,
                parent,
                false ))}
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val recipe = recipeInfo[position]
        holder.itemView.apply {
            title.text = recipe.title
            author.text = recipe.author
            ingredients.text =recipe.ingredients
            instructions.text =recipe.instructions
        }
    }
    override fun getItemCount() = recipeInfo.size
}