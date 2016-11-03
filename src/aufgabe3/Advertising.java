package aufgabe3;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Speichert in einer Map<Corporation, List> eine Liste von Artikel.
 * @author christian
 *
 */
public class Advertising {
	
	/**
	 * Map für Corps und Article Liste.
	 */
	private final Map<Corporation, List<String>> corpArticles;
	
	/**
	 * Constructor, Map wird mit der Datei gefüttert.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	Advertising() throws FileNotFoundException{
		corpArticles = readCorpFile("/home/christian/Downloads/input/corporations.txt");
	}
	/**
	 * Konstruktor mit Pfadangabe.
	 * @param path pfad.
	 * @throws FileNotFoundException - File nicht gefunden.
	 */
	Advertising(String path) throws FileNotFoundException{
		corpArticles = readCorpFile(path);
	}
	
	/**
	 * get a List of Corporations with the specified articles.
	 * @param article Ein String mit dem gewollten Artikel.
	 * @return List of Corporation containing the article.
	 */
	private List<Corporation> getWithArticle(String article){
		
		final List<Corporation> corpWithArticle = new ArrayList<Corporation>();
		int count = 0;
		for (Entry<Corporation, List<String>> lauf1 : corpArticles.entrySet()){
			//System.out.println(lauf1.getValue().toString());
			if(lauf1.getValue().toString().contains(article)){
				corpWithArticle.add(lauf1.getKey());
				count++;
			}
		}
		System.out.println("Found: " + count);
		return corpWithArticle;
		
	}
	
	/**
	 * Firmen + Adresse + Artikelliste aus Datei in die Map packen.
	 * @return Map über <Corporation, List> zurückgeben.
	 * @param s String für Dateipfad.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private HashMap<Corporation, List<String>> readCorpFile(String s) throws FileNotFoundException{
		
		final Map<Corporation, List<String>> corpMap = new HashMap<>();
		
		/**
		 * Read aus der Datei.
		 */
		try (FileReader reader = new FileReader(s)){
			
			int bang;
				
			bang = reader.read();
			
			while(bang != -1){
				String name = "";
				String address = "";
				/*
				 * Schleife für Firmenname
				 */
				while((char)bang != ',' && bang != -1){
					name += (char) bang;
					//System.out.println(name);
					bang = reader.read();
				}
				if((char) bang != '\n')bang = reader.read();
				if((char) bang != '\n')bang = reader.read();
				
				/*
				 * Schleife für Firmenaddresse
				 */
				while((char)bang != ',' && bang != -1){
					address += (char) bang;
					//System.out.println(address);
					bang = reader.read();
				}
				if((char) bang != '\n')bang = reader.read();
				if((char) bang != '\n')bang = reader.read();
				
				/*
				 * Neue Corporation erstellen
				 */
				final Corporation corp = new Corporation(name, address);
				
				/*
				 * Jetzt Artikelliste einlesen und erstellen
				 */

				final List<String> articles = new ArrayList<String>();
				
				while((char)bang != '\n' && bang != -1){
					name = "";
					while((char)bang != ',' && (char)bang != '\n' && bang != -1){
						name += (char) bang;
						bang = reader.read();
					}
					articles.add(name);
					if((char) bang != '\n')bang = reader.read();
					if((char) bang != '\n')bang = reader.read();
					
				}
				corpMap.put(corp, articles);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return (HashMap<Corporation, List<String>>) corpMap;
		
	}
	
	/**
	 * toString methode.
	 */
	@Override
 	public String toString(){
		return "" + corpArticles;
 	} 

	
	
	
	
	
	
	/**
	 * Application.
	 * @param args Kommandozeile Argumente.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException{
		
		final Advertising mike = new Advertising();
		System.out.println(mike);
		
		System.out.println();
		System.out.println(mike.getWithArticle("Food"));
		
	}
	
	
	
}
