/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Classificacao;
import Modelo.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoope
 */
public class FilmeDAO extends ExecuteSQL{
    
    public FilmeDAO(Connection con) {
        super(con);
    }
    
    public String Cadastro(Filme f){
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
                String consulta = "insert into filme values (0,?,?,?,?,?,?)";
                PreparedStatement ps = getCon().prepareStatement(consulta);
                
                ps.setString(1, f.getTitulo());
                ps.setInt(2, f.getAno());
                ps.setString(3,f.getDuracao());
                ps.setInt(4,f.getCod_categoria());
                ps.setInt(5,f.getCod_classificacao());
                ps.setString(6,f.getCapa());
                
                
                
                
                if(ps.executeUpdate() > 0){
                 return "Cadastrado!";
                }
            
            
            //if (login != "" && senha != "" && nome != ""){
            
                
                      
            
        } catch (SQLException ex) {
            return "Não cadastrado: Nome de filme já em uso";//+ex.getMessage();
           // Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //return null;
        return null;
        
        
        
    }

    public String Conferir(Filme c){
        try {
            String consulta2 = "select titulo,ano,duracao,idcategoria,idclassificacao,capa from filme "
                    +"where idfilme = '"+c.getCodigo()+"'";
            PreparedStatement ps2 = getCon().prepareStatement(consulta2);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2 != null){
                while(rs2.next()){
                    
                    c.setTitulo(rs2.getString(1));
                    c.setAno(rs2.getInt(2));
                    c.setDuracao(rs2.getString(3));
                    c.setCod_categoria(rs2.getInt(4));
                    c.setCod_classificacao(rs2.getInt(5));
                    c.setCapa(rs2.getString(6));
                    //finalResult = true;
                    return "Filme encontrado!";
                }
            }else{
                return "Filme inexistente!";
            }
        } catch (SQLException ex) {
            //Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Filme inexistente!";
    }
    
    public String Alterar(Filme c){
        try {
            String up = "update filme set"
                    + " titulo = '"+c.getTitulo()+"',"
                    + " ano = '"+c.getAno()+"',"
                    + " duracao = '"+c.getDuracao()+"',"
                    + " idcategoria = '"+c.getCod_categoria()+"',"
                    + " idclassificacao = '"+c.getCod_classificacao()+"',"
                    + " capa = '"+c.getCapa()+"'"
                    + " where idfilme = '"+c.getCodigo()+"'";
            PreparedStatement ps = getCon().prepareStatement(up);
            
            if (ps.executeUpdate() > 0) {
                return "Alterado";
            }else{
                return "Não encontrado";
            }
            
           
        } catch (SQLException ex) {
            //Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "Já existe filme com esse nome";
        }
         
        
    }
    
        public List<Filme> Consulta() {
        String consulta = "select idfilme,titulo,ano,duracao,idcategoria,idclassificacao,capa from filme";
            List<Filme> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Filme f = new Filme();
                    f.setCodigo(rs.getInt(1));
                    f.setTitulo(rs.getString(2));
                    f.setAno(rs.getInt(3));
                    f.setDuracao(rs.getString(4));
                    f.setCod_categoria(rs.getInt(5));
                    f.setCod_classificacao(rs.getInt(6));
                    f.setCapa(rs.getString(7));
                    
                    lista.add(f);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
           // Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public List<Filme> Consulta_Nome(String nome) {
        String consulta = "select idfilme,titulo,ano,duracao,idcategoria,idclassificacao,capa from filme where titulo Like '%"+nome+"%'";
            List<Filme> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {
                    Filme f = new Filme();
                    f.setCodigo(rs.getInt(1));
                    f.setTitulo(rs.getString(2));
                    f.setAno(rs.getInt(3));
                    f.setDuracao(rs.getString(4));
                    f.setCod_categoria(rs.getInt(5));
                    f.setCod_classificacao(rs.getInt(6));
                    f.setCapa(rs.getString(7));
                    
                    lista.add(f);     
                   
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
           // Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public List<Filme> Consulta_Cod(int cod) {
        String consulta = "select idfilme,titulo,ano,duracao,idcategoria,idclassificacao,capa from filme where idfilme Like '%"+cod+"%'";
            List<Filme> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Filme f = new Filme();
                    f.setCodigo(rs.getInt(1));
                    f.setTitulo(rs.getString(2));
                    f.setAno(rs.getInt(3));
                    f.setDuracao(rs.getString(4));
                    f.setCod_categoria(rs.getInt(5));
                    f.setCod_classificacao(rs.getInt(6));
                    f.setCapa(rs.getString(7));
                    
                    lista.add(f);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
           // Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public List<Filme> ListarComboFilme(){
        try {
            String sql = "select titulo from filme order by titulo";
            List<Filme> lista = new ArrayList<>();
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Filme f = new Filme();
                    f.setTitulo(rs.getString(1));
                    lista.add(f);
                    
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
    
    public List<Filme> ConsultaCodigoFilme(String nome){
        try {
            String consulta = "select idfilme,capa from filme where titulo = '"+nome+"' ";
            List<Filme> lista = new ArrayList<>();
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Filme c = new Filme();
                    c.setCodigo(rs.getInt(1));
                    c.setCapa(rs.getString(2));
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
    
    public String ExcluirFilme(Filme c){
        try {
            String sql = "delete from filme where idfilme = ? and titulo = ? ";
            
            PreparedStatement ps = getCon().prepareStatement(sql);
           
            ps.setInt(1, c.getCodigo());
            ps.setString(2, c.getTitulo());
            
            if(ps.executeUpdate() > 0){
                return "Excluído com sucesso";
            }else{
                return "Erro ao excluir";
            }     
        } catch (SQLException ex) {
           // Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "Filme não pode ser excluído! \n"
                    + "(Há tabelas que usam dados deste Filme)";
        }
       
    }
    
    public String PegaNome(int cod){
        String con = "select titulo from filme where idfilme = '"+cod+"'";
         try {
            
            String classificacao;
            PreparedStatement ps = getCon().prepareStatement(con);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    //Categoria c = new Categoria();
                    classificacao = rs.getString(1);
                    return classificacao;
                }
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
           // Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    
}
