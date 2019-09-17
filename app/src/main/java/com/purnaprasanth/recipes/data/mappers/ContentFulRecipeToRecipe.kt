package com.purnaprasanth.recipes.data.mappers

import com.purnaprasanth.recipes.contentful.EntryResource
import com.purnaprasanth.recipes.contentful.data.Recipe
import com.purnaprasanth.recipes.data.Mapper
import com.purnaprasanth.recipes.data.model.RecipeListItem

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

object ContentFulRecipeToRecipe : Mapper<EntryResource<Recipe>, RecipeListItem> {
    override suspend fun map(from: EntryResource<Recipe>): RecipeListItem {
        return RecipeListItem(title = from.data.title)
    }
}