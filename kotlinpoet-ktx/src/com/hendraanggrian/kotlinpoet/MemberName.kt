package com.hendraanggrian.kotlinpoet

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.MemberName
import kotlin.reflect.KClass

/** Returns a [MemberName] using package and target name. */
fun String.memberOf(simpleName: String): MemberName = MemberName(this, simpleName)

/** Returns a [MemberName] using enclosing [ClassName] and target name. */
fun ClassName.memberOf(simpleName: String): MemberName = MemberName.run { member(simpleName) }

/** Returns a [MemberName] using enclosing [Class] and target name. */
fun Class<*>.memberOf(simpleName: String): MemberName = MemberName.run { member(simpleName) }

/** Returns a [MemberName] using enclosing [KClass] and target name. */
fun KClass<*>.memberOf(simpleName: String): MemberName = MemberName.run { member(simpleName) }
