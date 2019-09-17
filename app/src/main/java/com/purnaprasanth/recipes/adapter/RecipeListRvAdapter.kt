package com.purnaprasanth.recipes.adapter

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.purnaprasanth.recipes.R
import com.purnaprasanth.recipes.data.model.RecipeListItem
import com.purnaprasanth.recipes.databinding.RecipeListItemBinding
import com.purnaprasanth.recipes.instances.NetworkInstances

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
        binding.recipeImage.load(getItem(position).imageUrl, NetworkInstances.contentfulCoilImageLoader) {
            transformations(RoundedCornersTransformation(4.0f))
        }
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