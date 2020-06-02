package br.ufc.crateus.imovel.entidade;

public class Corretor implements Comparable<Corretor> {
	private String nome;
	private long creci;
	
	public Corretor(long creci, String nome) {
		this.creci = creci;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getCreci() {
		return creci;
	}
	
	public void setCreci(long creci) {
		this.creci = creci;
	}
	
	@Override
	public int compareTo(Corretor o) {
		return this.nome.compareTo(o.nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corretor other = (Corretor) obj;
		if (creci != other.creci)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Corretor [Creci: " + creci + ", nome: " + nome + "]";
	}
}
