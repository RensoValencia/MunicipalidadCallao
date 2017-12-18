package pe.edu.upc.municipalidadcallao.utils;

import java.util.Calendar;

/**
 * Created by RENSO on 18/12/2017.
 */

public class UtilDate {

    public static String getAnio() {
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }
}
