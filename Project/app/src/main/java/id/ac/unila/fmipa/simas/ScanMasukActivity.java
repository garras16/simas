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

public class ScanMasukActivity extends AppCompatActivity  implements BarcodeReader.BarcodeReaderListener {
    private String KODE = "KODE";
    BarcodeReader barcodeReader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_masuk);

        // buat instant pembaca barcode nya
        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.scan_masuk);
    }

    @Override
    public void onScanned(Barcode barcode) {
        barcodeReader.playBeep();
        Log.d("hasil_scan",barcode.displayValue);
        Intent masuk = new Intent(ScanMasukActivity.this, MasukActivity.class);
        masuk.putExtra(KODE, barcode.rawValue);
        finish();
        startActivity(masuk);
    }

    @Override
    public void onScannedMultiple(List<Barcode> list) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onCameraPermissionDenied() {
        finish();
    }
    @Override
    public void onScanError(String s) {
        Toast.makeText(getApplicationContext(), "Error saat melakukan scan "+ s, Toast.LENGTH_SHORT).show();

    }
}
