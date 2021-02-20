package com.ejemploudb.sueldooperario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtnombre,edtsueldo,edtyear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        edtnombre=findViewById(R.id.edtNombre);
        edtsueldo=findViewById(R.id.edtSal);
        edtyear=findViewById(R.id.edtyear);



    }


    public void Send(View  view){

        /*- No debe de permitir ingresar valores negativos ni salario menor a 100*/

        try {
            Double sal= Double.valueOf(edtsueldo.getText().toString());
            if (sal<100) {
                Toast.makeText(getApplicationContext(), "El Salario debe ser mayor a $100.00", Toast.LENGTH_SHORT).show();
            }else {
            String nombre = edtnombre.getText().toString();

            Integer year= Integer.valueOf(edtyear.getText().toString());
            Intent intent = new Intent(this,MainActivity2.class);
            intent.putExtra("name",nombre );
            intent.putExtra("sal",sal);
            intent.putExtra("year",year);
            startActivityForResult(intent,10);

            Toast.makeText(getApplicationContext(), "Se han registrado los Datos", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Todos los campos obligatorios", Toast.LENGTH_SHORT).show();
        }


    }

    public void cerrar(View view) {
        finish();
    }
}