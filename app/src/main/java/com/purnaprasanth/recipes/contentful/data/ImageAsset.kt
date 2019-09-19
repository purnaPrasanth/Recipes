package com.purnaprasanth.recipes.contentful.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

/**
 * Data class for fetching Image Assets
 *
 * Knowns Usages in [AssetResource]
 */

data class ImageAsset(
    @SerializedName("file")
    val fileDetails: AssetFile,
    @SerializedName("title")
    val title: String
)

data class AssetFile(
    @SerializedName("contentType")
    val contentType: String,
    @SerializedName("details")
    val details: Details,
    @SerializedName("fileName")
    val fileName: String,
    @SerializedName("url")
    val url: String
)

data class Details(
    @SerializedName("image")
    val image: Image,
    @SerializedName("size")
    val size: Int
)

data class Image(
    @SerializedName("height")
    val height: Int,
    @SerializedName("width")
    val width: Int
)