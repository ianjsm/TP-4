package Entities;

public class Autor {
	private int id_autor;
	private String nome;

	public Autor(String nome) {
		super();
		this.nome = nome;
	}

	public Autor(int id_autor, String nome) {
		this.id_autor = id_autor;
		this.nome = nome;
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}