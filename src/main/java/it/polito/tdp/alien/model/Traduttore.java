package it.polito.tdp.alien.model;

import java.util.HashMap;

public class Traduttore {
	
	private HashMap<String, ParolaTradotta> dizionario = new HashMap<String, ParolaTradotta>();
	
	public void addDizionario(String parolaAliena , String traduzione) {
		if (dizionario.get(parolaAliena)==null) {
		   dizionario.put(parolaAliena.toLowerCase(), new ParolaTradotta(parolaAliena.toLowerCase(),traduzione.toLowerCase()) );}
		else if (dizionario.get(parolaAliena)!= null) {
			ParolaTradotta p = dizionario.get(parolaAliena);
			p.addParolaPiu(traduzione, parolaAliena);
		}
		
		
	}
	
	public String translate(String parolaAliena) {
		if (dizionario.get(parolaAliena)!=null) {
			ParolaTradotta p = dizionario.get(parolaAliena);
			String ss=""; 
			if ( p.getParoleConPiuTraduzioni().size() == 0 ) {
				String s = dizionario.get(parolaAliena).getParolaIta();
				return s;
			}
			else {
			  for( ParolaAliena s  : p.getParoleConPiuTraduzioni().values()) {
				  if ( s.getParolaAliena().compareTo(parolaAliena)==0) {
				     ss += " " + s.getParolaIta();}}
			  return ss;
			  }
		}
		else if ( dizionario.get(parolaAliena)==null) {
			String s = "Parola non trovata";
			return s;
		}
		return null;
	}
	
	
}
