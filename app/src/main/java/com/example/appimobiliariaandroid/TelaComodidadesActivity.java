package com.example.appimobiliariaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaComodidadesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_comodidades);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        CheckBox chkPiscina = findViewById(R.id.chkPiscina);
        CheckBox chkAreaGourmet = findViewById(R.id.chkAreaGourmet);
        CheckBox chkLavanderia = findViewById(R.id.chkLavanderia);
        CheckBox chkChurrasqueira = findViewById(R.id.chkChurrasqueira);
        CheckBox chkVaranda = findViewById(R.id.chkVaranda);
        CheckBox chkAcademia = findViewById(R.id.chkAcademia);
        Button btnFinalizar = findViewById(R.id.btnFinalizar);

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comodidades = "";

                if (chkPiscina.isChecked()) {
                    comodidades += "- Piscina\n";
                }
                if (chkAreaGourmet.isChecked()){
                    comodidades += "- Área Gourmet\n";
                }
                if (chkLavanderia.isChecked()){
                    comodidades += "- Lavanderia\n";
                }
                if(chkChurrasqueira.isChecked()){
                    comodidades += "- Churrasqueira\n";
                }
                if (chkVaranda.isChecked()){
                    comodidades += "- Varanda\n";
                }
                if(chkAcademia.isChecked()){
                    comodidades += "- Academia\n";
                }
                if(comodidades.isEmpty()){
                    comodidades = "Nenhuma preferência selecionada";
                }

                Intent i = new Intent(TelaComodidadesActivity.this, TelaResumoActivity.class);

                Imovel imovel = (Imovel) getApplication();
                imovel.setComodidades(comodidades);
                startActivity(i);
            }
        });
    }
}