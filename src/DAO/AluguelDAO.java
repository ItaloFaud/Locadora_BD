/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Aluguel;
import Modelo.Categoria;
import Modelo.Cliente;
import Modelo.DVD;
import Modelo.Filme;
import Modelo.Listar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoope
 */
public class AluguelDAO extends ExecuteSQL {
    
    public AluguelDAO(Connection con) {
        super(con);
    }
    
    public String Conferir(DVD d,Filme f){
        try {
            String consulta = "select idfilme,preco_compra from dvd where iddvd = '"+d.getCodigo()+"' and situacao = "
                    + "'Disponível'";
            
            PreparedStatement ps2 = getCon().prepareStatement(consulta);
            ResultSet rs2 = ps2.executeQuery();
            
            if(rs2 != null){
                while(rs2.next()){
                    //Funcionario fun = new Funcionario();
                    d.setPreco(rs2.getString(2));
                    String consulta2 = "select titulo,idcategoria,idclassificacao,capa from filme where idfilme = '"+rs2.getInt(1)+"'";
                    PreparedStatement ps = getCon().prepareStatement(consulta2);
                    ResultSet rs = ps.executeQuery();
                        if(rs != null){
                            while(rs.next()){
                                
                                f.setTitulo(rs.getString(1));
                                f.setCod_categoria(rs.getInt(2));
                                f.setCod_classificacao(rs.getInt(3));
                                f.setCapa(rs.getString(4));

                                
                                
                            }
                        }
                    
                    //finalResult = true;
                    return "DVD disponível!";
                }
            }else{
                return "DVD já emprestado!";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "DVD não encontrado";
        }
        return "DVD já emprestado";
        
    }
    
    
    
    
    
    public String Cadastrar(String hora,String data_aluguel,String data_devolucao, int idcliente, int iddvd){
        try {
            String sql = "insert into aluguel values (0,?,?,?,?,?)";
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, iddvd);
            ps.setInt(2, idcliente);
            ps.setString(3, hora);
            ps.setString(4, data_aluguel);
            ps.setString(5, data_devolucao);

            if(ps.executeUpdate() > 0){
                String sql2 = "update dvd set situacao = 'indisponível' where iddvd = '"+iddvd+"'";
                PreparedStatement ps2 = getCon().prepareStatement(sql2);
                if(ps2.executeUpdate() > 0){
                    return "Locação efetuada!";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro de Locação: "+ex.getMessage();
        }
        return null;
        
    }
    
    public List<Aluguel> Consulta() {
        String consulta = "select idaluguel,iddvd,idcliente,hora_aluguel,data_aluguel,data_devolucao from aluguel";
            List<Aluguel> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Aluguel c = new Aluguel();
                    c.setCod(rs.getInt(1));
                    c.setCod_dvd(rs.getInt(2));
                    c.setCod_cliente(rs.getInt(3));
                    c.setHorario(rs.getString(4));
                    c.setData_aluguel(rs.getString(5));
                    c.setData_devolucao(rs.getString(6));
                    
                    lista.add(c);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public List<Aluguel> ConsultaTipada(String tipo, int id) {
        String consulta = "select idaluguel,iddvd,idcliente,hora_aluguel,data_aluguel,data_devolucao from aluguel "
                + "where id"+tipo+" = '"+id+"'";
            List<Aluguel> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Aluguel c = new Aluguel();
                    c.setCod(rs.getInt(1));
                    c.setCod_dvd(rs.getInt(2));
                    c.setCod_cliente(rs.getInt(3));
                    c.setHorario(rs.getString(4));
                    c.setData_aluguel(rs.getString(5));
                    c.setData_devolucao(rs.getString(6));
                    
                    lista.add(c);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public List<Aluguel> ConsultaCliente(String nome) {
        try {
            String consulta1 = "select idcliente from cliente where nome = '"+nome+"'";
            
            PreparedStatement ps2 = getCon().prepareStatement(consulta1);
            ResultSet rs2 = ps2.executeQuery();
            
            if(rs2 != null){
                while (rs2.next()) {
                    try {
                
            String consulta = "select idaluguel,iddvd,idcliente,hora_aluguel,data_aluguel,data_devolucao from aluguel "
                    + "where idcliente = '"+rs2.getInt(1)+"'";
            List<Aluguel> lista = new ArrayList<>();
            
                PreparedStatement ps = getCon().prepareStatement(consulta);
                ResultSet rs = ps.executeQuery();
                
                if(rs != null){
                    while (rs.next()) {
                        Aluguel c = new Aluguel();
                        c.setCod(rs.getInt(1));
                        c.setCod_dvd(rs.getInt(2));
                        c.setCod_cliente(rs.getInt(3));
                        c.setHorario(rs.getString(4));
                        c.setData_aluguel(rs.getString(5));
                        c.setData_devolucao(rs.getString(6));
                        
                        lista.add(c);
                    }return lista;
                }else{
                    return null;
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
                }
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        }
        return null;
        
        
    }
    
    public void Devolucao(Aluguel a, Cliente c, Filme f,DVD d){
        try {
            String consulta = "select hora_aluguel,data_aluguel,data_devolucao from aluguel where idaluguel = '"+Listar.getCodaluguel()+"'";
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while(rs.next()){
                    //Funcionario fun = new Funcionario();
                    a.setHorario(rs.getString(1));
                    a.setData_aluguel(rs.getString(2));
                    a.setData_devolucao(rs.getString(3));
                    //finalResult = true;
                    //return "Classificação encontrada!";
                }
            }
            
            
            String consulta2 = "select nome from cliente where idcliente = '"+Listar.getCodcliente()+"'";
            PreparedStatement ps2 = getCon().prepareStatement(consulta2);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2 != null){
                while(rs2.next()){
                    //Funcionario fun = new Funcionario();
                    c.setNome(rs2.getString(1));
                    
                    //finalResult = true;
                    //return "Classificação encontrada!";
                }
            }
            
            String consulta3 = "select idfilme,preco_compra from dvd where iddvd = '"+Listar.getCoddvd()+"'";
            PreparedStatement ps3 = getCon().prepareStatement(consulta3);
            ResultSet rs3 = ps3.executeQuery();
            if(rs3 != null){
                while(rs3.next()){
                    d.setPreco(rs3.getString(2));
                    String consulta4 = "select titulo,idcategoria,idclassificacao,capa from filme where idfilme = "
                    + "'"+rs3.getInt(1)+"'";
                    PreparedStatement ps4 = getCon().prepareStatement(consulta4);
                    ResultSet rs4 = ps4.executeQuery();
                        if(rs4 != null){
                            while(rs4.next()){
                                //Funcionario fun = new Funcionario();
                                f.setTitulo(rs4.getString(1));
                                f.setCod_categoria(rs4.getInt(2));
                                f.setCod_classificacao(rs4.getInt(3));
                                f.setCapa(rs4.getString(4));
                                //finalResult = true;
                                //return "Classificação encontrada!";
                            }
                        }
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String Devolver(){
        
            try {
                String consulta = "delete from aluguel where idaluguel = ?";
                
                PreparedStatement ps = getCon().prepareStatement(consulta);
                
                ps.setInt(1, Listar.getCodaluguel());
                
                if(ps.executeUpdate() > 0){
                    try {
                            String consulta2 = "update dvd set situacao = 'Disponível' where iddvd = '"+Listar.getCoddvd()+"'";

                            PreparedStatement ps2 = getCon().prepareStatement(consulta2);

                            if(ps2.executeUpdate() > 0){            
                                return "Devolvido com sucesso!";
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
                            return "Erro na devolução";
                        }
                }
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
                return "Erro na devolução";
            }
            
            return "Erro na devolução";

    }
    
    
    
}
