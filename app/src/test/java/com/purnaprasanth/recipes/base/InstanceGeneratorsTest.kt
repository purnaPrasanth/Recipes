package com.purnaprasanth.recipes.base

import com.purnaprasanth.recipes.base.creational.factory
import com.purnaprasanth.recipes.base.creational.single
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by Purna on 2019-09-18 as a part of Recipes
 **/

@RunWith(JUnit4::class)
class InstanceGeneratorsTest {

    @Test
    fun testSingleInstanceGenerator() {
        val generator = single {
            listOf("Hello", "Prasanth")
        }

        assert(generator.getInstance() === generator.getInstance())
    }

    @Test
    fun testFactoryInstanceGenerator() {
        val generator = factory {
            listOf("Hello", "Prasanth")
        }

        assert(generator.getInstance() !== generator.getInstance())
    }
}