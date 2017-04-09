package br.com.webinfodesigner.conversorapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TempActivity extends Activity {

    private Button celsius;
    private Button fahrenheit;
    private TextView tempResult;
    private EditText temperature;

    @Override
    protected void onCreate(Bundle savedValues) {
        super.onCreate(savedValues);
        setContentView(R.layout.activity_temp);

        temperature = (EditText) this.findViewById(R.id.temperature);

        celsius = (Button) this.findViewById(R.id.celsius);
        celsius.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                convertToCelsius(temperature);
            }
        });

        fahrenheit = (Button) this.findViewById(R.id.fahrenheit);
        fahrenheit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                convertToFahrenheit(temperature);
            }
        });

        tempResult = (TextView) this.findViewById(R.id.tempResult);
    }

    protected void convertToFahrenheit(EditText temperature) {
        Double b = new Double(temperature.getText().toString());

        Double tf = new Double((1.8 * b.doubleValue()) + 32);

        tempResult.setText("Temperatura em Fahrenheit eh: " + tf.toString());
    }

    protected void convertToCelsius(EditText temperature) {
        Double b = new Double(temperature.getText().toString());

        Double tf = new Double((0.55555555555555555555555555555556) * (b.doubleValue() - 32.0));

        tempResult.setText("Temperatura em Celsius eh: " + tf.toString());
    }

    //Metodo para voltar p/tela anterior
    public void voltar(View view) {
        onBackPressed();
    }
}