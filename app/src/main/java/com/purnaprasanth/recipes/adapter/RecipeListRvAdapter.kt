package com.purnaprasanth.recipes.adapter

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.purnaprasanth.recipes.R
import com.purnaprasanth.recipes.data.model.RecipeListItem
import com.purnaprasanth.recipes.databinding.RecipeListItemBinding

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

class RecipeListRvAdapter(context: Context) : SingleTypeBaseRvAdapter<RecipeListItemBinding, RecipeListItem>(
    context,
    R.layout.recipe_list_item,
    RecipeListItemDiffCallback()
) {
    override fun onBindViewHolder(binding: RecipeListItemBinding, position: Int) {
        binding.title.text = getItem(position).title
    }
}

class RecipeListItemDiffCallback : DiffUtil.ItemCallback<RecipeListItem>() {
    override fun areItemsTheSame(oldItem: RecipeListItem, newItem: RecipeListItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: RecipeListItem, newItem: RecipeListItem): Boolean {
        return oldItem.title == newItem.title
    }

}