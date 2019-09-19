package com.purnaprasanth.recipes.main

import android.app.Application
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.jraska.livedata.test
import com.purnaprasanth.recipes.base.Dispatchers
import com.purnaprasanth.recipes.data.NetworkError
import com.purnaprasanth.recipes.data.NetworkSuccess
import com.purnaprasanth.recipes.data.model.RecipeListItem
import com.purnaprasanth.recipes.data.repo.RecipeRepo
import com.purnaprasanth.recipes.recipeListItems
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.concurrent.TimeUnit

/**
 * Created by Purna on 2019-09-19 as a part of Recipes
 */

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE, sdk = [Build.VERSION_CODES.O_MR1])
class RecipeVMTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var recipeRepo: RecipeRepo

    private val applicationMock = Mockito.mock(Application::class.java)

    lateinit var viewModel: RecipeViewModel

    private lateinit var error: LiveData<NetworkError<*>>

    private lateinit var data: LiveData<List<RecipeListItem>>

    private lateinit var loading: LiveData<Boolean>

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        viewModel = RecipeViewModel(
            applicationMock,
            Dispatchers(
                kotlinx.coroutines.Dispatchers.Main,
                kotlinx.coroutines.Dispatchers.IO,
                kotlinx.coroutines.Dispatchers.Default
            ),
            recipeRepo
        )

        error = viewModel.error
        data = viewModel.recipeList
        loading = viewModel.loading
    }

    @Test
    fun getRecipeDetail() {
        runBlocking {
            `when`(recipeRepo.getRecipes()).thenReturn(NetworkSuccess(recipeListItems))

            viewModel.getRecipes()

            data
                .test()
                .awaitNextValue(3, TimeUnit.SECONDS)
                .assertValue { it == recipeListItems }
        }
    }

    @Test
    fun getLoading() {
        runBlocking {
            `when`(recipeRepo.getRecipes()).thenReturn(NetworkSuccess(recipeListItems))

            viewModel.getRecipes()

            loading.test()
                .awaitNextValue(3, TimeUnit.SECONDS)
                .assertValue {
                    it == false
                }

        }
    }

    @Test
    fun getError() {
        runBlocking {
            val exception = NetworkError<List<RecipeListItem>>(Exception("Error"))
            `when`(recipeRepo.getRecipes()).thenReturn(exception)

            viewModel.getRecipes()

            error.test()
                .awaitNextValue(3, TimeUnit.SECONDS)
                .assertValue {
                    it == exception
                }

        }
    }

    @After
    fun after() {

    }
}