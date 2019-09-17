package com.purnaprasanth.recipes.activity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.purnaprasanth.recipes.R
import com.purnaprasanth.recipes.adapter.RecipeListRvAdapter
import com.purnaprasanth.recipes.baseandroid.BaseActivity
import com.purnaprasanth.recipes.databinding.ActivityMainBinding
import com.purnaprasanth.recipes.instances.ExecutorInstances
import com.purnaprasanth.recipes.instances.RepoInstances
import com.purnaprasanth.recipes.viewmodel.RecipeVMFactory
import com.purnaprasanth.recipes.viewmodel.RecipeViewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main, ExecutorInstances.appDispatchers) {

    val viewModel: RecipeViewModel by lazy {
        ViewModelProviders.of(
            this,
            RecipeVMFactory(ExecutorInstances.appDispatchers, RepoInstances.recipeRepo)
        ).get(RecipeViewModel::class.java)
    }

    private val recipeAdapter = RecipeListRvAdapter(this)

    override fun initUI() {
        binding.recipeItems.adapter = recipeAdapter
        binding.recipeItems.layoutManager = LinearLayoutManager(this)
        viewModel.recipeList.observe(this, Observer {
            recipeAdapter.submitList(it)
        })
    }
}
