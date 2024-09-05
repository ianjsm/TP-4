package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroDAO {

	public void adicionarLivro(String titulo, int ano_lancamento, int id_autor) {
		String url = "jdbc:mysql://localhost:3306/banco_de_dados_TP4?useSSL=false";
		String username = "root";
		String password = "86779791";

		String insertQuery = "INSERT INTO Livros (titulo, ano_de_lancamento, id_autor) VALUES (?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

			preparedStatement.setString(1, titulo);
			preparedStatement.setInt(2, ano_lancamento);
			preparedStatement.setInt(3, id_autor);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Livro adicionado com sucesso!");
			} else {
				System.out.println("Erro ao adicionar livro");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletarLivro(int id_livro) {
		String url = "jdbc:mysql://localhost:3306/banco_de_dados_TP4?useSSL=false";
		String username = "root";
		String password = "86779791";

		String deleteQuery = "DELETE FROM Livros WHERE id_livro = ?";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

			preparedStatement.setInt(1, id_livro);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Livro deletado com sucesso!");
			} else {
				System.out.println("Erro ao deletar livro");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void visualizarLivros() {
		String url = "jdbc:mysql://localhost:3306/banco_de_dados_TP4?useSSL=false";
		String username = "root";
		String password = "86779791";

		String selectQuery = "SELECT Livros.id_livro, Livros.titulo, Livros.ano_de_lancamento, Autores.nome FROM Livros JOIN Autores ON Livros.id_autor = Autores.id_autor";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				int id_livro = resultSet.getInt("id_livro");
				String titulo = resultSet.getString("titulo");
				int ano_de_lancamento = resultSet.getInt("ano_de_lancamento");
				String nomeAutor = resultSet.getString("nome");
				System.out.println("ID do livro: " + id_livro + ", Título: " + titulo + ", Ano de lançamento: "
						+ ano_de_lancamento + ", Autor: " + nomeAutor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void pesquisarLivroPorID(int id_livro) {
		String url = "jdbc:mysql://localhost:3306/banco_de_dados_TP4?useSSL=false";
		String username = "root";
		String password = "86779791";

		String selectQuery = "SELECT * FROM Livros WHERE id_livro = ?";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

			preparedStatement.setInt(1, id_livro);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id_livro");
					String titulo = resultSet.getString("titulo");
					System.out.println("ID: " + id + ", Título: " + titulo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizarLivro(int id_livro, String titulo, int ano_de_lancamento, int id_autor) {
		String url = "jdbc:mysql://localhost:3306/banco_de_dados_TP4?useSSL=false";
		String username = "root";
		String password = "86779791";

		String updateQuery = "UPDATE Livros SET titulo = ?, ano_de_lancamento = ?, id_autor = ? WHERE id_livro = ?";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

			preparedStatement.setString(1, titulo);
			preparedStatement.setInt(2, ano_de_lancamento);
			preparedStatement.setInt(3, id_autor);
			preparedStatement.setInt(4, id_livro);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Livro atualizado com sucesso!");
			} else {
				System.out.println("Erro ao atualizar livro");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}