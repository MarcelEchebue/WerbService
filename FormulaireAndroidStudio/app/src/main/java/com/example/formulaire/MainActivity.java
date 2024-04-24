package com.example.formulaire;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import androidx.appcompat.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonAdd, buttonView, buttonEdit, buttonDelete;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonView = findViewById(R.id.buttonView);
        buttonEdit = findViewById(R.id.buttonEdit);
        buttonDelete = findViewById(R.id.buttonDelete);

        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
        buttonEdit.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAdd:
                // Implementación para añadir datos
                // Aquí colocamos un ejemplo de cómo mostrar un mensaje indicando que esta función está en desarrollo
                Toast.makeText(MainActivity.this, "Función de añadir datos en desarrollo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonView:
                // Implementación para ver datos
                // Aquí colocamos un ejemplo de cómo iniciar una nueva actividad para ver los datos
                Intent viewIntent = new Intent(MainActivity.this, ViewDataActivity.class);
                startActivity(viewIntent);
                break;
            case R.id.buttonEdit:
                // Implementación para editar datos
                // Aquí colocamos un ejemplo de cómo mostrar un mensaje indicando que esta función está en desarrollo
                Toast.makeText(MainActivity.this, "Función de editar datos en desarrollo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonDelete:
                // Implementación para borrar datos
                // Aquí colocamos un ejemplo de cómo mostrar un mensaje indicando que esta función está en desarrollo
                Toast.makeText(MainActivity.this, "Función de borrar datos en desarrollo", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private class ViewDataTask extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Cargando datos...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("http://127.0.0.1:8000/api/formulaires"); // Reemplaza con tu URL de la API
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                bufferedReader.close();

                return stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            if (s != null) {
                try {
                    JSONArray jsonArray = new JSONArray(s);
                    // Mostrar los datos en una nueva actividad o ventana de diálogo
                    showData(jsonArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(MainActivity.this, "Error al cargar datos", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showData(JSONArray jsonArray) {
        // Muestra los datos en una nueva actividad o ventana de diálogo
        // Por ejemplo, puedes crear una nueva actividad y pasar los datos a través de un Intent
        // O puedes mostrar los datos en un cuadro de diálogo utilizando AlertDialog
        // Aquí hay un ejemplo básico para mostrar los datos en un Toast
        StringBuilder dataBuilder = new StringBuilder();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String nombre = jsonObject.getString("nombre");
                String apellido = jsonObject.getString("apellido");
                String edad = jsonObject.getString("edad");
                String nombrePadre = jsonObject.getString("nombre_padre");
                String nombreMadre = jsonObject.getString("nombre_madre");
                dataBuilder.append("Nombre: ").append(nombre).append("\n")
                        .append("Apellido: ").append(apellido).append("\n")
                        .append("Edad: ").append(edad).append("\n")
                        .append("Nombre del Padre: ").append(nombrePadre).append("\n")
                        .append("Nombre de la Madre: ").append(nombreMadre).append("\n\n");
            }
            Toast.makeText(MainActivity.this, dataBuilder.toString(), Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

