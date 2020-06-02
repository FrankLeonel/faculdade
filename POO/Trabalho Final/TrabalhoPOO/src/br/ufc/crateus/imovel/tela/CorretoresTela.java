package br.ufc.crateus.imovel.tela;

import java.util.Scanner;

import br.ufc.crateus.imovel.entidade.Corretor;
import br.ufc.crateus.imovel.repositorio.Corretores;



public class CorretoresTela extends Tela {

	private Corretores corretores = new Corretores();
	
	public CorretoresTela(Scanner in) {
		super(in);
	}

	
	void tela() {
		System.out.println("==== Sistema Imobiliário - Adm. de Corretores ====");
		System.out.println("1 - Cadastrar corretor");
		System.out.println("2 - Alterar corretor");
		System.out.println("3 - Remover corretor");
		System.out.println("4 - Listar corretores");
	}
	
	private void cadastrarCorretor() {
		long creci = lerLong("Creci: ");
		String nome = lerString("Nome: ");
		
		Corretor corretor = corretores.buscarPorCreci(creci);
		if (corretor == null) {
			corretores.adicionar(new Corretor(creci, nome));
			System.out.println("Corretor cadastrado com sucesso!");			
		}
		else {
			System.out.println("Corretor já cadastrado!");
		}
		
	}
	
	private void alterarCorretor() {
		int creci = lerInteiro("Digite o creci do corretor: ");
		Corretor corretor = corretores.buscarPorCreci(creci);
		if (corretor != null) {
			String nome = lerString("Nome: ");
			corretor.setNome(nome);
			long creciC = lerLong("Creci: ");
			corretor.setCreci(creciC);
			
				
			System.out.println("Corretor alterado com sucesso!");
		}
		else System.out.println("Nenhum corretor encontrado!");
	}

	private void removerCorretor() {
		int creci = lerInteiro("Digite o creci do corretor: ");
		Corretor corretor = corretores.buscarPorCreci(creci);
		if (corretor != null) {
			corretores.remover(corretor);
			System.out.println("Corretor removido com sucesso!");
		}
		else {
			System.out.println("Corretor não foi encontrado!");
		}
	}
	
	@Override
	void tratarOpcao(int op) {
		switch (op) {
		case 1:
			cadastrarCorretor();
			break;
			
		case 2:
			alterarCorretor();
			break;
			
		case 3:
			removerCorretor();
			break;
		case 4:
			corretores.mostrarOrdenado();
			break; 
			
		default:
			System.out.println("Opção inválida, tente novamente!");
			break;
		}
	}
}
