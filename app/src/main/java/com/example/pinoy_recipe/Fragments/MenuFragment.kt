package com.example.pinoy_recipe.Fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pinoy_recipe.Constants.ACC_INFO
import com.example.pinoy_recipe.Constants.FoodCategory
import com.example.pinoy_recipe.Constants.PICK_FOOD
import com.example.pinoy_recipe.Constants.USERNAME
import com.example.pinoy_recipe.R
import com.example.pinoy_recipe.RealmDb.DataBase
import com.example.pinoy_recipe.databinding.FragmentMenuBinding

class MenuFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedPreferencesPerson: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater,container,false)
        binding.MenuBackBtn.setOnClickListener(this)
        binding.MenuDessertBtn.setOnClickListener(this)
        binding.MenuDishesBtn.setOnClickListener(this)
        binding.MenuDrinksBtn.setOnClickListener(this)
        binding.MenuSnacksBtn.setOnClickListener(this)
        binding.FavoriteBtn.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(p0: View?) {
        sharedPreferences = this.requireActivity().getSharedPreferences(PICK_FOOD, Context.MODE_PRIVATE)
        sharedPreferencesPerson = this.requireActivity().getSharedPreferences(ACC_INFO, Context.MODE_PRIVATE)
        when(p0!!.id){
            (R.id.MenuBackBtn)->{
                findNavController().navigate(R.id.action_menuFragment_to_startFragment)
            }
            (R.id.MenuDessertBtn)->{
                sharedPreferences.edit().putString(FoodCategory,"Desserts").apply()
                findNavController().navigate(R.id.action_menuFragment_to_foodPlace)
            }
            (R.id.MenuDishesBtn)->{
                sharedPreferences.edit().putString(FoodCategory,"Dishes").apply()
                findNavController().navigate(R.id.action_menuFragment_to_foodPlace)
            }
            (R.id.MenuDrinksBtn)->{
                sharedPreferences.edit().putString(FoodCategory,"Drinks").apply()
                findNavController().navigate(R.id.action_menuFragment_to_foodPlace)
            }
            (R.id.MenuSnacksBtn)->{
                sharedPreferences.edit().putString(FoodCategory,"Snacks").apply()
                findNavController().navigate(R.id.action_menuFragment_to_foodPlace)
            }
            (R.id.FavoriteBtn)->{
                if(sharedPreferencesPerson.getString(USERNAME,"").toString() != "") {
                    val queryFavorites = DataBase.queryFav(sharedPreferencesPerson.getString(USERNAME, "").toString())
                    if (queryFavorites.isEmpty()) {
                        Toast.makeText(requireContext(), "There are no favorites!", Toast.LENGTH_SHORT).show()
                    } else {
                        findNavController().navigate(R.id.action_menuFragment_to_favoritesFragment)
                    }
                }
            }
        }
    }
}