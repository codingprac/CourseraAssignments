package atweek4;

import java.io.*;
import java.util.*;

public class BinarySearch {

	static long binarySearch(long[] a, int low, int high, long x) {
		//int low = 0, high = a.length;
		long out = -1;

		if(high<low)
			return out;

		if(a[low]==x)
			return low;
		if(a[high]==x)
			return high;
		
		if((high-low)==1){
			if(a[low]==x)
				return low;
			else if(a[high]==x)
				return high;
			else
				return out;
		}
		
		if(high==low && a[low]==x){
			return low;
		}else if(high==low && a[low]!=x)
			return out;

		int mid=low+(high-low)/2;

		if(a[mid] == x)
			return mid;
		else if(x < a[mid]){
			return binarySearch(a, low, mid-1, x);
		}else
			return binarySearch(a, mid+1, high, x);
	}

	static int linearSearch(int[] a, int x) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextLong();
		}
		int m = scanner.nextInt();
		long[] b = new long[m];
		for (int i = 0; i < m; i++) {
			b[i] = scanner.nextLong();
		}
		for (int i = 0; i < m; i++) {
			//replace with the call to binarySearch when implemented
			//System.out.print(linearSearch(a, b[i]) + " ");
			System.out.print(binarySearch(a, 0, a.length-1, b[i]) + " ");
		}
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
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}
