package com.example.pripachkin.kotlinproject.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by Anton P. on 07.11.2017.
 */

class MyDatabaseHelper(context: Context) : SQLiteOpenHelper(context, "Blabla", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}
