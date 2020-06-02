package br.ufc.crateus.imovel.entidades;


import br.ufc.crateus.imovel.entidade.Corretor;

public class Imovel implements Comparable<Imovel>{
	private Integer numero;
	protected String tipo;
	protected String descricao;
	private Corretor corretor;
	protected Boolean tipoDeRegistro;
	protected Double valor;

	public Imovel(int numero, String tipo, String descricao, Corretor corretor,	boolean tipoDeRegistro, double valor) {
		this.numero = numero;
		this.tipo = tipo;
		this.descricao = descricao;
		this.corretor = corretor;
		this.tipoDeRegistro = tipoDeRegistro;
		this.valor = valor;
	}
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Corretor getCorretor() {
		return corretor;
	}

	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}

	public Boolean getTipoDeRegistro() {
		return tipoDeRegistro;
	}

	public void setTipoDeRegistro(Boolean tipoDeRegistro) {
		this.tipoDeRegistro = tipoDeRegistro;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@Override
	public int compareTo(Imovel imovel) {
		return this.valor.compareTo(imovel.valor);
	}

	@Override
	public String toString() {
		return "Número: " + numero + ", tipo: " + tipo + ", descrição: " + descricao + ", tipo de registro: " + tipoDeRegistro 
		+ ", corretor: " + corretor.getNome() + ", valor: " + valor;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
}