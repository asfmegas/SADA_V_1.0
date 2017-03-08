/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Auxiliar.Erros;
import Objetos.Disciplina;
import Objetos.Movimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author asfmegas
 */
public class MovimentoDAO {
    private Connection conexao;

    public MovimentoDAO() {
        this.conexao = Conexao.getConexao();
    }
    
    public void salvar(Movimento mov){
        String sql = "insert into tbmovimento (idcur,iddisc,idalu) values (?,?,?)";
        int x = 0;
        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(++x, mov.getIdCurso());
            stmt.setInt(++x,mov.getIdDisc());
            stmt.setInt(++x, mov.getId());         
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Movimento salvo com sucesso!");
        }catch(SQLException e){
            Erros.erroSql("Erro ao salvar movimento\n"+e.getMessage());
        }
    }
    
    public List<Disciplina> pesquisarCurDisc(String curso){
        String sql = "select d.iddisc,d.especificacao,c.idcur,c.especificacao" +
                        " from tbcurdisc as cd,tbdisciplina as d,tbcurso as c" +
                        " where cd.idcur = c.idcur and cd.iddisc = d.iddisc and c.especificacao like ?";
        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, curso);
            ResultSet rs = stmt.executeQuery();
            List<Disciplina> listaDisc = new ArrayList<>();
            
            while(rs.next()){
                Disciplina dadosDisc = new Disciplina();
                dadosDisc.setIdDisc(rs.getInt(1));
                dadosDisc.setNome(rs.getString(2));
                dadosDisc.setId(rs.getInt(3));
                dadosDisc.setCurso(rs.getString(4));
                
                listaDisc.add(dadosDisc);
            }
            rs.close();
            return listaDisc;
             
        }catch(SQLException e){
            Erros.erroSql("Erro ao pesquisar por curso\n"+e.getMessage());
        }
        return null;
    }
    
    public List<Movimento> pesquisar(String campo, String nome){
        String sql = "select m.idmov,a.idalu,a.nome,a.nasc,c.idcur,c.especificacao,d.iddisc,d.especificacao,m.nota1,m.nota2,m.nota3,m.falta" +
            " from tbmovimento as m,tbaluno as a,tbcurso as c,tbdisciplina as d" +
            " where m.idalu = a.idalu and m.idcur = c.idcur and m.iddisc = d.iddisc and "+campo+" like ?";
        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, nome);
            
            List<Movimento> listaMov = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            int x = 0;
            while(rs.next()){
                Movimento mov = new Movimento();
                mov.setIdMov(rs.getInt(++x));
                mov.setId(rs.getInt(++x));
                mov.setNome(rs.getString(++x));
                mov.setData(rs.getString(++x));
                mov.setIdCurso(rs.getInt(++x));
                mov.setNomeCurso(rs.getString(++x));
                mov.setIdDisc(rs.getInt(++x));
                mov.setNomeDisc(rs.getString(++x));
                mov.setNota1(rs.getDouble(++x));
                mov.setNota2(rs.getDouble(++x));
                mov.setNota3(rs.getDouble(++x));
                mov.setFaltas(rs.getInt(++x));
                
                listaMov.add(mov);
                x = 0; 
            }
            rs.close();
            return listaMov;
        }catch(SQLException e){
            Erros.erroSql("Erro ao buscar dados\n "+e.getMessage());
        }
        return null;
    }
    
    public void alterar(Movimento mov){
        String sql = "update tbmovimento set nota1=?,nota2=?,nota3=?,falta=? where idmov=?";
        int x = 0;
        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setDouble(++x, mov.getNota1());
            stmt.setDouble(++x, mov.getNota2());
            stmt.setDouble(++x, mov.getNota3());
            stmt.setInt(++x, mov.getFaltas());
            stmt.setInt(++x, mov.getIdMov());
            
            stmt.execute();
        }catch(SQLException e){
            Erros.erroSql("Erro ao tentar alterar dados\n"+e.getMessage());
        }
    }
    
    public void excluir(int id){
        String sql = "delete from tbmovimento where idmov=?";
        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Movimento excluido com sucesso!");
        }catch(SQLException e){
            Erros.erroSql("Erro ao tentar excluir dados.\n"+e.getMessage());
        }
    }
}
