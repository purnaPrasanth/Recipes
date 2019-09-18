package com.purnaprasanth.recipes.di

import coil.ImageLoader
import com.purnaprasanth.recipes.ContentFul
import com.purnaprasanth.recipes.contentful.ContentFulCoilDelegate
import com.purnaprasanth.recipes.contentful.EntryResource
import com.purnaprasanth.recipes.contentful.IContentFulServices
import com.purnaprasanth.recipes.contentful.OkhttpContentfulServices
import com.purnaprasanth.recipes.contentful.data.Recipe
import com.purnaprasanth.recipes.data.Mapper
import com.purnaprasanth.recipes.data.datasources.recipe.ContentFulDataSource
import com.purnaprasanth.recipes.data.datasources.recipe.IRecipeDataSource
import com.purnaprasanth.recipes.data.mappers.ContentFulRecipeToRecipe
import com.purnaprasanth.recipes.data.mappers.ContentFulRecipeToRecipeDetail
import com.purnaprasanth.recipes.data.model.RecipeDetails
import com.purnaprasanth.recipes.data.model.RecipeListItem
import dagger.Binds
import dagger.Module

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

@Module
abstract class NetworkModuleBinds {

    @Binds
    abstract fun providesContentFulServices(okhttpContentfulServices: OkhttpContentfulServices): IContentFulServices

    @Binds
    @ContentFul
    abstract fun providesContentFulRecipeDataSource(contentFulDataSource: ContentFulDataSource): IRecipeDataSource

    @Binds
    abstract fun providesContentfulRecipeToRecipeMapper(contentFulRecipeToRecipe: ContentFulRecipeToRecipe): Mapper<EntryResource<Recipe>, RecipeListItem>

    @Binds
    abstract fun provideContentFulToRecipeDetailMapper(contentFulRecipeToRecipeDetail: ContentFulRecipeToRecipeDetail): Mapper<EntryResource<Recipe>, RecipeDetails>

    @Binds
    @ContentFul
    abstract fun providesContentFulCoil(contentFulImageLoader: ContentFulCoilDelegate): ImageLoader
}