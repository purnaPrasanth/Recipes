package com.purnaprasanth.recipes.instances

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.purnaprasanth.recipes.base.creational.BaseGenerator
import com.purnaprasanth.recipes.base.creational.single
import com.purnaprasanth.recipes.contentful.IContentFulServices
import com.purnaprasanth.recipes.contentful.OkhttpContentfulServices
import com.purnaprasanth.recipes.data.NetworkCallRunner
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/
object NetworkInstances {

    private val okHttpGenerator: BaseGenerator<OkHttpClient> = single {
        OkHttpClient.Builder()
            .dispatcher(Dispatcher(ExecutorInstances.appExecutors.ioExecutor as ExecutorService))
            .connectTimeout(20, TimeUnit.SECONDS)
            .callTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    private val contentFulServicesGenerator: BaseGenerator<IContentFulServices> = single {
        OkhttpContentfulServices(okHttpClient)
    }

    private val networkRunnerGenerator: BaseGenerator<NetworkCallRunner> = single {
        NetworkCallRunner()
    }

    val okHttpClient: OkHttpClient
        get() = okHttpGenerator.getInstance()

    val contentfulServices: IContentFulServices
        get() = contentFulServicesGenerator.getInstance()

    val networkCallRunner: NetworkCallRunner
        get() = networkRunnerGenerator.getInstance()

}