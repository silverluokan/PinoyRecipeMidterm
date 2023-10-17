package com.example.pinoy_recipe.Fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pinoy_recipe.Adapaters.DessertAdapter
import com.example.pinoy_recipe.Adapaters.DishesAdapter
import com.example.pinoy_recipe.Adapaters.DrinksAdapter
import com.example.pinoy_recipe.Adapaters.SnacksAdapter
import com.example.pinoy_recipe.Constants.FoodCategory
import com.example.pinoy_recipe.Constants.PICK_FOOD
import com.example.pinoy_recipe.Lists.DessertList
import com.example.pinoy_recipe.Lists.DishesList
import com.example.pinoy_recipe.Lists.DrinkList
import com.example.pinoy_recipe.Lists.SnackList
import com.example.pinoy_recipe.R
import com.example.pinoy_recipe.databinding.FragmentFoodPlaceBinding


class FoodPlace : Fragment(), View.OnClickListener {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: FragmentFoodPlaceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodPlaceBinding.inflate(inflater,container,false)
        sharedPreferences = this.requireActivity().getSharedPreferences(PICK_FOOD, Context.MODE_PRIVATE)
        val FoodCateg = sharedPreferences.getString(FoodCategory,"")
        val llm = LinearLayoutManager(this.context)
        llm.orientation = LinearLayoutManager.VERTICAL
        binding.FoodOrDrinksRecycler.layoutManager = llm
        binding.textView6.text = FoodCateg
        FoodCategSelector(FoodCateg)
        binding.FPmenuBackBtn.setOnClickListener(this)
        return binding.root
    }
    fun FoodCategSelector(FoodCateg: String?) {
        when(FoodCateg){
            ("Dishes")->{
                binding.FoodOrDrinksRecycler.adapter = DishesAdapter(DishesList.dishesList,requireContext())
            }
            ("Drinks")->{
                binding.FoodOrDrinksRecycler.adapter = DrinksAdapter(DrinkList.drinksList,requireContext())
            }
            ("Snacks")->{
                binding.FoodOrDrinksRecycler.adapter = SnacksAdapter(SnackList.snackList,requireContext())
            }
            ("Desserts")->{
                binding.FoodOrDrinksRecycler.adapter = DessertAdapter(DessertList.dessertList,requireContext())
            }
        }
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            (R.id.FPmenuBackBtn)->{
                findNavController().navigate(R.id.action_foodPlace_to_menuFragment)
            }
        }
    }

    fun btnClickLesitenerFindNav(){
        findNavController().navigate(R.id.action_foodPlace_to_reciperAndHowTo)
    }

}