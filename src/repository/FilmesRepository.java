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

        try (Connection conn = DbConnectionFilmes.getConnection(); //uma tentativa de conectar com o banco de dados para que possa ser adicionado as seguintes informações nos campos adequados.
            PreparedStatement stmt = conn.prepareStatement(sql)) {//campos para ser adicionadas as informações:

                stmt.setString(1, filmes.getFilmeTitulo());
                stmt.setString(2, filmes.getFilmeDesc());
                stmt.setString(3, filmes.getFilmeDuracao());
                stmt.setInt(4, filmes.getFilmeAno());
                stmt.setString(5, filmes.getFilmeClas());
                stmt.setInt(6, filmes.getCatId());

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) { //caso as informações tenham sido adicionadas corretamente aparecerá a seguinte mensagem:
                    System.out.println("Filme adicionado com sucesso!");
                }

        } catch (SQLException e) { // caso tenha dado algum erro ao adicionar aparecerá a mesagem:
            System.out.println("Erro ao adicionar filme.");
            e.printStackTrace();
        }
    }


// Obter todos os filmes:
    public List<Filmes> obterTodosFilmess() { // uma lista de todos os filmes que já foram inseridos
        List<Filmes> filme = new ArrayList<>();
        String sql = "SELECT * FROM filmes";

        try (Connection conn = DbConnectionFilmes.getConnection(); // verifica se os filmes estão conectados (salvos) no banco de dados para trazer a lista deles
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) { 
                    Filmes filmes = new Filmes(
                        rs.getInt("filmeId"),
                        rs.getString("filmeTitulo"),
                        rs.getString("filmeDesc"),
                        rs.getString("filmeDuracao"),
                        rs.getInt("filmeAno"),
                        rs.getString("filmeClas"),
                        rs.getInt("catId")
                    );
                filmes.add(filmes);
                }

        } catch (SQLException e) { // caso acontece um erro ao obter a lista
            System.out.println("Erro ao obter filmes.");
            e.printStackTrace();
        }
        return filme;
    }


// Obter filmes por filmesId
    public Filmes obterFilmesPorId(int filmesId) { // traz um filme buscando por seu id
        String sql = "SELECT * FROM contatos WHERE filmesId = ?";
        Filmes filmes = null;

        try (Connection conn = DbConnectionFilmes.getConnection(); // verifica se o filme do id selecionado está conectado com o bd para trazer ele
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, filmesId);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    filmes = new Filmes(
                        rs.getInt("filmesId"),
                        rs.getString("filmeTitulo"),
                        rs.getString("filmeDesc"),
                        rs.getString("filmeDuracao"),
                        rs.getInt("filmeAno"),
                        rs.getString("filmeClas"),
                        rs.getInt("catId")
                    );
                }

        } catch (SQLException e) { // caso dê um erro ao executar a função acima
            System.out.println("Erro ao obter filmes por filmesId.");
            e.printStackTrace();
        }
        return filmes;
    }


// Atualizar um filmes
    public void atualizarFilmes(Filmes filmes) { // função para atualizar um filme selecionado
        String sql = "UPDATE contatos SET filmeTitulo = ?, filmeDesc= ?, filmeDuracao = ?, filmeAno = ?, filmeClas = ?, catId = ?";

        try (Connection conn = DbConnectionFilmes.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) { // verificação para conferir se o filme selecionado está conectado (salvo) com o banco de dados para que seja possível atualizar ele

                stmt.setString(1, filmes.getFilmeTitulo());
                stmt.setString(2, filmes.getFilmeDesc());
                stmt.setString(3, filmes.getFilmeDuracao());
                stmt.setInt(4, filmes.getFilmeAno());
                stmt.setString(5, filmes.getFilmeClas());
                stmt.setInt(6, filmes.getCatId());
                stmt.setInt(7, filmes.getFilmeId());

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) { // caso a atualização tenha sido feita corretamente aparecerá a seguinte mensagem:
                    System.out.println("Filmes atualizado com sucesso!");
                } else { // caso o filme selecionado não tenha sido encontrado no banco de dados enviará a mensagem:
                    System.out.println("Filme não encontrado.");
                }

        } catch (SQLException e) { // caso o filme não tenha sido atualizado corretamente:
            System.out.println("Erro ao atualizar filme.");
            e.printStackTrace();
        }
    }


// Deletar um filmes
    public void deletarFilmes(int filmesId) { //  função para deletar um filme selecionado
        String sql = "DELETE FROM filmes WHERE filmesId = ?";

        try (Connection conn = DbConnectionFilmes.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) { // verifica se o filme selecionado está conectado com o banco de dados para que seja possível deletar ele.

                stmt.setInt(1, filmesId);

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) { // caso a função deletar tenha sido bem sucedida
                    System.out.println("Filme deletado com sucesso!");
                } else {
                    System.out.println("Filme não encontrado."); // caso o filme slecionado não tenha sido encontrado seu id no banco de dados
                }

        } catch (SQLException e) { // caso a função de deletar o filme selecionado não tenha ocorrido conforme o esperado:
            System.out.println("Erro ao deletar filmes.");
            e.printStackTrace();
        }
    }
}
