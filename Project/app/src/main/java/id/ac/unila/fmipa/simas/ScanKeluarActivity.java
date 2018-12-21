package id.ac.unila.fmipa.simas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import info.androidhive.barcode.BarcodeReader;

public class ScanKeluarActivity extends AppCompatActivity  implements BarcodeReader.BarcodeReaderListener {
    private String KODE = "KODE";
    // panggil BarcodeReader nya google vision
    BarcodeReader barcodeReader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_keluar);

        // buat instant pembaca barcode nya
        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.scan_keluar);
    }
    // pas ke scan, lakuin yang ada di dalam fungsi ini
    @Override
    public void onScanned(Barcode barcode) {
        // bunyiin suara beep kayak barcode scanner di super market biar tahu kalo udah ke scan
        barcodeReader.playBeep();
        // Log.d("hasil_scan",barcode.displayValue);
        // buat intent ke activity yang nampilin data dari hasil scan
        Intent masuk = new Intent(ScanKeluarActivity.this, KeluarActivity.class);
        // kirimin data kodenya juga
        masuk.putExtra(KODE, barcode.rawValue);
        // matiin activitynya biar kalo user teken tombol back, balik ke activity menu
        finish();
        // arahin ke activity menu
        startActivity(masuk);
    }

    // kalo kedepannya mau scan sekaligus banyak item
    @Override
    public void onScannedMultiple(List<Barcode> list) {

    }
    // kalo kedepannya mau scan berupa gambar
    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }
    // kalo kamera gak punya permission
    @Override
    public void onCameraPermissionDenied() {
        finish();
    }
    // kalo proses scan error tampilin toast kalo error dan kode errornya
    @Override
    public void onScanError(String s) {
        Toast.makeText(getApplicationContext(), "Error saat melakukan scan "+ s, Toast.LENGTH_SHORT).show();

    }
}
