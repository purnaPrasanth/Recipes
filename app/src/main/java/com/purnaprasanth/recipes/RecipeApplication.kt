package com.purnaprasanth.recipes

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/
class RecipeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        Stetho.initializeWithDefaults(this)
    }

    companion object {
        private lateinit var INSTANCE: Application

        val application: Application
            get() = INSTANCE

        val applicationContext: Context
            get() = INSTANCE
    }
}