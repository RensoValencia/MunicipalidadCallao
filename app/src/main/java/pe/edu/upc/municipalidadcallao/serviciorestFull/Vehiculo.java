package pe.edu.upc.municipalidadcallao.serviciorestFull;

import java.util.Date;

/**
 * Created by RENSO on 25/11/2017.
 */

public class Vehiculo {

    private String numeroDocumento;
    private String placa;
    private String porcentaje;
    private String marca;
    private String modelo;
    private String categoria;
    private String claseVehiculo;
    private int anioFabricacion;
    private int anioAdquicion;
    private Date fechaRegistroPublico;
    private Character moneda;
    private long valorAdquicion;
    private long tipoCambio;
    private long valorRealVehiculo;
    private String provincia;

    public Vehiculo(String numeroDocumento, String placa, String porcentaje, String marca, String modelo, String categoria, String claseVehiculo, int anioFabricacion, int anioAdquicion, Date fechaRegistroPublico, Character moneda, long valorAdquicion, long tipoCambio, long valorRealVehiculo, String provincia) {
        this.numeroDocumento = numeroDocumento;
        this.placa = placa;
        this.porcentaje = porcentaje;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.claseVehiculo = claseVehiculo;
        this.anioFabricacion = anioFabricacion;
        this.anioAdquicion = anioAdquicion;
        this.fechaRegistroPublico = fechaRegistroPublico;
        this.moneda = moneda;
        this.valorAdquicion = valorAdquicion;
        this.tipoCambio = tipoCambio;
        this.valorRealVehiculo = valorRealVehiculo;
        this.provincia = provincia;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClaseVehiculo() {
        return claseVehiculo;
    }

    public void setClaseVehiculo(String claseVehiculo) {
        this.claseVehiculo = claseVehiculo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public int getAnioAdquicion() {
        return anioAdquicion;
    }

    public void setAnioAdquicion(int anioAdquicion) {
        this.anioAdquicion = anioAdquicion;
    }

    public Date getFechaRegistroPublico() {
        return fechaRegistroPublico;
    }

    public void setFechaRegistroPublico(Date fechaRegistroPublico) {
        this.fechaRegistroPublico = fechaRegistroPublico;
    }

    public Character getMoneda() {
        return moneda;
    }

    public void setMoneda(Character moneda) {
        this.moneda = moneda;
    }

    public long getValorAdquicion() {
        return valorAdquicion;
    }

    public void setValorAdquicion(long valorAdquicion) {
        this.valorAdquicion = valorAdquicion;
    }

    public long getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(long tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public long getValorRealVehiculo() {
        return valorRealVehiculo;
    }

    public void setValorRealVehiculo(long valorRealVehiculo) {
        this.valorRealVehiculo = valorRealVehiculo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
