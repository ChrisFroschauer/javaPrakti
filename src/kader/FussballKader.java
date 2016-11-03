package kader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Krasse Klasse für FussballKader.
 * @author christian
 *
 */
public class FussballKader {
	/**
	 * Application für Aufgabe.
	 * @param args Argumente der Kommandozeile.
	 */
	public static void main(String[] args){
		/**
		 * Neue HashMap kader für Fußballkader.
		 */
		final Map<String, Integer> kader = new HashMap<String, Integer>();
		
		/**
		 * kader befüllen.
		 */
		// CHECKSTYLE:OFF MagicNumber
		kader.put("Arturo Vidal", 25);
		kader.put("David Alaba", 27);
		kader.put("Josuha Kimmich", 32);
		kader.put("Manuel Neuer", 1);
		kader.put("Philipp Lahm", 21);
		kader.put("Sven Ulreich", 26);
		kader.put("Th", 25);
		
		/**
		 * Duplikate finden.
		 */
		System.out.println("Gibt es ein Duplikat?");
		findDuplicateTrikot(kader);
		
		/**
		 * Spieler mit Nummer 1 finden.
		 */
		getTrikotAt(kader, 1);
		
		/**
		 * Einen Eintrag löschen, hier 26.
		 */
		deleteTrikotAt(kader, 26);
		
	}
	/**
	 * Duplikate finden bei den Trikotnummern.
	 * @param map Bekommt den Kader.
	 * @return map Gibt den Kader wieder zurück.
	 */
	public static Map<String, Integer> findDuplicateTrikot(Map<String, Integer> map){
		for (Entry<String, Integer> lauf1 : map.entrySet()){
			for (Entry<String, Integer> lauf2 : map.entrySet()){
				if (lauf1.getKey() != lauf2.getKey() && lauf1.getValue() == lauf2.getValue()){
					System.out.println("Duplikat bei Trikot-Nummer: " + lauf1.getValue());
					return map;
				}
			}
		}
		return map;
	}
	
	/**
	 * Gibt Trikot mit nr "trikotnr" aus.
	 * @param map Bekommt den Kader.
	 * @param trikotnr Die Trikotnummer die gesucht ist.
	 * @return map Gibt den Kader wieder zurück.
	 */
	public static Map<String, Integer> getTrikotAt(Map<String, Integer> map, int trikotnr){
		for (Entry<String, Integer> entry: map.entrySet()){
			if(entry.getValue() == trikotnr){
				System.out.println(entry.getKey() + "=" + entry.getValue());
				return map;
			}
		}
		System.out.println("Kein Spieler mit der Nummer: " + trikotnr);
		return map;
		
	}
	
	/**
	 * Löscht Trikot mit "trikotnr".
	 * @param map Bekommt den Kader.
	 * @param trikotnr Die Trikotnummer die gesucht ist.
	 * @return map Gibt den Kader wieder zurück.
	 */
	public static Map<String, Integer> deleteTrikotAt(Map<String, Integer> map, int trikotnr){
		for (Entry<String, Integer> entry: map.entrySet()){
			if(entry.getValue() == trikotnr){
				map.remove(entry.getKey());
				return map;
			}
		}
		return map;
	}
}
