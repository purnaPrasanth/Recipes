package com.purnaprasanth.recipes.instances

import com.purnaprasanth.recipes.base.creational.BaseGenerator
import com.purnaprasanth.recipes.base.creational.single
import com.purnaprasanth.recipes.contentful.EntryResource
import com.purnaprasanth.recipes.contentful.data.Recipe
import com.purnaprasanth.recipes.data.Mapper
import com.purnaprasanth.recipes.data.mappers.ContentFulRecipeToRecipe
import com.purnaprasanth.recipes.data.model.RecipeListItem

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

object MapperInstances {
    private val contentFulRecipeToRecipeMapperGenerator: BaseGenerator<Mapper<EntryResource<Recipe>, RecipeListItem>> =
        single {
            ContentFulRecipeToRecipe(NetworkInstances.contentfulServices.assetServices)
        }

    val contentFulRecipeToRecipeMapper: Mapper<EntryResource<Recipe>, RecipeListItem>
        get() = contentFulRecipeToRecipeMapperGenerator.getInstance()
}