package br.ufc.crateus.imovel.tela;

import java.util.Collection;
import java.util.Scanner;

import br.ufc.crateus.imovel.entidade.Corretor;
import br.ufc.crateus.imovel.entidades.Comercial;
import br.ufc.crateus.imovel.entidades.Imovel;
import br.ufc.crateus.imovel.entidades.Residencial;
import br.ufc.crateus.imovel.entidades.Rural;
import br.ufc.crateus.imovel.repositorio.Corretores;
import br.ufc.crateus.imovel.repositorio.Imoveis;


public class ImovelTela extends Tela {

	public ImovelTela(Scanner in) {
		super(in);
	}

	private Imoveis imoveis = new Imoveis(); 
	private Corretores corretores = new Corretores();

	@Override
	void tela() {
		System.out.println("==== Sistema Imobili�rio - Adm. de Im�veis ====");
		System.out.println("1 - Cadastrar Imovel");
		System.out.println("2 - Buscar por tipo");
		System.out.println("3 - Buscar por descri��o");
		System.out.println("4 - Buscar por tipo de registro");
		System.out.println("5 - Buscar por faixa de valores");
		System.out.println("6 - Alterar im�vel");
		System.out.println("7 - Remover im�vel");
	}

	private void cadastrarImovel() {
		int creciCorretor = lerInteiro("Digite o creci do Corretor: ");
		Corretor corretor = corretores.buscarPorCreci(creciCorretor);
		if (corretor != null) {
			int tipo = 0;
			do {
				tipo = lerInteiro("Tipo ([0] - Rural, [1] - Comercial, [2] - Residencial: ");
			}
			while (tipo < 0 || tipo > 2);

			int numero = lerInteiro("C�digo do im�vel: ");
			Imovel imovel = imoveis.buscarPorNumero(numero);

			if (imovel == null) {
				String descricao = lerString("Descri��o: ");
				double valor = lerDouble("Valor: ");
				boolean tipoDeRegistro = lerBoolean("Tipo de registro(true = venda, false = aluguel): ");

				if (tipo == 0) {
					String tipoImovelR = "Rural";
					double tamanho = lerDouble("Tamanho: ");
					String localizacaoRural = lerString("Localiza��o: ");
					imovel = new Rural(numero, tipoImovelR, descricao, corretor, tipoDeRegistro, valor, tamanho, localizacaoRural);
				}
				else if(tipo == 1) {
					String tipoImovelC = "Comercial";
					int numAndaresC = lerInteiro("N�mero de andares: ");
					int numComodosC = lerInteiro("N�mero de comodos: ");
					String localizacaoComercial = lerString("Localiza��o: ");
					imovel = new Comercial(numero, tipoImovelC, descricao, corretor, tipoDeRegistro, valor, numComodosC, numAndaresC, 
							 localizacaoComercial);
				}else {
					String tipoImovelRe = "Residencial";
					int numAndaresR = lerInteiro("N�mero de andares: ");
					int numComodosR = lerInteiro("N�mero de comodos: ");
					String localizacaoResidencial = lerString("Localiza��o: ");
					imovel = new Residencial(numero, tipoImovelRe, descricao, corretor, tipoDeRegistro, valor, numComodosR, numAndaresR, 
							 localizacaoResidencial);
				}

				imoveis.adicionar(imovel);
				System.out.println("Im�vel adicionado com sucesso!");
			}
			else {
				System.out.println("Im�vel j� cadastrado!");
			}
		}
		else {
			System.out.println("Corretor n�o encontrado!");
		}

	}

	private void buscarImovelPorTipo() {
		String tipoImovel = lerString("Digite o tipo do im�vel: ");
		Collection<Imovel> encontrados = imoveis.buscarPorTipo(tipoImovel);
		if (!encontrados.isEmpty()) {
			for (Imovel imovel : encontrados)
				System.out.println(imovel);
		}
		else System.out.println("Nenhum im�vel encontrado!");
	}

	private void buscarImovelPorDescricao() {
		String descricao = lerString("Digite a descri��o do im�vel: ");
		Collection<Imovel> encontrados = imoveis.buscarPorDescricao(descricao);
		if (!encontrados.isEmpty()) {
			for (Imovel imovel : encontrados)
				System.out.println(imovel);
		}
		else System.out.println("Nenhum im�vel encontrado!");
	}
	
	private void buscarImovelPorTipoDeRegistro() {
		boolean tipoDeRegistro = lerBoolean("Digite o tipo de registro do im�vel(true = venda, false = aluguel): ");
		Collection<Imovel> encontrados = imoveis.buscarPorTipoDeRegistro(tipoDeRegistro);
		if (!encontrados.isEmpty()) {
			for (Imovel imovel : encontrados)
				System.out.println(imovel);
		}
		else System.out.println("Nenhum im�vel encontrado!");
	}
	
	private void buscarImovelPorFaixaDeValores() {
		double valorMin = lerDouble("Informe o valor inicial do im�vel: ");
		double valorMax = lerDouble("Informe o valor final do im�vel: ");
		Collection<Imovel> encontrados = imoveis.buscarPorFaixaDeValores(valorMin, valorMax);
		if (!encontrados.isEmpty()) {
			for (Imovel imovel : encontrados)
				System.out.println(imovel);
		}
		else System.out.println("Nenhum im�vel encontrado!");
	}
	
	private void alterarImovel() {
		int numero = lerInteiro("Digite o c�digo do im�vel: ");
		Imovel imovel = imoveis.buscarPorNumero(numero);
		if (imovel != null) {
			
			if (imovel instanceof Rural) {
				Rural r = (Rural) imovel;
				String descricao = lerString("Nova descri��o: ");
				r.setDescricao(descricao);
				boolean tipoDeRegistro = lerBoolean("Novo tipo de registro: ");
				r.setTipoDeRegistro(tipoDeRegistro);
				double valor = lerDouble("Novo valor: ");
				r.setValor(valor);
				double tamanho = lerDouble("Novo tamanho: ");
				r.setTamanho(tamanho);
				String localizacao = lerString("Nova localiza��o: ");
				r.setLocalizacao(localizacao);
				
				System.out.println("Im�vel alterado com sucesso!");
			}
			else if(imovel instanceof Comercial){
				Comercial c = (Comercial) imovel;
				String descricao = lerString("Nova descri��o: ");
				c.setDescricao(descricao);
				boolean tipoDeRegistro = lerBoolean("Novo tipo de registro: ");
				c.setTipoDeRegistro(tipoDeRegistro);
				double valor = lerDouble("Novo valor: ");
				c.setValor(valor);
				int numAndaresC = lerInteiro("N�mero de ndares: ");
				c.setNumAndares(numAndaresC);
				int numComodosC = lerInteiro("N�mero de ndares: ");
				c.setNumComodos(numComodosC);
				String localizacao = lerString("Nova localiza��o: ");
				c.setLocalizacao(localizacao);
				
				System.out.println("Im�vel alterado com sucesso!");
			}else {
				Residencial re = (Residencial) imovel;
				String descricao = lerString("Nova descri��o: ");
				re.setDescricao(descricao);
				boolean tipoDeRegistro = lerBoolean("Novo tipo de registro: ");
				re.setTipoDeRegistro(tipoDeRegistro);
				double valor = lerDouble("Novo valor: ");
				re.setValor(valor);
				int numAndaresR = lerInteiro("N�mero de ndares: ");
				re.setNumAndares(numAndaresR);
				int numComodosR = lerInteiro("N�mero de ndares: ");
				re.setNumComodos(numComodosR);
				String localizacao = lerString("Nova localiza��o: ");
				re.setLocalizacao(localizacao);
				
				System.out.println("Im�vel alterado com sucesso!");
			}
		}else {
			System.out.println("Im�vel n�o foi encontrado!");
		}
	}

	private void removerImovel() {
		int numero = lerInteiro("Digite o c�digo do im�vel: ");
		Imovel imovel = imoveis.buscarPorNumero(numero);
		if (imovel != null) {
			imoveis.remover(imovel);
			System.out.println("Imovel removido com sucesso!");
		}
		else {
			System.out.println("Im�vel n�o foi encontrado!");
		}
	}


	@Override
	void tratarOpcao(int op) {
		switch (op) {
		case 1:
			cadastrarImovel();
			break;

		case 2:
			buscarImovelPorTipo();
			break;
		
		case 3:
			buscarImovelPorDescricao();
			break;
			
		case 4:
			buscarImovelPorTipoDeRegistro();
			break;
		
		case 5:
			buscarImovelPorFaixaDeValores();
			break;
		case 6:
			alterarImovel();
			break;

		case 7:
			removerImovel();
			break;

		default:
			System.out.println("Op��o inv�lida, tente novamente!");
		}
	}

}
