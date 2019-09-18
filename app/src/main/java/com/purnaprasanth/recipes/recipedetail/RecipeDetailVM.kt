package com.purnaprasanth.recipes.recipedetail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.purnaprasanth.recipes.base.Dispatchers
import com.purnaprasanth.recipes.baseandroid.BaseViewModel
import com.purnaprasanth.recipes.data.NetworkError
import com.purnaprasanth.recipes.data.NetworkSuccess
import com.purnaprasanth.recipes.data.model.RecipeDetails
import com.purnaprasanth.recipes.data.repo.RecipeRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-18 as a part of Recipes
 **/

class RecipeDetailVM @Inject constructor(
    application: Application,
    dispatchers: Dispatchers,
    private val recipeRepo: RecipeRepo
) : BaseViewModel(application, dispatchers) {

    private val _recipeDetail = MutableLiveData<RecipeDetails>()

    val recipeDetail: LiveData<RecipeDetails>
        get() = _recipeDetail

    fun getRecipeDetail(recipeId: String) {
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

