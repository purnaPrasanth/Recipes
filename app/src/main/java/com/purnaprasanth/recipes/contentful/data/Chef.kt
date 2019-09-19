package com.purnaprasanth.recipes.contentful.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Purna on 2019-09-18 as a part of Recipes
 **/

/**
 * Data class for fetching Chef Details
 *
 * Knowns Usages in [EntryResource]
 */

data class Chef(
    @SerializedName("name") val name: String
)