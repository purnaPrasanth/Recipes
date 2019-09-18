package com.purnaprasanth.recipes.di

import android.app.Application
import android.content.Context
import com.purnaprasanth.recipes.App
import com.purnaprasanth.recipes.RecipeApplication
import dagger.Module
import dagger.Provides

/**
 * Created by Purna on 2019-09-18 as a part of Recipes
 **/

@Module
class AppModule {

    @Provides
    @App
    fun providesContext(application: RecipeApplication): Context = application

    @Provides
    fun providesApplication(application: RecipeApplication): Application = application
}