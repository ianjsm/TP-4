package application;

import Entities.Autor;
import Service.AutorService;
import Service.LivroService;

public class Main {
	public static void main(String[] args) {
		LivroService livroService = new LivroService();
		AutorService autorService = new AutorService();

		autorService.adicionarAutor("Machado de Assis"); // id do autor = 1
		autorService.adicionarAutor("Rachel de Queiroz"); // id do autor = 2
		autorService.visualizarAutores();
		System.out.println();

		livroService.adicionarLivro("Memórias Póstumas de Brás Cubas", 1881, 1); // id do livro = 1
		livroService.adicionarLivro("Dom Casmurro", 1899, 1); // id do livro = 2
		livroService.adicionarLivro("O Quinze", 1930, 2); // id do livro = 3
		livroService.adicionarLivro("Caminho de Pedras", 1937, 2); // id do livro = 4
		livroService.visualizarLivros();
		System.out.println();

		autorService.atualizarAutor(1, "M. de Assis");
		autorService.pesquisarAutorPorID(1);
		autorService.visualizarAutores();
		System.out.println();

		livroService.atualizarLivro(1, "Coletânea de livros de M. de Assis", 2000, 1);
		livroService.pesquisarLivroPorID(1);
		livroService.visualizarLivros();
		System.out.println();

		//não achamos nomes de escritores famosos e que fossem parecidos, então vamos colocar o nome de celebridades :p
		System.out.println("Adicionando um array de nomes...");
		Autor[] lista_de_autores = { new Autor("Michael Jordan"), new Autor("Michael Jackson"), new Autor("Michael Phelps") };
		autorService.adicionarArrayAutores(lista_de_autores);
		autorService.visualizarAutores();
		System.out.println();
		
		System.out.println("Nomes que se parecem no banco de dados");
		autorService.pesquisarAutoresPorNome("Michael");
		System.out.println();
		
		autorService.deletarAutor(1);
		livroService.deletarLivro(3);
		System.out.println();
		
		autorService.visualizarAutores();
		livroService.visualizarLivros();
	}
}