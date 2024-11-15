package com.example.personitasqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataManager {
    private Context contexto;
    private DBHelper dbHelper;
    private SQLiteDatabase miBase;

    public DataManager(Context contexto) {
        this.contexto = contexto;
        dbHelper = new DBHelper(contexto);
        miBase = dbHelper.getWritableDatabase();
    }

    void abrir() {
        miBase = dbHelper.getWritableDatabase();
    }

    void cerrar() {
        miBase.close();
    }

    void guardarPersonita(Personita fulanito) {
        ContentValues valores = new ContentValues();

        valores.put("nombre", fulanito.getNombre());

        miBase.insert("personita", null, valores);
    }

    ArrayList<Personita> leerPersonitas() {
        ArrayList<Personita> personitas = new ArrayList<>();
        String[] columnas = {"nombre"};
        Cursor miCursor = miBase.query("personita", columnas, null, null, null, null, "nombre");
        while(miCursor.moveToNext()) {
            Personita fulanito = new Personita();
            fulanito.setNombre(miCursor.getString(0));
            personitas.add(fulanito);
        }

        miCursor.close();
        return personitas;
    }

}
