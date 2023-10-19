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
import com.example.pinoy_recipe.Adapaters.FavFoodAdapters
import com.example.pinoy_recipe.Constants.ACC_INFO
import com.example.pinoy_recipe.Constants.USERNAME
import com.example.pinoy_recipe.R
import com.example.pinoy_recipe.RealmDb.DataBase
import com.example.pinoy_recipe.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment(), View.OnClickListener {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedPreferencesPerson: SharedPreferences
    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var llm:LinearLayoutManager
    var index = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater,container,false)
        sharedPreferencesPerson = this.requireActivity().getSharedPreferences(ACC_INFO,Context.MODE_PRIVATE)
        val UserName = sharedPreferencesPerson.getString(USERNAME,"")
        if(UserName != ""){
            val DataB = DataBase.queryFav(UserName.toString())
            binding.recyclerView.adapter = FavFoodAdapters(DataB,requireContext())
        }
        llm = LinearLayoutManager(this.context)
        llm.orientation = LinearLayoutManager.HORIZONTAL
        binding.recyclerView.layoutManager = llm
        binding.NextButton.setOnClickListener(this)
        binding.PrevButton.setOnClickListener(this)
        binding.FPmenuBackBtn2.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View?) {
        val indexMax = binding.recyclerView.adapter?.itemCount
        when(v!!.id){
            (R.id.PrevButton) -> {
                index--
                if (indexMax != null) {
                    if(index < 0) {
                        index = indexMax
                        binding.recyclerView.scrollToPosition(index)
                    }
                    else {
                        binding.recyclerView.scrollToPosition(index)
                    }
                }
            }
            (R.id.NextButton) -> {
                index++
                if (indexMax != null) {
                    if (index > indexMax) {
                        index = 0
                        binding.recyclerView.scrollToPosition(index)
                    } else {
                        binding.recyclerView.scrollToPosition(index)
                    }
                }
            }
            (R.id.FPmenuBackBtn2)->{
                findNavController().navigate(R.id.action_favoritesFragment_to_menuFragment)
            }
        }
    }

}