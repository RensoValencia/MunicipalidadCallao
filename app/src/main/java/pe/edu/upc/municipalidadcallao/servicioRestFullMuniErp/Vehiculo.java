package pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp;

import java.util.UUID;
/**
 * Created by RENSO on 06/12/2017.
 */
public class Vehiculo {

    private String id;
    private String placa;
    private String marca;
    private String modelo;
    private String categoria;
    private String anioFabricacion;
    private String fechaRegistroPublico;
    private String provincia;

    public Vehiculo(String placa, String marca, String modelo, String categoria, String anioFabricacion, String fechaRegistroPublico, String provincia) {
        this.id = UUID.randomUUID().toString();
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.anioFabricacion = anioFabricacion;
        this.fechaRegistroPublico = fechaRegistroPublico;
        this.provincia = provincia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

    public String getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(String anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getFechaRegistroPublico() {
        return fechaRegistroPublico;
    }

    public void setFechaRegistroPublico(String fechaRegistroPublico) {
        this.fechaRegistroPublico = fechaRegistroPublico;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}