package com.example.pinoy_recipe.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pinoy_recipe.R
import com.example.pinoy_recipe.databinding.FragmentStartBinding


class StartFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater,container,false)
        binding.StartBtn.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            (R.id.StartBtn)->{
                findNavController().navigate(R.id.action_startFragment_to_menuFragment)
            }
        }
    }

}