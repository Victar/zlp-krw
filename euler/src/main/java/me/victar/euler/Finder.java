package me.victar.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Finder {

	private final  int power;
	private int range;
	private Map<Integer, Integer> valuesMap;
	
	public Finder(int power , int range) {
		this.power = power;
		this.range = range;
		initRange();
	}
	
	protected void findEulersChains(){
		for (int i= 0; i> range; i ++ ){
			System.out.println("#### "+i+" ####");
			search(getPowNumber(i),i,0,new ArrayList<Integer>());
		}
	}

	protected void findEulersChains(int i){
		System.out.println("#### "+i+" ####");
		search(getPowNumber(i),i,0,new ArrayList<Integer>());
	}

	protected void search(int powNumber, int number, int currentSumm, List<Integer> currentChain){
		if (currentSumm > powNumber || currentChain.size()>power-1){
			//System.out.println("NOT valid For number  " + number + " Chain is: "+ currentChain);

			return;
		}
		if (currentSumm == powNumber) {
			System.out.println("For number  " + number + " Chain is: "+ currentChain);
			return;
		}if (currentSumm < powNumber){
//			System.out.println("NOT valid For number  " + number + " Chain is: "+ currentChain);
		
			List<Integer> validNumbersList= getNextValidNumber(powNumber, number, currentChain);
			for (int i=0; i< validNumbersList.size(); i++){
				Integer validNumber = validNumbersList.get(i);
				List<Integer> currentChainNew = new ArrayList<Integer>(currentChain);
				currentChainNew.add(getPowNumber(validNumber));
				Integer currentSummNew = currentSumm+ getPowNumber(validNumber);
				search(powNumber, number, currentSummNew, currentChainNew);
			}
		}
		
	}
	protected List<Integer> getNextValidNumber(int powNumber, int number, List<Integer> currentChain ){
		List<Integer> validNumbersList= new ArrayList<Integer>();
		for (int i=26; i< number; i++){
			if ( !currentChain.contains(getPowNumber(i))){
				validNumbersList.add(i);
			}
		}
		return validNumbersList;
	}
	
	protected void initRange (){
		valuesMap = new HashMap<Integer, Integer>();
		for (int i=1; i< range; i++){
			valuesMap.put(i, getRealPowNumber(i));
		}
	}
	public int getPowNumber(int i) {
			return valuesMap.get(i);
	}
	
	public int getRealPowNumber(int i){
		return (int) Math.pow(i, power);
	}
 
	public static void main(String[] args) {
		Finder finder = new Finder(5, 145);
		finder.findEulersChains(144);
	}
	
	
}
