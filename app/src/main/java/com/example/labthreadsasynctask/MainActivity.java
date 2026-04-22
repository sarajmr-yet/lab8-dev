package com.example.labthreadsasynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txtStatus;
    private ProgressBar progressBar;
    private ImageView imageView;
    private Button btnLoad, btnToast, btnCalc;

    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtStatus = findViewById(R.id.txtStatus);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageView);
        btnLoad = findViewById(R.id.btnLoad);
        btnToast = findViewById(R.id.btnToast);
        btnCalc = findViewById(R.id.btnCalc);


        btnLoad.setOnClickListener(v -> {
            txtStatus.setText("Chargement en cours... ");
            imageView.setVisibility(View.GONE);

            new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(() -> {
                    txtStatus.setText("Image chargée ");
                    imageView.setVisibility(View.VISIBLE);
                });
            }).start();
        });


        btnToast.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "UI fluide ", Toast.LENGTH_SHORT).show();
        });


        btnCalc.setOnClickListener(v -> {
            new HeavyTask().execute();
        });
    }


    private class HeavyTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            progressBar.setProgress(0);
            txtStatus.setText("Calcul en cours... ");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i <= 100; i += 5) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void unused) {
            txtStatus.setText("Calcul terminé ");
        }
    }
}