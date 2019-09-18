package com.purnaprasanth.recipes.recipedetail

import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.purnaprasanth.recipes.ContentFul
import com.purnaprasanth.recipes.R
import com.purnaprasanth.recipes.baseandroid.BaseActivity
import com.purnaprasanth.recipes.contentful.ContentFulCoilDelegate
import com.purnaprasanth.recipes.data.repo.RecipeRepo
import com.purnaprasanth.recipes.databinding.ActivityRecipeDetailBinding
import javax.inject.Inject

class RecipeDetailActivity : BaseActivity<ActivityRecipeDetailBinding>(R.layout.activity_recipe_detail) {

    @Inject
    lateinit var repo: RecipeRepo

    @Inject
    @ContentFul
    lateinit var contentFulCoil: ContentFulCoilDelegate

    private val recipeId: String by lazy { intent.getStringExtra(BUNDLE_RECIPE_ID) }

    private val viewModel: RecipeDetailVM by lazy {
        ViewModelProviders.of(
            this,
            RecipeDetailVMFactory(dispatchers, recipeId, repo)
        ).get(RecipeDetailVM::class.java)
    }

    override fun initUI() {
        binding.recipeDetail = viewModel.recipeDetail
        viewModel.recipeDetail.observe(this, Observer { recipeDetail ->
            binding.recipeTags.setContent(recipeDetail.tags?.joinToString(separator = ", ") { it })
            binding.recipeImage.load(recipeDetail.imageUrl, contentFulCoil) {
                RoundedCornersTransformation(8.0f)
            }
        })
    }

    companion object {
        const val BUNDLE_RECIPE_ID = "BUNDLE_RECIPE_ID"

        fun getIntent(context: Context, recipeId: String) = Intent(context, RecipeDetailActivity::class.java).apply {
            putExtra(BUNDLE_RECIPE_ID, recipeId)
        }
    }
}
