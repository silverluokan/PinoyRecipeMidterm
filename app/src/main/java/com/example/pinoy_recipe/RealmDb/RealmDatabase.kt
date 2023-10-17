package com.example.pinoy_recipe.RealmDb


import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class FoodInfo(
    @PrimaryKey
    var FavFoodName: String = "",

    var FavFoodTimeAdded: String = ""
): RealmObject