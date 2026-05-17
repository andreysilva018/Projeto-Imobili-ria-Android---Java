package com.example.appimobiliariaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaPreferencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_preferencia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RadioGroup rgQuartos = findViewById(R.id.rgQuartos);
        RadioGroup rgBanheiros = findViewById(R.id.rgBanheiros);
        RadioGroup rgGaragem  = findViewById(R.id.rgGaragem);
        Button btnAvancar = findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quartos, banheiros, garagem;
                if(rgQuartos.getCheckedRadioButtonId() == -1 || rgBanheiros.getCheckedRadioButtonId() == -1 || rgGaragem.getCheckedRadioButtonId() == -1){
                    Toast.makeText(TelaPreferencia.this, "Selecione todas as opções", Toast.LENGTH_SHORT).show();
                }
                else{
                    int idQuartos = rgQuartos.getCheckedRadioButtonId();
                    RadioButton rbQuartos = findViewById(idQuartos);
                    quartos = rbQuartos.getText().toString();

                    int idBanheiros = rgBanheiros.getCheckedRadioButtonId();
                    RadioButton rbBanheiros = findViewById(idBanheiros);
                    banheiros = rbBanheiros.getText().toString();

                    int idGaragem = rgGaragem.getCheckedRadioButtonId();
                    RadioButton rbGaragem = findViewById(idGaragem);
                    if (rbGaragem.getText().toString().equals("Sim")){
                        garagem = "Precisa de garagem";
                    }else{
                        garagem = "Não precisa de garagem";
                    }

                    Intent i = new Intent(TelaPreferencia.this, TelaComodidadesActivity.class);

                    quartos = rbQuartos.getText().toString();
                    banheiros = rbBanheiros.getText().toString();

                    Imovel imovel = (Imovel) getApplication();
                    imovel.setQuartos(quartos);
                    imovel.setBanheiros(banheiros);
                    imovel.setGaragem(garagem);
                    startActivity(i);
                }
            }
        });
    }
}