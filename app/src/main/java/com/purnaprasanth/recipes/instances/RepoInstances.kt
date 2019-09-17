package com.purnaprasanth.recipes.instances

import com.purnaprasanth.recipes.base.creational.BaseGenerator
import com.purnaprasanth.recipes.base.creational.single
import com.purnaprasanth.recipes.data.datasources.recipe.ContentFulDataSource
import com.purnaprasanth.recipes.data.datasources.recipe.IRecipeDataSource
import com.purnaprasanth.recipes.data.repo.RecipeRepo

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

object RepoInstances {

    private val contentfulRecipeDatasourceGenerator: BaseGenerator<IRecipeDataSource> = single {
        ContentFulDataSource(
            NetworkInstances.contentfulServices.recipeServices,
            NetworkInstances.networkCallRunner,
            MapperInstances.contentFulRecipeToRecipeMapper
        )
    }

    private val recipeRepoGenerator: BaseGenerator<RecipeRepo> = single {
        RecipeRepo(contentFulRecipeDataSource)
    }

    val contentFulRecipeDataSource: IRecipeDataSource
        get() = contentfulRecipeDatasourceGenerator.getInstance()

    val recipeRepo: RecipeRepo
        get() = recipeRepoGenerator.getInstance()
}