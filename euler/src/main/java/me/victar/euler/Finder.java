package me.victar.euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Finder {

	private final  int power;
	private int range;
	private Map<Integer, BigInteger> valuesMap;
	
	public Finder(int power , int range) {
		this.power = power;
		this.range = range;
		initRange();
	}
	
	protected void findEulersChains(){
		for (int i= 1; i< range; i ++ ){
			System.out.println("#### "+i+" ####");
			search(getPowNumber(i),i,BigInteger.ZERO,new ArrayList<BigInteger>());
		}
	}

	protected void findEulersChains(int i){
		System.out.println("#### "+i+" ####");
		search(getPowNumber(i),i,BigInteger.ZERO,new ArrayList<BigInteger>());
	}

	protected void search(BigInteger powNumber, int number, BigInteger currentSumm, List<BigInteger> currentChain){
		if (currentSumm.compareTo(powNumber)>0 || currentChain.size()>power-1){
			//System.out.println("NOT valid For number  " + number + " Chain is: "+ currentChain);

			return;
		}
		if (currentSumm.compareTo(powNumber) == 0) {
			System.out.println("For number  " + number + " Chain is: "+ currentChain);
			return;
		}if (currentSumm.compareTo(powNumber) < 0){
			List<Integer> validNumbersList= getNextValidNumber(powNumber, number, currentChain);
			for (int i=0; i< validNumbersList.size(); i++){
				Integer validNumber = validNumbersList.get(i);
				List<BigInteger> currentChainNew = new ArrayList<BigInteger>(currentChain);
				currentChainNew.add(getPowNumber(validNumber));
				BigInteger currentSummNew = currentSumm.add(getPowNumber(validNumber));
				search(powNumber, number, currentSummNew, currentChainNew);
			}
		}
		
	}
	protected List<Integer> getNextValidNumber(BigInteger powNumber, int number, List<BigInteger> currentChain ){
		List<Integer> validNumbersList= new ArrayList<Integer>();
		for (int i=0; i< number; i++){
			if ( !currentChain.contains(getPowNumber(i))){
				validNumbersList.add(i);
			}
		}
		return validNumbersList;
	}
	
	protected void initRange (){
		valuesMap = new HashMap<Integer, BigInteger>();
		for (int i=1; i< range; i++){
			valuesMap.put(i, getRealPowNumber(BigInteger.valueOf(i)));
		}
	}
	public BigInteger getPowNumber(int i) {
			return valuesMap.get(i);
	}
	
	public BigInteger getRealPowNumber(BigInteger number ){
		BigInteger result = number ;
		for (int i = 0; i< power-1; i ++){
			result = 	result.multiply(number);
		}
		return result;
	}
 
	public static void main(String[] args) {
		Finder finder = new Finder(5, 150);
		finder.findEulersChains(144);
//		finder.findEulersChains();
		
	}
	
	
}
