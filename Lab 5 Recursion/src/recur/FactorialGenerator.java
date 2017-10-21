package recur;


public class FactorialGenerator {
	
	public double nthFactorial(int n) {
		return computeFactorialRecurse(n);
	}
	private double computeFactorialRecurse(int n) {
		if(n<0) {
			assert n>= 0 : "Illegal n: " + n;
		}
		if (n ==0)
			return 1;
		else {
	
			return n*(computeFactorialRecurse(n-1));	
		
		}
		
		
		
	}
	public static void main (String[] args) { 
		FactorialGenerator generator = new FactorialGenerator();
		System.out.println(generator.nthFactorial(-1));

		for(int i =1;i<=32;i++) {
			System.out.println(i+":"+generator.nthFactorial(i));
		}
		System.out.println("Long max value is: "+ Long.MAX_VALUE);
		
		
		
		
		
		
		
	}

}
