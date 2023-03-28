package it.polito.tdp.alien.model;

import java.util.HashMap;

public class ParolaTradotta {
	
	private HashMap <String , ParolaAliena> paroleConPiuTraduzioni ;
	private String parolaAliena;
	private String parolaIta;
	
	public ParolaTradotta(String parolaAliena, String parolaIta) {
		this.parolaAliena = parolaAliena;
		this.parolaIta = parolaIta;
		paroleConPiuTraduzioni = new HashMap<String, ParolaAliena>();
		 
	}

	public String getParolaAliena() {
		return parolaAliena;
	}

	public String getParolaIta() {
		return parolaIta;
	}

	public HashMap<String, ParolaAliena> getParoleConPiuTraduzioni() {
		return paroleConPiuTraduzioni;
	}

	public void addParolaPiu(String parolaAliena , String Traduzione) {
		this.paroleConPiuTraduzioni.put(Traduzione,new ParolaAliena(Traduzione,parolaAliena));
		
	}
	
	

}
