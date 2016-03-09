package com.ctproject.samplesnackbar;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    private Button tombolSnackbarSederhana, tombolSnackbarCallback, tombolSnackbarCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi atau pendeklarasian variabel yang dijadikan Button berdasarkan id yang sudah diberikan
        tombolSnackbarSederhana = (Button) findViewById(R.id.bSederhana);
        tombolSnackbarCallback = (Button) findViewById(R.id.bCallback);
        tombolSnackbarCustom = (Button) findViewById(R.id.bCustom);
        //Inisialisasi CoordinatorLayout yang digunakan berdasarkan id, disini kita bisa menggunakan jenis Layout lain
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        //Sekarang kita akan membuat aksi yang dilakukan jika tombol ditekan menggunakan setOnClickListener()
        //Tombol Snackbar Sederhana terlebih dahulu
        tombolSnackbarSederhana.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Pendeklarasian varibael snackbar sebagai Snackbar
                Snackbar snackbar = Snackbar
                        /*
                        coordinatorLayout digunakan sebagai Layout dimana Snackbar akan dimunculkan
                        lalu, LENGTH_LONG atau LENGTH_SHORT atau LENGTH_IDEFINITE adalah durasi yang digunakan
                        LENGTH_LONG memiliki durasi 3500ms atau 3,5 detik
                        LENGTH_SHORT memiliki durasi 2000ms atau 2,5 detik
                        sedangkan LENGTH_IDEFINITE tidak memiliki durasi, snackbar akan hilang jika ada Aksi yang diberikan
                        Jadi... bentuk umumnya
                        variabel_yang_dijadikan_snackbar=Snackbar.make(tempat_dimunculkan,kalimat,durasi);
                        */
                        .make(coordinatorLayout, "Selamat!!!!\nKamu berhasil membuat Snackbar :)", Snackbar.LENGTH_LONG);
                //digunakan untuk menampilkan Snackbar
                snackbar.show();
            }
        });

        //Tombol Snackbar dengan Callback atau UNDO
        tombolSnackbarCallback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Pendeklarasian varibael snackbar sebagai Snackbar
                Snackbar snackbar = Snackbar
                        /*
                        coordinatorLayout digunakan sebagai Layout dimana Snackbar akan dimunculkan
                        lalu, LENGTH_LONG atau LENGTH_SHORT atau LENGTH_IDEFINITE adalah durasi yang digunakan
                        LENGTH_LONG memiliki durasi 3500ms atau 3,5 detik
                        LENGTH_SHORT memiliki durasi 2000ms atau 2,5 detik
                        sedangkan LENGTH_IDEFINITE tidak memiliki durasi, snackbar akan hilang jika ada Aksi yang diberikan
                        Jadi... bentuk umumnya
                        variabel_yang_dijadikan_snackbar=Snackbar.make(tempat_dimunculkan,kalimat,durasi);
                        */
                        .make(coordinatorLayout, "Pesan dihapus!", Snackbar.LENGTH_LONG)
                        //disini kita menambahkan aksi yang akan dilakukan jika tombol BATALKAN ditekan
                        .setAction("BATALKAN", new View.OnClickListener() {
                            //buat aksi disini
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Pesan dipulihkan!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });
                //digunakan untuk menampilkan Snackbar
                snackbar.show();
            }
        });

        //Tombol Snackbar dengan kustomisasi
        tombolSnackbarCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pendeklarasian varibael snackbar sebagai Snackbar
                Snackbar snackbar = Snackbar
                        /*
                        coordinatorLayout digunakan sebagai Layout dimana Snackbar akan dimunculkan
                        lalu, LENGTH_LONG atau LENGTH_SHORT atau LENGTH_IDEFINITE adalah durasi yang digunakan
                        LENGTH_LONG memiliki durasi 3500ms atau 3,5 detik
                        LENGTH_SHORT memiliki durasi 2000ms atau 2,5 detik
                        sedangkan LENGTH_IDEFINITE tidak memiliki durasi, snackbar akan hilang jika ada Aksi yang diberikan
                        Jadi... bentuk umumnya
                        variabel_yang_dijadikan_snackbar=Snackbar.make(tempat_dimunculkan,kalimat,durasi);
                        */
                        .make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_SHORT)
                        //disini kita ubah durasi dari LENGTH_LONG menjadi 7000ms atau 7 detik
                        .setDuration(7000)
                                //disini kita menambahkan aksi yang akan dilakukan jika tombol BATALKAN ditekan
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            //buat aksi disini
                            public void onClick(View view) {
                                //disini kita akan membuat Toast jika tombol ditekan
                                Toast.makeText(MainActivity.this, "Tidak ada koneksi!", Toast.LENGTH_SHORT).show();
                            }
                        });
                // Selanjutnya disini kita bisa mengubah warna dari teks Snackbar, disini kita ubah dengan yang simpel saja
                snackbar.setActionTextColor(Color.RED);
                // Sekarang ubah Teks untuk tombol aksi
                View sView = snackbar.getView();
                TextView textView = (TextView) sView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                //Tampilkan Snackbar
                snackbar.show();
            }
        });

    }
}
