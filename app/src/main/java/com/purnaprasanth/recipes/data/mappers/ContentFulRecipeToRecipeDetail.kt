package com.purnaprasanth.recipes.data.mappers

import com.purnaprasanth.recipes.contentful.EntryResource
import com.purnaprasanth.recipes.contentful.data.Recipe
import com.purnaprasanth.recipes.contentful.dataservices.IAssetServices
import com.purnaprasanth.recipes.contentful.dataservices.IRecipeServices
import com.purnaprasanth.recipes.data.Mapper
import com.purnaprasanth.recipes.data.model.RecipeDetails
import com.purnaprasanth.recipes.data.model.RecipeListItem
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-18 as a part of Recipes
 **/

/**
 * a mapper to map [Recipe] to [RecipeListItem]
 * @param assetsService an [IAssetServices] implementation to fetch assets from ContentFul Delivery API
 * @param recipeServices an [IAssetServices] implementation to fetch recipe related data from ContentFul Delivery API
 */

@Singleton
class ContentFulRecipeToRecipeDetail @Inject constructor(
    private val assetsService: IAssetServices,
    private val recipeServices: IRecipeServices
) : Mapper<EntryResource<Recipe>, RecipeDetails> {
    override suspend fun map(from: EntryResource<Recipe>): RecipeDetails = coroutineScope {

        val imageAsyncJob = async { assetsService.getImageAsset(from.data.photo.sys.id) }

        val tagsAsyncJobs = from.data.tags?.map {
            async { recipeServices.getTagDetail(it.sys.id) }
        }

        val chefAsyncJob = async { from.data.chef?.sys?.id?.let { recipeServices.getChefDetail(it) } }

        RecipeDetails(
            recipeId = from.sys.id,
            title = from.data.title,
            description = from.data.description,
            imageUrl = "https://" + imageAsyncJob.await().data.fileDetails.url,
            chefName = chefAsyncJob.await()?.data?.name,
            tags = tagsAsyncJobs?.map {
                it.await().data.name
            }
        )
    }
}