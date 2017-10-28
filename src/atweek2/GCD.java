package atweek2;
import java.util.*;

public class GCD {
	private static int gcd(int a, int b) {
		int current_gcd = 1;
		for(int d = 2; d <= a && d <= b; ++d) {
			if (a % d == 0 && b % d == 0) {
				if (d > current_gcd) {
					current_gcd = d;
				}
			}
		}

		return current_gcd;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		System.out.println(fastGCD(a, b));
	}

	private static long fastGCD(long a, long b){
		long current_gcd = 1;
		if(b==0)
			return a;
		long upper = a;
		long lower = b;
		long rem = 0;
		if(a<b){
			upper = b;
			lower = a;
		}
		do{
			if(upper==0)
				return lower;
			rem = upper%lower;
			if(rem==0)
				return lower;
			//System.out.println("Rem : "+rem+" Upper%Lower : "+upper+" % "+lower);
			upper=lower;
			//System.out.println("Upper : "+upper);
			lower=rem;
			//System.out.println("Lower : "+rem);
			
		}while(upper%rem!=0);
		current_gcd=rem;

		/*for(int d = 2; d <= a && d <= b; ++d) {

	  }*/
		return current_gcd;
	}

}
