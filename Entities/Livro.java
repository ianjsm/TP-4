package Entities;

public class Livro {

	private int id_livro;
	private String titulo;
	private int ano_lancamento;
	private int id_autor;

	public Livro(int id_livro, String titulo, int ano_lancamento, int id_autor) {
		this.id_livro = id_livro;
		this.titulo = titulo;
		this.ano_lancamento = ano_lancamento;
		this.id_autor = id_autor;
	}

	public int getId_livro() {
		return id_livro;
	}

	public void setId_livro(int id_livro) {
		this.id_livro = id_livro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno_lancamento() {
		return ano_lancamento;
	}

	public void setAno_lancamento(int ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	@Override
	public String toString() {
		return "Livro: " + titulo + ", Ano de lançamento=" + ano_lancamento;
	}
}