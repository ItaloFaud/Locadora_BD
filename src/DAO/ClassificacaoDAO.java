/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import Modelo.Classificacao;
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
public class ClassificacaoDAO extends ExecuteSQL{
    
    public ClassificacaoDAO(Connection con){
        super(con);
    }
    
    public String Cadastro(Classificacao c){
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
                String consulta = "insert into classificacao values (0,?,?)";
                PreparedStatement ps = getCon().prepareStatement(consulta);
                
                ps.setString(1, c.getNome());
                ps.setDouble(2, c.getPreco());
                
                
                
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

    public String Conferir(Classificacao c){
        try {
            String consulta2 = "select nome,preco from classificacao "
                    +"where idclassificacao = '"+c.getCodigo()+"'";
            PreparedStatement ps2 = getCon().prepareStatement(consulta2);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2 != null){
                while(rs2.next()){
                    //Funcionario fun = new Funcionario();
                    c.setNome(rs2.getString(1));
                    c.setPreco(rs2.getDouble(2));
                    //finalResult = true;
                    return "Classificação encontrada!";
                }
            }else{
                return "Classificação inexistente!";
            }
        } catch (SQLException ex) {
            //Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public String Alterar(Classificacao c){
        try {
            String up = "update classificacao set nome = '"+c.getNome()+"', preco = '"+c.getPreco()+"' where"
                    + " idclassificacao = '"+c.getCodigo()+"'";
            PreparedStatement ps = getCon().prepareStatement(up);
            
            if (ps.executeUpdate() > 0) {
                return "Alterado";
            }else{
                return "Não encontrado";
            }
            
           
        } catch (SQLException ex) {
            //Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "Já existe classificacao com esse nome";
        }
         
        
    }
    
    public List<Classificacao> Consulta() {
        String consulta = "select idclassificacao,nome,preco from classificacao";
            List<Classificacao> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Classificacao c = new Classificacao();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setPreco(rs.getDouble(3));
                    
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
    
    public List<Classificacao> Consulta_Nome(String nome) {
        String consulta = "select idclassificacao,nome,preco from classificacao where nome Like '%"+nome+"%'";
            List<Classificacao> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Classificacao c = new Classificacao();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setPreco(rs.getDouble(3));
                    
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
    
    public List<Classificacao> Consulta_Cod(int cod) {
        String consulta = "select idclassificacao,nome,preco from classificacao where idclassificacao Like '%"+cod+"%'";
            List<Classificacao> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Classificacao c = new Classificacao();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setPreco(rs.getDouble(3));
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
    
    public List<Classificacao> ListarComboClassificacao(){
        try {
            String sql = "select nome from classificacao order by nome";
            List<Classificacao> lista = new ArrayList<>();
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Classificacao c = new Classificacao();
                    c.setNome(rs.getString(1));
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
    
    public List<Classificacao> ConsultaCodigoClassificacao(String nome){
        try {
            String consulta = "select idclassificacao from classificacao where nome = '"+nome+"' ";
            List<Classificacao> lista = new ArrayList<>();
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Classificacao c = new Classificacao();
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
    
    public String ExcluirClassificacao(Classificacao c){
        try {
            String sql = "delete from classificacao where idclassificacao = ? and nome = ? ";
            
            PreparedStatement ps = getCon().prepareStatement(sql);
           
            ps.setInt(1, c.getCodigo());
            ps.setString(2, c.getNome());
            
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
