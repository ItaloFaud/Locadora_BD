/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
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
public class CategoriaDAO extends ExecuteSQL{

    public CategoriaDAO(Connection con) {
        super(con);
    }
    
    public String Cadastro(Categoria c){
       //String consulta = "select login,senha from funcionario where login = '"+login+"' and senha = '"+senha+"' ";
       
        try {
            
//            String consulta2 = "SELECT `idcategoria`,`nome` FROM `categoria` WHERE nome = '"+c.getNome()+"'";
//            PreparedStatement ps2 = getCon().prepareStatement(consulta2);
//            ResultSet rs2 = ps2.executeQuery();
//            
//            if(rs2 != null){
//                return "Não cadastrado, categorias com informações iguais";
//                
//            }else{
                String consulta = "insert into categoria values (0,?)";
                PreparedStatement ps = getCon().prepareStatement(consulta);
                
                ps.setString(1, c.getNome());
                
                
                
                if(ps.executeUpdate() > 0){
                 return "Cadastrado!";
                }
            
            
            //if (login != "" && senha != "" && nome != ""){
            
                
                      
            
        } catch (SQLException ex) {
            return "Não cadastrada: Nome de categoria já em uso";//+ex.getMessage();
           // Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //return null;
        return null;
        
        
        
    }

    public String Conferir(Categoria c){
        try {
            String consulta2 = "select nome from categoria "
                    +"where idcategoria = '"+c.getCodigo()+"'";
            PreparedStatement ps2 = getCon().prepareStatement(consulta2);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2 != null){
                while(rs2.next()){
                    //Funcionario fun = new Funcionario();
                    c.setNome(rs2.getString(1));
                    
                    //finalResult = true;
                    return "Categoria encontrada!";
                }
            }else{
                return "Categoria inexistente!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public String Alterar(Categoria c){
        try {
            String up = "update categoria set nome = '"+c.getNome()+"'"
                    + "where idcategoria = '"+c.getCodigo()+"'";
            PreparedStatement ps = getCon().prepareStatement(up);
            
            if (ps.executeUpdate() > 0) {
                return "Alterado";
            }else{
                return "Não encontrado";
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
        
    }
    
    public List<Categoria> Consulta() {
        String consulta = "select idcategoria,nome from categoria";
            List<Categoria> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Categoria c = new Categoria();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    
                    lista.add(c);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public List<Categoria> Consulta_Nome(String nome) {
        String consulta = "select idcategoria,nome from categoria where nome Like '%"+nome+"%'";
            List<Categoria> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Categoria c = new Categoria();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    
                    lista.add(c);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public List<Categoria> Consulta_Cod(int cod) {
        String consulta = "select idcategoria,nome from categoria where idcategoria Like '%"+cod+"%'";
            List<Categoria> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Categoria c = new Categoria();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    lista.add(c);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public List<Categoria> ListarComboCategoria(){
        try {
            String sql = "select nome from categoria order by nome";
            List<Categoria> lista = new ArrayList<>();
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Categoria c = new Categoria();
                    c.setNome(rs.getString(1));
                    lista.add(c);
                    
                }
                return lista;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
       
    }
    
    public List<Categoria> ConsultaCodigoCategoria(String nome){
        try {
            String consulta = "select idcategoria from categoria where nome = '"+nome+"' ";
            List<Categoria> lista = new ArrayList<>();
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Categoria c = new Categoria();
                    c.setCodigo(rs.getInt(1));
                    lista.add(c);
                    
                }
                return lista;
                
            }else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        
        }
    }
    
    public String ExcluirCategoria(Categoria c){
        try {
            String sql = "delete from categoria where idcategoria = ? and nome = ? ";
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, c.getCodigo());
            ps.setString(2, c.getNome());
            
            if(ps.executeUpdate() > 0){
                return "Excluído com sucesso";
            }else{
                return "Erro ao excluir";
            }     
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
       
    }
    
    public String PegaCat(int Cod){
        String sql = "select nome from categoria where idcategoria = '"+Cod+"'";
        try {
            
            String categoria;
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    //Categoria c = new Categoria();
                    categoria = rs.getString(1);
                    return categoria;
                }
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
          //  Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    
    
    
}
