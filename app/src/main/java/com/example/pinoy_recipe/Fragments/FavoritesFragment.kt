package com.example.pinoy_recipe.Fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pinoy_recipe.Adapaters.FavFoodAdapters
import com.example.pinoy_recipe.R
import com.example.pinoy_recipe.RealmDb.DataBase
import com.example.pinoy_recipe.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment(), View.OnClickListener {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var llm:LinearLayoutManager
    var index = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater,container,false)
        llm = LinearLayoutManager(this.context)
        val DataB = DataBase.queryFav()
        llm.orientation = LinearLayoutManager.HORIZONTAL
        binding.recyclerView.layoutManager = llm
        binding.recyclerView.adapter = FavFoodAdapters(DataB,requireContext())
        binding.NextButton.setOnClickListener(this)
        binding.PrevButton.setOnClickListener(this)
        binding.FPmenuBackBtn2.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View?) {
        val indexMax = binding.recyclerView.adapter?.itemCount
        when(v!!.id){
            (R.id.PrevButton)->{
                index--
                Log.e("indexMax: ", indexMax.toString())
                if (indexMax != null) {
                    if(index<0)
                        binding.recyclerView.scrollToPosition(indexMax)
                    else
                        binding.recyclerView.scrollToPosition(index)
                }

            }
            (R.id.NextButton)->{
                index++
                if (indexMax != null) {
                    if(index > indexMax)
                        binding.recyclerView.scrollToPosition(0)
                    else
                        binding.recyclerView.scrollToPosition(index)
                }

            }
            (R.id.FPmenuBackBtn2)->{
                findNavController().navigate(R.id.action_favoritesFragment_to_menuFragment)
            }
        }
    }

}