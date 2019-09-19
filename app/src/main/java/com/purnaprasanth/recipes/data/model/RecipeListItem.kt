package com.purnaprasanth.recipes.data.model

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

/**
 * The Recipe list contract that the App depends on
 */

data class RecipeListItem(
    val id: String,
    val title: String,
    val imageUrl: String
)