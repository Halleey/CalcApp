package com.example.zard;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editTextNumero1;
    private EditText editTextNumero2;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editTextNumero1 = findViewById(R.id.editTextNumero1);
        editTextNumero2 = findViewById(R.id.editTextNumero2);

        Button botaoCalcular = findViewById(R.id.botaoCalcular);
        botaoCalcular.setOnClickListener(v -> calcularResultado("+"));

        Button botaoDividir = findViewById(R.id.button);
        botaoDividir.setOnClickListener(v -> calcularResultado("/"));

        Button botaoSubtrair = findViewById(R.id.button2);
        botaoSubtrair.setOnClickListener(v -> calcularResultado("-"));

        Button botaoMultiplicar = findViewById(R.id.button3);
        botaoMultiplicar.setOnClickListener(v -> calcularResultado("*"));
    }

    private void calcularResultado(String operador) {
        try {
            double numero1 = Double.parseDouble(editTextNumero1.getText().toString());
            double numero2 = Double.parseDouble(editTextNumero2.getText().toString());
            double resultado = 0;

            switch (operador) {
                case "+":
                    resultado = numero1 + numero2;
                    break;
                case "-":
                    resultado = numero1 - numero2;
                    break;
                case "/":
                    if (numero2 != 0) {
                        resultado = numero1 / numero2;
                    } else {
                        textView.setText("Não é possível dividir por zero.");
                        return;
                    }
                    break;
                case "*":
                    resultado = numero1 * numero2;
                    break;
                default:
                    textView.setText("Operador inválido.");
                    return;
            }

            textView.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            textView.setText("Por favor, insira números válidos.");
        }
    }
}