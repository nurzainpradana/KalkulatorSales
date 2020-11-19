package com.example.android.kalkulatorsales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etHarga, etDP, etTenor, etBunga;
    Button btnHitung;

    String nama;
    Double harga, dp, tenor, bunga;

    static String NAMA_KEY = "nama_key";
    static String HARGA_KEY = "harga_key";
    static String DP_KEY = "dp_key";
    static String TENOR_KEY = "tenor_key";
    static String BUNGA_KEY = "bunga_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);
        etHarga = findViewById(R.id.et_harga);
        etDP = findViewById(R.id.et_dp);
        etTenor = findViewById(R.id.et_tenor);
        etBunga = findViewById(R.id.et_bunga);
        btnHitung = findViewById(R.id.btn_hitung);

    }

    public void ambilDataDanKirim(View view) {
        if (cekData()){
            ambilData();
            pindahDanKirimData();
        } else {
            Toast toast = Toast.makeText(this, "Data Belum Lengkap", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 200);
            toast.show();
        }
    }

    private boolean cekData() {
        return !etNama.getText().toString().equals("") &&
                !etHarga.getText().toString().equals("") &&
                !etDP.getText().toString().equals("") &&
                !etTenor.getText().toString().equals("") &&
                !etBunga.getText().toString().equals("");
    }

    private void ambilData() {
        nama = etNama.getText().toString();
        harga = Double.parseDouble(etHarga.getText().toString());
        dp = Double.parseDouble(etDP.getText().toString());
        tenor = Double.parseDouble(etTenor.getText().toString());
        bunga = Double.parseDouble(etBunga.getText().toString());
    }


    private void pindahDanKirimData() {
        Intent goToHasil = new Intent(MainActivity.this, HasilActivity.class);
        goToHasil.putExtra(NAMA_KEY, nama);
        goToHasil.putExtra(HARGA_KEY, harga);
        goToHasil.putExtra(DP_KEY, dp);
        goToHasil.putExtra(TENOR_KEY, tenor);
        goToHasil.putExtra(BUNGA_KEY, bunga);
        startActivity(goToHasil);
    }

}