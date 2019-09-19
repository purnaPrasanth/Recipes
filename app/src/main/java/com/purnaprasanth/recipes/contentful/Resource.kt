package com.purnaprasanth.recipes.contentful

import com.google.gson.annotations.SerializedName

/**
 * Created by Purna on 2019-09-14 as a part of Recipes
 **/

/**
 * Base Class for fetching resources from ContentFul Delivery API
 * @param T the type of data in this resource
 */
sealed class BaseResource<T> {
    abstract val sys: BaseResSys
    abstract val data: T?
}

/**
 * Base Class for fetching resources that have ID from ContentFul Delivery API
 * @param T the type of data in this resource
 */
abstract class IdeableResource<T> : BaseResource<T>() {
    abstract override val sys: IdeableResSys
}

/**
 * Base Class for fetching content resources from ContentFul Delivery API
 * @param T the type of data in this resource
 */
abstract class ContentResource<T> : BaseResource<T>() {
    abstract override val sys: ContentResSys
}

/**
 * Base Class for fetching array of resources from ContentFul Delivery API
 *
 * @param T the type of data in this resource. Must be a subclass of [BaseResource]
 */
data class ArrayResource<T : BaseResource<*>>(
    @SerializedName("sys") override val sys: ArrayResSys,
    @SerializedName("total") val total: Int,
    @SerializedName("skip") val skip: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("items") override val data: List<T>
) : BaseResource<List<T>>()

/**
 * Base Class for fetching Link resources from ContentFul Delivery API
 *
 * Holds no data
 */
data class LinkRes(
    @SerializedName("sys") override val sys: LinkResSys,
    override val data: Nothing? = null
) : IdeableResource<Nothing>()

/**
 * Base Class for fetching Entry resources from ContentFul Delivery API
 *
 * @param T the type of data in this resource
 */
data class EntryResource<T>(
    @SerializedName("sys") override val sys: EntryResSys,
    @SerializedName("fields") override val data: T
) : BaseResource<T>()

/**
 * Base Class for fetching Asset resources from ContentFul Delivery API
 *
 * @param T the type of data in this Asset
 */
data class AssetResource<T>(
    @SerializedName("sys") override val sys: AssetResSys,
    @SerializedName("fields") override val data: T
) : BaseResource<T>()