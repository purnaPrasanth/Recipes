package com.purnaprasanth.recipes.main

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>
}