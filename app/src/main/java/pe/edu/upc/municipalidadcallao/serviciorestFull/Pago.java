package pe.edu.upc.municipalidadcallao.serviciorestFull;

/**
 * Created by RENSO on 25/11/2017.
 */

public class Pago {

    private Integer anio;
    private String codigoMarca;
    private String marca;
    private String tipoModelo;
    private String modelo;
    private String categoria;
    private String descripcion;
    private Long anio1;
    private Long anio2;
    private Long anio3;

    public Pago(Integer anio, String codigoMarca, String marca, String tipoModelo, String modelo, String categoria, String descripcion, Long anio1, Long anio2, Long anio3) {
        this.anio = anio;
        this.codigoMarca = codigoMarca;
        this.marca = marca;
        this.tipoModelo = tipoModelo;
        this.modelo = modelo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.anio1 = anio1;
        this.anio2 = anio2;
        this.anio3 = anio3;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(String codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoModelo() {
        return tipoModelo;
    }

    public void setTipoModelo(String tipoModelo) {
        this.tipoModelo = tipoModelo;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getAnio1() {
        return anio1;
    }

    public void setAnio1(Long anio1) {
        this.anio1 = anio1;
    }

    public Long getAnio2() {
        return anio2;
    }

    public void setAnio2(Long anio2) {
        this.anio2 = anio2;
    }

    public Long getAnio3() {
        return anio3;
    }

    public void setAnio3(Long anio3) {
        this.anio3 = anio3;
    }
}
