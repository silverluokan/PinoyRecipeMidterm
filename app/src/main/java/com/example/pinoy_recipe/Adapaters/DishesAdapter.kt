package com.example.pinoy_recipe.Adapaters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pinoy_recipe.Constants.FoodName
import com.example.pinoy_recipe.Constants.PICK_FOOD
import com.example.pinoy_recipe.DataMenu.DishesData
import com.example.pinoy_recipe.R
import com.example.pinoy_recipe.databinding.FoodmenuBinding

class DishesAdapter(val Dish: List<DishesData>,private var context: Context): RecyclerView.Adapter<DishesAdapter.FavFoodViewHolder>(){
    private lateinit var sharedPreference: SharedPreferences
    inner class FavFoodViewHolder(val bindingFood: FoodmenuBinding) : RecyclerView.ViewHolder(bindingFood.root) {
        fun bindDessert(Dish: DishesData){
            bindingFood.FMFoodNames.text = Dish.DishesName
            bindingFood.FMFoodDescriptions.text = Dish.DishesDescription
            bindingFood.FoodImg.setImageResource(Dish.Img)

            bindingFood.FoodBtn.setOnClickListener{
                sharedPreference = context.getSharedPreferences(PICK_FOOD, Context.MODE_PRIVATE)
                sharedPreference.edit().putString(FoodName,Dish.DishesName).apply()
                it.findNavController().navigate(R.id.action_foodPlace_to_reciperAndHowTo)
            }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavFoodViewHolder {
        return FavFoodViewHolder(FoodmenuBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FavFoodViewHolder, position: Int) {
        val EatMe = Dish[position]
        holder.bindDessert(EatMe)
    }



    override fun getItemCount(): Int {
        return Dish.size
    }
} 