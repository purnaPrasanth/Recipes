package com.purnaprasanth.recipes.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.purnaprasanth.recipes.ViewModelFactory
import com.purnaprasanth.recipes.ViewModelKey
import com.purnaprasanth.recipes.main.RecipeViewModel
import com.purnaprasanth.recipes.recipedetail.RecipeDetailVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Purna on 2019-09-18 as a part of Recipes
 **/

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RecipeDetailVM::class)
    internal abstract fun provideRecipeDetailVM(viewModel: RecipeDetailVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RecipeViewModel::class)
    internal abstract fun provideRecipeListVM(viewModel: RecipeViewModel): ViewModel
}