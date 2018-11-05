package DAO;

import java.sql.*;


import Modelo.Funcionario;
import Visao.Cadastrar.CadastrarFuncionario;
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
       String consulta = "insert into funcionario values (0,?,?,?)";
        try {
            
            String consulta2 = "select login,senha from funcionario "
                    +"where login = '"+f.getLogin()+"' and senha = '"+f.getSenha()+"'";
            PreparedStatement ps2 = getCon().prepareStatement(consulta2);
            ResultSet rs2 = ps2.executeQuery();
            
            if(rs2 != null){
                return "Não cadastrado, funcionario com informações iguais";
                
            }else{
                PreparedStatement ps = getCon().prepareStatement(consulta);
                
                ps.setString(1, f.getNome());
                ps.setString(2, f.getLogin());
                ps.setString(3, f.getSenha());
                
                if(ps.executeUpdate() > 0){
                 return "Cadastrado!";
                }
            }
            
            //if (login != "" && senha != "" && nome != ""){
            
                
                      
            
        } catch (SQLException ex) {
            return "Não cadastrado:"+ex.getMessage();
           // Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //return null;
        return null;
        
        
        
    }    
    
    
    
    
    
}
