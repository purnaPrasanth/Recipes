package com.purnaprasanth.recipes.contentful.dataservices

import com.purnaprasanth.recipes.contentful.ArrayResource
import com.purnaprasanth.recipes.contentful.EntryResource
import com.purnaprasanth.recipes.contentful.data.ImageAsset
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/
interface IAssetServices {

    @GET("assets/{asset_id}")
    suspend fun getImageAsset(@Path("asset_id") assetId: String): EntryResource<ImageAsset>
}