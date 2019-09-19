package com.purnaprasanth.recipes.data.datasources.recipe

import com.purnaprasanth.recipes.contentful.EntryResource
import com.purnaprasanth.recipes.contentful.data.Recipe
import com.purnaprasanth.recipes.contentful.dataservices.IRecipeServices
import com.purnaprasanth.recipes.data.Mapper
import com.purnaprasanth.recipes.data.NetworkCallRunner
import com.purnaprasanth.recipes.data.NetworkResult
import com.purnaprasanth.recipes.data.model.RecipeDetails
import com.purnaprasanth.recipes.data.model.RecipeListItem
import com.purnaprasanth.recipes.data.toAsyncListMapper
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

/**
 * Imaplementation of [IRecipeServices] to fetch recipes from ContentFul
 *
 * @param recipeServices an implementation to fetch RecipeDetails from ContentFul
 * @param networkCallRunner a runner to run the network calls
 * @param recipeListMapper a mapper to map [Recipe] to [RecipeListItem]. see [ContentFulRecipeToRecipe]
 * @param recipeDetailMapper a mapper to map [Recipe] to [RecipeDetails]. see [ContentFulRecipeToRecipeDetail]
 */

@Singleton
class ContentFulDataSource @Inject constructor(
    private val recipeServices: IRecipeServices,
    private val networkCallRunner: NetworkCallRunner,
    private val recipeListMapper: Mapper<EntryResource<Recipe>, RecipeListItem>,
    private val recipeDetailMapper: Mapper<EntryResource<Recipe>, RecipeDetails>
) : IRecipeDataSource {
    override suspend fun getListOfRecipes(): NetworkResult<List<RecipeListItem>> {
        return networkCallRunner.executeForResponse(
            mapper = recipeListMapper.toAsyncListMapper(),
            request = { recipeServices.getRecipes("recipe").data })
    }

    override suspend fun getRecipeDetails(recipeId: String): NetworkResult<RecipeDetails> {
        return networkCallRunner.executeForResponse(
            mapper = recipeDetailMapper,
            request = { recipeServices.getRecipeDetail(recipeId) })
    }
}