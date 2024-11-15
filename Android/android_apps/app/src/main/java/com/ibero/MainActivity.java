package com.ibero;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity { //MainActivity hereda de la clase AppCompatActivity

    EditText editNombre;
    Button botonAceptar;
    TextView textoSaludo;
    ImageView imagenChileMorron;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //se sobreescribe onCreate con el Override
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //aquí se vincula el main_activity de res/layout

        editNombre = (EditText) findViewById(R.id.editNombre); //instanciamos el objeto editNombre
        botonAceptar = (Button) findViewById(R.id.buttonAceptar);
        textoSaludo = (TextView) findViewById(R.id.textSaludo);
        imagenChileMorron = (ImageView) findViewById(R.id.image_chile_morron);

        textoSaludo.setText("");
        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre;
                nombre = editNombre.getText().toString();
                textoSaludo.setText("Hola " + nombre + " mucho gusto!");
                Toast.makeText(getApplicationContext(), "Me apretaste chaval!", Toast.LENGTH_LONG).show();
            }
        });

        imagenChileMorron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;

                if((count % 2) == 1) {
                    Toast.makeText(getApplicationContext(), "Apretaste al chile morrón!", Toast.LENGTH_LONG).show();
                    imagenChileMorron.setImageResource(R.drawable.papu);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Apretaste al papu :v", Toast.LENGTH_LONG).show();
                    imagenChileMorron.setImageResource(R.drawable.chile_morron);
                }
            }
        });


    }
}