package com.example.enrico.clientsocialz;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class MainActivity extends AppCompatActivity {

    private static final String SOAP_ACTION = "";
    private static final String METHOD_NAME = "getHobbiesConPraticanti";
    private static final String NAMESPACE = "http://webservicesocialz/";
    private static final String URL = "http://10.0.2.2:8080/WebServiceSocialZ/WebServiceSocialZ?wsdl";

    private ScrollView scrollView;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = (ScrollView) findViewById(R.id.scroll);
        context=this;
        new AsyncTaskRunner().execute();

    }

    private class AsyncTaskRunner extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

                envelope.setOutputSoapObject(request);

                HttpTransportSE ht = new HttpTransportSE(URL);
                try {
                    ht.call(SOAP_ACTION, envelope);
                    SoapObject response = (SoapObject) envelope.bodyIn;

                    return response.getProperty("return").toString();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
            //return "{\"hobbies\":[{\"nome\":\"pallavolo\",\"praticanti\":[\"a\",\"enricodr99@gmail.com\"]},{\"nome\":\"calcio\",\"praticanti\":[\"a\"]}]}";
        }

        @Override
        protected void onPostExecute(String result){
            scrollView.removeAllViews();
            Gson gson=new GsonBuilder().create();
            Pojo p=gson.fromJson(result,Pojo.class);
            List<Hobby> hobbies=p.getHobbies();
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
            params.setMargins(40, 10, 10, 10);
            for(final Hobby h:hobbies){
                TextView tv = new TextView(context);
                tv.setTextSize(20);
                tv.setLayoutParams(params);
                tv.setText(h.getNome());
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(context,PraticantiActivity.class);
                        i.putExtra("nome",h.getNome());
                        List<String>praticanti=h.getPraticanti();
                        int l=praticanti.size();
                        i.putExtra("numPraticanti",l);
                        for(int j=0;j<l;j++){
                            i.putExtra("praticante"+j,praticanti.get(j));
                        }

                        startActivity(i);
                    }
                });
                linearLayout.addView(tv);
            }
            scrollView.addView(linearLayout);
        }

    }
}
