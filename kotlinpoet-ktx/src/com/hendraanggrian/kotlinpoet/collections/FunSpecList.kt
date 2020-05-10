package com.hendraanggrian.kotlinpoet.collections

import com.hendraanggrian.kotlinpoet.FunSpecBuilder
import com.hendraanggrian.kotlinpoet.KotlinpoetDslMarker
import com.hendraanggrian.kotlinpoet.buildConstructorFunSpec
import com.hendraanggrian.kotlinpoet.buildFunSpec
import com.hendraanggrian.kotlinpoet.buildGetterFunSpec
import com.hendraanggrian.kotlinpoet.buildSetterFunSpec
import com.hendraanggrian.kotlinpoet.constructorFunSpecOf
import com.hendraanggrian.kotlinpoet.funSpecOf
import com.hendraanggrian.kotlinpoet.getterFunSpecOf
import com.hendraanggrian.kotlinpoet.setterFunSpecOf
import com.squareup.kotlinpoet.FunSpec

/** A [FunSpecList] is responsible for managing a set of function instances. */
open class FunSpecList internal constructor(actualList: MutableList<FunSpec>) :
    MutableList<FunSpec> by actualList {

    /** Add function from [name], returning the function added. */
    fun add(name: String): FunSpec =
        funSpecOf(name).also { add(it) }

    /** Add function from [name] with custom initialization [builderAction], returning the function added. */
    inline fun add(name: String, builderAction: FunSpecBuilder.() -> Unit): FunSpec =
        buildFunSpec(name, builderAction).also { add(it) }

    /** Add constructor function, returning the function added. */
    fun addConstructor(): FunSpec =
        constructorFunSpecOf().also { add(it) }

    /** Add constructor function with custom initialization [builderAction], returning the function added. */
    inline fun addConstructor(builderAction: FunSpecBuilder.() -> Unit): FunSpec =
        buildConstructorFunSpec(builderAction).also { add(it) }

    /** Add getter function, returning the function added. */
    fun addGetter(): FunSpec =
        getterFunSpecOf().also { add(it) }

    /** Add getter function with custom initialization [builderAction], returning the function added. */
    inline fun addGetter(builderAction: FunSpecBuilder.() -> Unit): FunSpec =
        buildGetterFunSpec(builderAction).also { add(it) }

    /** Add setter function, returning the function added. */
    fun addSetter(): FunSpec =
        setterFunSpecOf().also { add(it) }

    /** Add setter function with custom initialization [builderAction], returning the function added. */
    inline fun addSetter(builderAction: FunSpecBuilder.() -> Unit): FunSpec =
        buildSetterFunSpec(builderAction).also { add(it) }

    /** Convenient function to add function with operator function. */
    operator fun plusAssign(name: String) {
        add(name)
    }
}

/** Receiver for the `functions` block providing an extended set of operators for the configuration. */
@KotlinpoetDslMarker
class FunSpecListScope(actualList: MutableList<FunSpec>) : FunSpecList(actualList) {

    /** Convenient function to add function with receiver type. */
    inline operator fun String.invoke(builderAction: FunSpecBuilder.() -> Unit): FunSpec =
        add(this, builderAction)
}