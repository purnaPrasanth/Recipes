package com.purnaprasanth.recipes.data.mappers

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.purnaprasanth.recipes.contentful.AssetResource
import com.purnaprasanth.recipes.contentful.EntryResource
import com.purnaprasanth.recipes.contentful.dataservices.IAssetServices
import com.purnaprasanth.recipes.imageEntryResSys
import com.purnaprasanth.recipes.immageAsset
import com.purnaprasanth.recipes.recipe1
import com.purnaprasanth.recipes.recipeEntryResSys
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.test.assertEquals

/**
 * Created by Purna on 2019-09-19 as a part of Recipes
 */

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE, sdk = [Build.VERSION_CODES.O_MR1])
class ContentFulRecipeToRecipeTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var assetServices: IAssetServices

    lateinit var contentFulRecipeToRecipe: ContentFulRecipeToRecipe

    val sampleData = EntryResource(sys = recipeEntryResSys, data = recipe1)

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        contentFulRecipeToRecipe = ContentFulRecipeToRecipe(assetServices)
    }

    @Test
    fun map() {
        runBlocking {
            `when`(assetServices.getImageAsset(sampleData.data.photo.sys.id)).thenReturn(
                AssetResource(
                    sys = imageEntryResSys,
                    data = immageAsset
                )
            )

            val sampleOutput = contentFulRecipeToRecipe.map(sampleData)
            assert(sampleOutput.imageUrl.equals("https:" + immageAsset.fileDetails.url))
        }
    }
}