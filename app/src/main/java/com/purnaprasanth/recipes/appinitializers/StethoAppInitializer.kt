package com.purnaprasanth.recipes.appinitializers

import android.app.Application
import com.facebook.stetho.BuildConfig
import com.facebook.stetho.Stetho
import com.purnaprasanth.recipes.baseandroid.AppInitializer
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-19 as a part of Recipes
 **/

/**
 * [AppInitializer] for initializaing Stetho
 */

class StethoAppInitializer @Inject constructor() : AppInitializer {
    override fun init(application: Application) {
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(application)
    }
}