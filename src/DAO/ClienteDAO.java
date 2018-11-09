/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Classificacao;
import Modelo.Cliente;
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
public class ClienteDAO extends ExecuteSQL{
    
    public ClienteDAO(Connection con) {
        super(con);
    }
    
    public String Cadastro(Cliente c){
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
                String consulta = "insert into cliente values (0,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = getCon().prepareStatement(consulta);
                
                ps.setString(1, c.getNome());
                ps.setString(2, c.getNascimento());
                ps.setString(3,c.getRg());
                ps.setString(4,c.getCpf());
                ps.setString(5,c.getEmail());
                ps.setString(6,c.getTelefone());
                ps.setString(7,c.getBairro());
                ps.setString(8,c.getRua());
                ps.setInt(9,c.getNumero());
                ps.setString(10,c.getCep());
                
                
                
                if(ps.executeUpdate() > 0){
                 return "Cadastrado!";
                }
            
            
            //if (login != "" && senha != "" && nome != ""){
            
                
                      
            
        } catch (SQLException ex) {
            return "Não cadastrado: CPF de cliente já em uso";//+ex.getMessage();
           // Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //return null;
        return null;
        
        
        
    }

    public String Conferir(Cliente c){
        try {
            String consulta2 = "select nome,data_nasc,rg,cpf,email,telefone,bairro,rua,numero,cep from cliente "
                    +"where idcliente = '"+c.getCodigo()+"'";
            PreparedStatement ps2 = getCon().prepareStatement(consulta2);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2 != null){
                while(rs2.next()){
                    //Funcionario fun = new Funcionario();
                    c.setNome(rs2.getString(1));
                    c.setNascimento(rs2.getString(2));
                    c.setRg(rs2.getString(3));
                    c.setCpf(rs2.getString(4));
                    c.setEmail(rs2.getString(5));
                    c.setTelefone(rs2.getString(6));
                    c.setBairro(rs2.getString(7));
                    c.setRua(rs2.getString(8));
                    c.setNumero(rs2.getInt(9));
                    c.setCep(rs2.getString(10));
                    
                    
                    //finalResult = true;
                    return "Cliente encontrado!";
                }
            }else{
                return "Cliente inexistente!";
            }
        } catch (SQLException ex) {
            //Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro!";
        }
        
        return null;
    }
    
    public String Alterar(Cliente c){
        try {
            String up = "update cliente set "
                    + "nome = '"+c.getNome()+"',"
                    + "data_nasc = '"+c.getNascimento()+"',"
                    + "rg = '"+c.getRg()+"',"
                    + "cpf = '"+c.getCpf()+"',"
                    + "email = '"+c.getEmail()+"',"
                    + "telefone = '"+c.getTelefone()+"',"
                    + "bairro = '"+c.getBairro()+"',"
                    + "rua = '"+c.getRua()+"',"
                    + "numero = '"+c.getNumero()+"',"
                    + "cep = '"+c.getCep()+"'"
                    + " where idcliente = '"+c.getCodigo()+"'";
            PreparedStatement ps = getCon().prepareStatement(up);
            
            if (ps.executeUpdate() > 0) {
                return "Alterado";
            }else{
                return "Não alterado";
            }
            
           
        } catch (SQLException ex) {
            //Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "Já existe um cliente com esse CPF";
        }
         
        
    }
    
    public List<Cliente> Consulta() {
        String consulta = "select idcliente,nome,data_nasc,rg,cpf,email,telefone,bairro,rua,numero,cep from cliente";
            List<Cliente> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Cliente c = new Cliente();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setNascimento(rs.getString(3));
                    c.setRg(rs.getString(4));
                    c.setCpf(rs.getString(5));
                    c.setEmail(rs.getString(6));
                    c.setTelefone(rs.getString(7));
                    c.setBairro(rs.getString(8));
                    c.setRua(rs.getString(9));
                    c.setNumero(rs.getInt(10));
                    c.setCep(rs.getString(11));
                    lista.add(c);
                    
                    //lista.add(c);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
           // Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public List<Cliente> Consulta_Nome(String nome) {
        String consulta = "select idcliente,nome,data_nasc,rg,cpf,email,telefone,bairro,rua,numero,cep from cliente where"
                + " nome Like '%"+nome+"%'";
            List<Cliente> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Cliente c = new Cliente();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setNascimento(rs.getString(3));
                    c.setRg(rs.getString(4));
                    c.setCpf(rs.getString(5));
                    c.setEmail(rs.getString(6));
                    c.setTelefone(rs.getString(7));
                    c.setBairro(rs.getString(8));
                    c.setRua(rs.getString(9));
                    c.setNumero(rs.getInt(10));
                    c.setCep(rs.getString(11));
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
    
    public List<Cliente> Consulta_Cod(int cod) {
        String consulta = "select idcliente,nome,data_nasc,rg,cpf,email,telefone,bairro,rua,numero,cep from cliente where "
                + "idcliente Like '%"+cod+"%'";
            List<Cliente> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Cliente c = new Cliente();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setNascimento(rs.getString(3));
                    c.setRg(rs.getString(4));
                    c.setCpf(rs.getString(5));
                    c.setEmail(rs.getString(6));
                    c.setTelefone(rs.getString(7));
                    c.setBairro(rs.getString(8));
                    c.setRua(rs.getString(9));
                    c.setNumero(rs.getInt(10));
                    c.setCep(rs.getString(11));
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
    
    public List<Cliente> ListarComboCliente(){
        try {
            String sql = "select nome from cliente order by nome";
            List<Cliente> lista = new ArrayList<>();
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Cliente c = new Cliente();
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
    
    public List<Cliente> ConsultaCodigoCliente(String nome){
        try {
            String consulta = "select idcliente from cliente where nome = '"+nome+"' ";
            List<Cliente> lista = new ArrayList<>();
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Cliente c = new Cliente();
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
    
    public String ExcluirCliente(Cliente c){
        try {
            String sql = "delete from cliente where idcliente = ? and nome = ? ";
            
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
