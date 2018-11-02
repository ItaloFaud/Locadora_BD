/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Hoope
 */
public class Aluguel {
    private int cod;
    private int cod_dvd;
    private int cod_cliente;
    private String data_aluguel;
    private String horario;
    private String data_devolucao;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCod_dvd() {
        return cod_dvd;
    }

    public void setCod_dvd(int cod_dvd) {
        this.cod_dvd = cod_dvd;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getData_aluguel() {
        return data_aluguel;
    }

    public void setData_aluguel(String data_aluguel) {
        this.data_aluguel = data_aluguel;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horatio) {
        this.horario = horatio;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    
    
}
