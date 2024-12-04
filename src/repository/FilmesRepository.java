package repository;

import config.DbConnectionFilmes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Filmes;

public class FilmesRepository {

// criar um novo filmes
    public void adicionarFilmes(Filmes filmes) {
        String sql = "INSERT INTO filmes (filmeTitulo, filmeDesc, filmeDuracao, filmeAno, filmeClas, catId) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConnectionFilmes.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, filmes.getFilmeTitulo());
                stmt.setString(2, filmes.getFilmeDesc());
                stmt.setInt(3, filmes.getFilmeDuracao());
                stmt.setInt(4, filmes.getFilmeAno());
                stmt.setInt(5, filmes.getFilmeClas());
                stmt.setInt(6, filmes.getCatId());

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Filme adicionado com sucesso!");
                }

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar filme.");
            e.printStackTrace();
        }
    }


// Obter todos os filmes:
    public List<Filmes> obterTodosFilmess() {
        List<Filmes> filme = new ArrayList<>();
        String sql = "SELECT * FROM filmes";

        try (Connection conn = DbConnectionFilmes.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Filmes filmes = new Filmes(
                        rs.getInt("filmeId"),
                        rs.getString("filmeTitulo"),
                        rs.getString("filmeDesc"),
                        rs.getInt("filmeDuracao"),
                        rs.getInt("filmeAno"),
                        rs.getInt("filmeClas"),
                        rs.getInt("catId")
                    );
                filmes.add(filmes);
                }

        } catch (SQLException e) {
            System.out.println("Erro ao obter filmes.");
            e.printStackTrace();
        }
        return filme;
    }


// Obter filmes por filmesId
    public Filmes obterFilmesPorId(int filmesId) {
        String sql = "SELECT * FROM contatos WHERE filmesId = ?";
        Filmes filmes = null;

        try (Connection conn = DbConnectionFilmes.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, filmesId);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    filmes = new Filmes(
                        rs.getInt("filmesId"),
                        rs.getString("filmeTitulo"),
                        rs.getString("filmeDesc"),
                        rs.getInt("filmeDuracao"),
                        rs.getInt("filmeAno"),
                        rs.getInt("filmeClas"),
                        rs.getInt("catId")
                    );
                }

        } catch (SQLException e) {
            System.out.println("Erro ao obter filmes por filmesId.");
            e.printStackTrace();
        }
        return filmes;
    }


// Atualizar um filmes
    public void atualizarFilmes(Filmes filmes) {
        String sql = "UPDATE contatos SET nome = ?, email = ?, telefone = ? WHERE filmesId = ?";

        try (Connection conn = DbConnectionFilmes.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, filmes.getFilmeTitulo());
                stmt.setString(2, filmes.getFilmeDesc());
                stmt.setInt(3, filmes.getFilmeDuracao());
                stmt.setInt(4, filmes.getFilmeAno());
                stmt.setInt(5, filmes.getFilmeClas());
                stmt.setInt(6, filmes.getCatId());
                stmt.setInt(7, filmes.getFilmeId());

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Filmes atualizado com sucesso!");
                } else {
                    System.out.println("Filme não encontrado.");
                }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar filme.");
            e.printStackTrace();
        }
    }


// Deletar um filmes
    public void deletarFilmes(int filmesId) {
        String sql = "DELETE FROM filmes WHERE filmesId = ?";

        try (Connection conn = DbConnectionFilmes.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                int filmeId;
                stmt.setInt(1, filmeId);

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Filme deletado com sucesso!");
                } else {
                    System.out.println("Filme não encontrado.");
                }

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar filmes.");
            e.printStackTrace();
        }
    }
}
