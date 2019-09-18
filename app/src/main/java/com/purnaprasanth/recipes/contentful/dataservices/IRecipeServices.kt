package com.purnaprasanth.recipes.contentful.dataservices

import com.purnaprasanth.recipes.contentful.ArrayResource
import com.purnaprasanth.recipes.contentful.EntryResource
import com.purnaprasanth.recipes.contentful.data.Chef
import com.purnaprasanth.recipes.contentful.data.Recipe
import com.purnaprasanth.recipes.contentful.data.Tag
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Purna on 2019-09-15 as a part of Recipes
 **/

interface IRecipeServices {

    @GET("entries")
    suspend fun getRecipes(@Query("content_type") contentType: String): ArrayResource<EntryResource<Recipe>>

    @GET("entries/{recipe_id}")
    suspend fun getRecipeDetail(@Path("recipe_id") recipeId: String): EntryResource<Recipe>

    @GET("entries/{tag_id}")
    suspend fun getTagDetail(@Path("tag_id") tagId: String): EntryResource<Tag>

    @GET("entries/{chef_id}")
    suspend fun getChefDetail(@Path("chef_id") chefId: String): EntryResource<Chef>

}