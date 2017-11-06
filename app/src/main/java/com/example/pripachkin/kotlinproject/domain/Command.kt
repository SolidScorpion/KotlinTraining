package com.example.pripachkin.kotlinproject.domain

/**
 * Created by Pripachkin on 06.11.2017.
 */
interface Command<out T> {
    fun execute(): T
}