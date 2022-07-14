package com.example.movil1firma_digital.Transacciones;

public class Transacciones
{
    /* tablas */
    public static final String tablaFirma = "tblfirma";
    /* Campos */
    public static final String id = "id";
    public static final String descripcion = "descripcion";
    public static final String firma = "firma";

    /* tablas - CREATE , DROP */
    public static final String CreateTableFirma = "CREATE TABLE tblfirma(id INTEGER PRIMARY KEY AUTOINCREMENT, firma BLOB,descripcion TEXT)";

    public static final String DropTableFirma  = "DROP TABLE IF EXISTS tblfirma";

    /* Creacion del nombre de la base de datos */
    public static final String NameDataBase = "DBpm12";
    public static final String test1 = "select * from tblfirma";

}
