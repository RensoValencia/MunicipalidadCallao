package pe.edu.upc.municipalidadcallao.serviciorestFull;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

/**
 * Created by RENSO on 25/11/2017.
 */

public class GetHttpReniec extends AsyncTask<Void, Void, String> {

    private Persona httpObject;
    private RecyclerView httpRecycler;
    private RecyclerView.Adapter httpAdapter;

    private Context httpContext;
    ProgressDialog progressDialog;

    public GetHttpReniec(Persona httpObject, RecyclerView httpRecycler, RecyclerView.Adapter httpAdapter, Context httpContext) {
        this.httpObject = httpObject;
        this.httpRecycler = httpRecycler;
        this.httpAdapter = httpAdapter;
        this.httpContext = httpContext;
    }

    @Override
    protected String doInBackground(Void... voids) {

        String result = null;

        try {
            String wsCliente = "http://localhost:8080/Reniec/webresources/consultarReniec/07534320";
            URL url = new URL(wsCliente);


            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            result = inputStreamToString(in);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.dismiss();
        try {

            JSONObject jsonObject = new JSONObject(URLDecoder.decode(s, "UTF-8"));
            /*
            {"apellidoMaterno":"BERROCAL","apellidoPaterno":"PORRAS","direccion":"AV HAYA DE LA TORRE,
             AV EL PACIFICO","distrito":"LA PERLA","nombres":"IVONNE"}
             */
            String nombres = jsonObject.getString("nombres");
            String apellidoPaterno = jsonObject.getString("apellidoPaterno");
            String apellidoMaterno = jsonObject.getString("apellidoMaterno");
            String distrito = jsonObject.getString("distrito");
            String direccion = jsonObject.getString("direccion");

            this.httpObject = new Persona(nombres, apellidoPaterno, apellidoMaterno, distrito, direccion);
            httpRecycler.setAdapter(this.httpAdapter);

        } catch(JSONException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private String inputStreamToString(InputStream is) {
        String rLine = "";
        StringBuilder answer = new StringBuilder();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader rd = new BufferedReader(isr);

        try {

            while((rLine = rd.readLine()) != null) {
                answer.append(rLine);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return answer.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(httpContext, "Descargando", "Por favor");
    }
}
