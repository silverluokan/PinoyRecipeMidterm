package com.example.pinoy_recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pinoy_recipe.databinding.ActivityMainBinding
import com.example.pinoy_recipe.databinding.ActivitySignUpBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}