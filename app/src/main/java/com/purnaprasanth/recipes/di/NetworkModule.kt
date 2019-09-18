package com.purnaprasanth.recipes.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.purnaprasanth.recipes.ContentFul
import com.purnaprasanth.recipes.IO
import com.purnaprasanth.recipes.contentful.CoilImageLoader
import com.purnaprasanth.recipes.contentful.IContentFulServices
import dagger.Module
import dagger.Provides
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

@Module(includes = [NetworkModuleBinds::class])
class NetworkModule {

    @Provides
    fun provideOkhttp(@IO ioExecutor: Executor) = OkHttpClient.Builder()
        .dispatcher(Dispatcher(ioExecutor as ExecutorService))
        .connectTimeout(20, TimeUnit.SECONDS)
        .callTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .addNetworkInterceptor(StethoInterceptor())
        .build()

    @Provides
    fun provideContentFulRecipeServices(contentFulServices: IContentFulServices) = contentFulServices.recipeServices

    @Provides
    fun provideContentFulAssetServices(contentFulServices: IContentFulServices) = contentFulServices.assetServices

    @Provides
    @ContentFul
    fun provideContentFulImageLoader(contentfulImageLoader: CoilImageLoader) = contentfulImageLoader.coilImageLoader

}