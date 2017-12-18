package pe.edu.upc.municipalidadcallao.serviciorestFull;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

import pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.Declaracion;

/**
 * Created by RENSO on 25/11/2017.
 */

public class GetHttpVehiculo extends AsyncTask<String, Void, String> {

    private Declaracion httpObject;
    private RecyclerView httpRecycler;
    private RecyclerView.Adapter httpAdapter;

    private Context httpContext;
    ProgressDialog progressDialog;

    public GetHttpVehiculo(Declaracion httpObject, RecyclerView httpRecycler, RecyclerView.Adapter httpAdapter, Context httpContext) {
        this.httpObject = httpObject;
        this.httpRecycler = httpRecycler;
        this.httpAdapter = httpAdapter;
        this.httpContext = httpContext;
    }

    public GetHttpVehiculo(Context httpContext) {
        this.httpContext = httpContext;
    }

    @Override
    protected String doInBackground(String... params) {

        String cadena = params[0];
        URL url = null;
        String devuelve ="";

        try {
            HttpURLConnection urlConn;

            DataOutputStream printout;
            DataInputStream input;
            url = new URL(cadena);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setDoInput(true);
            urlConn.setDoOutput(true);
            urlConn.setUseCaches(false);
            urlConn.setRequestMethod("POST");
            urlConn.setRequestProperty("Content-Type", "application/json");
            urlConn.setRequestProperty("Accept", "application/json");
            urlConn.connect();
            //Creo el Objeto JSON
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("dni", params[1]);
            jsonParam.put("nombre", params[2]);
            jsonParam.put("distrito", params[3]);
            jsonParam.put("apellidoPaterno", params[4]);
            jsonParam.put("apellidoMaterno", params[5]);
            jsonParam.put("direccion", params[6]);
            jsonParam.put("correoElectronico", params[6]);
            jsonParam.put("clave", params[7]);
             System.out.println("jsonParam.toString(): " + jsonParam.toString());
            // Envio los parámetros post.
            OutputStream os = urlConn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(jsonParam.toString());
            writer.flush();
            writer.close();

            System.out.println("urlConn: " + urlConn);
            int respuesta = urlConn.getResponseCode();


            StringBuilder result = new StringBuilder();
            System.out.println("result: " + result+  " - " + HttpURLConnection.HTTP_OK);
            if (respuesta == HttpURLConnection.HTTP_OK) {

                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    result.append(line);
                    //response+=line;
                }

                //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                //Accedemos al vector de resultados

                //String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON

                //if (resultJSON == "1") {      // hay un alumno que mostrar
                //  devuelve = "Alumno insertado correctamente";

                //} else if (resultJSON == "2") {
                //  devuelve = "El alumno no pudo insertarse";
                //}
                devuelve = "Insertar ok: " + result.toString() + " - " + respuestaJSON.getString("estado");

            } else {
                //ToaskCustom.msg(httpContext, "Hubo un error");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            devuelve = "Ocurrio un error: " + ex.getMessage();
        }

        return devuelve;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.dismiss();
        try {

            System.out.println("informacion: " + s + " - ");
            JSONObject jsonObject = new JSONObject(URLDecoder.decode(s, "UTF-8"));
            /*
            {"apellidoMaterno":"BERROCAL","apellidoPaterno":"PORRAS","direccion":"AV HAYA DE LA TORRE,
             AV EL PACIFICO","distrito":"LA PERLA","nombres":"IVONNE"}
             */
            System.out.println("s: " + s);
            String dni = jsonObject.getString("dni");
            String nombres = jsonObject.getString("nombre");
            String apellidoPaterno = jsonObject.getString("apellidoPaterno");
            String apellidoMaterno = jsonObject.getString("apellidoMaterno");
            String distrito = jsonObject.getString("distrito");
            String direccion = jsonObject.getString("direccion");
            String correo = jsonObject.getString("correoElectronico");
            String clave = jsonObject.getString("clave");

            //this.httpObject = new Declaracion(nombres, apellidoPaterno, apellidoMaterno, distrito, direccion, distrito, correo, clave);
            //httpRecycler.setAdapter(this.httpAdapter);

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
