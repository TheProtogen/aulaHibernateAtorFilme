package fronteira;


import java.util.List;
import java.util.Scanner;

import controller.AtorController;
import controller.FilmeController;
import model.Ator;
import model.Filme;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String nomeFilme;
		String nomeAtor;
		Filme f1 = new Filme();
		Ator a1 = new Ator();
		FilmeController fControl = new FilmeController();
		AtorController aControl = new AtorController();
		int escolha;

		do {
			System.out.println("Menu:");
			System.out.println("1. Inserir Filme");
			System.out.println("2. Pequisar um Filme");
			System.out.println("3. Listar Todos");
			System.out.println("4. Atualizar um Filme");
			System.out.println("5. Apagar um Filme");
			System.out.println("=======================");
			System.out.println("6. Inserir Ator");
			System.out.println("7. Pequisar um Ator");
			System.out.println("8. Apagar um Ator");
			System.out.println("9. Atualizar um Ator");
			System.out.println("=======================");
			System.out.println("10. Participa√ß√£o Ator no Filme");
			System.out.println("11. Sair");

			System.out.print("Escolha uma opÁ„o: ");
			escolha = scanner.nextInt();

			switch (escolha) {
			case 1:// utilize o Scanner para captar dados
				System.out.println("Inserir Filme");
				f1.setId(0);
				f1.setTitulo("Cidade de Deus");
				f1.setNomeDiretor("Ze Trindade");
				fControl.inserirFilme(f1);		
				break;
				
			case 2:
				System.out.println("Pesquisar um filme = ");
				nomeFilme = scanner.next();
				List<Filme> filmes = fControl.pesquisarUmFilme(nomeFilme);	
				if (!(filmes.isEmpty())) {
					for (Filme filme : filmes ) {
						System.out.println("Nome: " + filme.getTitulo() + " Id= " + filme.getId()+ " Diretor: " + filme.getNomeDiretor());
					}
				}
				else System.out.println("N√£o encontrou o Filme");
				scanner.nextLine();
				break;
				
			case 3:
				System.out.println("Listando Todos os Filmes");
				filmes = fControl.pesquisarTodos();	
				if (!(filmes.isEmpty())) {
					for (Filme filme : filmes ) {
						System.out.println("Id= " + filme.getId() + " Nome: " + filme.getTitulo() + ", Diretor: " + filme.getNomeDiretor());
					}
				}
				else System.out.println("N√£o encontrou o Filme");
				break;
				
			case 4:
				System.out.println("Escolha um filme para atualizar ");
				long id = scanner.nextLong();
				f1.setId(id);
				f1.setTitulo("Terminator");
				f1.setNomeDiretor("James Cammeron");
				fControl.atualizar(f1);
				break;
			case 5:
				System.out.println("Escolha um filme para apagar ");
				 id = scanner.nextLong();
				fControl.apagar(id);
				break;	
			case 6:
				System.out.println("Inserir ator ");
				a1.setId(0);
				a1.setNome("Arnold Schwarzenegger");
				a1.setPais("USA");
				aControl.inserir(a1);	
				break;
			case 7:
				System.out.println("Pesquisar ator  ");
				nomeAtor = scanner.next();
				List<Ator> atores = aControl.listarUm(nomeAtor);
				if (!(atores.isEmpty())) {
					for (Ator ator : atores ) {
						System.out.println("Id= " + ator.getId() + " Nome: " + ator.getNome() + ", Pais: " + ator.getPais());
					}
				}
				else System.out.println("N„o encontrou o Ator");
				break;
			case 8:
				System.out.println("Escolha um ator para apagar ");
				id = scanner.nextInt();
				aControl.apagar(id);
				break;
			case 9:
				System.out.println("Atualizar um ator ");
				
				break;
			case 10:
				System.out.println("Verificar participaÁ„o de ator no filme ");
				
				break;
			case 11:
				System.out.println("Saindo do menu.");
				break;
			default:
				System.out.println("Op√ß√£o inv√°lida. Tente novamente.");
			}
		} while (escolha != 11);

		scanner.close();
	}
}


