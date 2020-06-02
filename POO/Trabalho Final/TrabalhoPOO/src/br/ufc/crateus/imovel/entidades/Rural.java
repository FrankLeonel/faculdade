package br.ufc.crateus.imovel.entidades;

import br.ufc.crateus.imovel.entidade.Corretor;

public class Rural extends Imovel {
	private double tamanho;
	private String localizacao;
	
	public Rural(int numero, String tipo, String descricao, Corretor corretor,
			boolean tipoDeRegistro, double valor, double tamanho, String localizacao) {
		super(numero, tipo, descricao, corretor,  tipoDeRegistro, valor);
		this.tamanho = tamanho;
		this.localizacao = localizacao;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
}
