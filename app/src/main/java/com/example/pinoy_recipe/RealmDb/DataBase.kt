package com.example.pinoy_recipe.RealmDb

import com.example.pinoy_recipe.DataMenu.FavFoodData
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class FoodInfo: RealmObject {
    @PrimaryKey
    var FavFoodName = ""
    var FavFoodDTimeStamp = ""
}
object DataBase {
    val configuration = RealmConfiguration.create(setOf(FoodInfo::class))
    val realm = Realm.open(configuration)

    suspend fun write(Fname:String, FTimeStamp:String) {
        val FFName = FoodInfo().apply {
            FavFoodName = Fname
            FavFoodDTimeStamp = FTimeStamp
        }

        realm.write {
            copyToRealm(FFName)
        }

    }

    fun query(Fname: String): Boolean {
        val all: RealmResults<FoodInfo> = realm.query<FoodInfo>().find()
        var isThere = false
        all.forEach(){Unit->
            if(Unit.FavFoodName == Fname){
                isThere = true
            }
        }
        return isThere

    }

    fun queryFav(): ArrayList<FavFoodData> {
        val all: RealmResults<FoodInfo> = realm.query<FoodInfo>().find()
        val FoodFav = mutableListOf<FavFoodData>()
        all.forEach { Unit ->
            FoodFav.add(FavFoodData(Unit.FavFoodName, Unit.FavFoodDTimeStamp))
        }
        return FoodFav as ArrayList<FavFoodData>

    }


    fun delete(Fname: String){
        realm.writeBlocking {
            val results: RealmResults<FoodInfo> = this.query<FoodInfo>().find()
            results.forEach { Unit ->
                if(Unit.FavFoodName == Fname){
                    delete(Unit)
                }
            }
        }
    }



}