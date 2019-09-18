package com.purnaprasanth.recipes.recipedetail

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Purna on 2019-09-18 as a part of Recipes
 **/

@Module
class RecipeDetailModule {
    @Provides
    fun provideActivity(activity: RecipeDetailActivity): Activity = activity

    @Provides
    fun provideContext(activity: RecipeDetailActivity): Context = activity
}