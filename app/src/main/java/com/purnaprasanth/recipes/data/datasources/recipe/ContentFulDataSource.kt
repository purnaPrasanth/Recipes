package com.purnaprasanth.recipes.data.datasources.recipe

import com.purnaprasanth.recipes.contentful.EntryResource
import com.purnaprasanth.recipes.contentful.data.Recipe
import com.purnaprasanth.recipes.contentful.dataservices.IRecipeServices
import com.purnaprasanth.recipes.data.Mapper
import com.purnaprasanth.recipes.data.NetworkCallRunner
import com.purnaprasanth.recipes.data.NetworkResult
import com.purnaprasanth.recipes.data.model.RecipeListItem
import com.purnaprasanth.recipes.data.toListMapper
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

@Singleton
class ContentFulDataSource @Inject constructor(
    private val recipeServices: IRecipeServices,
    private val networkCallRunner: NetworkCallRunner,
    @Named(value = "contentRecipeResToRecipeMapper") private val recipeListMapper: Mapper<EntryResource<Recipe>, RecipeListItem>
) : IRecipeDataSource {
    override suspend fun getListOfRecipes(): NetworkResult<List<RecipeListItem>> {
        return networkCallRunner.executeForResponse(
            mapper = recipeListMapper.toListMapper(),
            request = { recipeServices.getRecipes("recipe").data })
    }
}