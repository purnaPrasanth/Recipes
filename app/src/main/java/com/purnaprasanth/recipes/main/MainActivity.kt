package com.purnaprasanth.recipes.main

import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.purnaprasanth.recipes.R
import com.purnaprasanth.recipes.baseandroid.BaseActivity
import com.purnaprasanth.recipes.data.repo.RecipeRepo
import com.purnaprasanth.recipes.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main),
    AdapterView.OnItemClickListener {

    @Inject
    lateinit var repo: RecipeRepo

    val viewModel: RecipeViewModel by lazy {
        ViewModelProviders.of(
            this,
            RecipeVMFactory(dispatchers, repo)
        ).get(RecipeViewModel::class.java)
    }

    @Inject
    lateinit var recipeAdapter: RecipeListRvAdapter

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
