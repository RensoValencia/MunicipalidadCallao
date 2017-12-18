package pe.edu.upc.municipalidadcallao.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by RENSO on 18/12/2017.
 */

public class UtilDate {

    public static String getAnio() {
        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }

    public static String getTotalFecha() {
        SimpleDateFormat ss = new SimpleDateFormat("dd/MM/yyyy");
        return ss.format(new Date());
    }
}
