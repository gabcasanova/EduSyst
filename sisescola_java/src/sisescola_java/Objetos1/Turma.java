/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisescola_java.Objetos1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Turma {

    private int Id_Turma, Ano, Classe;
    private String Etapa;

    private List<Aluno> alunos; // Lista para armazenar alunos

    public Turma() {
        alunos = new ArrayList<>(); // Inicializa a lista de alunos
    }

    public int getId_Turma() {
        return Id_Turma;
    }

    public void setId_Turma(int Id_Turma) {
        this.Id_Turma = Id_Turma;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public int getClasse() {
        return Classe;
    }

    public void setClasse(int Classe) {
        this.Classe = Classe;
    }

    public String getEtapa() {
        return Etapa;
    }

    public void setEtapa(String Etapa) {
        this.Etapa = Etapa;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }
}
