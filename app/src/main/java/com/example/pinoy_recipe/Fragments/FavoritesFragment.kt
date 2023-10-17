package com.example.pinoy_recipe.Fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pinoy_recipe.Adapaters.FavFoodAdapters
import com.example.pinoy_recipe.DataMenu.FavFoodData
import com.example.pinoy_recipe.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var FoodDataBase: ArrayList<FavFoodData>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater,container,false)
        val llm = LinearLayoutManager(this.context)
        FoodDataBase = arrayListOf()
        llm.orientation = LinearLayoutManager.HORIZONTAL
        binding.recyclerView.layoutManager = llm
        binding.recyclerView.adapter = FavFoodAdapters(FoodDataBase,requireContext())
        return binding.root
    }

}