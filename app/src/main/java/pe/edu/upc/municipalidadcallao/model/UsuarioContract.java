package pe.edu.upc.municipalidadcallao.model;

import android.provider.BaseColumns;

/**
 * Created by RENSO on 12/12/2017.
 */

public class UsuarioContract {

    public static abstract class UsuarioEntry implements BaseColumns {

        public static final String TABLE_NAME = "USUARIO";

        public static final String ID = "ID";
        public static final String DNI="DNI";
        public static final String NOMBRE="NOMBRE";
        public static final String APELLIDO_PATERNO="APELLIDO_PATERNO";
        public static final String APELLIDO_MATERNO="APELLIDO_MATERNO";
        public static final String DIRECCION="DIRECCION";
        public static final String DISTRITO="DISTRITO";
        public static final String CORREO_ELECTRONICO="EMAIL";
        public static final String CLAVE="CLAVE";



    }
}
