package pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp;

import java.util.UUID;

/**
 * Created by RENSO on 06/12/2017.
 */

public class Vencimiento {

    private String id;
    private String anio;
    private String periodo;
    private String fecha;
    private String tim;

    public Vencimiento(String anio, String periodo, String fecha, String tim) {
        this.id = UUID.randomUUID().toString();
        this.anio = anio;
        this.periodo = periodo;
        this.fecha = fecha;
        this.tim = tim;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim;
    }
}
