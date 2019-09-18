package com.purnaprasanth.recipes.di

import com.purnaprasanth.recipes.RecipeApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        NetworkModule::class,
        ExecutorsModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<RecipeApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: RecipeApplication): AppComponent
    }
}