package com.example.beermath;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt350;
    EditText edt355;
    EditText edt473;
    EditText edt600;
    EditText edt1000;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt350 = findViewById(R.id.edt350);
        edt355 = findViewById(R.id.edt355);
        edt473 = findViewById(R.id.edt473);
        edt600 = findViewById(R.id.edt600);
        edt1000 = findViewById(R.id.edt1000);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double maisBarato = 0;
                double valorLitro = 0;
                double valorLitroBarato = 0;
                int preenchido = 0;

                //verificando se há pelo menos 2 campos preenchidos. Se campo foi preenchido, já calcula o valor por litro e guarda no maisBarato.
                if(edt350.length()!=0){
                    String numberString = (edt350.getText().toString());
                    //transformando vírgulas em pontos.
                    numberString = numberString.replaceAll(",", ".");
                    double number = Double.parseDouble(numberString);
                    //calcula valor por litro
                    valorLitro = (number*1000)/350;
                    //como é o primeiro, já guarda a quantidade de ml no mais barato
                    maisBarato = 350;
                    //guarda  valor do litro no valorLitroBarato
                    valorLitroBarato = valorLitro;
                    preenchido = preenchido+1;
                }
                if(edt355.length()!=0){
                    String numberString = (edt355.getText().toString());
                    numberString = numberString.replaceAll(",", ".");
                    double number = Double.parseDouble(numberString);
                    //calcula valor por litro
                    valorLitro = (number*1000)/355;
                    //vejo se é mais barato que o anterior
                    if(valorLitro < valorLitroBarato){
                        maisBarato = 355;
                        valorLitroBarato = valorLitro;
                    }
                    preenchido = preenchido+1;
                }
                if(edt473.length()!=0){
                    String numberString = (edt473.getText().toString());
                    numberString = numberString.replaceAll(",", ".");
                    double number = Double.parseDouble(numberString);
                    valorLitro = (number*1000)/473;
                    if(valorLitro < valorLitroBarato){
                        maisBarato = 473;
                        valorLitroBarato = valorLitro;
                    }
                    preenchido = preenchido+1;
                }
                if(edt600.length()!=0){
                    String numberString = (edt600.getText().toString());
                    numberString = numberString.replaceAll(",", ".");
                    double number = Double.parseDouble(numberString);
                    valorLitro = (number*1000)/600;
                    if(valorLitro < valorLitroBarato){
                        maisBarato = 600;
                        valorLitroBarato = valorLitro;
                    }
                    preenchido = preenchido+1;
                }
                if(edt1000.length()!=0){
                    String numberString = (edt1000.getText().toString());
                    numberString = numberString.replaceAll(",", ".");
                    double number = Double.parseDouble(numberString);
                    if(number < valorLitroBarato){
                        maisBarato = 1000;
                        valorLitroBarato = number;
                    }
                    preenchido = preenchido+1;
                }
                if(preenchido>1){
                    criarToast("O mais barato foi o de "+Double.toString(maisBarato)+"ml. O preço por litro é R$"+Double.toString(valorLitroBarato));

                }else{
                    criarToast("Preencher pelo menos 2 campos para comparar");
                }
            }
        });
    }
    public void criarToast(String texto){
        Toast.makeText(MainActivity.this,texto,Toast.LENGTH_LONG).show();
    }
}
