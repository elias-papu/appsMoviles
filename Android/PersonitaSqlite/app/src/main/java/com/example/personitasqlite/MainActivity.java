package com.example.personitasqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button botonGuardar;
    EditText editNombre;
    ListView listaPersonitas;
    DataManager dataManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataManager = new DataManager(getApplicationContext());
        botonGuardar = (Button)findViewById(R.id.boton_guardar);
        editNombre = (EditText)findViewById(R.id.edit_nombre);
        listaPersonitas = (ListView)findViewById(R.id.lista_personitas);
        mostrarPersonitas();
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = editNombre.getText().toString();
                if(!nombre.isEmpty()) {
                    Personita fulanito = new Personita(nombre);
                    dataManager.guardarPersonita(fulanito);
                    Toast.makeText(MainActivity.this, "Personita: " + nombre + " guardada!", Toast.LENGTH_SHORT).show();
                    editNombre.setText("");
                    mostrarPersonitas();
                }
                else {
                    Toast.makeText(MainActivity.this, "Debés poner nombre boludo!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void mostrarPersonitas() {
        try {
            ArrayList<Personita> personitas = dataManager.leerPersonitas();
            ArrayAdapter<Personita> adaptador = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, personitas);
            listaPersonitas.setAdapter(adaptador);
            listaPersonitas.setVerticalScrollBarEnabled(true);
        }
        catch(Exception ex) {
            Toast.makeText(this, "Chaval q pollas estas haciendo tío!!!", Toast.LENGTH_SHORT).show();
        }
    }
}