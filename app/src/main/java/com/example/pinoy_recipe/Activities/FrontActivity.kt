package com.example.pinoy_recipe.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pinoy_recipe.Constants.ACC_INFO
import com.example.pinoy_recipe.Constants.USERNAME
import com.example.pinoy_recipe.MainActivity
import com.example.pinoy_recipe.R
import com.example.pinoy_recipe.RealmDb.AccountDB
import com.example.pinoy_recipe.databinding.ActivityFrontBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


class FrontActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var sharedPreferencesPerson: SharedPreferences
    private lateinit var binding: ActivityFrontBinding
    private lateinit var coroutine: CoroutineContext

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrontBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferencesPerson = getSharedPreferences(ACC_INFO, Context.MODE_PRIVATE)

        coroutine = Job() + Dispatchers.IO

//        val Array = AccountDB.query()
//        for(i in 0..Array.size)
//            Log.e("Arrays: ", Array[i])

        binding.SignInBtn.setOnClickListener(this)
        binding.SignUpBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            (R.id.SignInBtn)->{
                val FindEmail = AccountDB.Emailquery(binding.EmailSingIn.text.toString(),binding.PasswordSignIn.text.toString())
                if(FindEmail == true){
                    val NameOfUser = AccountDB.Namequery(binding.EmailSingIn.text.toString())
                    sharedPreferencesPerson.edit().putString(USERNAME,NameOfUser).apply()
                    Log.e("Name:", NameOfUser)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Incorrect username or password!", Toast.LENGTH_SHORT).show()
                }
            }
            (R.id.SignUpBtn)->{
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }
}