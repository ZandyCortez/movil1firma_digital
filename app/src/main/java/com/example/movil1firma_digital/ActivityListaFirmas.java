package com.example.movil1firma_digital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.movil1firma_digital.OBJ.Adaptador;
import com.example.movil1firma_digital.OBJ.signaturess;
import com.example.movil1firma_digital.Transacciones.Transacciones;

import java.util.ArrayList;
import java.util.List;

public class ActivityListaFirmas extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adaptador reviewadapter;
    SQLiteConexion conexion;
    ListView listfoto;
    ArrayList<signaturess> lista;
    ArrayList<String> ArregloFirmas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_firmas);

        recyclerView=(RecyclerView)findViewById(R.id.viewRe);//iniciamos el recycle view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//le damos un tipo de layout a el recycle

        reviewadapter=new Adaptador(ObtenerFirma());//creamos o inizializamos el adaptador con los datos de obtener foto
        recyclerView.setAdapter(reviewadapter);//le ponemos el adaptador al recycle view
    }

    private List<signaturess> ObtenerFirma()
    {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase,null,1);
        SQLiteDatabase db= conexion.getReadableDatabase();
        signaturess firma=null;
        lista= new ArrayList<signaturess>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.tablaFirma, null);

        while(cursor.moveToNext())
        {
            firma = new signaturess();
            firma.setId(cursor.getInt(0));
            firma.setDescripcion(cursor.getString(2));
            firma.setFirma(cursor.getBlob(1));
            lista.add(firma);
        }
        cursor.close();
        return lista;
    }
}