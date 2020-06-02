package br.ufc.crateus.imovel;

import java.util.Scanner;
import br.ufc.crateus.imovel.tela.ImobiliariaTela;

public class Imobiliaria{
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		new ImobiliariaTela(in).executar();
		in.close();
	}
}