package com.example.pripachkin.kotlinproject

import kotlin.reflect.KProperty

/**
 * Created by Anton P. on 07.11.2017.
 */
class NotNullSingleValueVar<T> {
    private var value: T? = null
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} + not init")
    }

    operator fun setValue(thisref: Any?, property: KProperty<*>, valuer: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("${property.name} already init")
    }
    object DelegatesExt {
        fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()
    }
}