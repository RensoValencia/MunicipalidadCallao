package pe.edu.upc.municipalidadcallao.utils;

import android.content.Context;
import android.widget.Toast;

import pe.edu.upc.municipalidadcallao.activity.RegistroActivity;

/**
 * Created by RENSO on 05/12/2017.
 */

public class ToaskCustom {

    public static void msg(Context context, String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }
}
