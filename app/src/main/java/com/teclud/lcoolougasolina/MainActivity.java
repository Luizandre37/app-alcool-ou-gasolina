package com.teclud.lcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText editTextalcool,editTexgasolina;
    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextalcool  = findViewById(R.id.textalcool);
        editTexgasolina = findViewById(R.id.textgasolina);
        textResultado      = findViewById(R.id.textResultado);
    }

    public void calcular(View view) {
        //recuperando valores Digitados
        String precoalcool = editTextalcool.getText().toString();
        String precogasolina = editTexgasolina.getText().toString();

        // validar os campos digitados
        Boolean camposValidados = validarcampos(precoalcool,precogasolina);
        if (camposValidados){

            //Convertendo String para Numeros
            Double valorAlcool = Double.parseDouble(precoalcool);
            Double valorGasolina = Double.parseDouble(precogasolina);
            Double resultado = valorAlcool/valorGasolina;
            if (resultado >= 0.7){
                textResultado.setText("Melhor utilizar Gasolina");
            }else{
                textResultado.setText("Melhor utilizar Álcool");
            }

        }else {
            textResultado.setText("Preencha os preços Primeiro !");
        }



    }
    public Boolean validarcampos(String pAlcool ,String pGasolina){
        Boolean camposValidados = true;
        if (pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }else if (pGasolina == null || pGasolina.equals("")){
            camposValidados = false;

        }

        return camposValidados;
    }
}
