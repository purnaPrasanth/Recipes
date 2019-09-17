package com.purnaprasanth.recipes.contentful

import android.content.Context
import coil.ImageLoader
import okhttp3.OkHttpClient

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

class CoilImageLoader(private val appContext: Context, okHttpClient: OkHttpClient) {

    private val contentfulOkhttp = okHttpClient.newBuilder()
        .addInterceptor(Authrization)
        .build()

    val coilImageLoader: ImageLoader by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        ImageLoader.invoke(appContext) {
            crossfade(true)
            okHttpClient(contentfulOkhttp)
        }
    }

}