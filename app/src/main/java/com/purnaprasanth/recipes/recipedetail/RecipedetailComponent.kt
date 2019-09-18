package com.purnaprasanth.recipes.recipedetail

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Purna on 2019-09-18 as a part of Recipes
 **/

@Subcomponent(modules = [RecipeDetailModule::class])
interface RecipeDetailComponent : AndroidInjector<RecipeDetailActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<RecipeDetailActivity>
}