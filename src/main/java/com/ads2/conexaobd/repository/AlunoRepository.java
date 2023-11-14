package com.ads2.conexaobd.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ads2.conexaobd.config.Conexao;
import com.ads2.conexaobd.model.Aluno;

@Repository
public class AlunoRepository {

    public void inserir(Aluno aluno) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        String query = "INSERT INTO aluno(id, nome, matricula) VALUES(NEXTVAL('ALUNO_ID_SEQ'),?,?)";

        PreparedStatement pstm;

        try {
            pstm = conn.prepareStatement(query);

            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getMatricula());

            pstm.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            conexao.desconectar(conn);
        }

    }

    public List<Aluno> buscar() throws SQLException {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        List<Aluno> alunos = new ArrayList<>();

        String consulta = "SELECT * FROM ALUNO";

        Statement stm = conn.createStatement();
        ResultSet resultado = stm.executeQuery(consulta);

        try {
            while (resultado.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(resultado.getInt("id"));
                aluno.setNome(resultado.getString("nome"));
                aluno.setMatricula(resultado.getString("matricula"));
                alunos.add(aluno);
            }

        } catch (SQLException e) {
            System.out.println("nao conseguiu a tabela aluno");
            
        } finally {
            conexao.desconectar(conn);
        }
        return alunos;
    }

    public void excluir(int id) throws SQLException {
            Conexao conexao = new Conexao();
            Connection conn = conexao.conectar();

            String consulta = "DELETE FROM ALUNO WHERE ID = ?";

            PreparedStatement pstm;
            pstm = conn.prepareStatement(consulta);

            pstm.setInt(1, id);
            pstm.execute();

            try{

            }catch (Exception e) {
                System.out.println("nao conseguiu excluir a tabela aluno");
            } finally {
                conexao.desconectar(conn);
            }

    }

}
