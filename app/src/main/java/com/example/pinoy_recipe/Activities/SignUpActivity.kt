package com.example.pinoy_recipe.Activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pinoy_recipe.R
import com.example.pinoy_recipe.RealmDb.AccountDB
import com.example.pinoy_recipe.databinding.ActivitySignUpBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var coroutine: CoroutineContext
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        coroutine = Job() + Dispatchers.IO
        binding.UserSignUpBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            (R.id.UserSignUpBtn)->{
                if(binding.UserNameSignUpText.text.toString() != "" && binding.UserEmailSignUpText.text.toString() != "" && binding.PasswordSignUpText.text.toString() != ""){
                    val scope = CoroutineScope(coroutine)
                    scope.launch(Dispatchers.IO){
                        withContext(Dispatchers.Main) {
                            AccountDB.writeAccount(binding.UserNameSignUpText.text.toString(),binding.UserEmailSignUpText.text.toString(),binding.PasswordSignUpText.text.toString())
                            Toast.makeText(applicationContext, "Sign Up Success", Toast.LENGTH_SHORT).show()
                        }
                    }
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