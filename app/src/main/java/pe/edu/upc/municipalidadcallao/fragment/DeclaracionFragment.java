package pe.edu.upc.municipalidadcallao.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import pe.edu.upc.municipalidadcallao.R;
import pe.edu.upc.municipalidadcallao.model.MunicipalidadDbHelper;
import pe.edu.upc.municipalidadcallao.serviciorestFull.Pago;
import pe.edu.upc.municipalidadcallao.serviciorestFull.Persona;
import pe.edu.upc.municipalidadcallao.serviciorestFull.Vehiculo;
import pe.edu.upc.municipalidadcallao.utils.CustomDialog;
import pe.edu.upc.municipalidadcallao.utils.ToaskCustom;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DeclaracionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DeclaracionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeclaracionFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int dia, mes, anio;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //variable para vehiculo
    private String xplaca;
    private String xmarca;
    private String xmodelo;
    private String xcatego;
    private int xanifab;
    private String xfecreg;
    private String xprovin;
    private int xanireg;
    private String canimef;
    // variables para declaracion
    private String xporcen;
    private int xaniadq;
    private String xmoneda;
    private long xvaladq;
    private long xtipcam;
    private long xvalorr;

    private double xvalmef;
    private double xbasimp;
    private double ximpues;
    private int xafecto;
    private String xidvehi;
    private String xidusua;
    // variables para ctacte
    private String xiddecj;
    private String xejerci;
    private String xperiod;
    private double xinsolu;
    private long xemisio;
    private String xfecven;

    EditText etFecha;
    EditText txtDni;
    EditText txtPlaca;
    EditText txtPorcentaje;
    EditText txtImpuesto;
    EditText txtAfectoDesde;
    EditText txtAnioAdquisicion;
    EditText txtMoneda;
    EditText txtValorAdquisicion;
    EditText txtTipoCambio;
    EditText txtValorRealAdquisicion;

    final String URL = "http://192.168.1.109:8080/SunarpNuevo/webresources/consultarSunarp/";
    final String URL_MEF = "http://192.168.1.109:8080/MefNuevo/webresources/consultarMef/";
    Gson gson = new GsonBuilder().create();
    MunicipalidadDbHelper muni;

    private OnFragmentInteractionListener mListener;

    public DeclaracionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeclaracionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeclaracionFragment newInstance(String param1, String param2) {
        DeclaracionFragment fragment = new DeclaracionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final RequestQueue que = Volley.newRequestQueue(getContext());

        final View rootView = inflater.inflate(R.layout.fragment_declaracion,
                container, false);

        etFecha = (EditText) rootView.findViewById(R.id.etFecha);
        txtDni = (EditText) rootView.findViewById(R.id.txtDni);
        txtPlaca = (EditText) rootView.findViewById(R.id.txtPlaca);
        txtPorcentaje = (EditText) rootView.findViewById(R.id.txtPorcentaje);
        txtImpuesto = (EditText) rootView.findViewById(R.id.txtImpuesto);
        txtAfectoDesde = (EditText) rootView.findViewById(R.id.txtAfectoDesde);
        txtAnioAdquisicion = (EditText) rootView.findViewById(R.id.txtAnioAdquisicion);
        txtMoneda = (EditText) rootView.findViewById(R.id.txtMoneda);
        txtValorAdquisicion = (EditText) rootView.findViewById(R.id.txtValorAdquisicion);
        txtTipoCambio = (EditText) rootView.findViewById(R.id.txtTipoCambio);
        txtValorRealAdquisicion = (EditText) rootView.findViewById(R.id.txtValorRealAdquisicion);

        txtPlaca.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(txtDni.getText().toString().length() == 8 && txtPlaca.getText().toString().length() == 6) {
                    String variables = txtDni.getText().toString() + "/" + txtPlaca.getText().toString();
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, URL + variables,
                            new com.android.volley.Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
                                        final Vehiculo vehiculo = gson.fromJson(response, Vehiculo.class);

                                        txtPorcentaje.setText(vehiculo.getPorcentaje());
                                        txtImpuesto.setText("0.18");
                                        txtAfectoDesde.setText("" + vehiculo.getAnioFabricacion());
                                        txtAnioAdquisicion.setText("" + vehiculo.getAnioAdquicion());
                                        txtMoneda.setText(""+vehiculo.getMoneda());
                                        txtValorAdquisicion.setText(String.valueOf(vehiculo.getValorAdquicion()));
                                        txtTipoCambio.setText(String.valueOf(vehiculo.getTipoCambio()));
                                        txtValorRealAdquisicion.setText(String.valueOf(vehiculo.getValorRealVehiculo()));

                                        xplaca=vehiculo.getPlaca();
                                        xmarca=vehiculo.getMarca();
                                        xmodelo=vehiculo.getModelo();
                                        xcatego=vehiculo.getCategoria();
                                        xanifab=vehiculo.getAnioFabricacion();
                                        xfecreg=vehiculo.getFechaRegistroPublico();
                                        xprovin=vehiculo.getProvincia();
                                        xporcen=vehiculo.getPorcentaje();
                                        xaniadq=vehiculo.getAnioAdquicion();
                                        xmoneda=vehiculo.getMoneda().toString();
                                        xvaladq=vehiculo.getValorAdquicion();
                                        xtipcam=vehiculo.getTipoCambio();
                                        xvalorr=vehiculo.getValorRealVehiculo();
                                        xanireg=Integer.parseInt(xfecreg.substring(0,4));
                                         muni=new MunicipalidadDbHelper(getContext());
                                        final long idvehiculo=muni.saveVehiculo(new pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.Vehiculo(xplaca,xmarca,xmodelo,xcatego,
                                                String.valueOf(xanifab),xfecreg,xprovin));
                                        final String usuarioid=muni.getUsuario(txtDni.getText().toString()).getId();

                                        //renso debe cambiar el 2017 por el año actual año del new date
                                        if (xanireg==xaniadq && xaniadq<2017){
                                            xafecto=xanireg+1;
                                        }else if (xanireg<xaniadq && xaniadq<2017){
                                            xafecto=xaniadq+1;
                                        }else if (xaniadq>=xanireg+3){
                                            CustomDialog.ShowCustomAlert("El vehiculo ya completo sus 3 años de impuesto",getContext());
                                            return;
                                        }else {
                                            xafecto=xaniadq+1;
                                        }
                                        if (xafecto<=2017){
                                            for (int i=xafecto; i<=2017; i++){
                                                final int j=i;
                                                String variables = vehiculo.getMarca() + "/" + vehiculo.getModelo() + "/" + i;
                                                System.out.println("ivon"+variables);
                                                StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_MEF + variables,
                                                        new com.android.volley.Response.Listener<String>() {
                                                            @Override
                                                            public void onResponse(String response) {
                                                                try {
                                                                    JSONObject jsonObject = new JSONObject(response);
                                                                    Pago pago = gson.fromJson(response, Pago.class);
                                                                    CustomDialog.ShowCustomAlert(pago.getAnio()+"",getContext());
                                                                    if (j-xanifab==1){
                                                                        xvalmef=pago.getAnio1();
                                                                    }else if (j-xanifab==2){
                                                                        xvalmef=pago.getAnio2();
                                                                    }else if(j-xanifab==3) {
                                                                        xvalmef=pago.getAnio3();
                                                                    }else {
                                                                        xvalmef=(pago.getAnio3()*(90/100));
                                                                    }
                                                                    xbasimp=Math.max(xvalorr,xvalmef);
                                                                    ximpues=xbasimp*(1/100);
                                                                    xidvehi=String.valueOf(idvehiculo);
                                                                    xidusua=usuarioid;
                                                                    final long iddeclaj=muni.saveDeclaracion(new pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.Declaracion(
                                                                            xidvehi, xidusua,xporcen,String.valueOf(xbasimp),String.valueOf(ximpues),"18/12/2017",
                                                                            String.valueOf(xafecto),String.valueOf(xaniadq), xmoneda,String.valueOf(xvaladq),String.valueOf(xtipcam),
                                                                            String.valueOf(xvalorr),String.valueOf(xvalmef)));
                                                                    xinsolu=xbasimp/4;
                                                                    xemisio=3;
                                                                    for (int z=1; z<=4; z++){
                                                                        xperiod="0"+String.valueOf(z);
                                                                        if (z==1){
                                                                            xfecven="28/02/"+String.valueOf(j);
                                                                        }else if (z==2){
                                                                            xfecven="31/05/"+String.valueOf(j);
                                                                        }else if (z==3){
                                                                            xfecven="31/08/"+String.valueOf(j);
                                                                        }else {
                                                                            xfecven="30/11/"+String.valueOf(j);
                                                                        }
                                                                        muni.saveCuentaCte(new pe.edu.upc.municipalidadcallao.servicioRestFullMuniErp.CuentaCte(
                                                                                String.valueOf(iddeclaj), String.valueOf(j),xperiod,String.valueOf(xinsolu),
                                                                                String.valueOf(xemisio),"0","0","",""));
                                                                    }


                                                                } catch(JSONException ex) {
                                                                    ex.printStackTrace();
                                                                    ToaskCustom.msg(getContext(),
                                                                            "Hubo un error al obtener el JSON");
                                                                }
                                                            }
                                                        }, new com.android.volley.Response.ErrorListener() {
                                                    @Override
                                                    public void onErrorResponse(VolleyError error) {
                                                        ToaskCustom.msg(rootView.getContext(), "Hubo un error al obtener los datos MEF");
                                                    }
                                                });
                                                que.add(stringRequest);

                                            }

                                        }

                                        //String variablesx = vehiculo.getMarca() + "/" + vehiculo.getModelo() + "/" + vehiculo.getAnioFabricacion();




                                    } catch(JSONException ex) {
                                        ex.printStackTrace();
                                        ToaskCustom.msg(getContext(),
                                                "Hubo un error al obtener el JSON");
                                    }
                                }
                            }, new com.android.volley.Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            ToaskCustom.msg(rootView.getContext(), "Hubo un error al obtener los datos RENIEC");
                        }
                    });
                    que.add(stringRequest);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        Button btnDeclarar = (Button) rootView.findViewById(R.id.btnDeclarar);
        Button btnFecha = (Button) rootView.findViewById(R.id.btnFecha);

        btnFecha.setOnClickListener(this);
        btnDeclarar.setOnClickListener(this);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnDeclarar:

                CustomDialog.ShowCustomAlert(txtDni.getText().toString() + " - " + txtPlaca.getText().toString(), view.getContext());

                break;
            case R.id.btnFecha:

                final Calendar calendar = Calendar.getInstance();
                dia = calendar.get(Calendar.DAY_OF_MONTH);
                mes = calendar.get(Calendar.MONTH);
                anio = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        etFecha.setText(day + "/" + (month+1) + "/" + year);
                    }
                }, dia, mes, anio);
                datePickerDialog.show();

                break;
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}