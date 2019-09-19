package com.purnaprasanth.recipes.data.repo

import com.purnaprasanth.recipes.ContentFul
import com.purnaprasanth.recipes.data.NetworkResult
import com.purnaprasanth.recipes.data.datasources.recipe.IRecipeDataSource
import com.purnaprasanth.recipes.data.model.RecipeDetails
import com.purnaprasanth.recipes.data.model.RecipeListItem
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

/**
 * Repo to fetch Recipe Related data
 *
 * @param contentfulIRecipeDataSource an [IRecipeDataSource] implementation to fetch recipe related data
 */

@Singleton
class RecipeRepo @Inject constructor(
    @ContentFul private val contentfulIRecipeDataSource: IRecipeDataSource
) {

    /**
     * To Fetch list of recipe
     */
    suspend fun getRecipes(): NetworkResult<List<RecipeListItem>> {
        return contentfulIRecipeDataSource.getListOfRecipes()
    }

    /**
     * To Fetch recipe details
     */
    suspend fun getRecipeDetail(recipeId: String): NetworkResult<RecipeDetails> {
        return contentfulIRecipeDataSource.getRecipeDetails(recipeId)
    }
}