package pe.edu.upc.municipalidadcallao.model;

import android.provider.BaseColumns;

/**
 * Created by RENSO on 12/12/2017.
 */

public class VehiculoContract {

    public static abstract class VehiculoEntry implements BaseColumns {

        public static final String TABLE_NAME = "VEHICULO";

        public static final String ID = "ID";
        public static final String PLACA = "PLACA";
        public static final String MARCA="MARCA";
        public static final String MODELO="MODELO";
        public static final String CATEGORIA="CATEGORIA";
        public static final String ANIO_FABRICACION="ANIO_FABRICACION";
        public static final String FECHA_REGISTRO_PUBLICO="FECHA_REGISTRO_PUBLICO";
        public static final String PROVINCIA="PROVINCIA";

    }
}