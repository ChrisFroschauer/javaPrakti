package aufgabe4;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import aufgabe3.Corporation;

/**
 * LimitedStringToIntMap eine Map mit maximaler Anzahl an Einträgen (int) löscht den ältesten wenn voll.
 * @author christian
 *
 */
public class LimitedStringToIntMap extends HashMap<String, Integer> implements LimitedMap{
	
	/**
	 * Liste zur Verfolgung der Neusten/Ältesten.
	 */
	private List<String> newest;
	
	/**
	 * Maximale Anzahl an Einträgen in Int.
	 */
	private final int capacity;
	
	
	/**
	 * Limitiert Map zur size von capacity.
	 * @param capacity Maximale Einträge in der Datenstruktur
	 */
	LimitedStringToIntMap(int capacity){
		//super();
		if(capacity <= 0){
			//this.capacity = capacity * (-1);
			throw new IllegalArgumentException("Capacity can't be negative");
		}else{
			this.capacity = capacity;
		}
		newest = new LinkedList<String>();
		//assert this.capacity <= this.size() : "Capacity can't be greater than size!";
	}
	
	
	@Override
	public void clear() {
		//newest leeren
		newest.clear();
		super.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		//touch
		if(newest.contains(key)){
			newest.remove(key);
			newest.add((String) key);
		}
		
		return super.containsKey(key);
	}

	@Override
	public Integer get(Object o) {
		//das mit key o als neusten markieren 		
		if(newest.contains(o)){
			newest.remove(o);
			newest.add((String)o);
		}
		return super.get((String)o);
	}

	@Override
	public Integer put(String key, Integer value) {
		if(this.containsKey(key)){//wenn key schon in der map ist
			newest.remove(key); //update den key in der newest
			newest.add(key);
		}else{
			if(this.getLimit() == newest.size()){
				super.remove(newest.get(0));
				newest.remove(0); //wenn VOLL
			}
			newest.add(key); //immer auch wenn nicht voll
		}
		
		return super.put(key, value);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Integer> map) {
		//soviele älteste wie map.size() entfernen. Was wenn map.size() größer als capacity?
		List<String> sorti = new ArrayList<>();
		sorti.addAll(map.keySet());
		sorti.sort(new Comparator<String>(){
			public int compare(String s, String t){
				return (Integer.parseInt(s))-(Integer.parseInt(t));
			}
		});
		//System.out.println(sorti);
		
		for(String lauf1: sorti){
			this.put(lauf1, map.get(lauf1));
		}
		
		/*for (java.util.Map.Entry<? extends String, ? extends Integer> lauf : map.entrySet()){
			this.put(lauf.getKey(), lauf.getValue());
		}*/
		
	}

	@Override
	public Integer remove(Object key) {
		//Einträge anpassen!
		newest.remove(key);
		return super.remove(key);
	}

	@Override
	public int getLimit() {
		return capacity;
	}
	
	@Override
	public String toString(){
		return super.toString() + newest.toString();
	}

}
