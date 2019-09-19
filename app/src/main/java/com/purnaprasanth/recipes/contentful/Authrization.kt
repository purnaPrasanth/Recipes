package com.purnaprasanth.recipes.contentful

import com.purnaprasanth.recipes.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

/**
 * Authorization [Interceptor] for authorizing requests to ContentFul
 */

object Authrization : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        val newRequest = requestBuilder.apply {
            addHeader("Authorization", "Bearer ${BuildConfig.ACCESS_TOKEN}")
        }.build()

        return chain.proceed(newRequest)
    }
}