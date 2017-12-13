package pe.edu.upc.municipalidadcallao.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.CuentaCte;
import pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.Declaracion;
import pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.Vehiculo;

/**
 * Created by RENSO on 12/12/2017.
 */

public class MunicipalidadDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MuniDB.db";

    private List<CuentaCte> lstCuentaCte = new ArrayList<>();
    private List<Declaracion> lstDeclaracion = new ArrayList<>();
    private List<Vehiculo> lstVehiculo = new ArrayList<>();

    public MunicipalidadDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Comandos SQL


        db.execSQL("CREATE TABLE " + CuentaCteContract.CuentaCteEntry.TABLE_NAME + " ("
                + CuentaCteContract.CuentaCteEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CuentaCteContract.CuentaCteEntry.ID + " TEXT NOT NULL,"
                + CuentaCteContract.CuentaCteEntry.ID_DECLARACION + " TEXT NOT NULL,"
                + CuentaCteContract.CuentaCteEntry.ANIO + " TEXT NOT NULL,"
                + CuentaCteContract.CuentaCteEntry.PERIODO + " TEXT NOT NULL,"
                + CuentaCteContract.CuentaCteEntry.INSOLUTO + " TEXT NOT NULL,"
                + CuentaCteContract.CuentaCteEntry.EMISION + " TEXT,"
                + CuentaCteContract.CuentaCteEntry.INTERES + " TEXT,"
                + CuentaCteContract.CuentaCteEntry.INDICADOR + " TEXT,"
                + CuentaCteContract.CuentaCteEntry.RECIBO + " TEXT,"
                + CuentaCteContract.CuentaCteEntry.FECHA_PAGO + " TEXT,"
                + "UNIQUE (" + CuentaCteContract.CuentaCteEntry.ID + "))");

/*
        db.execSQL("CREATE TABLE " + DeclaracionContract.DeclaracionEntry.TABLE_NAME + " ("
                + DeclaracionContract.DeclaracionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DeclaracionContract.DeclaracionEntry.ID + " TEXT NOT NULL,"
                + DeclaracionContract.DeclaracionEntry.ID_VEHICULO + " TEXT NOT NULL,"
                + DeclaracionContract.DeclaracionEntry.ID_USUARIO + " TEXT NOT NULL,"
                + DeclaracionContract.DeclaracionEntry.PORCENTAJE + " integer NOT NULL,"
                + DeclaracionContract.DeclaracionEntry.BASE_IMPONIBLE + " TEXT NOT NULL,"
                + DeclaracionContract.DeclaracionEntry.IMPUESTO + " TEXT,"
                + DeclaracionContract.DeclaracionEntry.FECHA_DECLARACION + " TEXT,"
                + DeclaracionContract.DeclaracionEntry.AFECTO_DESDE + " TEXT,"
                + DeclaracionContract.DeclaracionEntry.ANIO_ADQUISICION + " TEXT,"
                + DeclaracionContract.DeclaracionEntry.MONEDA + " TEXT,"
                + DeclaracionContract.DeclaracionEntry.TIPO_CAMBIO + " TEXT,"
                + DeclaracionContract.DeclaracionEntry.VALOR_REAL_ADQUISICION + " TEXT,"
                + DeclaracionContract.DeclaracionEntry.VALOR_MEF + " TEXT,"
                + "UNIQUE (" + DeclaracionContract.DeclaracionEntry.ID + "))");


        db.execSQL("CREATE TABLE " + UsuarioContract.UsuarioEntry.TABLE_NAME + " ("
                + UsuarioContract.UsuarioEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UsuarioContract.UsuarioEntry.ID + " TEXT NOT NULL,"
                + UsuarioContract.UsuarioEntry.DNI + " TEXT NOT NULL,"
                + UsuarioContract.UsuarioEntry.NOMBRE + " TEXT NOT NULL,"
                + UsuarioContract.UsuarioEntry.APELLIDO_PATERNO+ " integer NOT NULL,"
                + UsuarioContract.UsuarioEntry.APELLIDO_MATERNO + " TEXT NOT NULL,"
                + UsuarioContract.UsuarioEntry.DIRECCION + " TEXT,"
                + UsuarioContract.UsuarioEntry.DISTRITO+ " TEXT,"
                + UsuarioContract.UsuarioEntry.CORREO_ELECTRONICO+ " TEXT,"
                + UsuarioContract.UsuarioEntry.CLAVE+ " TEXT,"
                + "UNIQUE (" + UsuarioContract.UsuarioEntry.ID + "))");

        db.execSQL("CREATE TABLE " + VehiculoContract.VehiculoEntry.TABLE_NAME + " ("
                + VehiculoContract.VehiculoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + VehiculoContract.VehiculoEntry.ID + " TEXT NOT NULL,"
                + VehiculoContract.VehiculoEntry.PLACA + " TEXT NOT NULL,"
                + VehiculoContract.VehiculoEntry.MARCA + " TEXT NOT NULL,"
                + VehiculoContract.VehiculoEntry.MODELO+ " integer NOT NULL,"
                + VehiculoContract.VehiculoEntry.CATEGORIA + " TEXT NOT NULL,"
                + VehiculoContract.VehiculoEntry.ANIO_FABRICACION + " TEXT,"
                + VehiculoContract.VehiculoEntry.FECHA_REGISTRO_PUBLICO + " TEXT,"
                + VehiculoContract.VehiculoEntry.PROVINCIA + " TEXT,"
                + "UNIQUE (" + VehiculoContract.VehiculoEntry.ID + "))");
*/
         doLoadInitialData(db);
    }


    public void doLoadInitialData(SQLiteDatabase db) {
        lstCuentaCte.add(new CuentaCte("1", "2016", "2016", "2017", "17", "0.5", "1", "2", "24/12/2017"));
        lstCuentaCte.add(new CuentaCte("1", "2016", "2017", "2018", "18", "1", "3", "5", "24/12/2015"));

        for(int i = 0; i < lstCuentaCte.size(); i++) {
            long insert = db.insert(CuentaCteContract.CuentaCteEntry.TABLE_NAME, null,
                    lstCuentaCte.get(i).toContentValues());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CuentaCteContract.CuentaCteEntry.TABLE_NAME);
        onCreate(db);
    }

    public List<CuentaCte> getLstCuentaCte() {

        List<CuentaCte> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(CuentaCteContract.CuentaCteEntry.TABLE_NAME, //Nombre de la tabla
                null, //Lista de columnas a consultar
                null, //Columnas para la clausula where
                null, //Valores a comparar con las columnas del where
                null, //Agrupar con un Group by
                null, //Condicion having para group by
                CuentaCteContract.CuentaCteEntry.ID_DECLARACION
        );

        while (c.moveToNext()) {
            String id = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.ID));
            String idDeclaracion = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.ID_DECLARACION));
            String anio = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.ANIO));
            String periodo = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.PERIODO));
            String insoluto = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.INSOLUTO));
            String emision = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.EMISION));
            String interes = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.INTERES));
            String indicador = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.INDICADOR));
            String recibo = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.RECIBO));
            String fechaPago = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.FECHA_PAGO));
            CuentaCte item = new CuentaCte(idDeclaracion, anio, periodo,insoluto, emision, interes, indicador, recibo, fechaPago);
            list.add(item);
        }
        db.close();
        return list;
    }

    public CuentaCte getCuentaCte(String cuentaCtaId) {

        String selection =  CuentaCteContract.CuentaCteEntry._ID + "=?";
        String[] selectionArgs = new String[1];
        selectionArgs[0] = cuentaCtaId;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(CuentaCteContract.CuentaCteEntry.TABLE_NAME, //Nombre de la tabla
                null, //Lista de columnas a consultar
                selection, //Columnas para la clausula where
                selectionArgs, //Valores a comparar con las columnas del where
                null, //Agrupar con un Group by
                null, //Condicion having para group by
                CuentaCteContract.CuentaCteEntry.ID_DECLARACION
        );

        CuentaCte cuentaCte = null;

        if(c != null && c.moveToFirst()) {

            c.moveToFirst();
            String id = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.ID));
            String idDeclaracion = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.ID_DECLARACION));
            String anio = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.ANIO));
            String periodo = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.PERIODO));
            String insoluto = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.INSOLUTO));
            String emision = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.EMISION));
            String interes = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.INTERES));
            String indicador = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.INDICADOR));
            String recibo = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.RECIBO));
            String fechaPago = c.getString(c.getColumnIndex(CuentaCteContract.CuentaCteEntry.FECHA_PAGO));
            cuentaCte = new CuentaCte(idDeclaracion, anio, periodo, insoluto, emision, interes, indicador, recibo, fechaPago);
        }
        db.close();
        return cuentaCte;
    }

    public long saveCuentaCte(CuentaCte cuentaCte) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(CuentaCteContract.CuentaCteEntry.TABLE_NAME,
                null, cuentaCte.toContentValues());
    }

    public int deleteCuentaCte(String cuentaCteId) {
        return getWritableDatabase().delete(
                CuentaCteContract.CuentaCteEntry.TABLE_NAME,
                CuentaCteContract.CuentaCteEntry._ID + "=?",
                new String[]{cuentaCteId});
    }

    public int updateCuentaCte(String cuentaCteId, CuentaCte cuentaCte) {
        return getWritableDatabase().update(
                CuentaCteContract.CuentaCteEntry.TABLE_NAME,
                cuentaCte.toContentValues(),
                CuentaCteContract.CuentaCteEntry._ID + "=?",
                new String[]{cuentaCteId});
    }

    /* Ejemplo para implementarlo en otra clase */
    /*
        MunicipalidadDbHelper muni;
        List<CuentaCte> listdo = new ArrayList<>();
        CuentaCte objeto = new CuentaCte();

        muni = new MunicipalidadDbHelper(LoginActivity.this);
        listdo = muni.getLstCuentaCte();
        objeto = muni.getCuentaCte("3");

        Recorrer una lista

        String datos = "";
            for(CuentaCte cta: listdo) {
                datos += cta.toString();
            }

        Obtener solo un objeto
         String info = objeto != null? objeto.toString() :"Esta vacio";

        //Crud al sistema

        /*
        Insertar
        CuentaCte cc = new CuentaCte("2", "2020",
                "2014", "2019", "17",
                "0.6", "3", "4", "15/05/2018");
        muni.saveCuentaCte(cc);
        */

        /* Eliminar
        muni.deleteCuentaCte("2");
        */

        /*
    CuentaCte cc = new CuentaCte("2", "2050",
            "2014", "2019", "18",
            "0.6", "3", "4", "15/05/2030");
        muni.updateCuentaCte("1", cc);

     */
}