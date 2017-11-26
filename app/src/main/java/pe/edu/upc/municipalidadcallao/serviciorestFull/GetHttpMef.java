package pe.edu.upc.municipalidadcallao.serviciorestFull;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
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

public class GetHttpMef extends AsyncTask<Void, Void, String> {

    private Pago httpObject;
    private RecyclerView httpRecycler;
    private RecyclerView.Adapter httpAdapter;

    private Context httpContext;
    ProgressDialog progressDialog;

    public GetHttpMef(Pago httpObject, RecyclerView httpRecycler, RecyclerView.Adapter httpAdapter, Context httpContext) {
        this.httpObject = httpObject;
        this.httpRecycler = httpRecycler;
        this.httpAdapter = httpAdapter;
        this.httpContext = httpContext;
    }

    @Override
    protected String doInBackground(Void... voids) {

        String result = null;

        try {
            String wsCliente = "http://localhost:8080/Mef/webresources/consultarMef/TOYOTA/CALDINA/2015";
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
            {"anio":2015,"anio1":157000,"anio2":141300,"anio3":125600,"categoria":"A4",
            "codigoMarca":"002","descripcion":"Más de 2,000 cc. de cilindrada",
            "marca":"TOYOTA","modelo":"CALDINA","tipoModelo":"002"}
             */

            Integer anio = Integer.parseInt(jsonObject.getString("anio"));
            String codigoMarca = jsonObject.getString("codigoMarca");
            String marca = jsonObject.getString("marca");
            String tipoModelo = jsonObject.getString("tipoModelo");
            String modelo = jsonObject.getString("modelo");
            String categoria = jsonObject.getString("categoria");
            String descripcion = jsonObject.getString("descripcion");
            Long anio1 = Long.parseLong(jsonObject.getString("anio1"));
            Long anio2 = Long.parseLong(jsonObject.getString("anio2"));
            Long anio3 = Long.parseLong(jsonObject.getString("anio3"));

            this.httpObject = new Pago(anio, codigoMarca, marca, tipoModelo, modelo, categoria, descripcion, anio1, anio2, anio3);
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
