package id.ac.unila.fmipa.simas;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MenuActivity extends AppCompatActivity {

    ImageButton btn_logout, btn_masuk, btn_keluar;
    TextView txt_id, txt_username;
    String id, username, gambar;
    SharedPreferences sharedpreferences;
    ImageView profil;
    Intent intent;

    // ambil data dari session login
    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";
    // panggil NotificationUtils
    private NotificationUtils mNotificationUtils;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        txt_id = (TextView) findViewById(R.id.txt_id);
        txt_username = (TextView) findViewById(R.id.txt_username);
        btn_logout = (ImageButton) findViewById(R.id.btn_logout);
        sharedpreferences = getSharedPreferences(MainActivity.my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

        mNotificationUtils = new NotificationUtils(this);

        Notification.Builder nb = mNotificationUtils.getAndroidChannelNotification("Notifikasi SIMAS", "Anda telah melakukan login sebagai " + username);

        mNotificationUtils.getManager().notify(101, nb.build());

        txt_id.setText("Email : " + id);
        txt_username.setText("Nama : " + username);

        btn_logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // kalo logout, session nya dikosongin lagi biar gak nimpa
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(MainActivity.session_status, false);
                editor.putString(TAG_ID, null);
                editor.putString(TAG_USERNAME, null);
                editor.apply();

                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }
    public void Masuk(View view) {
        Intent intent = new Intent(MenuActivity.this, ScanMasukActivity.class);
        startActivity(intent);
    }
    public void Keluar(View view) {
        Intent intent = new Intent(MenuActivity.this, ScanKeluarActivity.class);
        startActivity(intent);
    }
    public void List(View view) {
        Intent intent = new Intent(MenuActivity.this, ListBarangActivity.class);
        startActivity(intent);
    }
}
