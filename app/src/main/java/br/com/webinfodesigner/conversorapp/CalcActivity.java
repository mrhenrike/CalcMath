package br.com.webinfodesigner.conversorapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends Activity {

    //Declaração de Variáveis
    TextView textView;
    String currentString = "0", previusString = null;
    boolean isTempStringShown = false;
    int currentopperand = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        //Recebe Tela de Cálculos
        textView = (TextView) findViewById(R.id.textViewTela);

        //Capturando valores das teclas numéricas
        int numberButtons[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
        NumberButtonClickListener numberClickListener = new NumberButtonClickListener();

        for (int id : numberButtons) {
            View v = findViewById(id);
            v.setOnClickListener(numberClickListener);
        }

        //Captura valores das teclas de operação
        int opperandButtons[] = {R.id.buttonSoma, R.id.buttonSubtrai, R.id.buttonDivisao, R.id.buttonMultiplica, R.id.buttonPonto, R.id.buttonLimpa, R.id.buttonIgual};
        OpperandButtonClickListener oppClickListener = new OpperandButtonClickListener();
        for (int id : opperandButtons) {
            View v = findViewById(id);
            v.setOnClickListener(oppClickListener);
        }
        setCurrentString("0");
    }

    void setCurrentString(String s) {
        currentString = s;
        textView.setText(s);
    }

    //Escuta as teclas numericas
    class NumberButtonClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            if (isTempStringShown) {
                previusString = currentString;
                currentString = "0";
                isTempStringShown = false;
            }
            String text = (String) ((Button) v).getText();
            if (currentString.equals("0")) setCurrentString(text);
            else setCurrentString(currentString + text);
        }
    }

    //Escuta as teclas de operação
    class OpperandButtonClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.buttonLimpa) {
                isTempStringShown = false;
                setCurrentString("0");
                previusString = null;
            }
            if (id == R.id.buttonPonto)
                if (!currentString.contains(".")) setCurrentString(currentString + ".");
            if (id == R.id.buttonSoma || id == R.id.buttonSubtrai || id == R.id.buttonMultiplica || id == R.id.buttonDivisao) {
                currentopperand = id;
                previusString = currentString;
                isTempStringShown = true;
            }
            if (id == R.id.buttonIgual) {
                double curr = Double.parseDouble(currentString);
                double result = 0;
                if (previusString != null) {
                    double prev = Double.parseDouble(previusString);
                    switch (currentopperand) {
                        case R.id.buttonSoma:
                            result = prev + curr;
                            break;
                        case R.id.buttonSubtrai:
                            result = prev - curr;
                            break;
                        case R.id.buttonMultiplica:
                            result = prev * curr;
                            break;
                        case R.id.buttonDivisao:
                            result = prev / curr;
                            break;
                    }
                }
                setCurrentString(Double.toString(result));
            }
        }
    }

    //Metodo para voltar p/tela anterior
    public void voltar(View view) {
        onBackPressed();
    }
}