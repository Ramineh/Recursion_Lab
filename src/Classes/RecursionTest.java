package Classes;

public class RecursionTest extends Pair{
	RecursionTest rt=new RecursionTest();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
 long begTime= System.nanoTime();
 fib(50);
 long endTime= System.nanoTime();
 long difference=endTime-begTime;
 System.out.print("The Execution speed for fib(n) algorithm is: " +difference);

 
 long begTime2= System.nanoTime();
 fib1(50);
 long endTime2= System.nanoTime();
 long difference2=endTime2-begTime2;
 System.out.print("\nThe Execution speed for fib(n) algorithm using Pair object is: " +difference2);

	}

	private static Long fib(int n) {
		if (n==1 || n==0) return (long) 1;
		else
			return fib (n-1) + fib (n-2);

	}
	private static Pair fib1 (int n) {
		if (n==0 || n==1) return new Pair(1, 1);
		Pair <Integer>p= fib1 (n-1);
		return new Pair((p.getFirst()+p.second()), p.getFirst());
		
	}
}
