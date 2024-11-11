/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisescola_java.Objetos1;

/**
 *
 * @author Matheus
 */
public class Horario {

    private int Id_Horario;
    private String Turno, Inicio, Fim, Dia_Semana;

    public int getId_Horario() {
        return Id_Horario;
    }

    public void setId_Horario(int Id_Horario) {
        this.Id_Horario = Id_Horario;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String Turno) {
        this.Turno = Turno;
    }

    public String getInicio() {
        return Inicio;
    }

    public void setInicio(String Inicio) {
        this.Inicio = Inicio;
    }

    public String getFim() {
        return Fim;
    }

    public void setFim(String Fim) {
        this.Fim = Fim;
    }

    public String getDia_Semana() {
        return Dia_Semana;
    }

    public void setDia_Semana(String Dia_Semana) {
        this.Dia_Semana = Dia_Semana;
    }

    @Override
    public String toString() {
        return Turno + " - " + Inicio + " - " + Dia_Semana; // Ajuste conforme os atributos da classe
    }

}
