package com.purnaprasanth.recipes.data.datasources.recipe

import com.purnaprasanth.recipes.contentful.dataservices.IRecipeServices
import com.purnaprasanth.recipes.data.NetworkCallRunner
import com.purnaprasanth.recipes.data.NetworkResult
import com.purnaprasanth.recipes.data.mappers.ContentFulRecipeToRecipe
import com.purnaprasanth.recipes.data.model.RecipeListItem
import com.purnaprasanth.recipes.data.toListMapper

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

class ContentFulDataSource(
    private val recipeServices: IRecipeServices,
    private val networkCallRunner: NetworkCallRunner,
    private val recipeListMapper: ContentFulRecipeToRecipe
) : IRecipeDataSource {
    override suspend fun getListOfRecipes(): NetworkResult<List<RecipeListItem>> {
        return networkCallRunner.executeForResponse(
            mapper = recipeListMapper.toListMapper(),
            request = { recipeServices.getRecipes("recipe").data })
    }
}