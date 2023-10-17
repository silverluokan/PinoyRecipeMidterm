package com.example.pinoy_recipe.FilipinoCuisine

class SnacksRecipe {
    companion object {
        val LumpiangShanghai = mapOf(
            Pair(1, "- 1 lb ground pork"),
            Pair(2, "- 1/2 cup finely chopped carrots"),
            Pair(3, "- 1/2 cup finely chopped onions"),
            Pair(4, "- 2 cloves garlic, minced"),
            Pair(5, "- 1/2 cup finely chopped green onions"),
            Pair(6, "- 1 egg"),
            Pair(7, "- Lumpia wrappers (spring roll wrappers)"),
            Pair(8, "- Salt and pepper to taste"),
            Pair(9, "- Cooking oil for frying")
        )
        val PrepareLumpiangShanghai = mapOf(
            Pair(1, "In a bowl, combine ground pork, carrots, onions, garlic, and green onions."),
            Pair(2, "Season the mixture with salt and pepper."),
            Pair(3, "Beat the egg and add it to the mixture as a binding agent."),
            Pair(4, "Take a lumpia wrapper and place a spoonful of the filling on one end."),
            Pair(5, "Roll it tightly, folding the sides in as you go."),
            Pair(6, "Seal the lumpia by moistening the edge with water."),
            Pair(7, "Repeat until all the lumpia are wrapped."),
            Pair(
                8,
                "Heat oil in a pan and deep-fry the lumpia until they are golden brown and crispy."
            ),
            Pair(9, "Drain excess oil on paper towels before serving.")
        )
        fun getLumpiangShanghai(Index: Int): String {
            return LumpiangShanghai[Index].toString()
        }
        fun getPrepareLumpiangShanghai(Index: Int): String {
            return PrepareLumpiangShanghai[Index].toString()
        }

        val PutoBumbong = mapOf(
            Pair(1, "- 2 cups glutinous rice (malagkit)"),
            Pair(2, "- 1/2 cup purple yam (ube) powder"),
            Pair(3, "- 2 cups water"),
            Pair(4, "- Banana leaves, cut into rectangles"),
            Pair(5, "- Grated coconut"),
            Pair(6, "- Muscovado sugar")
        )
        val PreparePutoBumbong = mapOf(
            Pair(1, "Soak the glutinous rice in water for at least 4 hours or overnight."),
            Pair(2, "Drain the rice and mix it with the ube powder."),
            Pair(3, "Grind the rice mixture until it becomes a smooth batter."),
            Pair(
                4,
                "Place a small amount of the batter on a piece of banana leaf and roll it into a cylinder shape, sealing the edges."
            ),
            Pair(5, "Steam the puto bumbong for about 10-15 minutes until cooked."),
            Pair(6, "Serve hot, topped with grated coconut and muscovado sugar.")
        )
        fun getPutoBumbong(Index: Int): String {
            return PutoBumbong[Index].toString()
        }
        fun getPreparePutoBumbong(Index: Int): String {
            return PreparePutoBumbong[Index].toString()
        }

        val BananaCue = mapOf(
            Pair(1, "- Ripe saba bananas, peeled and cut into halves"),
            Pair(2, "- Brown sugar"),
            Pair(3, "- Cooking oil"),
            Pair(4, "- Wooden skewers")
        )
        val PrepareBananaCue = mapOf(
            Pair(1, "Skewer the banana halves onto the wooden skewers."),
            Pair(2, "Heat cooking oil in a pan and add brown sugar."),
            Pair(3, "Allow the sugar to caramelize."),
            Pair(4, "Once the sugar has caramelized, add the skewered bananas."),
            Pair(5, "Fry the bananas until they are coated with caramel and turn golden brown."),
            Pair(6, "Remove the banana cue from the pan and let them cool before serving.")
        )
        fun getBananaCue(Index: Int): String {
            return BananaCue[Index].toString()
        }
        fun getPrepareBananaCue(Index: Int): String {
            return PrepareBananaCue[Index].toString()
        }

        val Ensaymada = mapOf(
            Pair(1, "- 12 pieces ensaymada bread (sweet bread)"),
            Pair(2, "- 1/2 cup unsalted butter, softened"),
            Pair(3, "- 1 cup grated Edam or Cheddar cheese"),
            Pair(4, "- 1 cup granulated sugar"),
            Pair(5, "- Grated cheese for topping")
        )
        val PrepareEnsaymada = mapOf(
            Pair(1, "Preheat the oven to 350°F (175°C)."),
            Pair(2, "Slice each ensaymada in half horizontally."),
            Pair(
                3,
                "Spread softened butter on each half and sprinkle with sugar and grated cheese."
            ),
            Pair(4, "Place the ensaymada halves on a baking sheet."),
            Pair(
                5,
                "Bake in the preheated oven for about 5-10 minutes or until the cheese and sugar melt and the bread is lightly toasted."
            ),
            Pair(6, "Remove from the oven and sprinkle with more grated cheese before serving.")
        )
        fun getEnsaymada(Index: Int): String {
            return Ensaymada[Index].toString()
        }
        fun getPrepareEnsaymada(Index: Int): String {
            return PrepareEnsaymada[Index].toString()
        }

        val PancitPalabok = mapOf(
            Pair(1, "- 8 oz rice noodles (bihon)"),
            Pair(2, "- 1/2 lb cooked shrimp"),
            Pair(3, "- 1/2 lb ground pork"),
            Pair(4, "- 2 cups shrimp broth (from boiling the shrimp shells)"),
            Pair(5, "- 2 tbsp cooking oil"),
            Pair(6, "- 1/2 cup tinapa (smoked fish), flaked"),
            Pair(7, "- 2 tbsp annatto powder (achuete)"),
            Pair(8, "- 2 tbsp fish sauce (patis)"),
            Pair(9, "- Chicharrón (crispy pork skin) for topping"),
            Pair(10, "- Sliced boiled eggs"),
            Pair(11, "- Sliced green onions"),
            Pair(12, "- Calamansi or lemon wedges")
        )
        val PreparePancitPalabok = mapOf(
            Pair(1, "Boil the rice noodles until tender. Drain and set aside."),
            Pair(2, "In a pan, heat cooking oil and sauté the ground pork until browned."),
            Pair(3, "Add annatto powder and shrimp broth, then bring to a simmer."),
            Pair(4, "Add fish sauce and cook until the sauce thickens."),
            Pair(5, "To assemble, place the cooked rice noodles on a serving platter."),
            Pair(6, "Pour the sauce over the noodles."),
            Pair(
                7,
                "Top with cooked shrimp, tinapa flakes, chicharrón, boiled eggs, green onions, and calamansi or lemon wedges."
            ),
            Pair(8, "Serve hot.")
        )
        fun getPancitPalabok(Index: Int): String {
            return PancitPalabok[Index].toString()
        }
        fun getPreparePancitPalabok(Index: Int): String {
            return PreparePancitPalabok[Index].toString()
        }
    }
}