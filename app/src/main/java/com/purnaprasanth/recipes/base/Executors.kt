package com.purnaprasanth.recipes.base

import java.util.concurrent.Executor

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

/**
 * Executors to be used across App
 * @param mainExecutor The Executor for Operations on Main Thread
 * @param ioExecutor The Executor for IO Operations
 * @param commonExecutor The Executor for Common Computational Operations
 *
 * Usually Used to create [Dispatchers]
 */
data class Executors(
    val mainExecutor: Executor,
    val ioExecutor: Executor,
    val commonExecutor: Executor
)