package com.example.pinoy_recipe.RealmDb

import com.example.pinoy_recipe.DataMenu.FavFoodData
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import kotlinx.coroutines.Dispatchers

class OperationDB(private var config: RealmConfiguration){

    suspend fun InsertFood(FavFoodNames: String, FoodTimeAdd:String){
        val realm = Realm.getInstance(config)
        realm.executeTransactionAwait(Dispatchers.IO) { realmTransaction ->
            val Food = FoodInfo(FavFoodName = FavFoodNames, FavFoodTimeAdded = FoodTimeAdd)
            realmTransaction.insert(Food)
        }
    }
    suspend fun retrieveFood(): ArrayList<FavFoodData>{
        val realm = Realm.getInstance(config)
        val realmResults = arrayListOf<FavFoodData>()

        realm.executeTransactionAwait(Dispatchers.IO) { executeTransaction  ->
            realmResults.addAll(executeTransaction
                .where(FoodInfo::class.java)
                .findAll()
                .map{
                    mapFood(it)
                })
        }
        return realmResults
    }

    suspend fun removeFood(foodName : String){
        val realm = Realm.getInstance(config)
        realm.executeTransactionAwait(Dispatchers.IO){ realmTransaction ->
            val FoodToRemove = realmTransaction
                .where(FoodInfo::class.java)
                .equalTo("FavFoodName",foodName)
                .findFirst()
            FoodToRemove?.deleteFromRealm()
        }
    }

    private fun mapFood(Foods: FoodInfo): FavFoodData{
        return FavFoodData(
            FavFoodNamer = Foods.FavFoodName,
            FavFoodTimeAdd = Foods.FavFoodTimeAdded
        )
    }
}