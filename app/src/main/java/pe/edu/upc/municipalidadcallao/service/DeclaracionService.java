package pe.edu.upc.municipalidadcallao.service;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.municipalidadcallao.R;
import pe.edu.upc.municipalidadcallao.pojos.Declaracion;

/**
 * Created by RENSO on 12/11/2017.
 */

public class DeclaracionService {

    private List<Declaracion> declaraciones;
    public List<Declaracion> getDeclaraciones() {
        return declaraciones;
    }

    public DeclaracionService(Context context) {
        Resources res = context.getResources();
        declaraciones = new ArrayList<>();
        declaraciones.add(new Declaracion(res.getString(R.string.carro1),
                res.getString(R.string.usuario1),
                res.getString(R.string.porcentaje1),
                res.getString(R.string.baseImponible1),
                res.getString(R.string.impuesto1),
                res.getString(R.string.fechaDeclaracion1),
                res.getString(R.string.afectoDesde1),
                "A1", "2016", "02/11/2014", "Bellavista", "", "",
                R.drawable.declaracion));

        declaraciones.add(new Declaracion(res.getString(R.string.carro1),
                res.getString(R.string.usuario1),
                res.getString(R.string.porcentaje1),
                res.getString(R.string.baseImponible1),
                res.getString(R.string.impuesto1),
                res.getString(R.string.fechaDeclaracion1),
                res.getString(R.string.afectoDesde1),
                "A1", "2016", "02/11/2014", "Bellavista", "", "",
                R.drawable.declaracion));


        declaraciones.add(new Declaracion(res.getString(R.string.carro1),
                res.getString(R.string.usuario1),
                res.getString(R.string.porcentaje1),
                res.getString(R.string.baseImponible1),
                res.getString(R.string.impuesto1),
                res.getString(R.string.fechaDeclaracion1),
                res.getString(R.string.afectoDesde1),
                "A1", "2016", "02/11/2014", "Bellavista", "", "",
                R.drawable.declaracion));
    }
}
