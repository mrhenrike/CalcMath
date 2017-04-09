package br.com.webinfodesigner.conversorapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    //Abre Cálculo de IMC
    public void abreIMC(View view) {
        Intent intent = new Intent(this, IMCActivity.class);
        startActivity(intent);
    }

    //Abre Cálculo de Média Aritimética Entre 3 Números
    public void abreMedia(View view) {
        Intent intent = new Intent(this, MediaActivity.class);
        startActivity(intent);
    }

    //Abre Conversor de Temperaturas
    public void abreTemperatura(View view) {
        Intent intent = new Intent(this, TempActivity.class);
        startActivity(intent);
    }

    //Abre a Calculadora
    public void abreCalculadora(View view) {
        Intent intent = new Intent(this, CalcActivity.class);
        startActivity(intent);
    }

    //Metodo para voltar p/tela anterior
    public void voltar(View view) {
        onBackPressed();
    }

}
