package br.ufc.crateus.imovel.repositorio;

import java.util.ArrayList;
import java.util.Collection;

import br.ufc.crateus.imovel.entidade.Corretor;

public class Corretores extends Repositorio<Corretor> {
	
	private static final String DB = "Corretores.txt";
	
	
	public Corretores() {
		super(DB);
	}

	public Corretor buscarPorCreci(long creci) {
		for (Corretor corretor : objs) 
			if (corretor.getCreci() == creci) return corretor;
		return null;
	}
	
	public Collection<Corretor> buscarPorNome(String nome) {
		Collection<Corretor> corretores = new ArrayList<>();
		
		for (Corretor corretor : objs) 
			if (corretor.getNome().startsWith(nome)) corretores.add(corretor);
		
		return corretores;
	}

	@Override
	protected Corretor linhaParaObjeto(String linha) {
		String[] campos = linha.split(";");
		int creci = Integer.parseInt(campos[0]);
		String nome = campos[1];
		Corretor corretor = new Corretor(creci, nome);

		return corretor;
	}

	@Override
	protected String objetoParaLinha(Corretor corretor) {
		StringBuilder str = new StringBuilder();
		str.append(corretor.getCreci()).append(";");
		str.append(corretor.getNome()).append(";");
		
		return str.toString();
	}
}