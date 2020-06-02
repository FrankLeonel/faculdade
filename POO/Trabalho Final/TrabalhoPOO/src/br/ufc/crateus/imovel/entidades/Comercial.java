package br.ufc.crateus.imovel.entidades;


import br.ufc.crateus.imovel.entidade.Corretor;

public class Comercial extends Imovel {
	private int numComodos;
	private int numAndares;
	private String localizacao;
	
	public Comercial(int numero, String tipo, String descricao, Corretor corretor, boolean tipoDeRegistro, 
			double valor, int numComodos, int numAndares, String localizacao) {
		super(numero, tipo, descricao, corretor, tipoDeRegistro, valor);
		this.numComodos = numComodos;
		this.numAndares = numAndares;
		this.localizacao = localizacao;
	}

	public int getNumComodos() {
		return numComodos;
	}

	public void setNumComodos(int numComodos) {
		this.numComodos = numComodos;
	}
	
	public int getNumAndares() {
		return numAndares;
	}

	public void setNumAndares(int numAndares) {
		this.numAndares = numAndares;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
}
