package aufgabe4;
/* (C) 2016, Gudrun Schiedermeier, gschied@haw-landshut.de
 * Oracle Corporation Java 1.8.0_72, Linux i386 4.4.0
 * mozart (Intel Core i7-4600U CPU/2701 MHz, 4 Cores, 11776 MB RAM)
 */
//package de.haw_landshut.gschied.ws2016.praktikum1.limitedmap;

import java.util.Map;

/**Represents a map with limited number of entries.
 * Type of key is String and value is Integer.
 * @author Gudrun Schiedermeier, gschied@haw-landshut.de
 * @version 2016-10-13
 */
public interface LimitedMap extends Map<String, Integer> {
	public static class MapOverflowException extends RuntimeException {
	}

	/**Removes all of the mappings from this map.
	 * @see https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#clear--
	 */
	void clear();

	/**Same as base interface.
	 * Additionally: marks entry as newest.
	 * @param key key whose presence in this map is to be tested.
	 * @return true if this map contains a mapping for the specified key.
	 * @see https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#containsKey-java.lang.Object-
	 */
	boolean containsKey(Object key);

	/**Same as base interface.
	 * Additionally: marks entry as newest.
	 * @param key the key whose associated value is to be returned.
	 * @return the value to which the specified key is mapped,
	 * or null if this map contains no mapping for the key
	 * @see https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#get-java.lang.Object-
	 */
	Integer get(Object o);

	/**Same as base interface.
	 * Additionally: removes oldest entry if this map is full.
	 * @param key  key with which the specified value is to be associated, not null.
	 * @param value value to be associated with the specified key.
	 * @return the previous value associated with key, or null if there was no mapping for key.
	 * @see https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#put-K-V-
	 */
	Integer put(String key, Integer value);

	/**Same as base interface.
	 * Additionally: for each new entry, removes oldest entry if this map is full.
	 * @param map mappings to be stored in this map
	 * @see https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#putAll-java.util.Map-
	 */
	void putAll(Map<? extends String, ? extends Integer> map);

	/**Same as base interface.
	 * @param key keytype of map, not null.
	 * @return the previous value associated with key, or null if there was no mapping for key.
	 * @see https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#remove-java.lang.Object-
	 */
	Integer remove(Object key);

	/**Capacity (maximal number of entries).
	 * @return Capacity, not negative.
	 */
	int getLimit();

	public String toString();

}