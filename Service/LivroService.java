package Service;

import DAO.LivroDAO;

public class LivroService {
	private LivroDAO livroDAO;

	public LivroService() {
		this.livroDAO = new LivroDAO();
	}

	public void adicionarLivro(String titulo, int ano_lancamento, int id_autor) {
		livroDAO.adicionarLivro(titulo, ano_lancamento, id_autor);
	}

	public void deletarLivro(int id_livro) {
		livroDAO.deletarLivro(id_livro);
	}

	public void visualizarLivros() {
		livroDAO.visualizarLivros();
	}

	public void pesquisarLivroPorID(int id_livro) {
		livroDAO.pesquisarLivroPorID(id_livro);
	}

	public void atualizarLivro(int id_livro, String titulo, int ano_de_lancamento, int id_autor) {
		livroDAO.atualizarLivro(id_livro, titulo, ano_de_lancamento, id_autor);
	}
}
