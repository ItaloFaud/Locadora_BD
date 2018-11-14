/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Classificacao;
import Modelo.DVD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoope
 */
public class DVDDAO extends ExecuteSQL{
    
    public DVDDAO(Connection con) {
        super(con);
    }
    
    public String Cadastro(DVD d){
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
                String consulta = "insert into dvd values (0,?,?,?,?)";
                PreparedStatement ps = getCon().prepareStatement(consulta);
                
                ps.setInt(1, d.getCod_filme());
                ps.setString(2, d.getPreco());
                ps.setString(3, d.getData_compra());
                ps.setString(4, d.getSituacao());
                
                
                
                if(ps.executeUpdate() > 0){
                 return "Cadastrado!";
                }
            
            
            //if (login != "" && senha != "" && nome != ""){
            
                
                      
            
        } catch (SQLException ex) {
            return ex.getMessage();//+ex.getMessage();
           // Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //return null;
        return null;
        
        
        
    }

    public String Conferir(DVD c){
        try {
            String consulta2 = "select idfilme,preco_compra,data_compra,situacao from dvd "
                    +"where iddvd = '"+c.getCodigo()+"'";
            PreparedStatement ps2 = getCon().prepareStatement(consulta2);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2 != null){
                while(rs2.next()){
                    //Funcionario fun = new Funcionario();
                    c.setCod_filme(rs2.getInt(1));
                    c.setPreco(rs2.getString(2));
                    c.setData_compra(rs2.getString(3));
                    c.setSituacao(rs2.getString(4));
                    //finalResult = true;
                    return "DVD encontrado!";
                }
            }else{
                return "DVD inexistente!";
            }
        } catch (SQLException ex) {
            //Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "DVD inexistente!";
        }
        return "DVD inexistente!";
        
        
    }
    
    public String Alterar(DVD c){
        try {
            String up = "update dvd set"
                    + " idfilme = '"+c.getCod_filme()+"',"
                    + " preco_compra = '"+c.getPreco()+"',"
                    + " data_compra = '"+c.getData_compra()+"',"
                    + " situacao = '"+c.getSituacao()+"'"
                    + " where iddvd = '"+c.getCodigo()+"'";
            PreparedStatement ps = getCon().prepareStatement(up);
            
            if (ps.executeUpdate() > 0) {
                return "Alterado";
            }else{
                return "Não alterado";
            }
            
           
        } catch (SQLException ex) {
            //Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "Já existe DVD com esse nome";
        }
         
        
    }
    
    public List<DVD> Consulta() {
        String consulta = "select iddvd,idfilme,preco_compra,data_compra,situacao from dvd";
            List<DVD> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    DVD c = new DVD();
                    c.setCodigo(rs.getInt(1));
                    c.setCod_filme(rs.getInt(2));
                    c.setPreco(rs.getString(3));
                    c.setData_compra(rs.getString(4));
                    c.setSituacao(rs.getString(5));
                    
                    lista.add(c);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
           // Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public List<DVD> Consulta_Data(String data) {
        String consulta = "select iddvd,idfilme,preco_compra,data_compra,situacao from dvd where data_compra Like '%"+data+"%'";
            List<DVD> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    DVD c = new DVD();
                    c.setCodigo(rs.getInt(1));
                    c.setCod_filme(rs.getInt(2));
                    c.setPreco(rs.getString(3));
                    c.setData_compra(rs.getString(4));
                    c.setSituacao(rs.getString(5));
                    
                    lista.add(c);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
           // Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public List<DVD> Consulta_Cod(int cod) {
        String consulta = "select iddvd,idfilme,preco_compra,data_compra,situacao from dvd where iddvd Like '%"+cod+"%'";
            List<DVD> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    DVD c = new DVD();
                    c.setCodigo(rs.getInt(1));
                    c.setCod_filme(rs.getInt(2));
                    c.setPreco(rs.getString(3));
                    c.setData_compra(rs.getString(4));
                    c.setSituacao(rs.getString(5));
                    lista.add(c);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
           // Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    // OLHAR DEPOIS 
    public List<DVD> ListarComboDVD(){
        try {
            String sql = "select iddvd from dvd";
            List<DVD> lista = new ArrayList<>();
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //                      //
            //      Olhar melhor    //
            //                      //
            if (rs != null) {
                while(rs.next()){
                    DVD c = new DVD();
                    c.setCodigo(rs.getInt(1));
                    lista.add(c);
                    
                }
                return lista;
            }else{
                return null;
            }
        } catch (SQLException ex) {
           // Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
       
    }
    
    public List<DVD> ConsultaCodigoDVD(String data){
        try {
            String consulta = "select iddvd from dvd where data_compra = '"+data+"' ";
            List<DVD> lista = new ArrayList<>();
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    DVD c = new DVD();
                    c.setCodigo(rs.getInt(1));
                    lista.add(c);
                    
                }
                return lista;
                
            }else{
                return null;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        
        }
    }
    
    public String ExcluirDVD(DVD c){
        try {
            String sql = "delete from dvd where iddvd = ?";
            
            PreparedStatement ps = getCon().prepareStatement(sql);
           
            ps.setInt(1, c.getCodigo());
            
            if(ps.executeUpdate() > 0){
                return "Excluído com sucesso";
            }else{
                return "Erro ao excluir";
            }     
        } catch (SQLException ex) {
           // Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
       
    }
    
    
}
