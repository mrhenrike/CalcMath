package br.com.webinfodesigner.conversorapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IMCActivity extends Activity {

    //Declaração de variáveis
    EditText edpeso, edaltura;
    TextView tres, tinform, triscos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        //Recebe valores por ID
        edpeso = (EditText) findViewById(R.id.peso);
        edaltura = (EditText) findViewById(R.id.altura);
        tres = (TextView) findViewById(R.id.resultado);
        tinform = (TextView) findViewById(R.id.inform);
        triscos = (TextView) findViewById(R.id.riscos);

        Button btMostrar = (Button) findViewById(R.id.btnmostrar);

        btMostrar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0) {

                double peso =  Double.parseDouble(edpeso.getText().toString());
                double altura = Double.parseDouble(edaltura.getText().toString());
                double res = (peso / (altura * altura));

                String informacao = (String) getText(R.string.info_naocalc);
                String riscos = (String) getText(R.string.risc_risco);

                if (res < 15) {
                    informacao = (String) getText(R.string.info_15);
                    riscos = (String) getText(R.string.risc_15);
                }
                if ((res >= 15) && (res < 18.5)) {
                    informacao = (String) getText(R.string.info_18_5);
                    riscos = (String) getText(R.string.risc_18_5);
                }
                if ((res >= 18.6) && (res < 24.9)) {
                    informacao = (String) getText(R.string.info_24_9);
                    riscos = (String) getText(R.string.risc_24_9);
                }
                if ((res >= 25) && (res < 29.4)) {
                    informacao = (String) getText(R.string.info_29_4);
                    riscos = (String) getText(R.string.risc_29_4);
                }
                if ((res >= 30) && (res < 39.4)) {
                    informacao = (String) getText(R.string.info_39_4);
                    riscos = (String) getText(R.string.risc_39_4);
                }
                if (res >= 40) {
                    informacao = (String) getText(R.string.info_40);
                    riscos = (String) getText(R.string.risc_40);
                }

                tres.setText(String.valueOf(res));
                tinform.setText(String.valueOf(informacao));
                triscos.setText(String.valueOf(riscos));
            }
        });
    }

    //Metodo para voltar p/tela anterior
    public void voltar(View view) {
        onBackPressed();
    }
}
