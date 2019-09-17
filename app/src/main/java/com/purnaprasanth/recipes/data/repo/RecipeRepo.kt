package com.purnaprasanth.recipes.data.repo

import com.purnaprasanth.recipes.data.NetworkResult
import com.purnaprasanth.recipes.data.datasources.recipe.IRecipeDataSource
import com.purnaprasanth.recipes.data.model.RecipeListItem
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

@Singleton
class RecipeRepo(
    private val contentfulIRecipeDataSource: IRecipeDataSource
) {
    suspend fun getRecipes(): NetworkResult<List<RecipeListItem>> {
        return contentfulIRecipeDataSource.getListOfRecipes()
    }
}