package com.purnaprasanth.recipes.baseandroid

import android.app.Application

/**
 * Created by Purna on 2019-09-19 as a part of Recipes
 **/
interface AppInitializer {
    fun init(application: Application)
}