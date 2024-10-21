package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Usuario, Contraseña;
    ProgressBar pgB;
    Button btnValidar;
    TextView lblResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Usuario = findViewById(R.id.txtUsuario);
        Contraseña = findViewById(R.id.txtPass);
        btnValidar = findViewById(R.id.btnLogin);
        pgB = findViewById(R.id.progressBar);
        lblResultado = findViewById(R.id.lblMsj);
        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            new  AsyncTaskV().execute(Usuario.getText().toString(), Contraseña.getText().toString());
            }
        });
    }
    class AsyncTaskV extends android.os.AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            pgB.setVisibility(View.VISIBLE);
            btnValidar.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                Thread.sleep(5000);
                String UserValido = "Pepito";
                String PassValido = "Pepito123";
                String UserInput = strings[0];
                String PassInput = strings[1];

                if (UserInput.equals(UserValido) && PassInput.equals(PassValido)) {
                    lblResultado.setText("Usuario correcto");
                } else {
                    lblResultado.setText("Usuario/Password incorrecto");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
           pgB.setVisibility(View.VISIBLE);
           btnValidar.setEnabled(true);
        }

    }
}