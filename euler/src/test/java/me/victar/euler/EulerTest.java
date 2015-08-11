package me.victar.euler;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class EulerTest {


	@Test
	public void isInRange(){
		Euler euler = new Euler(3, 50);
		assertTrue(euler.isInRange(0));
		assertFalse(euler.isInRange(52));
	}

	@Test
	public void pow(){
		Euler euler = new Euler(2, 50);
		assertEquals(new BigInteger("4"),euler.pow(2));
		assertEquals(new BigInteger("25"),euler.pow(5));
		Euler euler3 =new Euler(3,50);
		assertEquals(new BigInteger("27"), euler3.pow(3));
		assertEquals(new BigInteger("64"), euler3.pow(4));
		Euler euler10 = new Euler(10,50);
		assertEquals(new BigInteger("1024"), euler10.pow(2));
		assertEquals(new BigInteger("59049"), euler10.pow(3));

	}
	@Test
	public void isEulerChain(){
		Euler euler = new Euler(3, 50);
		assertTrue(euler.hasEuler(6));

	}

}
