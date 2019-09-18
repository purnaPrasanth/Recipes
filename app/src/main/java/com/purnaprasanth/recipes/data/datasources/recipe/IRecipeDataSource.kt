package com.purnaprasanth.recipes.data.datasources.recipe

import com.purnaprasanth.recipes.data.NetworkResult
import com.purnaprasanth.recipes.data.model.RecipeDetails
import com.purnaprasanth.recipes.data.model.RecipeListItem

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/
interface IRecipeDataSource {
    suspend fun getListOfRecipes(): NetworkResult<List<RecipeListItem>>

    suspend fun getRecipeDetails(recipeId: String): NetworkResult<RecipeDetails>
}