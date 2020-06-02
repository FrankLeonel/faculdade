package br.ufc.crateus.imovel.repositorio;

import java.util.ArrayList;
import java.util.Collection;

import br.ufc.crateus.imovel.entidade.Corretor;
import br.ufc.crateus.imovel.entidades.Comercial;
import br.ufc.crateus.imovel.entidades.Imovel;
import br.ufc.crateus.imovel.entidades.Residencial;
import br.ufc.crateus.imovel.entidades.Rural;

public class Imoveis extends Repositorio<Imovel>{
	private static final String DB = "Imoveis.txt";

	private static Corretores corretores = new Corretores();
	
	public Imoveis() {
		super(DB);
	}
	
	public Imovel buscarPorNumero(int numero) {
		for (Imovel obj : super.objs)
			if (obj.getNumero() == numero) return obj;
		return null;
	}

	public Collection<Imovel> buscarPorTipo(String tipo) {
		Collection<Imovel> imoveis = new ArrayList<>();
		
		for (Imovel imovel : objs) 
			if (imovel.getTipo().startsWith(tipo)) imoveis.add(imovel);
		
		return imoveis;
	}
	
	public Collection<Imovel> buscarPorDescricao(String descricao) {
		Collection<Imovel> imoveis = new ArrayList<>();
		
		for (Imovel imovel : objs) 
			if (imovel.getDescricao().startsWith(descricao)) imoveis.add(imovel);
		
		return imoveis;
	}
	
	public Collection<Imovel> buscarPorTipoDeRegistro(boolean tipoDeRegistro) {
		Collection<Imovel> imoveis = new ArrayList<>();
		
		for (Imovel imovel : objs) 
			if (imovel.getTipoDeRegistro() == tipoDeRegistro) imoveis.add(imovel);
		
		return imoveis;
	}
	
	public Collection<Imovel> buscarPorFaixaDeValores(double valorMin, double valorMax) {
		Collection<Imovel> imoveis = new ArrayList<>();
		
		for (Imovel imovel : objs) 
			if ((imovel.getValor() >= valorMin && imovel.getValor() <= valorMax)) imoveis.add(imovel);
		
		return imoveis;
	}
	
	@Override
	protected Imovel linhaParaObjeto(String linha) {
		String[] campos = linha.split(";");
		int tipo = Integer.parseInt(campos[0]);
		int numero = Integer.parseInt(campos[1]);
		String tipoImovel = campos[2];
		String descricao = campos[3];
		int creci = Integer.parseInt(campos[4]);
		boolean tipoDeRegistro = Boolean.parseBoolean(campos[5]);
		double valor = Double.parseDouble(campos[6]);
		
		Corretor corretor = corretores.buscarPorCreci(creci);
		
		switch (tipo) {
		case 1:
			 double tamanho = Double.parseDouble(campos[7]);
			 String localizacaoRural = campos[8];
			 return new Rural(numero, tipoImovel, descricao, corretor, tipoDeRegistro, valor, tamanho, localizacaoRural);
		case 2:
			int numComodosC = Integer.parseInt(campos[7]);
			int numAndaresC = Integer.parseInt(campos[8]);
			 String localizacaoComercial = campos[9];
			 return new Comercial(numero, tipoImovel, descricao, corretor, tipoDeRegistro, valor, numComodosC, numAndaresC, 
					 localizacaoComercial);
		case 3:
			int numComodosR = Integer.parseInt(campos[7]);
			int numAndaresR = Integer.parseInt(campos[8]);
			String localizacaoResidencial = campos[9];
			return new Residencial(numero, tipoImovel, descricao, corretor, tipoDeRegistro, valor, numComodosR, numAndaresR, 
					 localizacaoResidencial);
		default:
			return null;
		}		
	}

	@Override
	protected String objetoParaLinha(Imovel imovel) {
		StringBuilder str = new StringBuilder();
		
		str.append(imovel.getNumero()).append(";");
		str.append(imovel.getTipo()).append(";");
		str.append(imovel.getDescricao()).append(";");
		str.append(imovel.getCorretor().getCreci()).append(";");
		str.append(imovel.getTipoDeRegistro()).append(";");
		str.append(imovel.getValor()).append(";");
		
		if (imovel instanceof Rural) {
			str.insert(0, "1;");
			Rural r = (Rural) imovel;
			str.append(r.getTamanho()).append(";");
			str.append(r.getLocalizacao()).append(";");
		}
		else if (imovel instanceof Comercial) {
			str.insert(0, "2;");
			Comercial c = (Comercial) imovel;
			str.append(c.getNumComodos()).append(";");
			str.append(c.getNumAndares()).append(";");
			str.append(c.getLocalizacao()).append(";");
		}else if (imovel instanceof Residencial) {
			str.insert(0, "3;");
			Residencial re = (Residencial) imovel;
			str.append(re.getNumComodos()).append(";");
			str.append(re.getNumAndares()).append(";");
			str.append(re.getLocalizacao()).append(";");
		}
		
		return str.toString();
	}

	public Imovel getImovelPorNumero(int numero) {
		for (Imovel imovel : objs)
			if (imovel.getNumero() == numero) return imovel;
		return null;
	}
}
