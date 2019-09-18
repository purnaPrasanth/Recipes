package com.purnaprasanth.recipes.data.mappers

import com.purnaprasanth.recipes.contentful.EntryResource
import com.purnaprasanth.recipes.contentful.data.Recipe
import com.purnaprasanth.recipes.contentful.dataservices.IAssetServices
import com.purnaprasanth.recipes.contentful.dataservices.IRecipeServices
import com.purnaprasanth.recipes.data.Mapper
import com.purnaprasanth.recipes.data.model.RecipeDetails
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-18 as a part of Recipes
 **/

@Singleton
class ContentFulRecipeToRecipeDetail @Inject constructor(
    private val assetsService: IAssetServices,
    private val recipeServices: IRecipeServices
) : Mapper<EntryResource<Recipe>, RecipeDetails> {
    override suspend fun map(from: EntryResource<Recipe>) = RecipeDetails(
        recipeId = from.sys.id,
        title = from.data.title,
        description = from.data.description,
        imageUrl = "https://" + assetsService.getImageAsset(from.data.photo.sys.id).data.fileDetails.url,
        chefName = from.data.chef?.sys?.id?.let { recipeServices.getChefDetail(it).data.name },
        tags = from.data.tags?.map {
            recipeServices.getTagDetail(it.sys.id).data.name
        }
    )
}