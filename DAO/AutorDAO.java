package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Autor;

public class AutorDAO {

	public void adicionarAutor(String nome) {
		String url = "jdbc:mysql://localhost:3306/banco_de_dados_TP4?useSSL=false";
		String username = "root";
		String password = "86779791";

		String insertQuery = "INSERT INTO Autores (nome) VALUES (?)";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

			preparedStatement.setString(1, nome);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Autor adicionado com sucesso!");
			} else {
				System.out.println("Erro ao adicionar autor");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void adicionarArrayAutores(Autor[] autores) {
		String url = "jdbc:mysql://localhost:3306/banco_de_dados_TP4?useSSL=false";
		String username = "root";
		String password = "86779791";

		String insertQuery = "INSERT INTO Autores (nome) VALUES (?)";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

			for (Autor autor : autores) {
				preparedStatement.setString(1, autor.getNome());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletarAutor(int id_autor) {
		String url = "jdbc:mysql://localhost:3306/banco_de_dados_TP4?useSSL=false";
		String username = "root";
		String password = "86779791";

		String deleteQuery = "DELETE FROM Autores WHERE id_autor = ?";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

			preparedStatement.setInt(1, id_autor);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Autor deletado com sucesso!");
			} else {
				System.out.println("Erro ao deletar autor");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void visualizarAutores() {
		String url = "jdbc:mysql://localhost:3306/banco_de_dados_TP4?useSSL=false";
		String username = "root";
		String password = "86779791";

		String selectQuery = "SELECT * FROM Autores";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				int id_autor = resultSet.getInt("id_autor");
				String nome = resultSet.getString("nome");
				System.out.println("ID: " + id_autor + ", Nome: " + nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void pesquisarAutorPorID(int id_autor) {
		String url = "jdbc:mysql://localhost:3306/banco_de_dados_TP4?useSSL=false";
		String username = "root";
		String password = "86779791";

		String selectQuery = "SELECT * FROM Autores WHERE id_autor = ?";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

			preparedStatement.setInt(1, id_autor);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id_autor");
					String nome = resultSet.getString("nome");
					System.out.println("ID: " + id + ", Nome: " + nome);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void pesquisarAutoresPorNome(String nome) {
		String url = "jdbc:mysql://localhost:3306/banco_de_dados_TP4?useSSL=false";
		String username = "root";
		String password = "86779791";

		String selectQuery = "SELECT * FROM Autores WHERE nome LIKE ?";
		List<Autor> autores = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

			preparedStatement.setString(1, "%" + nome + "%");

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					Autor autor = new Autor(resultSet.getString("nome"));
					autores.add(autor);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (Autor autor : autores) {
			System.out.println(autor.getNome());
		}
	}

	public void atualizarAutor(int id_autor, String nome) {
		String url = "jdbc:mysql://localhost:3306/banco_de_dados_TP4?useSSL=false";
		String username = "root";
		String password = "86779791";

		String updateQuery = "UPDATE Autores SET nome = ? WHERE id_autor = ?";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

			preparedStatement.setString(1, nome);
			preparedStatement.setInt(2, id_autor);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Autor atualizado com sucesso!");
			} else {
				System.out.println("Erro ao atualizar autor");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}