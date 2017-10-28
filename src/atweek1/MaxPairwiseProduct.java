package atweek1;
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {

	Random rand = new Random();

	static long getMaxPairwiseProduct(int[] numbers) {
		long result = 0;
		int n = numbers.length;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if ((long)numbers[i] * numbers[j] > result) {
					result = numbers[i] * numbers[j];
				}
			}
		}
		return result;
	}

	static long getMaxPairwiseProductFast(int[] numbers) {
		long result = 0;
		int max=0;
		int maxIndex1=-1;
		int secondMax=0;

		for(int i=0; i<numbers.length; i++){
			if(numbers[i] >= max){
				max=numbers[i];
				maxIndex1 = i;
			}
		}
		
		//System.out.println("MaxIndex 1 : "+maxIndex1);

		for(int i=0; i<numbers.length; i++){
			if(i!=maxIndex1 && numbers[i] > secondMax){
				secondMax=numbers[i];
			}
		}
		
		//System.out.println("MaxIndex 2 : "+maxIndex2);
		//System.out.println(max+" - "+secondMax);
		result = (long)max * secondMax;
		return result;
	}

	public static void main(String[] args) {


		/*long res1=0;
		long res2=0;

		while(true){
			int arr[] = new MaxPairwiseProduct().testGenerator();
			res1 = getMaxPairwiseProduct(arr);
			res2 = getMaxPairwiseProductFast(arr);
			if(res1!=res2){
				System.out.println();
				System.out.println("Wrong Answer");
				System.out.println(res1+" - "+res2);
				break;
			}else
				System.out.println("OK");
		}*/
		FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
	}

	public int[] testGenerator(){
		int n = rand.nextInt((5 - 2) + 1) + 2;
		System.out.println(n);

		int[] arr = new int[n];

		for(int i=0; i<n ; i++){
			int randNum = rand.nextInt((9 - 0) + 1) + 0;
			arr[i] = randNum;
		}

		for(int i=0; i<arr.length ; i++)
			System.out.print(arr[i]+" ");
		System.out.println();

		return arr;
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}