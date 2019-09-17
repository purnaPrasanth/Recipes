package com.purnaprasanth.recipes.activity

import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.purnaprasanth.recipes.R
import com.purnaprasanth.recipes.adapter.RecipeListItemDiffCallback
import com.purnaprasanth.recipes.adapter.RecipeListRvAdapter
import com.purnaprasanth.recipes.baseandroid.BaseActivity
import com.purnaprasanth.recipes.databinding.ActivityMainBinding
import com.purnaprasanth.recipes.instances.ExecutorInstances
import com.purnaprasanth.recipes.instances.RepoInstances
import com.purnaprasanth.recipes.viewmodel.RecipeVMFactory
import com.purnaprasanth.recipes.viewmodel.RecipeViewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main, ExecutorInstances.appDispatchers),
    AdapterView.OnItemClickListener {

    val viewModel: RecipeViewModel by lazy {
        ViewModelProviders.of(
            this,
            RecipeVMFactory(ExecutorInstances.appDispatchers, RepoInstances.recipeRepo)
        ).get(RecipeViewModel::class.java)
    }

    private val recipeAdapter = RecipeListRvAdapter(this, RecipeListItemDiffCallback())

    override fun initUI() {
        binding.recipeItems.adapter = recipeAdapter
        binding.recipeItems.layoutManager = LinearLayoutManager(this)
        recipeAdapter.onItemClickListener = this
        viewModel.recipeList.observe(this, Observer {
            recipeAdapter.submitList(it)
            Log.d("MainActivity", it.toString())
        })
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val clickedItem = recipeAdapter.getItem(p2)
    }
}
