package com.purnaprasanth.recipes

import android.app.Activity
import android.app.Application
import com.facebook.stetho.Stetho
import com.purnaprasanth.recipes.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/
class RecipeApplication : DaggerApplication(), HasAndroidInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        Stetho.initializeWithDefaults(this)
    }

    fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    companion object {
        private lateinit var INSTANCE: Application

        val application: Application
            get() = INSTANCE
    }
}