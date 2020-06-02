package br.ufc.crateus.imovel.tela;


import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Tela {
	protected Scanner in;
	
	public Tela(Scanner in) {
		this.in = in;
	}
	
	abstract void tela();
	abstract void tratarOpcao(int op);
	
	public void executar() {
		int op = 0;
		do {
			tela();
			op = lerInteiro("Digite sua opÁ„o (0 para sair): ");
			tratarOpcao(op);
		} while (op != 0);
	}
	
	protected int lerInteiro(String msg) {
		System.out.print(msg);
		int val = -1;
		try {
			val = in.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("\nValor inv√°lido. Digite o valor correto.");
		}
		
		in.nextLine();
		return val;
	}
	
	protected long lerLong(String msg) {
		System.out.print(msg);
		long val = -1L;
		try {
			val = in.nextLong();
		}
		catch (InputMismatchException e) {
			System.out.println("\nValor inv√°lido. Digite o valor correto.");
		}
	
		in.nextLine();
		return val;
	}
	
	protected double lerDouble(String msg) {
		System.out.print(msg);
		double val = -1.0;
		try {
			val = in.nextDouble();
		}
		catch (InputMismatchException e) {
			System.out.println("\nValor inv√°lido. Digite o valor correto.");
		}
		
		in.nextLine();
		return val;
	}
	
	protected String lerString(String msg) {
		System.out.print(msg);
		return in.nextLine();
	}
	
	protected boolean lerBoolean(String msg) {
		System.out.print(msg);
		return in.nextBoolean();
	}
}
