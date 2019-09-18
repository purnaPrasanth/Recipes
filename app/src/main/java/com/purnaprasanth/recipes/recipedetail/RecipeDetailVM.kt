package com.purnaprasanth.recipes.recipedetail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.purnaprasanth.recipes.RecipeApplication
import com.purnaprasanth.recipes.base.Dispatchers
import com.purnaprasanth.recipes.baseandroid.BaseViewModel
import com.purnaprasanth.recipes.data.NetworkError
import com.purnaprasanth.recipes.data.NetworkSuccess
import com.purnaprasanth.recipes.data.model.RecipeDetails
import com.purnaprasanth.recipes.data.repo.RecipeRepo
import kotlinx.coroutines.launch

/**
 * Created by Purna on 2019-09-18 as a part of Recipes
 **/

class RecipeDetailVM(
    application: Application,
    dispatchers: Dispatchers,
    private val recipeId: String,
    private val recipeRepo: RecipeRepo
) : BaseViewModel(application, dispatchers) {

    private val _recipeDetail = MutableLiveData<RecipeDetails>()

    val recipeDetail: LiveData<RecipeDetails>
        get() = _recipeDetail

    init {
        getRecipeDetail(recipeId)
    }

    private fun getRecipeDetail(recipeId: String) {
        launch {
            when (val result = recipeRepo.getRecipeDetail(recipeId)) {
                is NetworkSuccess -> {
                    _recipeDetail.postValue(result.data)
                }
                is NetworkError -> {

                }
            }
        }
    }
}

class RecipeDetailVMFactory(
    private val appDispatchers: Dispatchers,
    private val recipeId: String,
    private val recipeRepo: RecipeRepo
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RecipeDetailVM(
            RecipeApplication.application,
            appDispatchers,
            recipeId,
            recipeRepo
        ) as T
    }
}

