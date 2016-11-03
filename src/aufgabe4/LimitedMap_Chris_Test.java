package aufgabe4;

import static org.junit.Assert.*;

//import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class LimitedMap_Chris_Test {
	
	private LimitedMap map;
	/*
	public LimitedMap_Chris_Test(LimitedMap map){
		this.map = map;
	}*/
	
	
	private LimitedMap create(int start, int end){
		
		LimitedMap mop = new LimitedStringToIntMap((end - start)+1);
		for (int i = start; i <= end; i++){
			mop.put(Integer.toString(i), i);
		}
		return mop;
	}
	
	/**
	 * SetUp vor jedem Test LimitedStringToIntMap mit 1-1 bis 5-5. Kapazität: 5.
	 */
	@Before
	public void SetUp(){
		//map = new LimitedStringToIntMap(5);
		map = create(1, 5);
		/*map.put("1" , 1);
		map.put("2" , 2);
		map.put("3" , 3);
		map.put("4" , 4);
		map.put("5" , 5);*/
	}
	
	/**
	 * constructor tests.
	 */
	@Test (expected=IllegalArgumentException.class)
	public void constructor_negativeInput_thenException_test(){
		@SuppressWarnings("unused")
		LimitedMap map = new LimitedStringToIntMap(-1);
	}
	@Test (expected=IllegalArgumentException.class)
	public void constructor_zeroAsInput_nowPut_test(){
		LimitedMap have = new LimitedStringToIntMap(0);
		have.put("1", 1);
		
		LimitedMap want = new LimitedStringToIntMap(0);
		
		//assertEquals(want, have);
		
	}
	
	
	
	/**
	 * clear tests.
	 */
	@Test 
	public void clear_test(){
		//Arange
		LimitedMap want = new LimitedStringToIntMap(5);
		//Act
		map.clear(); 
		LimitedMap have = map;
		
		//Assert
		assertEquals(want, have);
		
	}
	@Test
	public void clear_isEmpty_test(){
		map.clear();
		LimitedMap have = map;
		
		assertTrue(have.isEmpty());	
	}
	
	
	
	
	
	/**
	 * containsKey tests.
	 */
	@Test
	public void containsKey_true_test(){
		//Arange
		//boolean want = true;
		
		//Act
		boolean have = map.containsKey("1");
		
		//assert
		assertTrue(have);
		
	}
	@Test
	public void containsKey_false_test(){
		boolean have = map.containsKey("9");
		assertFalse(have);
	}
	@Test
	public void containsKey_true_isNewest_test(){
		//Arange
		LimitedMap want = create(1, 5);
		want.put("1", 1);
		
		//Act
		map.containsKey("1");
		LimitedMap have = map;
		
		//Assert
		assertEquals(want, have);
	}
	@Test
	public void containsKey_true_alreadyNewest_test(){
		//Arange
		LimitedMap want = create(1,5);
		
		//Act
		map.containsKey("5");
		LimitedMap have = map;
		
		//Assert
		assertEquals(want, have);
	}
	@Test
	public void containsKey_false_mapEquals_test(){
		//Arange
		LimitedMap want = create(1,5);
		
		//Act
		map.containsKey("9");
		LimitedMap have = map;
		
		//Assert
		assertEquals(want, have);
	}
	
	/**
	 * putAll tests.
	 */
	@Test
	public void putAll_capacity_LessThan_InputMap_only_new_Entries_test(){
		//Arange
		LimitedMap want = create(11,15);
		LimitedMap insert = create(6,15);
		//Act
		map.putAll(insert);
		LimitedMap have = map;
		//System.out.println(map);
		//Assert
		assertEquals(want, have);
	}
	@Test
	public void putAll_capacity_GreaterThan_InputMap_test(){
		//arange
		LimitedMap want = create(1,5);
		want.put("6", 6);
		want.put("7", 7);
		
		LimitedMap insert = create(6,7);
		
		//act
		map.putAll(insert);
		LimitedMap have = map;
		
		//assert
		assertEquals(want,have);
	}
	
	/**
	 * Tests if the insertion of an empty map changes anything in the tested map
	 */
	@Test
	public void putAll_EmptyMap_Then_NoChange(){
		LimitedMap lmap = new LimitedStringToIntMap(1); 
		int size = map.size();
		SetUp();
		map.putAll(lmap);
		assertEquals(size , map.size()); 
	}
	
	/**
	 * get tests.
	 */
	@Test
	public void get_alreadyInMap_test(){
		//arange
		int want = 1;
		//act
		int have = map.get("1");
		//assert
		assertEquals(want, have);
	}
	@Test
	public void get_notInMap_test(){
		assertNull(map.get("9"));
	}
	@Test
	public void get_isNewest_test(){
		//Arange
		LimitedMap want = create(1,5);
		want.put("1", 1);
				
		//act
		map.get("1");
		LimitedMap have = map;
		
		//assert
		assertEquals(want, have);
	}
	
	/**
	 * put tests.
	 */
	@Test
	public void put_String_1_notAlreadyInMap_test(){
		//arange
		//int want = (Integer) null;
		
		//act
		//int have = map.put("String", 1);
		
		//assert
		assertNull(map.put("String", 1));
	}
	
	@Test
	public void put_1_2_AlreadyInMap_test(){
		//arange
		int want = 1;
		
		//act
		int have = map.put("1", 4);
		
		//assert
		assertEquals(want, have);
	}
	
	@Test
	public void put_notFull_sameKey_thenKeyNewest_test(){
		LimitedMap have = new LimitedStringToIntMap(2);
		have.put("1", 1);
		have.put("2", 2);
		have.put("1", 1);
		have.put("3", 3);
		System.out.println(have);
		
		
		LimitedMap want = new LimitedStringToIntMap(2);
		want.put("2", 2);
		want.put("1", 1);
		want.put("3", 3);
		
		System.out.println(want);
		assertEquals(want, have);
	}
	
	/**
	 * remove tests.
	 */
	@Test
	public void remove_AlreadyInMap_test(){
		//arange
		int want = 1;
		
		//act
		int have = map.remove("1");
		
		//assert
		assertEquals(want, have);
	}
	
	@Test
	public void remove_notInMap_test(){
		assertNull(map.remove("9"));
	}
	
	
	
	
	
	/**
	 * getLimit tests.
	 */
	@Test
	public void getLimit_test(){
		int want = 5;
		int have = map.getLimit();
		assertEquals(want, have);
	}

}
