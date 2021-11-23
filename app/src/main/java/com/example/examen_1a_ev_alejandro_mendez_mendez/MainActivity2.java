package com.example.examen_1a_ev_alejandro_mendez_mendez;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {


    private TextView txt_nzona;
    private TextView txt_ncantidad;
    private int num_entradas;
    private String sp_zonas;
    private RadioButton rb_si;
    private RadioButton rb_no;
    private double precio_general = 5.0;
    private double precio_anfiteatro = 4.0;
    private double precio_goles = 3.0;
    private TextView txt_zonas;
    private TextView txt_ntotal;
    private TextView txt_ntotalPagar;
    private TextView txt_ndescuento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // recupero los datos que me han mandado
        txt_nzona = (TextView) findViewById(R.id.txt_nzona);
        txt_ncantidad = (TextView) findViewById(R.id.txt_ncantidad);
        txt_zonas = (TextView) findViewById(R.id.txt_zonas);
        txt_ntotal = (TextView)findViewById(R.id.txt_ntotal);
        txt_ntotalPagar =(TextView)findViewById(R.id.txt_ntotalPagar);
        txt_ndescuento = (TextView)findViewById(R.id.txt_ndescuento);
        rb_si = (RadioButton) findViewById(R.id.rb_si);
        rb_no = (RadioButton) findViewById(R.id.rb_no);
        //--------------------------------------------------------------------------------------------------------
        Intent intent = getIntent();
        if (intent != null) {
            num_entradas = intent.getIntExtra(MainActivity.EXTRA_NUM_ENTRADAS, 0);
            txt_ncantidad.setText(String.valueOf(num_entradas));
            //-------------------------------------------------------------------
            sp_zonas = intent.getStringExtra(MainActivity.EXTRA_SPINNER);
            txt_nzona.setText(String.valueOf(sp_zonas) + "€");
            //---------------------------------------------------------------------
            Toast.makeText(this, "numero de entradas -> " + String.valueOf(num_entradas), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Zona de asientos -> " + String.valueOf(sp_zonas), Toast.LENGTH_SHORT).show();




            if(rb_no.isSelected()) {
                double total = 0.0;
                if (txt_zonas.equals("Zona general"))
                {
                    total = num_entradas-precio_general;
                }
                else if (txt_zonas.equals("Zona anfiteatro"))
                {
                    total = num_entradas-precio_anfiteatro;
                }
                else if (txt_zonas.equals("Zona goles"))
                {
                    total = num_entradas-precio_goles;
                }

                txt_ntotal.setText(String.valueOf(total) + "€");
                txt_ntotalPagar.setText(String.valueOf(total)+"€");

            }
            else{
                double total = 0.0;
                double descuento = 0.0;
                double totalDescuento = 0.0;
                if (txt_zonas.equals("Zona general"))
                {
                    descuento = (num_entradas-precio_general)*0.1;
                    total = num_entradas-precio_general;
                    totalDescuento = num_entradas-precio_general-descuento;
                }
                else if (txt_zonas.equals("Zona anfiteatro"))
                {
                    descuento = (num_entradas-precio_anfiteatro)*0.1;
                    total = num_entradas-precio_anfiteatro;
                    totalDescuento =num_entradas-precio_anfiteatro-descuento;
                }
                else if (txt_zonas.equals("Zona goles"))
                {
                    descuento = (num_entradas-precio_goles)*0.1;
                    total = num_entradas-precio_goles;
                    totalDescuento = num_entradas-precio_goles-descuento;
                }

                txt_ntotal.setText(String.valueOf(total) + "€");
                txt_ntotalPagar.setText(String.valueOf(totalDescuento));
                txt_ndescuento.setText(String.valueOf(descuento));
            }

        }
    }
}

