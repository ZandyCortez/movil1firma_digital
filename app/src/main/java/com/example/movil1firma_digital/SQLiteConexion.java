package com.example.movil1firma_digital;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.movil1firma_digital.Transacciones.Transacciones;


public class SQLiteConexion extends SQLiteOpenHelper
{
    public SQLiteConexion(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(Transacciones.CreateTableFirma);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(Transacciones.DropTableFirma);
        onCreate(db);
    }


}
