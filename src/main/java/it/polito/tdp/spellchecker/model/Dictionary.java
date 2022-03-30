package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;

public class Dictionary {
	
	public LinkedHashSet<String> paroleItalian = new LinkedHashSet();
	
	public LinkedHashSet<String> paroleEnglish = new LinkedHashSet();
	
	public void loadDictionary(String language) {
		
		if(language.compareTo("English")==0) {
			
		try {
			FileReader fr = new FileReader("src/main/resources/English.txt");//cambia percorso
			BufferedReader br = new BufferedReader(fr); 
			String word;
			while ((word = br.readLine()) != null) {
				
						paroleEnglish.add(word);
			                          // Aggiungere parola alla struttura dati
			             }
			                    br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}}
		
		if(language.compareTo("Italian")==0){
			
			try {
				FileReader fr = new FileReader("src/main/resources/Italian.txt");
				BufferedReader br = new BufferedReader(fr); 
				String word;
				while ((word = br.readLine()) != null) {
					
						paroleItalian.add(word);
				                          // Aggiungere parola alla struttura dati
				             }
				                    br.close();
				} catch (IOException e){
				System.out.println("Errore nella lettura del file");
				}
		}
			
	}

}
