package com.purnaprasanth.recipes.main

import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.purnaprasanth.recipes.R
import com.purnaprasanth.recipes.baseandroid.BaseActivity
import com.purnaprasanth.recipes.baseandroid.ext.showShortToast
import com.purnaprasanth.recipes.databinding.ActivityMainBinding
import com.purnaprasanth.recipes.recipedetail.RecipeDetailActivity
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main),
    AdapterView.OnItemClickListener {

    val viewModel: RecipeViewModel by lazy {
        ViewModelProviders.of(
            this,
            viewModelFactory
        )[RecipeViewModel::class.java]
    }

    @Inject
    lateinit var recipeAdapter: RecipeListRvAdapter

    override fun initUI() {
        viewModel.getRecipes()
        binding.recipeItems.adapter = recipeAdapter
        binding.recipeItems.layoutManager = LinearLayoutManager(this)
        recipeAdapter.onItemClickListener = this
        viewModel.error.observe(this, Observer { error ->
            error.exception.message?.let { showShortToast(it) }
        })
        viewModel.loading.observe(this, Observer {
            binding.progressView.visibility = if (it == false) View.GONE else View.VISIBLE
        })
        viewModel.recipeList.observe(this, Observer {
            recipeAdapter.submitList(it)
        })
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val clickedItem = recipeAdapter.getItem(p2)
        startActivity(RecipeDetailActivity.getIntent(this, clickedItem.id))
    }
}
