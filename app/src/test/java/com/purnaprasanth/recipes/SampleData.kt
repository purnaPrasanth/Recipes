package com.purnaprasanth.recipes

import com.purnaprasanth.recipes.contentful.AssetResSys
import com.purnaprasanth.recipes.contentful.EntryResSys
import com.purnaprasanth.recipes.contentful.LinkRes
import com.purnaprasanth.recipes.contentful.LinkResSys
import com.purnaprasanth.recipes.contentful.data.*
import com.purnaprasanth.recipes.data.model.RecipeListItem

/**
 * Created by Purna on 2019-09-19 as a part of Recipes
 **/

val photoResSys = LinkResSys(
    type = "Link",
    linkType = "Asset",
    id = "5mFyTozvSoyE0Mqseoos86"
)

val chefResSys = photoResSys.copy(linkType = "Entry", id = "NysGB8obcaQWmq0aQ6qkC")

val spaceResSys = photoResSys.copy(linkType = "Space", id = "kk2bw5ojx476")

val environmentResSys = spaceResSys.copy(linkType = "Environment", id = "master")

val recipeContentTypeResSys = spaceResSys.copy(linkType = "ContentType", id = "recipe")

val tagResSys = chefResSys.copy(id = "61Lgvo6rzUIgIGgcOAMgQ8")

val recipeEntryResSys = EntryResSys(
    spaceRes = LinkRes(spaceResSys),
    type = "Entry",
    id = "437eO3ORCME46i02SeCW46",
    contentType = LinkRes(recipeContentTypeResSys)
)

val imageEntryResSys: AssetResSys = AssetResSys(
    spaceRes = LinkRes(spaceResSys),
    type = "Asset",
    id = "61XHcqOBFYAYCGsKugoMYK"
)

val recipe1 = Recipe(
    title = "Crispy Chicken and Rice\\twith Peas & Arugula Salad",
    description = "Crispy chicken skin, tender meat, and rich, tomatoey sauce form a winning trifecta of delicious in this one-pot braise. We spoon it over rice and peas to soak up every last drop of goodness, and serve a tangy arugula salad alongside for a vibrant boost of flavor and color. Dinner is served! Cook, relax, and enjoy!",
    photo = LinkRes(photoResSys),
    calories = 178
)

val recipe2 = recipe1.copy(chef = LinkRes(chefResSys))

val recipe3 = recipe1.copy(tags = listOf(LinkRes(tagResSys)))

val recipe4 = recipe1.copy(tags = listOf(LinkRes(tagResSys)), chef = LinkRes(chefResSys))

val contentFulRecipeList = listOf(recipe1, recipe2, recipe3, recipe4)

val immageAsset = ImageAsset(
    title = "SKU1240 hero-374f8cece3c71f5fcdc939039e00fb96",
    fileDetails = AssetFile(
        contentType = "image/jpeg",
        details = Details(
            image = Image(height = 680, width = 1020),
            size = 194737
        ),
        fileName = "SKU1240_hero-374f8cece3c71f5fcdc939039e00fb96.jpg",
        url = "//images.ctfassets.net/kk2bw5ojx476/61XHcqOBFYAYCGsKugoMYK/0009ec560684b37f7f7abadd66680179/SKU1240_hero-374f8cece3c71f5fcdc939039e00fb96.jpg"
    )
)

val recipeListItems = contentFulRecipeList.map {
    RecipeListItem(
        title = it.title,
        id = "437eO3ORCME46i02SeCW46",
        imageUrl = "https://images.ctfassets.net/kk2bw5ojx476/61XHcqOBFYAYCGsKugoMYK/0009ec560684b37f7f7abadd66680179/SKU1240_hero-374f8cece3c71f5fcdc939039e00fb96.jpg"
    )
}