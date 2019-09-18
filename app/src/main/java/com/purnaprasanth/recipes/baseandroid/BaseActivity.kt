package com.purnaprasanth.recipes.baseandroid

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.purnaprasanth.recipes.base.Dispatchers
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import java.util.concurrent.CancellationException
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

/**
 * Base Class for activities across the app that heavily uses @see <a href="https://developer.android.com/topic/libraries/data-binding">Data Binding</a>
 *
 * @param BINDING type of view binding that this [AppCompatActivity] uses
 * @param layoutId the layout id for [setContentView]
 *
 * This also implements [CoroutineScope], hence acts as a parent for all the coRoutines started in this activity scope or Lifecycle
 * @property parentJob parent job for the coRoutines started in this scope
 * @property binding Binding class made available for child classes for introducing effects
 */

abstract class BaseActivity<BINDING : ViewDataBinding>(@LayoutRes val layoutId: Int) :
    DaggerAppCompatActivity(), CoroutineScope {
    protected lateinit var binding: BINDING

    private val parentJob = SupervisorJob()

    @Inject
    lateinit var dispatchers: Dispatchers

    override val coroutineContext: CoroutineContext
        get() = dispatchers.mainDispatcher + parentJob

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        initUI()
    }

    override fun onDestroy() {
        super.onDestroy()
        parentJob.cancel(cause = CancellationException("Parent Scope Destroyed"))
    }

    abstract fun initUI()
}