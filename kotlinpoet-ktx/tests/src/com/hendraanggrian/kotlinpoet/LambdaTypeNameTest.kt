package com.hendraanggrian.kotlinpoet

import com.squareup.kotlinpoet.DOUBLE
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.UNIT
import kotlin.test.Test
import kotlin.test.assertEquals

class LambdaTypeNameTest2 {

    @Test fun parameterSpecListParameters() {
        val int = buildParameter<Int>("int")
        val string = buildParameter<String>("string")
        assertEquals(
            "kotlin.Double.() -> kotlin.Unit",
            "${UNIT.lambdaBy2(emptyList(), receiver = DOUBLE)}"
        )
        assertEquals(
            "kotlin.Double.(int: kotlin.Int, string: kotlin.String) -> kotlin.Unit",
            "${UNIT.lambdaBy2(listOf(int, string), receiver = DOUBLE)}"
        )
        assertEquals(
            "kotlin.Double.(int: kotlin.Int, string: kotlin.String) -> kotlin.Unit",
            "${Unit::class.java.lambdaBy2(listOf(int, string), receiver = Double::class.java)}"
        )
        assertEquals(
            "kotlin.Double.(int: kotlin.Int, string: kotlin.String) -> kotlin.Unit",
            "${Unit::class.lambdaBy2(listOf(int, string), receiver = Double::class)}"
        )
    }

    @Test fun typeVarargParameters() {
        assertEquals(
            "kotlin.Double.() -> kotlin.Unit",
            "${UNIT.lambdaBy2(receiver = DOUBLE)}"
        )
        assertEquals(
            "kotlin.Double.(kotlin.Int, kotlin.String) -> kotlin.Unit",
            "${UNIT.lambdaBy2(INT, STRING, receiver = DOUBLE)}"
        )
        assertEquals(
            "kotlin.Double.(kotlin.Int, java.lang.String) -> kotlin.Unit",
            "${Unit::class.java.lambdaBy2(Int::class.java, String::class.java, receiver = Double::class.java)}"
        )
        assertEquals(
            "kotlin.Double.(kotlin.Int, kotlin.String) -> kotlin.Unit",
            "${Unit::class.lambdaBy2(Int::class, String::class, receiver = Double::class)}"
        )
    }

    @Test fun parameterSpecVarargParameters() {
        val int = buildParameter<Int>("int")
        val string = buildParameter<String>("string")
        assertEquals(
            "kotlin.Double.() -> kotlin.Unit",
            "${UNIT.lambdaBy2(*emptyArray<ParameterSpec>(), receiver = DOUBLE)}"
        )
        assertEquals(
            "kotlin.Double.(int: kotlin.Int, string: kotlin.String) -> kotlin.Unit",
            "${UNIT.lambdaBy2(int, string, receiver = DOUBLE)}"
        )
        assertEquals(
            "kotlin.Double.(int: kotlin.Int, string: kotlin.String) -> kotlin.Unit",
            "${Unit::class.java.lambdaBy2(int, string, receiver = Double::class.java)}"
        )
        assertEquals(
            "kotlin.Double.(int: kotlin.Int, string: kotlin.String) -> kotlin.Unit",
            "${Unit::class.lambdaBy2(int, string, receiver = Double::class)}"
        )
    }
}