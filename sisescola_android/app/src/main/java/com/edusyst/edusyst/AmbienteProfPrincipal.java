package com.edusyst.edusyst;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import selects_professores.ProfObterInfo;
import selects_professores.ProfObterNome;

public class AmbienteProfPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ambiente_prof_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Status bar.
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.azulEscuro)); // Mudar a cor do fundo
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        // Botão Sair.
        Button bt_deslogar = findViewById(R.id.bt_deslogarProf);
        bt_deslogar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(AmbienteProfPrincipal.this, MainActivity.class);
                        startActivity(i);
                    }
                }
        );

        // Obter informações do professor.
        Intent intent = getIntent();
        String idProfStr = intent.getStringExtra("id_professor");
        int idProf = Integer.parseInt(idProfStr);

        TextView tv_profNome = findViewById(R.id.tv_profNome);
        new ProfObterNome(tv_profNome).execute(idProf);

        TextView tv_profInfo = findViewById(R.id.tv_profInfo);
        new ProfObterInfo(tv_profInfo).execute(idProf);

        // Botões.
        Button bt_profAlunos = findViewById(R.id.bt_profAlunos); // BOTÃO ALUNOS.
        bt_profAlunos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AmbienteProfPrincipal.this, AmbienteProfAlunos.class);
                i.putExtra("id_professor", idProfStr);
                startActivity(i);
            }
        });
    }
}