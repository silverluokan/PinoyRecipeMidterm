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
import com.example.pinoy_recipe.DataMenu.DessertData
import com.example.pinoy_recipe.DataMenu.DrinksData
import com.example.pinoy_recipe.Fragments.FoodPlace
import com.example.pinoy_recipe.R
import com.example.pinoy_recipe.databinding.FoodmenuBinding

class DessertAdapter(val desserts: List<DessertData>,private var context: Context): RecyclerView.Adapter<DessertAdapter.DessertViewHolder>(){
    private lateinit var sharedPreference: SharedPreferences
    inner class DessertViewHolder(val bindingFood: FoodmenuBinding) : RecyclerView.ViewHolder(bindingFood.root) {
        fun bindDessert(desserts:DessertData){
            bindingFood.FMFoodNames.text = desserts.DessertName
            bindingFood.FMFoodDescriptions.text = desserts.DessertDescription
            bindingFood.FoodImg.setImageResource(desserts.img)

            bindingFood.FoodBtn.setOnClickListener{
                sharedPreference = context.getSharedPreferences(PICK_FOOD, Context.MODE_PRIVATE)
                sharedPreference.edit().putString(FoodName,desserts.DessertName).apply()
                it.findNavController().navigate(R.id.action_foodPlace_to_reciperAndHowTo)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DessertAdapter.DessertViewHolder {
        return DessertViewHolder(FoodmenuBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: DessertAdapter.DessertViewHolder, position: Int) {
        val EatMe = desserts[position]
        holder.bindDessert(EatMe)
    }

    override fun getItemCount(): Int {
        return desserts.size
    }
}