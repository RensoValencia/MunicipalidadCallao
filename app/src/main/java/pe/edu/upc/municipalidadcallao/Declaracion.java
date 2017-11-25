package pe.edu.upc.municipalidadcallao;

/**
 * Created by RENSO on 12/11/2017.
 */

public class Declaracion {

    private String carro;
    private String usuario;
    private String porcentaje;
    private String baseImponible;
    private String impuesto;
    private String fechaDeclaracion;
    private String afectoDesde;
    private String anioAdquicion;
    private String tipoMoneda;
    private String valorAdquisicion;
    private String tipoCambio;
    private String valorRealAdquisicion;
    private String valorMef;
    private int imagen;

    public Declaracion(String carro, String usuario, String porcentaje, String baseImponible, String impuesto, String fechaDeclaracion, String afectoDesde, String anioAdquicion, String tipoMoneda, String valorAdquisicion, String tipoCambio, String valorRealAdquisicion, String valorMef, int imagen) {
        this.carro = carro;
        this.usuario = usuario;
        this.porcentaje = porcentaje;
        this.baseImponible = baseImponible;
        this.impuesto = impuesto;
        this.fechaDeclaracion = fechaDeclaracion;
        this.afectoDesde = afectoDesde;
        this.anioAdquicion = anioAdquicion;
        this.tipoMoneda = tipoMoneda;
        this.valorAdquisicion = valorAdquisicion;
        this.tipoCambio = tipoCambio;
        this.valorRealAdquisicion = valorRealAdquisicion;
        this.valorMef = valorMef;
        this.imagen = imagen;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getAnioAdquicion() {
        return anioAdquicion;
    }

    public void setAnioAdquicion(String anioAdquicion) {
        this.anioAdquicion = anioAdquicion;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}