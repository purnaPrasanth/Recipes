package com.purnaprasanth.recipes.di

import com.purnaprasanth.recipes.main.MainActivity
import com.purnaprasanth.recipes.main.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

@Module(subcomponents = [MainActivityComponent::class])
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    internal abstract fun bindMainActivity(factory: MainActivityComponent.Factory): AndroidInjector.Factory<*>
}