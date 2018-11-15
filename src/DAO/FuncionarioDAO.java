package DAO;

import java.sql.*;


import Modelo.Funcionario;
import Visao.Cadastrar.CadastrarFuncionario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO extends ExecuteSQL{
    
    public FuncionarioDAO(Connection con){
        super(con);
    }
    
    public boolean Logar(String login, String senha){
        boolean finalResult = false;
        try{
            String consulta = "select login,senha from funcionario "
                    +"where login = '"+login+"' and senha = '"+senha+"'";
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Funcionario fun = new Funcionario();
                    fun.setLogin(rs.getString(1));
                    fun.setSenha(rs.getString(2));
                    finalResult = true;
                }
            }
                    
            
        }catch(SQLException ex){
            ex.getMessage();
        }
        return finalResult;
    }
    
    public String Cadastro(Funcionario f){
       //String consulta = "select login,senha from funcionario where login = '"+login+"' and senha = '"+senha+"' ";
       String nome = f.getNome();
       String login = f.getLogin();
        try {
            
//            String consulta2 = "select login,nome from funcionario where "
//                    + "login = '"+login+"' and nome = '"+nome+"' ";
//            PreparedStatement ps2 = getCon().prepareStatement(consulta2);
//            ResultSet rs2 = ps2.executeQuery();
//            
//            if(rs2 != null){
//                while(rs2.next()){
//                    return "Não cadastrado, funcionario com informações iguais";
//                }
//                
//            }else{
                
                String consulta = "insert into funcionario values (0,?,?,?)";
                PreparedStatement ps = getCon().prepareStatement(consulta);
                
                ps.setString(1, f.getNome());
                ps.setString(2, f.getLogin());
                ps.setString(3, f.getSenha());
                
                if(ps.executeUpdate() > 0){
                 return "Cadastrado!";
                }else{
                    return "Não cadastrado";
                }
                
                
                
            
            
            //if (login != "" && senha != "" && nome != ""){
            
                
                      
            
        } catch (SQLException ex) {
            return "Não cadastrado: Login já usado por outro funcionário!";//+ex.getMessage();
           // Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //return null;
        
        
        
        
    }

    public String Conferir(Funcionario f){
        try {
            String consulta2 = "select nome,login,senha from funcionario "
                    +"where idfuncionario = '"+f.getCod()+"'";
            PreparedStatement ps2 = getCon().prepareStatement(consulta2);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2 != null){
                while(rs2.next()){
                    //Funcionario fun = new Funcionario();
                    f.setNome(rs2.getString(1));
                    f.setLogin(rs2.getString(2));
                    f.setSenha(rs2.getString(3));
                    //finalResult = true;
                    return "Funcionário encontrado!";
                }
            }else{
                return "Funcionário inexixtente!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Funcionário inexixtente!";
    }
    
    public String Alterar(Funcionario f){
        try {
            String up = "update funcionario set nome = '"+f.getNome()+"', login = '"+f.getLogin()+"',"
                    + " senha = '"+f.getSenha()+"' where idfuncionario = '"+f.getCod()+"'";
            PreparedStatement ps = getCon().prepareStatement(up);
            
            if (ps.executeUpdate() > 0) {
                return "Alterado";
            }else{
                return "Não encontrado";
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
        
    }
    
    public List<Funcionario> Consulta() {
        String consulta = "select idfuncionario,nome,login,senha from funcionario";
            List<Funcionario> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Funcionario f = new Funcionario();
                    f.setCod(rs.getInt(1));
                    f.setNome(rs.getString(2));
                    f.setLogin(rs.getString(3));
                    f.setSenha(rs.getString(4));
                    lista.add(f);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public List<Funcionario> Consulta_Nome(String nome) {
        String consulta = "select idfuncionario,nome,login,senha from funcionario where nome Like '%"+nome+"%'";
            List<Funcionario> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Funcionario f = new Funcionario();
                    f.setCod(rs.getInt(1));
                    f.setNome(rs.getString(2));
                    f.setLogin(rs.getString(3));
                    f.setSenha(rs.getString(4));
                    lista.add(f);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public List<Funcionario> Consulta_Cod(int cod) {
        String consulta = "select idfuncionario,nome,login,senha from funcionario where idfuncionario Like '%"+cod+"%'";
            List<Funcionario> lista = new ArrayList<>();
        try {
            
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Funcionario f = new Funcionario();
                    f.setCod(rs.getInt(1));
                    f.setNome(rs.getString(2));
                    f.setLogin(rs.getString(3));
                    f.setSenha(rs.getString(4));
                    lista.add(f);
                }return lista;
            }else{
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public List<Funcionario> ListarComboFuncionario(){
        try {
            String sql = "select nome from funcionario order by nome";
            List<Funcionario> lista = new ArrayList<>();
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    Funcionario f = new Funcionario();
                    f.setNome(rs.getString(1));
                    lista.add(f);
                    
                }
                return lista;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
       
    }
    
    public List<Funcionario> ConsultaCodigoFuncionario(String nome){
        try {
            String consulta = "select idfuncionario from funcionario where nome = '"+nome+"' ";
            List<Funcionario> lista = new ArrayList<>();
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while (rs.next()) {                    
                    Funcionario f = new Funcionario();
                    f.setCod(rs.getInt(1));
                    lista.add(f);
                    
                }
                return lista;
                
            }else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        
        }
    }
    
    public String ExcluirFuncionario(Funcionario f){
        try {
            String sql = "delete from funcionario where idfuncionario = ? and nome = ? ";
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, f.getCod());
            ps.setString(2, f.getNome());
            
            if(ps.executeUpdate() > 0){
                return "Excluído com sucesso";
            }else{
                return "Erro ao excluir";
            }     
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro ao excluir funcionário! \n"
                    + "(Há tabelas que usam dados deste funcionário)";
        }
       
    }
        
  
    
}
