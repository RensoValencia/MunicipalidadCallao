package pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp;

import java.util.UUID;

/**
 * Created by RENSO on 06/12/2017.
 */

public class Declaracion {

    private String id;
    private String idVehiculo;
    private String idUsuario;
    private String porcentaje;
    private String baseImponible;
    private String impuesto;
    private String fechaDeclaracion;
    private String afectoDesde;
    private String anioAdquisicion;
    private String moneda;
    private String valorAdquisicion;
    private String tipoCambio;
    private String valorRealAdquisicion;
    private String valorMef;

    public Declaracion(String idVehiculo, String idUsuario, String porcentaje, String baseImponible, String impuesto, String fechaDeclaracion, String afectoDesde, String anioAdquisicion, String moneda, String valorAdquisicion, String tipoCambio, String valorRealAdquisicion, String valorMef) {
        this.id = UUID.randomUUID().toString();
        this.idVehiculo = idVehiculo;
        this.idUsuario = idUsuario;
        this.porcentaje = porcentaje;
        this.baseImponible = baseImponible;
        this.impuesto = impuesto;
        this.fechaDeclaracion = fechaDeclaracion;
        this.afectoDesde = afectoDesde;
        this.anioAdquisicion = anioAdquisicion;
        this.moneda = moneda;
        this.valorAdquisicion = valorAdquisicion;
        this.tipoCambio = tipoCambio;
        this.valorRealAdquisicion = valorRealAdquisicion;
        this.valorMef = valorMef;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getBaseImponible() {
        return baseImponible;
    }

    public void setBaseImponible(String baseImponible) {
        this.baseImponible = baseImponible;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public String getFechaDeclaracion() {
        return fechaDeclaracion;
    }

    public void setFechaDeclaracion(String fechaDeclaracion) {
        this.fechaDeclaracion = fechaDeclaracion;
    }

    public String getAfectoDesde() {
        return afectoDesde;
    }

    public void setAfectoDesde(String afectoDesde) {
        this.afectoDesde = afectoDesde;
    }

    public String getAnioAdquisicion() {
        return anioAdquisicion;
    }

    public void setAnioAdquisicion(String anioAdquisicion) {
        this.anioAdquisicion = anioAdquisicion;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getValorAdquisicion() {
        return valorAdquisicion;
    }

    public void setValorAdquisicion(String valorAdquisicion) {
        this.valorAdquisicion = valorAdquisicion;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getValorRealAdquisicion() {
        return valorRealAdquisicion;
    }

    public void setValorRealAdquisicion(String valorRealAdquisicion) {
        this.valorRealAdquisicion = valorRealAdquisicion;
    }

    public String getValorMef() {
        return valorMef;
    }

    public void setValorMef(String valorMef) {
        this.valorMef = valorMef;
    }
}