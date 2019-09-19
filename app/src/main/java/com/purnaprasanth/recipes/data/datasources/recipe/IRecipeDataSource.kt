package com.purnaprasanth.recipes.data.datasources.recipe

import com.purnaprasanth.recipes.data.NetworkResult
import com.purnaprasanth.recipes.data.model.RecipeDetails
import com.purnaprasanth.recipes.data.model.RecipeListItem

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

/**
 * Contract to fetch Recipes into the app
 *
 * see [ContentFulDataSource]
 */
interface IRecipeDataSource {

    /**
     * To get a list of Recipes
     */
    suspend fun getListOfRecipes(): NetworkResult<List<RecipeListItem>>

    /**
     * To get recipe details of a recipe
     */
    suspend fun getRecipeDetails(recipeId: String): NetworkResult<RecipeDetails>
}