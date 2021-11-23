package com.example.examen_1a_ev_alejandro_mendez_mendez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_NUM_ENTRADAS = "";
    public static final String EXTRA_SPINNER = "";
    private EditText edt_nentradas = null;
    private Spinner sp_zonas = null;
    private Button bt_siguiente = null;
    private String zonas;
    private int num_entradas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_nentradas = (EditText) findViewById(R.id.edt_nentradas);
        sp_zonas = (Spinner) findViewById(R.id.sp_zonas);
        bt_siguiente = (Button) findViewById(R.id.bt_siguiente);

        if(sp_zonas != null)
        {
            String[] zona = { "ZONA GENERAL", "ZONA GOLES", "ZONA ANFITEATRO"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.estilospinner, zona);
            sp_zonas.setAdapter(adapter);
            sp_zonas.setOnItemSelectedListener(this);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        zonas = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void siguiente(View view) {
        boolean errores = false;
        int nEntradas= Integer.valueOf(String.valueOf(edt_nentradas));
        String texto_entradas = String.valueOf(edt_nentradas.getText());

        if(!texto_entradas.isEmpty())
        {
            num_entradas = Integer.valueOf(texto_entradas);
        }

        else if (nEntradas<1){
            edt_nentradas.setError("El numero de entradas debe estar comprendido entre 1 y 10");
        }

        else if (nEntradas>10){
            edt_nentradas.setError("El numero de entradas debe estar comprendido entre 1 y 10");
        }

        else {
            edt_nentradas.setError("Debes introducir el número de entradas");
            errores = true;
        }
        if(errores == true)
        {
            return;
        }
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra(EXTRA_NUM_ENTRADAS,num_entradas);
        intent.putExtra(EXTRA_SPINNER, String.valueOf(sp_zonas));
        startActivity(intent);
    }
}