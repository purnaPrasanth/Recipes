package com.purnaprasanth.recipes.contentful

import com.google.gson.annotations.SerializedName

/**
 * Created by Purna on 2019-09-14 as a part of Recipes
 **/

sealed class BaseResource<T> {
    abstract val sys: BaseResSys
    abstract val data: T?
}

abstract class IdeableResource<T> : BaseResource<T>() {
    abstract override val sys: IdeableResSys
}

abstract class ContentResource<T> : BaseResource<T>() {
    abstract override val sys: ContentResSys
}

data class ArrayResource<T : BaseResource<*>>(
    @SerializedName("sys") override val sys: ArrayResSys,
    @SerializedName("total") val total: Int,
    @SerializedName("skip") val skip: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("items") override val data: List<T>
) : BaseResource<List<T>>()

data class LinkRes(
    @SerializedName("sys") override val sys: LinkResSys,
    override val data: Nothing? = null
) : IdeableResource<Nothing>()

data class EntryResource<T>(
    @SerializedName("sys") override val sys: EntryResSys,
    @SerializedName("fields") override val data: T
) : BaseResource<T>()

data class AssetResource<T>(
    @SerializedName("sys") override val sys: AssetResSys,
    @SerializedName("fields") override val data: T
) : BaseResource<T>()