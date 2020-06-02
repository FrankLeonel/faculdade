package br.ufc.crateus.imovel.repositorio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public abstract class Repositorio<T extends Comparable<T>> {
	
	private String db;
	
	protected Collection<T> objs;
	
	public Repositorio(String db) {
		this.db = db;
		try {
			this.objs = carregar();
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo '" + db + "' não encontrado.");
		}
	}
	
	public void adicionar(T obj) {
		objs.add(obj);
		try {
			acrescentar(obj);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo '" + db + "' não encontrado.");
		}
	}
	
	public void remover(T obj) {
		objs.remove(obj);
		try {
			salvar();
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo '" + db + "' não encontrado.");
		}
	}
	
	public void atualizar(T novo) {
		T antigo = null;
		for (T obj : objs) 
			if (obj.equals(novo)) antigo = obj;
		
		if (antigo != null) {
			remover(antigo);
			adicionar(novo);
		}
	}
	
	public void mostrarOrdenado() {
		List<T> lista = new ArrayList<>(objs);
		Collections.sort(lista);
		
		for (T obj : objs) System.out.println(obj);
	}
	
	protected Collection<T> carregar() throws FileNotFoundException {
		Scanner in = new Scanner(new FileInputStream(db));
		Collection<T> objs = new ArrayList<>();
		
		while (in.hasNext()) {
			T obj = linhaParaObjeto(in.nextLine());
			objs.add(obj);
		}
		in.close();
		return objs;
	}
	
	protected void salvar() throws FileNotFoundException {
		PrintStream out = new PrintStream(new FileOutputStream(db));
		for (T o : objs) {
			String linha = objetoParaLinha(o);
			out.println(linha);
		}
		out.close();
	}
	
	protected void acrescentar(T obj) throws FileNotFoundException {
		PrintStream out = new PrintStream(new FileOutputStream(db, true));
		
		String linha = objetoParaLinha(obj);
		out.println(linha);
		
		out.close();
	}
	
	protected abstract T linhaParaObjeto(String linha);
	
	protected abstract String objetoParaLinha(T obj);
}
