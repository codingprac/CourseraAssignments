package atweek3;

import java.util.*;
import java.util.stream.Collectors;

public class DotProduct {
	private static long minDotProduct(int[] a, int[] b) {

		long result = 0;

		if(a.length==1 && b.length==1){
			return a[0] * b[0];
		}

		/*for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				if(a[i] < a[j]){
					int tempValue = a[i];
					a[i] = a[j];
					a[j]=tempValue;
				}
				if(b[i] < b[j]){
					int tempValue = b[i];
					b[i] = b[j];
					b[j]=tempValue;
				}
			}
		}*/

		List<Integer> aTemp = Arrays.stream(a).boxed().collect(Collectors.toList());
		List<Integer> bTemp = Arrays.stream(b).boxed().collect(Collectors.toList());
		//List<int[]> bTemp = Arrays.asList(b); 

		for(int i=0;i<a.length;i++){
			int maxA = max(aTemp);
			int minB = min(bTemp);
			result += maxA * minB;
			remove(aTemp,maxA);
			remove(bTemp,minB);
		}

		/*for(int i=0;i<a.length;i++){
			if(a[i]<0){
				int maxB = max(bTemp);
				result += a[i] * maxB;
				remove(bTemp,maxB);
			}else{
				int minB = min(bTemp);
				result += a[i] * minB;
				remove(bTemp,minB);
			}
		}*/

		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = scanner.nextInt();
		}
		System.out.println(minDotProduct(a, b));
	}

	public static void remove(List<Integer> bTemp,int selValue){

		Iterator<Integer> itr = bTemp.iterator();
		while(itr.hasNext()){
			if((Integer)itr.next()==selValue){
				itr.remove();
				break;
			}
		}
	}

	public static int max(List<Integer> bTemp){
		int max = bTemp.get(0);
		for(Integer i : bTemp){
			if(max<(Integer)i)
				max=(Integer)i;
		}
		return max;
	}

	public static int min(List<Integer> bTemp){
		int min = bTemp.get(0);
		for(Integer i : bTemp){
			if(min>(Integer)i)
				min=(Integer)i;
		}
		return min;
	}
}

