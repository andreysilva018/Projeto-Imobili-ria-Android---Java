package com.example.appimobiliariaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaResumoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_resumo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView txtCidade, txtValoruf, txtQuartos, txtBanheiros, txtGaragem, txtPreferencias, txtValorTotal;
        String cidade, valorUF, quartos, banheiros, garagem, preferencias;
        double valorTotal = 0;

        txtCidade = findViewById(R.id.txtCidade);
        txtValoruf = findViewById(R.id.txtValorUF);
        txtQuartos = findViewById(R.id.txtQuartos);
        txtBanheiros = findViewById(R.id.txtBanheiros);
        txtGaragem = findViewById(R.id.txtGaragem);
        txtPreferencias = findViewById(R.id.txtPreferencias);
        txtValorTotal = findViewById(R.id.txtValorTotal);

        Imovel imovel = (Imovel) getApplication();
        Intent i = getIntent();

        cidade = imovel.getCidade();
        valorUF = imovel.getUf();
        quartos = imovel.getQuartos();
        banheiros = imovel.getBanheiros();
        garagem = imovel.getGaragem();
        preferencias = imovel.getComodidades();

        if(imovel.getQuartos().contains("1 quarto")){
            valorTotal += 300;
        }
        else if(imovel.getQuartos().contains("2 quarto")){
            valorTotal += 500;
        }
        else{
            valorTotal += 700;
        }

        if(imovel.getBanheiros().contains("1 banheiro")){
            valorTotal += 100;
        }
        else if(imovel.getBanheiros().contains("2 banheiro")){
            valorTotal += 200;
        }
        else{
            valorTotal += 300;
        }

        if (imovel.getGaragem().contains("Precisa de garagem")){
            valorTotal += 100;
        }
        if(imovel.getComodidades().contains("Piscina")){
            valorTotal += 150;
        }
        if(imovel.getComodidades().contains("Área Gourmet")){
            valorTotal += 150;
        }
        if (imovel.getComodidades().contains("Lavanderia")){
            valorTotal += 150;
        }
        if (imovel.getComodidades().contains("Churrasqueira")){
            valorTotal += 150;
        }
        if(imovel.getComodidades().contains("Varanda")){
            valorTotal += 150;
        }
        if(imovel.getComodidades().contains("Academia")){
            valorTotal += 150;
        }

        txtCidade.setText(cidade);
        txtValoruf.setText(valorUF);
        txtQuartos.setText(quartos);
        txtBanheiros.setText(banheiros);
        txtGaragem.setText(garagem);
        txtPreferencias.setText(preferencias);
        txtValorTotal.setText("Valor do aluguel: R$ " + Double.parseDouble(String.valueOf(valorTotal)));
    }
}