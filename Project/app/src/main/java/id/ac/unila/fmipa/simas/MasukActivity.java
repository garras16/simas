package id.ac.unila.fmipa.simas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.ac.unila.fmipa.simas.login.AppController;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

public class MasukActivity extends AppCompatActivity {
    TextView nilaiKode;
    private ImageView imgbarang;
    private TextView txtnama, txtdes, txtjum;
    private EditText editJumlah;
    private Button btnSimpan;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;
    private ProgressDialog pDialog;

    private String kode;
    private String KODE = "KODE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        // nilaiKode = (TextView) findViewById(R.id.nilaiKode);

        Bundle extras = getIntent().getExtras();
        kode = extras.getString(KODE);
        // nilaiKode.setText("Nilai Kode Barcode = " + kode);

        String url = "http://192.168.43.81/simas/login/edit.php?id="+kode;

        imgbarang = (ImageView) findViewById(R.id.imgBarang);
        txtnama = (TextView) findViewById(R.id.nama);
        txtdes = (TextView) findViewById(R.id.deskrip);
        txtjum = (TextView) findViewById(R.id.jmlh);
        btnSimpan = (Button) findViewById(R.id.simpan);
        editJumlah = (EditText) findViewById(R.id.editJumlah);

        requestQueue = Volley.newRequestQueue(MasukActivity.this);

        list_data = new ArrayList<HashMap<String, String>>();
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("barang");
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("nama", json.getString("nama"));
                        map.put("deskripsi", json.getString("deskripsi"));
                        map.put("jumlah", json.getString("jumlah"));
                        map.put("gambar", json.getString("gambar"));
                        list_data.add(map);
                    }
                    Glide.with(getApplicationContext())
                            .load("http://192.168.43.81/simas/login/img/" + list_data.get(0).get("gambar"))
                            .crossFade()
                            .into(imgbarang);
                    txtdes.setText(list_data.get(0).get("deskripsi"));
                    txtnama.setText(list_data.get(0).get("nama"));
                    txtjum.setText(list_data.get(0).get("jumlah"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MasukActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBarang(kode);
            }
        });
    }
    private void updateBarang(final String kode) {
        String updateUrl = "http://192.168.43.81/simas/login/update.php";
        final String jumlahBarang = editJumlah.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, updateUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MasukActivity.this,response,Toast.LENGTH_LONG).show();
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MasukActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("kode", kode);
                params.put("jumlah", jumlahBarang);
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest);
    }

}
