/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Auxiliar.Erros;
import Objetos.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asfmegas
 */
public class ClasseTeste {
    private Connection conexao;
    
    public ClasseTeste() {
        this.conexao = Conexao.getConexao();
    }
    
    
    
    //tstar a conexão com o banco
    public static void main(String[] args) {
        ClasseTeste teste = new ClasseTeste();
        teste.testePesquisar();

        //teste.inserir();
    }
    
    public void inserir(){
        String sql = "insert into tbcurso (especificacao,carga_horaria) values(?,?)";
        try (PreparedStatement stmt = conexao.prepareCall(sql)){
            stmt.setString(1, "Ads");
            stmt.setInt(2, 600);
            
            stmt.execute();
           
        } catch (Exception e) {
            Erros.erroSql("Erro ao salvar curso. "+e.getMessage());
        }
        
    }

    public void testePesquisar(){
        AlunoDAO dao = new AlunoDAO();
        List<Aluno> aluno = new ArrayList<>();
        aluno = dao.pesquisarFone(154717);
        if(aluno.size() > 1){
            System.out.println("fone: "+aluno.get(0).getFone());
            System.out.println("fone: "+aluno.get(1).getFone());
        }
    }
}
