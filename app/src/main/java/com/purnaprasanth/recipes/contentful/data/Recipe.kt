package com.purnaprasanth.recipes.contentful.data

import com.google.gson.annotations.SerializedName
import com.purnaprasanth.recipes.contentful.LinkRes

/**
 * Created by Purna on 2019-09-14 as a part of Recipes
 **/

/**
 * Data class for fetching Recipe Details
 *
 * Knowns Usages in [EntryResource]
 */

data class Recipe(
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("photo") val photo: LinkRes,
    @SerializedName("calories") val calories: Int,
    @SerializedName("chef") val chef: LinkRes? = null,
    @SerializedName("tags") val tags: List<LinkRes>? = null
)