package com.purnaprasanth.recipes.contentful

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.purnaprasanth.recipes.contentful.dataservices.IRecipeServices
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

class OkhttpContentfulServices(
    okHttpClient: OkHttpClient
) : IContentFulServices {

    private val contentfulOkhttp = okHttpClient.newBuilder()
        .addInterceptor(Authrization)
        .build()

    // todo; space_id, environment from product_flavours
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://cdn.contentful.com/spaces/kk2bw5ojx476/environments/master/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(contentfulOkhttp)
        .build()

    override val recipeServices: IRecipeServices by lazy {
        retrofit.create(IRecipeServices::class.java)
    }
}