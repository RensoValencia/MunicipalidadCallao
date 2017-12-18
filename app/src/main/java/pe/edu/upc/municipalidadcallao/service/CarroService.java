package pe.edu.upc.municipalidadcallao.service;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.municipalidadcallao.R;
import pe.edu.upc.municipalidadcallao.pojos.Carro;
import pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.Vehiculo;

/**
 * Created by RENSO on 12/11/2017.
 */

public class CarroService {

    private List<Vehiculo> carros;
    public List<Vehiculo> getCarros() {
        return carros;
    }

    public CarroService(Context context) {
        Resources res = context.getResources();
        carros = new ArrayList<>();
        /*carros.add(new Carro(res.getString(R.string.placa1),
                res.getString(R.string.marca1),
                res.getString(R.string.modelo1),
                "A1", "2016", "02/11/2014", "Bellavista",
                R.drawable.carro01));

        carros.add(new Carro(res.getString(R.string.placa2),
                res.getString(R.string.marca2),
                res.getString(R.string.modelo2),
                "A2", "2014", "02/11/2012", "Jesus Maria",
                R.drawable.carro02));

        carros.add(new Carro(res.getString(R.string.placa3),
                res.getString(R.string.marca3),
                res.getString(R.string.modelo3),
                "A2", "2014", "02/11/2012", "Jesus Maria",
                R.drawable.carro03));

        carros.add(new Carro(res.getString(R.string.placa4),
                res.getString(R.string.marca4),
                res.getString(R.string.modelo4),
                "A2", "2014", "02/05/2011", "San Miguel",
                R.drawable.carro04));

        carros.add(new Carro(res.getString(R.string.placa5),
                res.getString(R.string.marca5),
                res.getString(R.string.modelo5),
                "A1", "2014", "02/05/2011", "La Perla",
                R.drawable.carro05));

        carros.add(new Carro(res.getString(R.string.placa6),
                res.getString(R.string.marca6),
                res.getString(R.string.modelo6),
                "A2", "2014", "02/05/2011", "Chorrillos",
                R.drawable.carro06));

        carros.add(new Carro(res.getString(R.string.placa7),
                res.getString(R.string.marca7),
                res.getString(R.string.modelo7),
                "A3", "2014", "02/05/2011", "Pueblo libre",
                R.drawable.carro07));*/
    }
}
