package com.example.pinoy_recipe.FilipinoCuisine

class DrinksRecipe {
    companion object{
        val SagotGulaman = mapOf(
            Pair(1,"- 1/2 cup sago pearls (tapioca pearls)"),
            Pair(2,"- 1 cup arnibal (caramelized brown sugar syrup)"),
            Pair(3,"- 1 cup gulaman (agar-agar), cubed"),
            Pair(4,"- Crushed ice"),
            Pair(5,"- Water")
        )
        val PrepareSagotGulaman = mapOf(
            Pair(1,"Cook sago pearls according to package instructions until they become translucent."),
            Pair(2,"Drain the cooked sago and rinse with cold water to remove excess starch."),
            Pair(3,"In a separate pot, prepare the gulaman according to package instructions."),
            Pair(4,"Once the gulaman has set, cut it into small cubes."),
            Pair(5,"In a glass, combine sago pearls and gulaman cubes."),
            Pair(6,"Add crushed ice."),
            Pair(7,"Pour arnibal syrup over the ice and mix well."),
            Pair(8,"Top up with cold water to desired sweetness."),
            Pair(9,"Stir and serve.")
        )
        fun getSagotGulaman(Index: Int): String {
            return SagotGulaman[Index].toString()
        }
        fun getPrepareSagotGulaman(Index: Int): String {
            return PrepareSagotGulaman[Index].toString()
        }

        val BukoPandanJuice = mapOf(
            Pair(1,"- 2 cups young coconut (buko), shredded"),
            Pair(2,"- 1 cup pandan-flavored gelatin (buko pandan jelly)"),
            Pair(3,"- 1 cup condensed milk"),
            Pair(4,"- 1 cup fresh milk"),
            Pair(5,"- Ice cubes")
        )
        val PrepareBukoPandanJuice = mapOf(
            Pair(1,"In a large mixing bowl, combine the shredded young coconut and pandan-flavored gelatin."),
            Pair(2,"Add condensed milk and fresh milk. Mix well."),
            Pair(3,"Add ice cubes to chill the drink."),
            Pair(4,"Stir before serving.")
        )
        fun getBukoPandanJuice(Index: Int): String {
            return BukoPandanJuice[Index].toString()
        }
        fun getPrepareBukoPandanJuice(Index: Int): String {
            return PrepareBukoPandanJuice[Index].toString()
        }

        val MilkTea = mapOf(
            Pair(1,"- 2-3 Taro tea bags or taro powder"),
            Pair(2,"- 1 cup hot water"),
            Pair(3,"- 1/2 cup sugar (adjust to taste)"),
            Pair(4,"- 2 cups milk"),
            Pair(5,"- Cooked tapioca pearls (optional)"),
            Pair(6,"- Ice cubes")
        )
        val PrepareMilkTea = mapOf(
            Pair(1,"Steep taro tea bags or taro powder in hot water for about 5-7 minutes."),
            Pair(2,"Remove the tea bags or strain the taro powder mixture."),
            Pair(3,"Add sugar to the taro tea and stir until dissolved."),
            Pair(4,"In a separate container, warm the milk (do not boil)."),
            Pair(5,"Mix the taro tea and milk."),
            Pair(6,"Add cooked tapioca pearls if desired."),
            Pair(7,"Pour the taro milk tea over ice cubes."),
            Pair(8,"Stir well and serve.")
        )
        fun getMilkTea(Index: Int): String {
            return MilkTea[Index].toString()
        }
        fun getPrepareMilkTea(Index: Int): String {
            return PrepareMilkTea[Index].toString()
        }

        val PineappleJuice = mapOf(
            Pair(1,"- Fresh pineapple chunks"),
            Pair(2,"- Sugar (to taste)"),
            Pair(3,"- Water"),
            Pair(4,"- Ice cubes")
        )
        val PreparePineappleJuice = mapOf(
            Pair(1,"Place fresh pineapple chunks in a blender."),
            Pair(2,"Add sugar and water to taste."),
            Pair(3,"Blend until smooth."),
            Pair(4,"Strain the juice to remove any pulp or fibers."),
            Pair(5,"Serve the pineapple juice over ice cubes.")
        )
        fun getPineappleJuice(Index: Int): String {
            return PineappleJuice[Index].toString()
        }
        fun getPreparePineappleJuice(Index: Int): String {
            return PreparePineappleJuice[Index].toString()
        }

        val IceScramble = mapOf(
            Pair(1,"- 1 cup crushed ice"),
            Pair(2,"- 1/4 cup evaporated milk"),
            Pair(3,"- 2-3 tbsp powdered chocolate or strawberry flavoring"),
            Pair(4,"- 2 tbsp sugar (adjust to taste)"),
            Pair(5,"- Evaporated milk for topping"),
            Pair(6,"- Powdered milk for topping"),
            Pair(7,"- Marshmallows (optional)"),
            Pair(8,"- Colored sprinkles (optional)")
        )
        val PrepareIceScramble = mapOf(
            Pair(1,"In a blender, combine crushed ice, evaporated milk, powdered flavoring, and sugar."),
            Pair(2,"Blend until you achieve a smooth, slushy consistency."),
            Pair(3,"Pour the ice scramble mixture into a bowl or cup."),
            Pair(4,"Drizzle with more evaporated milk and sprinkle with powdered milk."),
            Pair(5,"Add marshmallows and colored sprinkles for extra fun."),
            Pair(6,"Serve immediately.")
        )
        fun getIceScramble(Index: Int): String {
            return IceScramble[Index].toString()
        }
        fun getPrepareIceScramble(Index: Int): String {
            return PrepareIceScramble[Index].toString()
        }
    }
}