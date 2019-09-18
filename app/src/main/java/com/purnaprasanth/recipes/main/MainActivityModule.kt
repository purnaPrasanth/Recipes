package com.purnaprasanth.recipes.main

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

@Module
class MainActivityModule {

    @Provides
    fun provideActivity(activity: MainActivity): Activity = activity

    @Provides
    fun provideContext(activity: MainActivity): Context = activity
}