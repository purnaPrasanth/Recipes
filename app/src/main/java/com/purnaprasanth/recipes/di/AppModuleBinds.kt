package com.purnaprasanth.recipes.di

import android.app.Application
import android.content.Context
import com.purnaprasanth.recipes.App
import com.purnaprasanth.recipes.RecipeApplication
import com.purnaprasanth.recipes.appinitializers.StethoAppInitializer
import com.purnaprasanth.recipes.baseandroid.AppInitializer
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

/**
 * Created by Purna on 2019-09-19 as a part of Recipes
 **/

@Module
abstract class AppModuleBinds {

    @Binds
    @App
    abstract fun providesContext(application: RecipeApplication): Context

    @Binds
    abstract fun providesApplication(application: RecipeApplication): Application

    @Binds
    @IntoSet
    abstract fun provideEmojiInitializer(bind: StethoAppInitializer): AppInitializer
}