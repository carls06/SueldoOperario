package com.ejemploudb.sueldooperario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    String nombre;
    Double sal;
    int year;
    TextView txtname,txtSueldo,txtyear, txtporcentaje,txtnuevosal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        txtname=findViewById(R.id.info_nombre);
        txtSueldo=findViewById(R.id.info_sal);
        txtyear=findViewById(R.id.info_year);
        txtnuevosal=findViewById(R.id.newsal);
        txtporcentaje=findViewById(R.id.porcentaje);


        Bundle data = getIntent().getExtras();
        nombre=data.getString("name","");
        sal=data.getDouble("sal",0.0);
        year=data.getInt("year",0);
        mostrarDatos();




    }

    public  void mostrarDatos(){
        double temp,nuevosal;
        txtname.setText("Nombre:   "+" "+ nombre);
        txtSueldo.setText("Sueldo:  "+"$ "+Double.valueOf(sal));
        txtyear.setText("Antiguedad:   "+""+Integer.valueOf(year)+" Años");
/*
        a) Si el sueldo es inferior a 500 y su antigüedad es igual o superior a 10 años, otorgarle un aumento del 20 %, mostrar el sueldo a pagar.

        b) Si el sueldo es inferior a 500 pero su antigüedad es menor a 10 años, otorgarle un aumento de 5 %.

        c) Si el sueldo es mayor o igual a 500 mostrar el sueldo en pantalla sin cambios.*/

        if(Double.valueOf(sal)<500 && Integer.valueOf(year)>=10){
            temp=sal*0.20;
            nuevosal =sal+temp;
            txtnuevosal.setText("El Nuevo sueldo a pagar es: $"+ nuevosal);
            txtporcentaje.setText("Aumento del 20%");

        }else if (Double.valueOf(sal)<500 && Integer.valueOf(year)<10){
            temp=sal*0.10;
            nuevosal =sal+temp;
            txtnuevosal.setText("El Nuevo sueldo a pagar es: $"+ nuevosal);
            txtporcentaje.setText("Aumento del 10%");
        }
        else if (Double.valueOf(sal)>=500){
            txtporcentaje.setText("No se realiza ningun cambio");

        }


    }



    public void Regresar(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}