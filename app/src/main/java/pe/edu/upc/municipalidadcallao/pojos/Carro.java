package pe.edu.upc.municipalidadcallao.pojos;

/**
 * Created by RENSO on 12/11/2017.
 */

public class Carro {

    private String placa;
    private String marca;
    private String modelo;
    private String categoria;
    private String anioFabricacion;
    private String fechaRegPub;
    private String provincia;
    private int imagen;

    public Carro(String placa, String marca, String modelo, String categoria, String anioFabricacion, String fechaRegPub, String provincia, int imagen) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.anioFabricacion = anioFabricacion;
        this.fechaRegPub = fechaRegPub;
        this.provincia = provincia;
        this.imagen = imagen;
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

    public String getFechaRegPub() {
        return fechaRegPub;
    }

    public void setFechaRegPub(String fechaRegPub) {
        this.fechaRegPub = fechaRegPub;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}