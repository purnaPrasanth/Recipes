package com.purnaprasanth.recipes.di

import com.purnaprasanth.recipes.Common
import com.purnaprasanth.recipes.IO
import com.purnaprasanth.recipes.Main
import com.purnaprasanth.recipes.async.CommonExecutor
import com.purnaprasanth.recipes.async.IOExecutor
import com.purnaprasanth.recipes.async.MainThreadExecutor
import com.purnaprasanth.recipes.base.Dispatchers
import com.purnaprasanth.recipes.base.Executors
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.asCoroutineDispatcher
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

@Module
class ExecutorsModule {

    @Provides
    @Singleton
    fun provideAppExecutors(
        mainExecutor: MainThreadExecutor,
        ioExecutor: IOExecutor,
        commonExecutor: CommonExecutor
    ): Executors {
        return Executors(
            mainExecutor = mainExecutor.executor,
            ioExecutor = ioExecutor.executor,
            commonExecutor = commonExecutor.executor
        )
    }

    @Provides
    @Singleton
    fun provideAppDispatchers(appExecutors: Executors): Dispatchers {
        return Dispatchers(
            mainDispatcher = appExecutors.mainExecutor.asCoroutineDispatcher(),
            ioDispatcher = appExecutors.ioExecutor.asCoroutineDispatcher(),
            commonDispatcher = appExecutors.commonExecutor.asCoroutineDispatcher()
        )
    }

    @Provides
    @IO
    fun provideIODispatcher(appDispatchers: Dispatchers) = appDispatchers.ioDispatcher

    @Provides
    @Common
    fun provideCommonDispatcher(appDispatchers: Dispatchers) = appDispatchers.commonDispatcher

    @Provides
    @Main
    fun provideMainDispatcher(appDispatchers: Dispatchers) = appDispatchers.mainDispatcher

    @Provides
    @IO
    fun provideIOExecutor(appExecutors: Executors) = appExecutors.ioExecutor

    @Provides
    @Common
    fun provideCommonExecutor(appExecutors: Executors) = appExecutors.commonExecutor

    @Provides
    @Main
    fun provideMainExecutor(appExecutors: Executors) = appExecutors.mainExecutor


}