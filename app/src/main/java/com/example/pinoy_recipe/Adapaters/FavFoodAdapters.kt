package com.example.pinoy_recipe.Adapaters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pinoy_recipe.Constants.PICK_FOOD
import com.example.pinoy_recipe.DataMenu.FavFoodData
import com.example.pinoy_recipe.Lists.DessertList
import com.example.pinoy_recipe.Lists.DishesList
import com.example.pinoy_recipe.Lists.DrinkList
import com.example.pinoy_recipe.Lists.SnackList
import com.example.pinoy_recipe.databinding.FavfoodViewBinding
import java.io.Serializable

class FavFoodAdapters(var FavFoo: ArrayList<FavFoodData>, private var context: Context): RecyclerView.Adapter<FavFoodAdapters.FavFoodViewHolder>(),Serializable{
    private lateinit var sharedPreference: SharedPreferences
    inner class FavFoodViewHolder(val bindingFood: FavfoodViewBinding) : RecyclerView.ViewHolder(bindingFood.root) {
        fun bindFavFoods(favFood: FavFoodData){
            bindingFood.FavFoodN.text = favFood.FavFoodNamer
            bindingFood.FavFoodAdded.text = favFood.FavFoodTimeAdd
            sharedPreference = context.getSharedPreferences(PICK_FOOD, Context.MODE_PRIVATE)
            for(i in 0..4){
                if(DishesList.dishesList[i].DishesName == bindingFood.FavFoodN.text){
                    bindingFood.FavFoodP.setImageResource(DishesList.dishesList[i].Img)
                }
            }
            for(i in 0..4){
                if(DessertList.dessertList[i].DessertName == bindingFood.FavFoodN.text){
                    bindingFood.FavFoodP.setImageResource(DessertList.dessertList[i].img)
                }
            }
            for(i in 0..4){
                if(SnackList.snackList[i].SnacksName == bindingFood.FavFoodN.text){
                    bindingFood.FavFoodP.setImageResource(SnackList.snackList[i].Img)
                }
            }
            for(i in 0..4){
                if(DrinkList.drinksList[i].DrinksName == bindingFood.FavFoodN.text){
                    bindingFood.FavFoodP.setImageResource(DrinkList.drinksList[i].Img)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavFoodAdapters.FavFoodViewHolder {
        return FavFoodViewHolder(FavfoodViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return FavFoo.size
    }

    override fun onBindViewHolder(holder: FavFoodAdapters.FavFoodViewHolder, position: Int) {
        val EatorDrinkMe = FavFoo[position]
        holder.bindFavFoods(EatorDrinkMe)
    }

    fun updateData(FavFoo: List<FavFoodData>){
        this.FavFoo = arrayListOf()
        notifyDataSetChanged()
        this.FavFoo.addAll(FavFoo)
        this.notifyItemInserted(this.FavFoo.size)
    }
}