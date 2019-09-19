package com.purnaprasanth.recipes.contentful

import com.google.gson.annotations.SerializedName

/**
 * Created by Purna on 2019-09-13 as a part of Recipes
 **/

sealed class BaseResSys {
    abstract val type: String
}

abstract class IdeableResSys : BaseResSys() {
    abstract val id: String
}

abstract class SpaceResSys : IdeableResSys() {
    abstract val spaceRes: LinkRes
}

abstract class ContentResSys : SpaceResSys() {
    abstract val contentType: LinkRes
}

data class ArrayResSys(
    @SerializedName("type") override val type: String = "Array"
) : BaseResSys()

data class LinkResSys(
    @SerializedName("type") override val type: String = "Link",
    @SerializedName("linkType") val linkType: String,
    @SerializedName("id") override val id: String
) : IdeableResSys()

data class EntryResSys(
    @SerializedName("type") override val type: String = "Entry",
    @SerializedName("id") override val id: String,
    @SerializedName("contentType") override val contentType: LinkRes,
    @SerializedName("space") override val spaceRes: LinkRes
) : ContentResSys()

data class AssetResSys(
    @SerializedName("type") override val type: String = "Asset",
    @SerializedName("id") override val id: String,
    @SerializedName("space") override val spaceRes: LinkRes
) : SpaceResSys()