package Service;

import DAO.AutorDAO;
import Entities.Autor;

public class AutorService {
	private AutorDAO autorDAO;

	public AutorService() {
		this.autorDAO = new AutorDAO();
	}

	public void adicionarAutor(String nome) {
		autorDAO.adicionarAutor(nome);
	}

	public void adicionarArrayAutores(Autor[] autores) {
		autorDAO.adicionarArrayAutores(autores);
	}

	public void deletarAutor(int id_autor) {
		autorDAO.deletarAutor(id_autor);
	}

	public void visualizarAutores() {
		autorDAO.visualizarAutores();
	}

	public void pesquisarAutorPorID(int id_autor) {
		autorDAO.pesquisarAutorPorID(id_autor);
	}

	public void pesquisarAutoresPorNome(String nome) {
		autorDAO.pesquisarAutoresPorNome(nome);
	}

	public void atualizarAutor(int id_autor, String nome) {
		autorDAO.atualizarAutor(id_autor, nome);
	}
}