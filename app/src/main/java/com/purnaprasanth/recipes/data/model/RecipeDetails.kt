package com.purnaprasanth.recipes.data.model

/**
 * Created by Purna on 2019-09-18 as a part of Recipes
 **/

/**
 * The Recipe Details contract that the App depends on
 */

data class RecipeDetails(
    val recipeId: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val chefName: String?,
    val tags: List<String>?
)