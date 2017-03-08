/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Auxiliar.Erros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author asfmegas
 */
public class LoginDAO {
    private Connection conexao;

    public LoginDAO() {
        this.conexao = Conexao.getConexao();
    }

    public boolean autenticar(String user, String password){
        String sql = "select id_login, user, pwd from login where user=? and pwd=?";
        boolean toReturn = false;
        
        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, user);
            stmt.setString(2, password);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
                toReturn = true;
            rs.close();
        }catch(SQLException e){
            Erros.erroSql("Erro ao listar login\n"+e.getMessage());
        }
        return toReturn;
    }
}
