package me.victar.zlpkrw.lambda;

public class Calculator {

	interface Operation{
		int operation (int a, int b);
	}
	
	public void calculate(int a, int b, Operation operation){
		System.out.println("a : " + a + "  b: "+b+ " operation: " + operation.operation(a, b));
	}

	public static void main (String[] args){
		Operation plus = (a,b)->a+b;
		Operation minus = (a,b)->a-b;
		Calculator test = new Calculator();
		test.calculate(10, 15, plus);
		test.calculate(10, 15, minus);
		
	}
}
