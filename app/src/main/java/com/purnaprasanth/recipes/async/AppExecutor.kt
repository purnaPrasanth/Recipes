package com.purnaprasanth.recipes.async

import java.util.concurrent.Executor

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

/**
 * Base Executor
 */

interface AppExecutor {
    val executor: Executor
}