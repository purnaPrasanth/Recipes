package com.purnaprasanth.recipes.data.mappers

import com.purnaprasanth.recipes.contentful.EntryResource
import com.purnaprasanth.recipes.contentful.data.Recipe
import com.purnaprasanth.recipes.contentful.dataservices.IAssetServices
import com.purnaprasanth.recipes.data.Mapper
import com.purnaprasanth.recipes.data.model.RecipeListItem
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

/**
 * a mapper to map [Recipe] to [RecipeListItem]
 * @param assetServices an [IAssetServices] implementation to fetch assets from ContentFul Delivery API
 */
@Singleton
class ContentFulRecipeToRecipe @Inject constructor(private val assetServices: IAssetServices) :
    Mapper<EntryResource<Recipe>, RecipeListItem> {

    override suspend fun map(from: EntryResource<Recipe>) = RecipeListItem(
        title = from.data.title,
        id = from.sys.id,
        imageUrl = "https:" + assetServices.getImageAsset(from.data.photo.sys.id).data.fileDetails.url
    )
}