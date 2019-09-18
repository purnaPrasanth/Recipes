package com.purnaprasanth.recipes.contentful

import android.content.Context
import coil.DefaultRequestOptions
import coil.ImageLoader
import coil.request.GetRequest
import coil.request.LoadRequest
import com.purnaprasanth.recipes.App
import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

@Singleton
class ContentFulCoilDelegate @Inject constructor(
    @App private val appContext: Context,
    okHttpClient: OkHttpClient
) : ImageLoader {

    private val coilImageLoader: ImageLoader by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        ImageLoader.invoke(appContext) {
            crossfade(true)
            okHttpClient(contentfulOkhttp)
        }
    }

    override val defaults: DefaultRequestOptions
        get() = coilImageLoader.defaults

    override fun clearMemory() {
        coilImageLoader.clearMemory()
    }

    override suspend fun get(request: GetRequest) = coilImageLoader.get(request)

    override fun load(request: LoadRequest) = coilImageLoader.load(request)

    override fun shutdown() {
        coilImageLoader.shutdown()
    }

    private val contentfulOkhttp = okHttpClient.newBuilder()
        .addInterceptor(Authrization)
        .build()

}