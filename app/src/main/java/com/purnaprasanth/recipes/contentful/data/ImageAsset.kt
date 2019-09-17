package com.purnaprasanth.recipes.contentful.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

data class ImageAsset(
    @SerializedName("file")
    val fileDetails: File,
    @SerializedName("title")
    val title: String
)

data class File(
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