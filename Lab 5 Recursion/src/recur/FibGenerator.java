package recur;

public class FibGenerator {

	private int[] callCounter;
	
	public int nthFib(int n) {
		callCounter = new int[n+1];
		 return computeFibRecurse(n);
	}
	
	private int computeFibRecurse(int n) {
		callCounter[n]= callCounter[n]+1;
		if (n==1||n==2) {
			return 1;
		}
		else { //x>2
			return computeFibRecurse(n-1)+computeFibRecurse(n-2);
		}
	}
	
	public void PrintCallCounter() {
		for (int i=0;i<callCounter.length;i++) {
			System.out.println(callCounter[i]+" calls to fib("+i+")");
		}
}
	public static void main (String[] args) {
		FibGenerator current = new FibGenerator();
		
		System.out.println("Starting: \n");
		
//		for(int i =1;i<=20;i++) {
//			System.out.println(current.nthFib(i));
//		}
		
		current.nthFib(20);
		
		current.PrintCallCounter();
		
	}
	
}
