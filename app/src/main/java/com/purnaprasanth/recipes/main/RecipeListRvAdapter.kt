package com.purnaprasanth.recipes.main

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import coil.ImageLoader
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.purnaprasanth.recipes.ContentFul
import com.purnaprasanth.recipes.R
import com.purnaprasanth.recipes.adapter.SingleTypeBaseRvAdapter
import com.purnaprasanth.recipes.data.model.RecipeListItem
import com.purnaprasanth.recipes.databinding.RecipeListItemBinding
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

class RecipeListRvAdapter @Inject constructor(
    context: Context,
    recipeListItemDiffCallback: RecipeListItemDiffCallback,
    @ContentFul val contentFulImageLoader: ImageLoader
) :
    SingleTypeBaseRvAdapter<RecipeListItemBinding, RecipeListItem>(
        context,
        R.layout.recipe_list_item,
        recipeListItemDiffCallback
    ) {
    override fun onBindViewHolder(binding: RecipeListItemBinding, position: Int) {
        binding.title.text = getItem(position).title
        binding.recipeImage.load(getItem(position).imageUrl, contentFulImageLoader) {
            transformations(RoundedCornersTransformation(4.0f))
        }
    }
}

@Singleton
class RecipeListItemDiffCallback @Inject constructor() : DiffUtil.ItemCallback<RecipeListItem>() {
    override fun areItemsTheSame(oldItem: RecipeListItem, newItem: RecipeListItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: RecipeListItem, newItem: RecipeListItem): Boolean {
        return oldItem.title == newItem.title
    }

}