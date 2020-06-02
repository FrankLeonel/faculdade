package br.ufc.crateus.imovel.tela;

import java.util.Scanner;

import br.ufc.crateus.imovel.repositorio.Corretores;
import br.ufc.crateus.imovel.repositorio.Imoveis;

public class ImobiliariaTela extends Tela {
	
	public ImobiliariaTela(Scanner in) {
		super(in);
	}

	Imoveis imoveis = new Imoveis();
	Corretores corretoes = new Corretores();

	@Override
	void tela() {
		System.out.println("========= Sistema Imobiliário =========");
		int op = 1;
		do {
			op = lerInteiro("Digite: \n[1] - Para administrar imóveis  \n[2] - Para administrar corretores\n");
		} while (op < 0 || op > 2);
		tratarOpcao(op);
	}
	
	@Override
	void tratarOpcao(int op) {
		switch (op) {
		case 1:
			new ImovelTela(super.in).executar();
			break;	
		case 2:
			new CorretoresTela(super.in).executar();
			break;
		default:
			break;
		}
	}
}
