package com.example.pinoy_recipe.FilipinoCuisine

class DessertRecipe {
    companion object {

        val HaloHalo = mapOf(
            Pair(1, "- Crushed ice"),
            Pair(
                2,
                "- Sweetened fruits (e.g., sweetened bananas, jackfruit, sweet potato, and red beans)"
            ),
            Pair(3, "- Leche flan (caramel custard)"),
            Pair(4, "- Ube halaya (purple yam jam)"),
            Pair(5, "- Kaong (sugar palm fruit)"),
            Pair(6, "- Nata de coco (coconut jelly)"),
            Pair(7, "- Sago (tapioca pearls)"),
            Pair(8, "- Pinipig (crisped rice)"),
            Pair(9, "- Evaporated milk"),
            Pair(10, "- Sugar syrup")
        )

        val PrepareHaloHalo = mapOf(
            Pair(1, "In a tall glass or bowl, layer the crushed ice."),
            Pair(2, "Add a spoonful each of the sweetened fruits, leche flan, ube halaya, kaong, nata de coco, sago, and pinipig."),
            Pair(3, "Drizzle with evaporated milk and sugar syrup."),
            Pair(4, "Mix everything together before eating. Enjoy the delightful mix of flavors and textures!")
        )


        fun getHaloHalo(Index: Int): String {
            return HaloHalo[Index].toString()
        }

        fun getPrepareHaloHalo(Index: Int): String {
            return PrepareHaloHalo[Index].toString()
        }

        val LecheFlan = mapOf(
            Pair(1, "- 10 egg yolks"),
            Pair(2, "- 1 can (14 oz) condensed milk"),
            Pair(3, "- 1 can (12 oz) evaporated milk"),
            Pair(4, "- 1 tsp vanilla extract"),
            Pair(5, "- 1 cup granulated sugar (for caramel)"),
        )

        val PrepareLecheFlan = mapOf(
            Pair(1, "Prepare the caramel by melting granulated sugar in a saucepan until it turns into a golden syrup. Pour the caramel into a llanera (a round metal mold) to coat the bottom."),
            Pair(2, "In a bowl, combine the egg yolks, condensed milk, evaporated milk, and vanilla extract. Mix well."),
            Pair(3, "Carefully pour the egg-milk mixture into the caramel-coated llanera."),
            Pair(4, "Cover the llanera with aluminum foil and steam it for about 30-40 minutes or until the flan is set."),
            Pair(5, "Let it cool, then refrigerate for a few hours or overnight."),
            Pair(6, "To serve, invert the llanera onto a plate, allowing the caramel to flow over the leche flan."),
            Pair(7, "Season with salt and pepper to taste.")
        )

        fun getLecheFlan(Index: Int): String {
            return LecheFlan[Index].toString()
        }

        fun getPrepareLecheFlan(Index: Int): String {
            return PrepareLecheFlan[Index].toString()
        }

        val BukoSalad = mapOf(
            Pair(1, "- 4 cups young coconut (buko), shredded"),
            Pair(2, "- 1 can (14 oz) fruit cocktail, drained"),
            Pair(3, "- 1 can (14 oz) sweetened condensed milk"),
            Pair(4, "- 1 cup all-purpose cream"),
            Pair(5, "- 1 cup nata de coco (coconut jelly)"),
            Pair(6, "- 1/2 cup kaong (sugar palm fruit)"),
            Pair(7, "- 1/2 cup macapuno (coconut sport)"),
            Pair(8, "- 1/2 cup grated cheese (optional)")
        )

        val PrepareBukoSalad = mapOf(
            Pair(1, "In a large mixing bowl, combine the shredded young coconut, drained fruit cocktail, nata de coco, kaong, and macapuno."),
            Pair(2, "In a separate bowl, mix the sweetened condensed milk and all-purpose cream until well combined."),
            Pair(3, "Pour the milk-cream mixture over the fruit and coconut mixture."),
            Pair(4, "Gently toss everything together until evenly coated."),
            Pair(5, "If desired, top with grated cheese before serving. Chill in the refrigerator before serving.")
        )

        fun getBukoSalad(Index: Int): String {
            return BukoSalad[Index].toString()
        }

        fun getPrepareBukoSalad(Index: Int): String {
            return PrepareBukoSalad[Index].toString()
        }

        val Taho = mapOf(
            Pair(1,"- 1 cup fresh silken tofu, cubed"),
            Pair(2,"- 1/4 cup arnibal (caramelized brown sugar syrup)"),
            Pair(3,"- 1/4 cup sago pearls (cooked tapioca pearls)")
        )

        val PrepareTaho = mapOf(
            Pair(1,"Place the cubed tofu in a serving glass or cup."),
            Pair(2,"Drizzle arnibal over the tofu."),
            Pair(3,"Top with cooked sago pearls."),
            Pair(4,"Stir well before eating to combine the flavors and textures.")
        )

        fun getTaho(Index: Int): String {
            return Taho[Index].toString()
        }

        fun getPrepareTaho(Index: Int): String {
            return PrepareTaho[Index].toString()
        }

        val MajaBlanca = mapOf(
            Pair(1,"- 2 cups coconut milk"),
            Pair(2,"- 1 cup cornstarch"),
            Pair(3,"- 1 can (14 oz) condensed milk"),
            Pair(4,"- 1 cup fresh milk"),
            Pair(5,"- 1 cup corn kernels"),
            Pair(6,"- 1/2 cup sugar"),
            Pair(7,"- Grated coconut (for topping)")
        )

        val PrepareMajaBlanca = mapOf(
            Pair(1,"In a saucepan, combine coconut milk, cornstarch, condensed milk, fresh milk, corn kernels, and sugar."),
            Pair(2,"Cook over low heat, stirring constantly until the mixture thickens and becomes smooth."),
            Pair(3,"Pour the mixture into a greased square or rectangular pan."),
            Pair(4,"Allow it to cool and set for about 30 minutes."),
            Pair(5,"Once set, sprinkle grated coconut on top."),
            Pair(6,"Cut into squares or diamonds before serving.")
        )

        fun getMajaBlanca(Index: Int): String {
            return MajaBlanca[Index].toString()
        }

        fun getPrepareMajaBlanca(Index: Int): String {
            return PrepareMajaBlanca[Index].toString()
        }
    }
}