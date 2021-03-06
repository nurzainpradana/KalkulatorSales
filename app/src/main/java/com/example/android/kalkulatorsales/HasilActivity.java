package com.example.android.kalkulatorsales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

import static com.example.android.kalkulatorsales.MainActivity.BUNGA_KEY;
import static com.example.android.kalkulatorsales.MainActivity.DP_KEY;
import static com.example.android.kalkulatorsales.MainActivity.HARGA_KEY;
import static com.example.android.kalkulatorsales.MainActivity.NAMA_KEY;
import static com.example.android.kalkulatorsales.MainActivity.TENOR_KEY;

public class HasilActivity extends AppCompatActivity {
    TextView tvNama, tvHarga, tvDP, tvPokokHutang, tvTotalBunga, tvTotalHutang, tvAngsuran, tvTenor;
    String nama;
    Float harga, dpPersen, dp, pokokHutang, totalBunga, totalHutang, angsuran, tenor, bunga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        // Insialisasi View
        tvNama = findViewById(R.id.tv_nama);
        tvHarga = findViewById(R.id.tv_harga);
        tvDP = findViewById(R.id.tv_dp);
        tvPokokHutang = findViewById(R.id.tv_pokok_hutang);
        tvTotalBunga = findViewById(R.id.tv_total_bunga);
        tvTotalHutang = findViewById(R.id.tv_total_hutang);
        tvAngsuran = findViewById(R.id.tv_angsuran);
        tvTenor = findViewById(R.id.tv_tenor);

        // Menjalankan Function ambilDataDariIntent()
        ambilDataDariIntent();
    }

    private void ambilDataDariIntent() {
        // Mengambil Data Dari Intent
        nama = getIntent().getStringExtra(NAMA_KEY);
        harga = getIntent().getFloatExtra(HARGA_KEY, 0);
        dpPersen = getIntent().getFloatExtra(DP_KEY, 0);
        tenor = getIntent().getFloatExtra(TENOR_KEY, 0);
        bunga = getIntent().getFloatExtra(BUNGA_KEY, 0);

        // Menghitung DP, Pokok Hutang, Total Hutang, Total Bunga dan Angsuran
        dp = harga * dpPersen / 100;
        pokokHutang = harga - dp;
        totalBunga = tenor * bunga * pokokHutang / 100;
        totalHutang = pokokHutang + totalBunga;
        angsuran = totalHutang / tenor;

        DecimalFormat myFormatter = new DecimalFormat("############");



        // Memberikan nilai untuk TextView
        tvNama.setText(nama);
        tvHarga.setText(String.valueOf(myFormatter.format(harga)));
        tvDP.setText(String.valueOf(myFormatter.format(dp)));
        tvPokokHutang.setText(String.valueOf(myFormatter.format(pokokHutang)));
        tvTotalBunga.setText(String.valueOf(myFormatter.format(totalBunga)));
        tvTotalHutang.setText(String.valueOf(myFormatter.format(totalHutang)));
        tvAngsuran.setText(String.valueOf(myFormatter.format(angsuran)));
        tvTenor.setText(String.valueOf(myFormatter.format(tenor)));
    }
}