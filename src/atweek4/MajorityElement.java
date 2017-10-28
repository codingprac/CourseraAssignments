package atweek4;

import java.util.*;
import java.io.*;

public class MajorityElement {
	
	static int count = 0;
	
    private static int getMajorityElement(int[] a) {
    	
    	int left = 0;
    	int right = a.length;
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        
        int n = a.length;
        int halfN = n/2;
        
        int[] a1 = new int[halfN];
        int[] a2 = null;
        
        if(n%2==0)
        	a2 = new int[halfN];
        else
        	a2 = new int[halfN+1];
        
        for(int i=0;i<halfN;i++){
        	a1[i] = a[i]; 
        }
        for(int i=halfN;i<n;i++){
        	a2[i] = a[i];
        }
        
        if(getMajorityElement(a1) == getMajorityElement(a2)){
        	count++ ;
        }
        	
        
        return -1;
    }

    private static int getElement(long a[]){
    	
    	//int count[] = new int[a.length];
    	if(a.length==1){
    		return 1;
    	}
    	HashMap<Long, Long> map = new HashMap<Long, Long>();
    
    	for(int i=0;i<a.length;i++){
    		long count =1;
    		if(map.containsKey(a[i])){
    			count = map.get(a[i]);
    			count++;
    			map.put(a[i], count);
    			if(count>(a.length/2))
    				return 1;
    		}else
    			map.put(a[i], count);
    		
    		
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
        /*if (getMajorityElement(a) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }*/
        if (getElement(a) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

