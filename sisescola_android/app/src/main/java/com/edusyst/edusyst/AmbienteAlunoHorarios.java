package com.edusyst.edusyst;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import selects_alunos.AlunoObterHor;

public class AmbienteAlunoHorarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ambiente_aluno_horarios);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Status bar.
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.azulEscuro)); // Mudar a cor do fundo
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        // Toolbar
        Toolbar tb_alunoHor = findViewById(R.id.tb_alunoHor);
        setSupportActionBar(tb_alunoHor);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            tb_alunoHor.getNavigationIcon().setTint(ContextCompat.getColor(this, R.color.white)); // Mudar cor do botão de voltar
        }

        // Obter informações do aluno.
        Intent intent = getIntent();
        String idAlunoStr = intent.getStringExtra("id_aluno");
        int idAluno = Integer.parseInt(idAlunoStr);

        TableLayout tl_hor = findViewById(R.id.tl_hor);
        new AlunoObterHor(this, tl_hor).execute(idAluno);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Voltar para página anterior
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}