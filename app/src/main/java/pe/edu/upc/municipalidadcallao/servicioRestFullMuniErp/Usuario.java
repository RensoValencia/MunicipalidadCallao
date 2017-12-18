package pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp;

import android.content.ContentValues;

import java.util.UUID;

import pe.edu.upc.municipalidadcallao.model.UsuarioContract;

/**
 * Created by RENSO on 06/12/2017.
 */
public class Usuario {

    private String id;
    private String dni;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private String distrito;
    private String correoElectronico;
    private String clave;

    public Usuario(String dni, String nombre, String apellidoPaterno, String apellidoMaterno, String direccion, String distrito, String correoElectronico, String clave) {
        this.id = UUID.randomUUID().toString();
        this.dni = dni;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.distrito = distrito;
        this.correoElectronico = correoElectronico;
        this.clave = clave;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", direccion='" + direccion + '\'' +
                ", distrito='" + distrito + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        // Pares clave-valor
        values.put(UsuarioContract.UsuarioEntry.ID, this.getId());
        values.put(UsuarioContract.UsuarioEntry.DNI, this.getDni());
        values.put(UsuarioContract.UsuarioEntry.NOMBRE, this.getNombre());
        values.put(UsuarioContract.UsuarioEntry.APELLIDO_PATERNO, this.getApellidoPaterno());
        values.put(UsuarioContract.UsuarioEntry.APELLIDO_MATERNO, this.getApellidoMaterno());
        values.put(UsuarioContract.UsuarioEntry.DIRECCION, this.getDireccion());
        values.put(UsuarioContract.UsuarioEntry.DISTRITO, this.getDistrito());
        values.put(UsuarioContract.UsuarioEntry.CORREO_ELECTRONICO, this.getCorreoElectronico());
        values.put(UsuarioContract.UsuarioEntry.CLAVE, this.getClave());
        return values;
    }

}