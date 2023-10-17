package com.example.pinoy_recipe.Adapaters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pinoy_recipe.Constants.FoodName
import com.example.pinoy_recipe.Constants.PICK_FOOD
import com.example.pinoy_recipe.DataMenu.SnacksData
import com.example.pinoy_recipe.Fragments.FoodPlace
import com.example.pinoy_recipe.R
import com.example.pinoy_recipe.databinding.FoodmenuBinding

class SnacksAdapter(val Snack: List<SnacksData>,private var context: Context): RecyclerView.Adapter<SnacksAdapter.SnackViewHolder>(){
    private lateinit var sharedPreference: SharedPreferences
    inner class SnackViewHolder(val bindingFood: FoodmenuBinding) : RecyclerView.ViewHolder(bindingFood.root) {
        fun bindDessert(Snack: SnacksData){
            bindingFood.FMFoodNames.text = Snack.SnacksName
            bindingFood.FMFoodDescriptions.text = Snack.SnacksDescription
            bindingFood.FoodImg.setImageResource(Snack.Img)

            bindingFood.FoodBtn.setOnClickListener{
                sharedPreference = context.getSharedPreferences(PICK_FOOD, Context.MODE_PRIVATE)
                sharedPreference.edit().putString(FoodName,Snack.SnacksName).apply()
                it.findNavController().navigate(R.id.action_foodPlace_to_reciperAndHowTo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnackViewHolder {
        return SnackViewHolder(FoodmenuBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: SnackViewHolder, position: Int) {
        val EatMe = Snack[position]
        holder.bindDessert(EatMe)
    }



    override fun getItemCount(): Int {
        return Snack.size
    }
}