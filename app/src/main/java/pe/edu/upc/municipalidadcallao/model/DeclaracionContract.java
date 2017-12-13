package pe.edu.upc.municipalidadcallao.model;

import android.provider.BaseColumns;
/**
 * Created by RENSO on 12/12/2017.
 */
public class DeclaracionContract {

    public static abstract class DeclaracionEntry implements BaseColumns {

        public static final String TABLE_NAME ="DECLARACION";

        public static final String ID = "ID";
        public static final String ID_VEHICULO="ID_VEHICULO";
        public static final String ID_USUARIO="ID_USUARIO";
        public static final String PORCENTAJE="PORCENTAJE";
        public static final String BASE_IMPONIBLE="BASE_IMPONIBLE";
        public static final String IMPUESTO="IMPUESTO";
        public static final String FECHA_DECLARACION="FECHA_DECLARACION";
        public static final String AFECTO_DESDE="AFECTO_DESDE";
        public static final String ANIO_ADQUISICION="ANIO_ADQUISICION";
        public static final String MONEDA="MONEDA";
        public static final String VALOR_ADQUISICION="VALOR_ADQUISICION";
        public static final String TIPO_CAMBIO="TIPO_CAMBIO";
        public static final String VALOR_REAL_ADQUISICION="VALOR_REAL_ADQUISICION";
        public static final String VALOR_MEF="VALOR_MEF";

    }
}