package me.victar.euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Euler conjecture checker for power in special range
 *
 */
public class Euler {


	private final int power;
	private final int minRange = 1;
	private final int maxRange;

	private Map<Integer, BigInteger> map;

	public Euler(int power, int maxRange) {
		this.power = power;
		this.maxRange = maxRange;
		initMap();
	}

	private void initMap(){
		map=new HashMap<Integer, BigInteger>();
		for (int i=minRange; i<maxRange;i++){
			map.put(i,pow(i));
		}
	}

	public boolean isInRange(int i) {
		return i>=minRange&&i<=maxRange;
	}

	public BigInteger pow(int i){
		return new BigInteger(String.valueOf(i)).pow(power);
	}


	public boolean hasEuler(int pretender) {
		if (!isInRange(pretender) ){
			throw new IllegalStateException(String.format("Numbers: %s, Must be in range [%s, %s] ", pretender ,minRange,maxRange));
		}
		return search(getCachedPow(pretender),pretender,BigInteger.ZERO,new ArrayList<BigInteger>());

	}

	protected boolean search(BigInteger powNumber, int number, BigInteger currentSumm, List<BigInteger> currentChain){
		if (currentSumm.compareTo(powNumber)>0 || currentChain.size()>power-1){

			return false;
		}
		if (currentSumm.compareTo(powNumber) == 0) {
			System.out.println("For number  " + number + " Chain is: "+ currentChain);
			return true;
		}if (currentSumm.compareTo(powNumber) < 0){
			List<Integer> validNumbersList= getNextValidNumber(powNumber, number, currentChain);
			for (int i=0; i< validNumbersList.size(); i++){
				Integer validNumber = validNumbersList.get(i);
				List<BigInteger> currentChainNew = new ArrayList<BigInteger>(currentChain);
				currentChainNew.add(getCachedPow(validNumber));
				BigInteger currentSummNew = currentSumm.add(getCachedPow(validNumber));
				boolean find = search(powNumber, number, currentSummNew, currentChainNew);
				if (find){
					return true;
				}
			}
		}
		return false;

	}

	protected List<Integer> getNextValidNumber(BigInteger powNumber, int number, List<BigInteger> currentChain ){
		List<Integer> validNumbersList= new ArrayList<Integer>();
		for (int i=minRange; i< number; i++){
			if ( !currentChain.contains(getCachedPow(i))){
				validNumbersList.add(i);
			}
		}
		return validNumbersList;
	}

	protected BigInteger getCachedPow(int i){

		return map.get(i);
	}

}
