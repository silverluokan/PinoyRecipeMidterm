package com.example.pinoy_recipe.RealmDb

import io.realm.kotlin.RealmConfiguration

private const val realmVersion = 1L

object RealmConfig {
    fun getConfiguration(): RealmConfiguration {
        return RealmConfiguration.Builder(setOf(FoodInfo::class))
            .schemaVersion(realmVersion)
            .deleteRealmIfMigrationNeeded()
            .build()
    }
}