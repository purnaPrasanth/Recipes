package com.purnaprasanth.recipes.contentful.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Purna on 2019-09-18 as a part of Recipes
 **/

data class Chef(
    @SerializedName("name") val name: String
)