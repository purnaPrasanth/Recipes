package com.purnaprasanth.recipes.contentful

import com.purnaprasanth.recipes.contentful.dataservices.IAssetServices
import com.purnaprasanth.recipes.contentful.dataservices.IRecipeServices

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

/**
 * A Utility for Providing Data Services of ContentFul Delivery API
 */

interface IContentFulServices {
    val recipeServices: IRecipeServices

    val assetServices: IAssetServices
}