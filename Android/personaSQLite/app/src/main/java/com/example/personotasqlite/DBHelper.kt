package com.example.personotasqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(base: SQLiteDatabase) {
        val comandoSql =
            "CREATE TABLE personita(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(50), apPat VARCHAR(50), apMat VARCHAR(50), fechaNac TEXT, sexo VARCHAR(50))"
        base.execSQL(comandoSql)
    }

    override fun onUpgrade(base: SQLiteDatabase, i: Int, i1: Int) {
        val comandoSql = "DROP TABLE personita"
        base.execSQL(comandoSql)
        onCreate(base)
    }

    companion object {
        private const val DB_NAME = "personota.db"
        private const val DB_VERSION = 1
    }
}