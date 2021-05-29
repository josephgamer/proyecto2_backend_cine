/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Esteban
 */
public class Horario implements Serializable{
    private int numHorario;
    private Date dia;
    private int hora;
    
    public Horario() {
        this.dia = new Date();
        this.hora = 0;
        this.numHorario = 0;
    }

    public Horario(int numHorario, Date dia, int hora) {
        this.numHorario = numHorario;
        this.dia = dia;
        this.hora = hora;
    }

    public int getNumHorario() {
        return numHorario;
    }

    public void setNumHorario(int numHorario) {
        this.numHorario = numHorario;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Horario{" + "numHorario=" + numHorario + ", dia=" + dia + ", hora=" + hora + '}';
    }
}
