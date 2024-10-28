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

import selects_alunos.AlunoObterInfo;
import selects_alunos.AlunoObterNome;
import selects_alunos.AlunoObterTurmaHeader;

public class AmbienteAlunoPrincipal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ambiente_aluno_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Status bar.
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.azulEscuro)); // Mudar a cor do fundo
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        // Botão Sair.
        Button bt_deslogar = findViewById(R.id.bt_deslogarAluno);
        bt_deslogar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(AmbienteAlunoPrincipal.this, MainActivity.class);
                        startActivity(i);
                    }
                }
        );

        // Obter informações do aluno.
        Intent intent = getIntent();
        String idAlunoStr = intent.getStringExtra("id_aluno");
        int idAluno = Integer.parseInt(idAlunoStr);

        TextView tv_alunoNome = findViewById(R.id.tv_alunoNome);
        new AlunoObterNome(tv_alunoNome).execute(idAluno);

        TextView tv_alunoInfoTurma = findViewById(R.id.tv_alunoInfoTurma);
        new AlunoObterTurmaHeader(tv_alunoInfoTurma).execute(idAluno);

        TextView tv_alunoInfo = findViewById(R.id.tv_alunoInfo);
        new AlunoObterInfo(tv_alunoInfo).execute(idAluno);

        // Botões.
        Button bt_alunoProfs = findViewById(R.id.bt_alunoProfs); // BOTÃO PROFESSORES.
        bt_alunoProfs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AmbienteAlunoPrincipal.this, AmbienteAlunoProf.class);
                i.putExtra("id_aluno", idAlunoStr);
                startActivity(i);
            }
        });

        Button bt_alunoMaterias = findViewById(R.id.bt_alunoMaterias); // BOTÃO MATÉRIAS.
        bt_alunoMaterias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AmbienteAlunoPrincipal.this, AmbienteAlunoMaterias.class);
                i.putExtra("id_aluno", idAlunoStr);
                startActivity(i);
            }
        });

        Button bt_alunoHorarios = findViewById(R.id.bt_alunoHorarios); // BOTÃO HORÁRIOS.
        bt_alunoHorarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AmbienteAlunoPrincipal.this, AmbienteAlunoHorarios.class);
                i.putExtra("id_aluno", idAlunoStr);
                startActivity(i);
            }
        });

        Button bt_alunoTurma = findViewById(R.id.bt_alunoTurma); // BOTÃO TURMA.
        bt_alunoTurma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AmbienteAlunoPrincipal.this, AmbienteAlunoTurma.class);
                i.putExtra("id_aluno", idAlunoStr);
                startActivity(i);
            }
        });

        Button bt_alunoBoletim = findViewById(R.id.bt_alunoBoletim); // BOTÃO BOLETIM.
        bt_alunoBoletim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AmbienteAlunoPrincipal.this, AmbienteAlunoBoletim.class);
                i.putExtra("id_aluno", idAlunoStr);
                startActivity(i);
            }
        });
    }
}