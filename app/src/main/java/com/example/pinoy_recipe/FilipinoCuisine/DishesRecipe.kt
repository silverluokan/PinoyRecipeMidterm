package com.example.pinoy_recipe.FilipinoCuisine

class DishesRecipe {
    companion object{

        val Sisig = mapOf(
            Pair(1,"- 1 lb pork face (snout, ears, and cheeks), boiled and chopped"),
            Pair(2,"- 1/2 cup chopped onion"),
            Pair(3,"- 1/2 cup mayonnaise"),
            Pair(4,"- 3 tbsp soy sauce"),
            Pair(5,"- 2 tbsp calamansi juice or lemon juice"),
            Pair(6,"- 2-3 cloves garlic, minced"),
            Pair(7,"- 2-3 pieces green chili peppers (siling haba), chopped"),
            Pair(8,"- 1-2 pieces red chili peppers (siling labuyo), chopped (optional)"),
            Pair(9,"- Salt and pepper to taste"),
            Pair(10,"- Cooking oil for fryin")
        )

        val SisigCook = mapOf(
            Pair(1,"Heat a pan with oil and fry the boiled and chopped pork face until crispy. Drain excess oil and set aside."),
            Pair(2,"In a separate pan, sauté the garlic and onions until fragrant."),
            Pair(3,"Add the chopped crispy pork to the sautéed garlic and onions."),
            Pair(4,"Pour in soy sauce and calamansi juice, and cook for a few minutes."),
            Pair(5,"Stir in mayonnaise and continue to cook until well combined."),
            Pair(6,"Add chopped chili peppers, salt, and pepper. Adjust seasoning to taste."),
            Pair(7,"Serve hot on a sizzling plate, often with rice and a raw egg on top.")
        )


        fun getSisig(Index: Int): String {
            return Sisig[Index].toString()
        }

        fun getHowToSisig(Index: Int): String {
            return SisigCook[Index].toString()
        }

        val KareKare = mapOf(
            Pair(1,"- 2 lbs oxtail, cut into 2-inch pieces"),
            Pair(2,"- 1 lb tripe (optional), cleaned and sliced into bite-sized pieces"),
            Pair(3,"- 2 cups string beans (sitaw), cut into 2-inch lengths"),
            Pair(4,"- 1 large eggplant (talong), sliced"),
            Pair(5,"- 1 bunch of banana blossoms (blossoms only)"),
            Pair(6,"- 1/2 cup peanut butter"),
            Pair(7,"- 2 tbsp cooking oil"),
            Pair(8,"- 1 onion, chopped"),
            Pair(9,"- 4 cloves garlic, minced"),
            Pair(10,"- 1/4 cup shrimp paste (bagoong)"),
            Pair(11,"- Salt and pepper to taste")
        )

        val KareKareCook = mapOf(
            Pair(1,"Boil the oxtail and tripe until tender. Remove impurities that rise to the surface while boiling."),
            Pair(2,"In a large pot, sauté garlic and onions in cooking oil until fragrant."),
            Pair(3,"Add the boiled oxtail and tripe. Cook for a few minutes."),
            Pair(4,"Pour in enough water to cover the meat, and bring it to a boil."),
            Pair(5,"Stir in the peanut butter, and simmer until the sauce thickens. Add more water if needed."),
            Pair(6,"Add the vegetables (string beans, eggplant, and banana blossoms) and cook until tender."),
            Pair(7,"Season with salt and pepper to taste."),
            Pair(8,"Serve hot with shrimp paste on the side, and steamed rice.")
        )

        fun getKareKare(Index: Int): String {
            return KareKare[Index].toString()
        }

        fun getHowToKareKare(Index: Int): String {
            return KareKareCook[Index].toString()
        }

        val Adobo = mapOf(
            Pair(1,"- 2 lbs chicken or pork, cut into serving pieces"),
            Pair(2,"- 1 onion, chopped"),
            Pair(3,"- 4 cloves garlic, minced"),
            Pair(4,"- 1/2 cup soy sauce"),
            Pair(5,"- 1/2 cup vinegar"),
            Pair(6,"- 1 bay leaf"),
            Pair(7,"- 1 tsp peppercorns"),
            Pair(8,"- Cooking oil"),
            Pair(9,"- Salt and sugar to taste")
        )

        val AdoboCook = mapOf(
            Pair(1,"In a pot, sauté garlic and onions in cooking oil until fragrant"),
            Pair(2,"Add the meat and brown it slightly."),
            Pair(3,"Pour in the soy sauce and vinegar."),
            Pair(4,"Add the bay leaf and peppercorns."),
            Pair(5,"Bring to a boil, then reduce the heat and simmer until the meat is tender."),
            Pair(6,"Season with salt and sugar to taste."),
            Pair(7,"Serve with steamed rice.")
        )

        fun getAdobo(Index: Int): String {
            return KareKare[Index].toString()
        }

        fun getHowToAdobo(Index: Int): String {
            return KareKareCook[Index].toString()
        }

        val Sinigang = mapOf(
            Pair(1,"- 1 lb pork ribs or pork belly, cut into serving pieces"),
            Pair(2,"- 1 onion, sliced"),
            Pair(3,"- 2 tomatoes, quartered"),
            Pair(4,"- 1 radish (labanos), sliced"),
            Pair(5,"- 1 eggplant (talong), sliced"),
            Pair(6,"- 10-12 pieces string beans (sitaw), cut into 2-inch lengths"),
            Pair(7,"- 2 green chili peppers (siling haba)"),
            Pair(8,"- 1 pack sinigang mix (tamarind soup base)"),
            Pair(9,"- Salt and fish sauce (patis) to taste")
        )

        val SinigangCook = mapOf(
            Pair(1,"In a pot, boil the pork in enough water until tender. Skim off any impurities."),
            Pair(2,"Add onions and tomatoes, and simmer until they soften."),
            Pair(3,"Add radish, eggplant, and string beans. Cook until the vegetables are tender."),
            Pair(4,"Add the sinigang mix and green chili peppers. Stir well."),
            Pair(5,"Season with salt and fish sauce to taste."),
            Pair(6,"Serve hot with steamed rice.")
        )

        fun getSinigang(Index: Int): String {
            return Sinigang[Index].toString()
        }

        fun getHowToSinigang(Index: Int): String {
            return SinigangCook[Index].toString()
        }

        val Dinuguan = mapOf(
            Pair(1,"- 1 lb pork belly, cut into small cubes"),
            Pair(2,"- 1/2 lb pork intestines (optional), cleaned and chopped"),
            Pair(3,"- 1 cup pig's blood (fresh or frozen)"),
            Pair(4,"- 1 onion, chopped"),
            Pair(5,"- 3 cloves garlic, minced"),
            Pair(6,"- 2-3 pieces green chili peppers (siling haba)"),
            Pair(7,"- 2-3 tbsp vinegar"),
            Pair(8,"- 1 cup water"),
            Pair(9,"- Cooking oil"),
            Pair(10,"- Salt and pepper to taste")
        )

        val DinuguanCook = mapOf(
            Pair(1,"In a pan, sauté garlic and onions in cooking oil until fragrant."),
            Pair(2,"Add pork belly and pork intestines. Cook until the meat is browned."),
            Pair(3,"Pour in vinegar and let it simmer for a few minutes to remove the sour taste."),
            Pair(4,"Add pig's blood while continuously stirring to avoid curdling."),
            Pair(5,"Add water and green chili peppers. Let it simmer until the sauce thickens."),
            Pair(6,"Season with salt and pepper to taste."),
            Pair(7,"Serve hot with rice or puto (rice cakes).")
        )

        fun getDinuguan(Index: Int): String {
            return Dinuguan[Index].toString()
        }

        fun getHowToDinuguan(Index: Int): String {
            return DinuguanCook[Index].toString()
        }
    }

}