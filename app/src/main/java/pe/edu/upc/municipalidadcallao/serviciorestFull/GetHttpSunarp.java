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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by RENSO on 25/11/2017.
 */

public class GetHttpSunarp extends AsyncTask<Void, Void, String> {

    private Vehiculo httpObject;
    private RecyclerView httpRecycler;
    private RecyclerView.Adapter httpAdapter;

    private Context httpContext;
    ProgressDialog progressDialog;

    public GetHttpSunarp(Vehiculo httpObject, RecyclerView httpRecycler, RecyclerView.Adapter httpAdapter, Context httpContext) {
        this.httpObject = httpObject;
        this.httpRecycler = httpRecycler;
        this.httpAdapter = httpAdapter;
        this.httpContext = httpContext;
    }

    @Override
    protected String doInBackground(Void... voids) {

        String result = null;

        try {
            String wsCliente = "http://localhost:8080/Sunarp/webresources/consultarSunarp/47911488/ABC-123";
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
            {"anioAdquicion":2014,"anioFabricacion":2013,"categoria":"B1","claseVehiculo":"CAMIONETA","marca":"MITSUBISHI",
            "modelo":"L200 CR GLX C/D 4X4 2.5 TD MEC","moneda":"S","numeroDocumento":"47911488","placa":"ABC-123",
            "porcentaje":"100","provincia":"CALLAO","tipoCambio":1, "valorAdquicion":71949,"valorRealVehiculo":71949}
             */
            String nroDocumento = jsonObject.getString("numeroDocumento");
            String placa = jsonObject.getString("placa");
            String porcentaje = jsonObject.getString("porcentaje");
            String marca = jsonObject.getString("marca");
            String modelo = jsonObject.getString("modelo");
            String categoria = jsonObject.getString("categoria");
            String claseVehiculo = jsonObject.getString("claseVehiculo");
            int anioFabricacion = Integer.parseInt(jsonObject.getString("anioFabricacion"));
            int anioAdquicion = Integer.parseInt(jsonObject.getString("anioAdquicion"));
            DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            //String fechaRegistroPublico = format.parse(jsonObject.getString("fechaRegistroPublico"));
            String fechaRegistroPublico = "";
            Character moneda = jsonObject.getString("moneda").charAt(0);
            Long valorAdquicion = Long.parseLong(jsonObject.getString("valorAdquicion"));
            Long tipoCambio = Long.parseLong(jsonObject.getString("tipoCambio"));
            Long valorRealVehiculo = Long.parseLong(jsonObject.getString("valorRealVehiculo"));
            String provincia = jsonObject.getString("provincia");

            this.httpObject = new Vehiculo(nroDocumento, placa, porcentaje, marca, modelo, categoria, claseVehiculo, anioFabricacion,
                    anioAdquicion, fechaRegistroPublico, moneda, valorAdquicion, tipoCambio, valorRealVehiculo, provincia);
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
