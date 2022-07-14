package com.example.movil1firma_digital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movil1firma_digital.OBJ.CaptureBitmap;
import com.example.movil1firma_digital.Transacciones.Transacciones;

public class MainActivity extends AppCompatActivity {
    EditText Descripcion;
    CaptureBitmap firma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firma =(CaptureBitmap)findViewById(R.id.firma);
//        CaptureBitmap firma = (CaptureBitmap)findViewById(R.id.firma);
        Descripcion = (EditText) findViewById(R.id.Descripcion);


        Button btnlista = (Button) findViewById(R.id.btnlista);
        btnlista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityListaFirmas.class);
                startActivity(intent);
            }
        });

        Button btnsave = (Button) findViewById(R.id.btnguardar);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                if(!Descripcion.getText().toString().isEmpty()){
                    guardarImagen();
                }else{
                    Toast.makeText(getApplicationContext(),"INGRRESE DESCRIPCION",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void guardarImagen()
    {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.descripcion, Descripcion.getText().toString());
        valores.put(Transacciones.firma,firma.getBytes());

        Long resultado = db.insert(Transacciones.tablaFirma,Transacciones.id,valores);
        Toast.makeText(getApplicationContext(),"Registro Ingresado! COD:"+resultado.toString(),Toast.LENGTH_LONG).show();

        db.close();

        Descripcion.setText("");
        firma.ClearCanvas();
    }


}