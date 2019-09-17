package com.purnaprasanth.recipes.contentful.dataservices

import com.purnaprasanth.recipes.contentful.ArrayResource
import com.purnaprasanth.recipes.contentful.EntryResource
import com.purnaprasanth.recipes.contentful.data.Recipe
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Purna on 2019-09-15 as a part of Recipes
 **/

interface IRecipeServices {

    @GET("entries")
    suspend fun getRecipes(@Query("content_type") contentType: String): ArrayResource<EntryResource<Recipe>>
}