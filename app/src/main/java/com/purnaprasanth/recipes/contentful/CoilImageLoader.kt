package com.purnaprasanth.recipes.contentful

import android.content.Context
import coil.ImageLoader
import com.purnaprasanth.recipes.App
import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

@Singleton
class CoilImageLoader @Inject constructor(@App private val appContext: Context, okHttpClient: OkHttpClient) {

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