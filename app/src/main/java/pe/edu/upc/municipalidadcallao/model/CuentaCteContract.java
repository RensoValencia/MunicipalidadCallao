package pe.edu.upc.municipalidadcallao.model;

import android.provider.BaseColumns;

/**
 * Created by RENSO on 12/12/2017.
 */

public class CuentaCteContract {

    public static abstract class CuentaCteEntry implements BaseColumns{

        public static final String TABLE_NAME ="CUENTA_CTA";

        public static final String ID = "ID";
        public static final String ID_DECLARACION="ID_DECLARACION";
        public static final String ANIO="ANIO";
        public static final String PERIODO="PERIODO";
        public static final String INSOLUTO = "INSOLUTO";
        public static final String EMISION = "EMISION";
        public static final String INTERES="INTERES";
        public static final String INDICADOR="INDICADOR";
        public static final String RECIBO="RECIBO";
        public static final String FECHA_PAGO="FECHA_PAGO";
        public static final String FECHA_VENCIMIENTO="FECHA_VENCIMIENTO";

    }
}
