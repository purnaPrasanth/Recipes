package com.purnaprasanth.recipes.di

import com.purnaprasanth.recipes.main.MainActivity
import com.purnaprasanth.recipes.main.MainActivityComponent
import com.purnaprasanth.recipes.recipedetail.RecipeDetailActivity
import com.purnaprasanth.recipes.recipedetail.RecipeDetailComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

@Module(subcomponents = [MainActivityComponent::class, RecipeDetailComponent::class])
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    internal abstract fun bindMainActivity(factory: MainActivityComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(RecipeDetailActivity::class)
    internal abstract fun bindRecipeDetailActivity(factory: RecipeDetailComponent.Factory): AndroidInjector.Factory<*>
}