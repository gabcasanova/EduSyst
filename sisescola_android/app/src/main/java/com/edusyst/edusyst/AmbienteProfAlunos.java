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

import selects_alunos.AlunoObterProfs;
import selects_professores.ProfObterAlunos;

public class AmbienteProfAlunos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ambiente_prof_alunos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Status bar.
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.azulEscuro)); // Mudar a cor do fundo
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        // Toolbar
        Toolbar tb_profAlunos = findViewById(R.id.tb_profAlunos);
        setSupportActionBar(tb_profAlunos);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            tb_profAlunos.getNavigationIcon().setTint(ContextCompat.getColor(this, R.color.white)); // Mudar cor do botão de voltar
        }

        // Obter alunos.
        Intent intent = getIntent();
        String idProfStr = intent.getStringExtra("id_professor");
        int idProfessor = Integer.parseInt(idProfStr);

        TableLayout tl_alunos = findViewById(R.id.tl_alunos);
        new ProfObterAlunos(this, tl_alunos).execute(idProfessor);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Go back to the previous activity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}