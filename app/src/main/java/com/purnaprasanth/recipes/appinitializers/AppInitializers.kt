package com.purnaprasanth.recipes.appinitializers

import android.app.Application
import com.purnaprasanth.recipes.baseandroid.AppInitializer
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-19 as a part of Recipes
 **/

/**
 * Single place for initializing all [AppInitializer]
 */

class AppInitializers @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards AppInitializer>
) {
    fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}