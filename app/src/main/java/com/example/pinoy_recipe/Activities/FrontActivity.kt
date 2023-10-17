package com.example.pinoy_recipe.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.pinoy_recipe.Constants.EMAIL
import com.example.pinoy_recipe.Constants.NAME
import com.example.pinoy_recipe.Constants.PASSWORD
import com.example.pinoy_recipe.MainActivity
import com.example.pinoy_recipe.R
import com.example.pinoy_recipe.databinding.ActivityFrontBinding

class FrontActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityFrontBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrontBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences  = getSharedPreferences("MY_USER", Context.MODE_PRIVATE)
        binding.SignInBtn.setOnClickListener(this)
        binding.SignUpBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            (R.id.SignInBtn)->{
                val EmailText = sharedPreferences.getString(EMAIL, "")
                val PasswordText = sharedPreferences.getString(PASSWORD,"")
                if(EmailText != "" || PasswordText != ""){
                    if(binding.EmailSingIn.text.toString() == EmailText && binding.PasswordSignIn.text.toString() == PasswordText){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                    else
                    {
                        Toast.makeText(applicationContext,"Email or Password is Incorrect!",Toast.LENGTH_SHORT).show()
                    }
                }
                else
                {
                    Toast.makeText(applicationContext, "No Account Found!",Toast.LENGTH_SHORT).show()
                }
            }
            (R.id.SignUpBtn)->{
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }
}