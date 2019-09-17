package com.purnaprasanth.recipes.contentful

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/
object Authrization : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        val newRequest = requestBuilder.apply {
            // TODO, take from build script
            addHeader("Authorization", "Bearer 7ac531648a1b5e1dab6c18b0979f822a5aad0fe5f1109829b8a197eb2be4b84c")
        }.build()

        return chain.proceed(newRequest)
    }
}