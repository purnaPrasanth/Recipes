package com.purnaprasanth.recipes.contentful

import com.google.gson.annotations.SerializedName

/**
 * Created by Purna on 2019-09-13 as a part of Recipes
 **/

/**
 * Base Class for fetching meta data of resources from ContentFul Delivery API
 */
sealed class BaseResSys {
    abstract val type: String
}

/**
 * Base Class for fetching meta data of resources that have an ID from ContentFul Delivery API
 */
abstract class IdeableResSys : BaseResSys() {
    abstract val id: String
}

/**
 * Base Class for fetching meta data of a resources in a space from ContentFul Delivery API
 */
abstract class SpaceResSys : IdeableResSys() {
    abstract val spaceRes: LinkRes
}

/**
 * Base Class for fetching meta data of content resources from ContentFul Delivery API
 */
abstract class ContentResSys : SpaceResSys() {
    abstract val contentType: LinkRes
}

data class ArrayResSys(
    @SerializedName("type") override val type: String = "Array"
) : BaseResSys()


/**
 * Meta Data of a Link Resource
 */
data class LinkResSys(
    @SerializedName("type") override val type: String = "Link",
    @SerializedName("linkType") val linkType: String,
    @SerializedName("id") override val id: String
) : IdeableResSys()

/**
 * Meta Data of a Entry Resource
 */
data class EntryResSys(
    @SerializedName("type") override val type: String = "Entry",
    @SerializedName("id") override val id: String,
    @SerializedName("contentType") override val contentType: LinkRes,
    @SerializedName("space") override val spaceRes: LinkRes
) : ContentResSys()

/**
 * Meta Data of a Asset Resource
 */
data class AssetResSys(
    @SerializedName("type") override val type: String = "Asset",
    @SerializedName("id") override val id: String,
    @SerializedName("space") override val spaceRes: LinkRes
) : SpaceResSys()