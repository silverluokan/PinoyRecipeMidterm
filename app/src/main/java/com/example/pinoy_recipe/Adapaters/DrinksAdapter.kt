package com.example.pinoy_recipe.Adapaters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pinoy_recipe.Constants.FoodName
import com.example.pinoy_recipe.Constants.PICK_FOOD
import com.example.pinoy_recipe.DataMenu.DrinksData
import com.example.pinoy_recipe.Fragments.FoodPlace
import com.example.pinoy_recipe.R
import com.example.pinoy_recipe.databinding.FoodmenuBinding

class DrinksAdapter(val drinkList: List<DrinksData>,private var context: Context): RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder>() {
    private lateinit var sharedPreference: SharedPreferences
    inner class DrinksViewHolder(val bindingFood: FoodmenuBinding) : RecyclerView.ViewHolder(bindingFood.root) {
        fun bindDrinks(drinkList:DrinksData){
            bindingFood.FMFoodNames.text = drinkList.DrinksName
            bindingFood.FMFoodDescriptions.text = drinkList.DrinkDescription
            bindingFood.FoodImg.setImageResource(drinkList.Img)

            bindingFood.FoodBtn.setOnClickListener{
                sharedPreference = context.getSharedPreferences(PICK_FOOD, Context.MODE_PRIVATE)
                sharedPreference.edit().putString(FoodName,drinkList.DrinksName).apply()
                it.findNavController().navigate(R.id.action_foodPlace_to_reciperAndHowTo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksAdapter.DrinksViewHolder {
        return DrinksViewHolder(FoodmenuBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {
        val DrinkMe = drinkList[position]
        holder.bindDrinks(DrinkMe)
    }

    override fun getItemCount(): Int {
        return drinkList.size
    }

}