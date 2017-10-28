package atweek2;
import java.util.*;

public class LCM {
  private static long lcm(int a, int b) {
	int current_lcm = 1;
	//HashSet<Integer> set = new HashSet<Integer>();
	/*int arr[] = new int[a];
	int i=0;
	for(int d=2;d<a ;d++){
		if(a%d==0 || b%d==0){
			arr[i]=d;
			i++;
		}
	}
	for(int j=0;j<arr.length;j++){
		if(arr[j]!=0){
			current_lcm = current_lcm * arr[j];
		}
	}*/
	int[] div={};
    return current_lcm;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(fastLCM(a, b));
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
  
  private static double fastLCM(int a, int b){
	  double current_lcm = 1;
	  double temp=a*b;
	  current_lcm = temp/fastGCD(a, b);
	  return current_lcm;
  }
}
