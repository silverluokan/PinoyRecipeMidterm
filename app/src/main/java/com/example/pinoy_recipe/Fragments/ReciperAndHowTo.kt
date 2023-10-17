package com.example.pinoy_recipe.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pinoy_recipe.Constants.FoodCategory
import com.example.pinoy_recipe.Constants.FoodName
import com.example.pinoy_recipe.Constants.PICK_FOOD
import com.example.pinoy_recipe.FilipinoCuisine.DessertRecipe
import com.example.pinoy_recipe.FilipinoCuisine.DishesRecipe
import com.example.pinoy_recipe.FilipinoCuisine.DrinksRecipe
import com.example.pinoy_recipe.FilipinoCuisine.SnacksRecipe
import com.example.pinoy_recipe.Lists.DessertList
import com.example.pinoy_recipe.Lists.DishesList
import com.example.pinoy_recipe.Lists.DrinkList
import com.example.pinoy_recipe.Lists.SnackList
import com.example.pinoy_recipe.R
import com.example.pinoy_recipe.RealmDb.OperationDB
import com.example.pinoy_recipe.RealmDb.RealmConfig
import com.example.pinoy_recipe.databinding.FragmentReciperAndHowToBinding
import io.realm.kotlin.RealmConfiguration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import kotlin.coroutines.CoroutineContext


class ReciperAndHowTo : Fragment(), View.OnClickListener {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedPreferencesFav: SharedPreferences
    private lateinit var binding: FragmentReciperAndHowToBinding
    private lateinit var config: RealmConfiguration
    private lateinit var operation: OperationDB
    private lateinit var coroutine: CoroutineContext

    var MinIndexRecipe = 1
    var MinIndexHowto = 1
    var OneTime = 1;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReciperAndHowToBinding.inflate(inflater,container,false)
        binding.PrevStep.setOnClickListener(this)
        binding.PrevIngred.setOnClickListener(this)
        binding.NextStep.setOnClickListener(this)
        binding.NextIngred.setOnClickListener(this)
        binding.FavBtn.setOnClickListener(this)
        binding.imageButton.setOnClickListener(this)
        sharedPreferences = this.requireActivity().getSharedPreferences(PICK_FOOD, Context.MODE_PRIVATE)
        binding.FoodNames.text = sharedPreferences.getString(FoodName, "")


        config = RealmConfig.getConfiguration()
        operation = OperationDB(config)
        coroutine = Job() + Dispatchers.IO

        PictureSettler()
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(p0: View?) {
        when(p0!!.id){
            (R.id.PrevIngred)->{
                MinIndexRecipe--
                OperationDish()
            }
            (R.id.PrevStep)->{
                MinIndexHowto--
                OperationDish()
            }
            (R.id.NextIngred)->{
                MinIndexRecipe++
                OperationDish()
            }
            (R.id.NextStep)->{
                MinIndexHowto++
                OperationDish()
            }
            (R.id.FavBtn)->{
                val current = LocalDateTime.now()
                if(binding.FavBtn.tag.equals("favorite")) {
                    binding.FavBtn.setImageResource(R.drawable.start_favorite)
                    binding.FavBtn.tag = "favorited"
                    addFood(
                        binding.FoodNames.text.toString(),
                        current.toString()
                    )
                }
                else{
                    binding.FavBtn.setImageResource(R.drawable.start_unfavorite)
                    binding.FavBtn.tag = "favorited"
                    removeFood(binding.FoodNames.text.toString())
                }
            }
            (R.id.imageButton)->{
                findNavController().navigate(R.id.action_reciperAndHowTo_to_foodPlace)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun OperationDish() {
        when(sharedPreferences.getString(FoodCategory, "").toString()){
            "Dishes"->{ Dishes() }
            "Dessert"->{ Dessert() }
            "Snacks"->{ Snacks() }
            "Drinks"->{ Drinks() }
        }
    }
    @SuppressLint("SetTextI18n")
    fun Dishes(){
        when(binding.FoodNames.text){
            ("Adobo")->{
                CheckIndexes(DishesRecipe.Adobo.size,DishesRecipe.AdoboCook.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DishesRecipe.getAdobo(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": \n"+DishesRecipe.getHowToAdobo(MinIndexHowto)
            }
            ("Sinigang")->{
                CheckIndexes(DishesRecipe.Sinigang.size,DishesRecipe.SinigangCook.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DishesRecipe.getSinigang(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": "+DishesRecipe.getHowToSinigang(MinIndexHowto)
            }
            ("Kare-Kare")->{
                CheckIndexes(DishesRecipe.KareKare.size,DishesRecipe.KareKareCook.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DishesRecipe.getKareKare(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": \n"+DishesRecipe.getHowToKareKare(MinIndexHowto)
            }
            ("Sisig")->{
                CheckIndexes(DishesRecipe.Sisig.size,DishesRecipe.SisigCook.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DishesRecipe.getSisig(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": \n"+DishesRecipe.getHowToSisig(MinIndexHowto)
            }
            ("Dinuguan")->{
                CheckIndexes(DishesRecipe.Dinuguan.size,DishesRecipe.DinuguanCook.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DishesRecipe.getDinuguan(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+":\n"+DishesRecipe.getHowToDinuguan(MinIndexHowto)
            }
        }
    }
    @SuppressLint("SetTextI18n")
    fun Dessert(){
        when(binding.FoodNames.text){
            ("Halo-Halo")->{
                CheckIndexes(DessertRecipe.HaloHalo.size,DessertRecipe.PrepareHaloHalo.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DessertRecipe.getHaloHalo(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": \n"+DessertRecipe.getPrepareHaloHalo(MinIndexHowto)
            }
            ("Leche Flan")->{
                CheckIndexes(DessertRecipe.LecheFlan.size,DessertRecipe.PrepareLecheFlan.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DessertRecipe.getLecheFlan(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": "+DessertRecipe.getPrepareLecheFlan(MinIndexHowto)
            }
            ("Buko Salad")->{
                CheckIndexes(DessertRecipe.BukoSalad.size,DessertRecipe.PrepareBukoSalad.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DessertRecipe.getBukoSalad(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": \n"+DessertRecipe.getPrepareBukoSalad(MinIndexHowto)
            }
            ("Taho")->{
                CheckIndexes(DessertRecipe.Taho.size,DessertRecipe.PrepareTaho.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DessertRecipe.getTaho(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": \n"+DessertRecipe.getPrepareTaho(MinIndexHowto)
            }
            ("Maja Blanca")->{
                CheckIndexes(DessertRecipe.MajaBlanca.size,DessertRecipe.PrepareMajaBlanca.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DessertRecipe.getMajaBlanca(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+":\n"+DessertRecipe.getPrepareMajaBlanca(MinIndexHowto)
            }
        }
    }
    @SuppressLint("SetTextI18n")
    fun Snacks(){
        when(binding.FoodNames.text){
            ("Lumpiang Shanghai")->{
                CheckIndexes(SnacksRecipe.LumpiangShanghai.size,SnacksRecipe.PrepareLumpiangShanghai.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+SnacksRecipe.getLumpiangShanghai(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": \n"+SnacksRecipe.getPrepareLumpiangShanghai(MinIndexHowto)
            }
            ("Puto Bumbong")->{
                CheckIndexes(SnacksRecipe.PutoBumbong.size,SnacksRecipe.PreparePutoBumbong.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+SnacksRecipe.getPutoBumbong(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": "+SnacksRecipe.getPreparePutoBumbong(MinIndexHowto)
            }
            ("Banana Cue")->{
                CheckIndexes(SnacksRecipe.BananaCue.size,SnacksRecipe.PrepareBananaCue.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+SnacksRecipe.getBananaCue(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": \n"+SnacksRecipe.getPrepareBananaCue(MinIndexHowto)
            }
            ("Ensaymada")->{
                CheckIndexes(SnacksRecipe.Ensaymada.size,SnacksRecipe.PrepareEnsaymada.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+SnacksRecipe.getEnsaymada(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": \n"+SnacksRecipe.getPrepareEnsaymada(MinIndexHowto)
            }
            ("Pancit Palabok")->{
                CheckIndexes(SnacksRecipe.PancitPalabok.size,SnacksRecipe.PreparePancitPalabok.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+SnacksRecipe.getPancitPalabok(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+":\n"+SnacksRecipe.getPreparePancitPalabok(MinIndexHowto)
            }
        }
    }
    @SuppressLint("SetTextI18n")
    fun Drinks(){
        when(binding.FoodNames.text){
            ("Sago't Gulaman")->{
                CheckIndexes(DrinksRecipe.SagotGulaman.size,DrinksRecipe.PrepareSagotGulaman.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DrinksRecipe.getSagotGulaman(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": \n"+DrinksRecipe.getPrepareSagotGulaman(MinIndexHowto)
            }
            ("Buko Pandan Juice")->{
                CheckIndexes(DrinksRecipe.BukoPandanJuice.size,DrinksRecipe.PrepareBukoPandanJuice.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DrinksRecipe.getBukoPandanJuice(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": "+DrinksRecipe.getPrepareBukoPandanJuice(MinIndexHowto)
            }
            ("Milk Tea (Taro)")->{
                CheckIndexes(DrinksRecipe.MilkTea.size,DrinksRecipe.PrepareMilkTea.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DrinksRecipe.getMilkTea(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": \n"+DrinksRecipe.getPrepareMilkTea(MinIndexHowto)
            }
            ("Pineapple Juice")->{
                CheckIndexes(DrinksRecipe.PineappleJuice.size,DrinksRecipe.PreparePineappleJuice.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DrinksRecipe.getPineappleJuice(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+": \n"+DrinksRecipe.getPreparePineappleJuice(MinIndexHowto)
            }
            ("Ice Scramble")->{
                CheckIndexes(DrinksRecipe.IceScramble.size,DrinksRecipe.PrepareIceScramble.size)
                binding.IngredText.text = "Ingredient "+MinIndexRecipe+": \n"+DrinksRecipe.getIceScramble(MinIndexRecipe)
                binding.HowToText.text = "Step "+MinIndexHowto+":\n"+DrinksRecipe.getPrepareIceScramble(MinIndexHowto)
            }
        }
    }

    fun CheckIndexes(Recipe:Int,Steps:Int){
        if(OneTime == 1){
            MinIndexRecipe = 1
            MinIndexHowto = 1
            OneTime++
        }
        else {
            if (MinIndexRecipe > Recipe) {
                MinIndexRecipe = 1
            } else if (MinIndexRecipe < 1) {
                MinIndexRecipe = Recipe
            }
            if (MinIndexHowto > Steps) {
                MinIndexHowto = 1
            } else if (MinIndexHowto < 1) {
                MinIndexHowto = Steps
            }
        }
    }

    fun PictureSettler(){

        when(sharedPreferences.getString(FoodCategory, "").toString()){
            "Dishes"->{
                for(i in 0..4){
                    if(DishesList.dishesList[i].DishesName == binding.FoodNames.text){
                        binding.FoodPic.setImageResource(DishesList.dishesList[i].Img)
                    }
                }
            }
            "Dessert"->{
                for(i in 0..4){
                    if(DessertList.dessertList[i].DessertName == binding.FoodNames.text){
                        binding.FoodPic.setImageResource(DessertList.dessertList[i].img)
                    }
                }
            }
            "Snacks"->{
                for(i in 0..4){
                    if(SnackList.snackList[i].SnacksName == binding.FoodNames.text){
                        binding.FoodPic.setImageResource(SnackList.snackList[i].Img)
                    }
                }
            }
            "Drinks"->{
                for(i in 0..4){
                    if(DrinkList.drinksList[i].DrinksName == binding.FoodNames.text){
                        binding.FoodPic.setImageResource(DrinkList.drinksList[i].Img)
                    }
                }
            }
        }
    }

    fun addFood(FoodN: String, FoodAdded: String) {
        val scope = CoroutineScope(coroutine)
        scope.launch(Dispatchers.IO){
            operation.InsertFood(FoodN,FoodAdded)
            withContext(Dispatchers.Main){
            }
        }
    }
    fun removeFood(FoodNR: String) {
        val scope = CoroutineScope(coroutine)
        scope.launch(Dispatchers.IO){
            operation.removeFood(FoodNR)
        }
    }
}