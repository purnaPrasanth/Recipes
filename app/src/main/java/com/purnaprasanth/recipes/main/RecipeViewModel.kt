package com.purnaprasanth.recipes.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.purnaprasanth.recipes.base.Dispatchers
import com.purnaprasanth.recipes.baseandroid.BaseViewModel
import com.purnaprasanth.recipes.data.NetworkError
import com.purnaprasanth.recipes.data.NetworkSuccess
import com.purnaprasanth.recipes.data.model.RecipeListItem
import com.purnaprasanth.recipes.data.repo.RecipeRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/
class RecipeViewModel @Inject constructor(
    application: Application,
    appDispatchers: Dispatchers,
    private val recipeRepo: RecipeRepo
) :
    BaseViewModel(application, appDispatchers) {

    private val _recipeList = MutableLiveData<List<RecipeListItem>>()

    val recipeList: LiveData<List<RecipeListItem>>
        get() = _recipeList

    private val _networkError = MutableLiveData<NetworkError<*>>()

    init {
        launch(appDispatchers.ioDispatcher) { getRecipes() }
    }

    private suspend fun getRecipes() {
        when (val result = recipeRepo.getRecipes()) {
            is NetworkSuccess -> {
                _recipeList.postValue(result.data)
            }
            is NetworkError -> {
                _networkError.postValue(result)
            }
        }
    }
}