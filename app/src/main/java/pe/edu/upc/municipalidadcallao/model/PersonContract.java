package pe.edu.upc.municipalidadcallao.model;

import android.provider.BaseColumns;

/**
 * Created by RENSO on 18/11/2017.
 */

public class PersonContract {

    public static abstract class PersonEntry implements BaseColumns {
        public static final String TABLE_NAME ="Person";

        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String DNI = "dni";
        public static final String EDAD = "edad";
        public static final String BIO = "bio";
        public static final String BIO2 = "bio";
        public static final String IMAGENURL = "imagenurl";
    }
}
