package com.example.personitasqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "base_personita.db";
    private static int DB_VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase base) {
        String comandoSql = "CREATE TABLE personita(nombre VARCHAR(50))";
        base.execSQL(comandoSql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase base, int i, int i1) {
        String comandoSql = "DROP TABLE personita";
        base.execSQL(comandoSql);
        onCreate(base);
    }
}
