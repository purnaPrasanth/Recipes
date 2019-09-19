package com.purnaprasanth.recipes.contentful

import com.purnaprasanth.recipes.BuildConfig
import com.purnaprasanth.recipes.contentful.dataservices.IAssetServices
import com.purnaprasanth.recipes.contentful.dataservices.IRecipeServices
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

@Singleton
class OkhttpContentfulServices @Inject constructor(okHttpClient: OkHttpClient) : IContentFulServices {

    private val contentfulOkhttp = okHttpClient.newBuilder()
        .addInterceptor(Authrization)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://cdn.contentful.com/spaces/${BuildConfig.SPACE_ID}/environments/${BuildConfig.ENVIRONMENT}/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(contentfulOkhttp)
        .build()

    override val recipeServices: IRecipeServices by lazy {
        retrofit.create(IRecipeServices::class.java)
    }

    override val assetServices: IAssetServices by lazy {
        retrofit.create(IAssetServices::class.java)
    }
}