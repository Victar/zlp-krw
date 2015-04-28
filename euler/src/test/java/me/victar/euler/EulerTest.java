package me.victar.euler;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class EulerTest {

	@Test
	public void getEuler(){
		assertEquals(new Euler(5).getPower(), 5);
	};
	
	@Test
	public void getEulerNumberPowered(){
		assertEquals(new Euler(2).getPower(), 2);
		assertEquals(new Euler(2).getPowNumber(5), 25);
		assertEquals(new Euler(3).getPowNumber(3), 27);
	}
	@Test
	public void findCourtegeMinLength(){
		assertEquals(new Euler(2).getCortegeMinLength(), 2);
	}
	
	@Test
	public void checkCouregeSum(){
		Map map = new HashMap<Integer, Integer>();
		map.put(2, 4);
		map.put(3, 9);
		
		assertEquals(new Euler(2).getCortegeSum(map), 13);
	}
	@Test
	public void findCourtege(){
		assertArrayEquals(new Euler(2).getCortege(5), new int[]{3,4});
	//	assertArrayEquals(new Euler(2).getCortege(10), new int[]{6,8});

	}
	
}
