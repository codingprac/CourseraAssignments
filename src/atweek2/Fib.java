package atweek2;
import java.util.Scanner;

public class Fib {

	static long[] arr = null;	
	private static long calc_fib(long n) {
		if (n <= 1)
			return n;

		return calc_fib(n - 1) + calc_fib(n - 2);
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		//System.out.println(calc_fib(n));
		arr = new long[(int)n+1];
		//System.out.println(fibFast(n));
		System.out.println(fibLastDigit(n));
		in.close();
	}

	private static long fibFast(long n){
		for(int i=0;i<=n;i++){
			if(i<=1)
				arr[i]=i;
			else
				arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[(arr.length-1)];
	}
	
	private static long fibLastDigit(long n){
		long lastDigit = fibFast(n);
		System.out.println(lastDigit);
		lastDigit = lastDigit%10;
		return lastDigit;
	}
}
