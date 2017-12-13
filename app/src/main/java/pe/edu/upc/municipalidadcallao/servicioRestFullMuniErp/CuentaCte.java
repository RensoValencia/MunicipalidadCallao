package pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp;

import android.content.ContentValues;

import java.util.UUID;

import pe.edu.upc.municipalidadcallao.model.CuentaCteContract;

/**
 * Created by RENSO on 06/12/2017.
 */

public class CuentaCte {

    private String id;
    private String idDeclaracion;
    private String anio;
    private String periodo;
    private String insoluto;
    private String emision;
    private String interes;
    private String indicador;
    private String recibo;
    private String fechaPago;

    public CuentaCte() {
    }

    public CuentaCte(String idDeclaracion, String anio, String periodo, String insoluto, String emision, String interes, String indicador, String recibo, String fechaPago) {
        this.id = UUID.randomUUID().toString();
        this.idDeclaracion = idDeclaracion;
        this.anio = anio;
        this.periodo = periodo;
        this.insoluto = insoluto;
        this.emision = emision;
        this.interes = interes;
        this.indicador = indicador;
        this.recibo = recibo;
        this.fechaPago = fechaPago;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDeclaracion() {
        return idDeclaracion;
    }

    public void setIdDeclaracion(String idDeclaracion) {
        this.idDeclaracion = idDeclaracion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getInsoluto() {
        return insoluto;
    }

    public void setInsoluto(String insoluto) {
        this.insoluto = insoluto;
    }

    public String getEmision() {
        return emision;
    }

    public void setEmision(String emision) {
        this.emision = emision;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    //Metodo para insertar los datos en SQLite
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        // Pares clave-valor
        values.put(CuentaCteContract.CuentaCteEntry.ID, this.getId());
        values.put(CuentaCteContract.CuentaCteEntry.ID_DECLARACION, this.getIdDeclaracion());
        values.put(CuentaCteContract.CuentaCteEntry.ANIO, this.getAnio());
        values.put(CuentaCteContract.CuentaCteEntry.PERIODO, this.getPeriodo());
        values.put(CuentaCteContract.CuentaCteEntry.INSOLUTO, this.getInsoluto());
        values.put(CuentaCteContract.CuentaCteEntry.EMISION, this.getEmision());
        values.put(CuentaCteContract.CuentaCteEntry.INTERES, this.getInteres());
        values.put(CuentaCteContract.CuentaCteEntry.INDICADOR, this.getIndicador());
        values.put(CuentaCteContract.CuentaCteEntry.RECIBO, this.getRecibo());
        values.put(CuentaCteContract.CuentaCteEntry.FECHA_PAGO, this.getFechaPago());
        return values;
    }

    @Override
    public String toString() {
        return "CuentaCte{" +
                "id='" + id + '\'' +
                ", idDeclaracion='" + idDeclaracion + '\'' +
                ", anio='" + anio + '\'' +
                ", periodo='" + periodo + '\'' +
                ", insoluto='" + insoluto + '\'' +
                ", emision='" + emision + '\'' +
                ", interes='" + interes + '\'' +
                ", indicador='" + indicador + '\'' +
                ", recibo='" + recibo + '\'' +
                ", fechaPago='" + fechaPago + '\'' +
                '}';
    }
}