package com.example.appimobiliariaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaLocalizacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_localizacao);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edtCidade = findViewById(R.id.edtCidade);
        Spinner listasuspensa_uf = findViewById(R.id.listasuspensa_uf);
        Button btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cidade = edtCidade.getText().toString().trim();
                String uf = listasuspensa_uf.getSelectedItem().toString();
                if(edtCidade.getText().toString().trim().isEmpty() && listasuspensa_uf.getSelectedItemPosition() == 0){
                    Toast.makeText(TelaLocalizacaoActivity.this, "TODOS OS CAMPOS DEVEM ESTAR PREENCHIDOS!", Toast.LENGTH_LONG).show();
                } else{
                    Imovel imovel = (Imovel) getApplication();
                    imovel.setCidade(cidade);
                    imovel.setUf(uf);
                    Intent i = new Intent(TelaLocalizacaoActivity.this, TelaPreferencia.class);
                    startActivity(i);

                }
            }
        });
    }
}