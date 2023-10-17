package com.example.pinoy_recipe.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.SigningInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.pinoy_recipe.Constants.EMAIL
import com.example.pinoy_recipe.Constants.NAME
import com.example.pinoy_recipe.Constants.PASSWORD
import com.example.pinoy_recipe.R
import com.example.pinoy_recipe.databinding.ActivityFrontBinding
import com.example.pinoy_recipe.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences  = getSharedPreferences("MY_USER", Context.MODE_PRIVATE)
        binding.UserSignUpBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            (R.id.UserSignUpBtn)->{
                if(binding.UserNameSignUpText.text.toString() != "" && binding.UserEmailSignUpText.text.toString() != "" && binding.PasswordSignUpText.text.toString() != ""){
                    val editor = sharedPreferences.edit()
                    editor.putString(NAME, binding.UserNameSignUpText.text.toString())
                    editor.putString(EMAIL, binding.UserEmailSignUpText.text.toString())
                    editor.putString(PASSWORD, binding.PasswordSignUpText.text.toString())
                    editor.apply()

                    Toast.makeText(applicationContext, "Sign Up Success", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, FrontActivity::class.java)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(applicationContext, "Fill up everything!", Toast.LENGTH_SHORT).show()
                }


            }
        }
    }
}