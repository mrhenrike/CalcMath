package br.com.webinfodesigner.conversorapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MediaActivity extends Activity {

    private EditText txtNota1;
    private EditText txtNota2;
    private EditText txtNota3;
    private Button btnCalcular;
    private TextView txtMediaFinal;
    private double nota1;
    private double nota2;
    private double nota3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        txtNota1 = (EditText) findViewById(R.id.txtNota1);
        txtNota2 = (EditText) findViewById(R.id.txtNota2);
        txtNota3 = (EditText) findViewById(R.id.txtNota3);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        txtMediaFinal = (TextView) findViewById(R.id.txtMediaFinal);

        btnCalcular.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                nota1 = Double.parseDouble(txtNota1.getText().toString());
                nota2 = Double.parseDouble(txtNota2.getText().toString());
                nota3 = Double.parseDouble(txtNota3.getText().toString());

                Double media = calcularMedia(nota1, nota2, nota3);
                txtMediaFinal.setText(media.toString());
            }
        });

    }

    private double calcularMedia(double n1, double n2, double n3) {
        double mediaFinal = (n1 + n2 + n3) / 3;
        return mediaFinal;
    }

    //Metodo para voltar p/tela anterior
    public void voltar(View view) {
        onBackPressed();
    }

}