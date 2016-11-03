package aufgabe4;

import java.util.HashMap;
import java.util.Map;

/**
 * Application for LimitedStringToIntMap.
 * @author christian
 *
 */
public class LimitedApp {
	
	/**
	 * Mainmethode.
	 * @param args Kommandozeile Argumente.
	 */
	public static void main(String[] args){
		/**
		 * TestMap.
		 */
		final LimitedMap testMap = new LimitedStringToIntMap(4);

		System.out.println(testMap + "" + testMap.getLimit());
		
		// CHECKSTYLE:OFF MagicNumber
		testMap.put("Test1", 1);
		testMap.put("Test2", 2);
		testMap.put("Test3", 3);
		//TestMap.put("Test4", 4);
		System.out.println(testMap);
		
		//System.out.println(TestMap.get("Test2"));
		//System.out.println(TestMap);

		//System.out.println(TestMap.containsKey("Test1"));
		
		final Map<String, Integer> addMap = new HashMap<String, Integer>();
		addMap.put("Add1", 11);
		addMap.put("Add2", 12);
		addMap.put("Add3", 13);
		//addMap.put("Add4", 14);
		
		testMap.putAll(addMap);
		System.out.println(testMap);
		
	}
}
