package atweek3;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
    	int count10=0,count5=0,rem10=0,count1=0;
    	int total=0;
    	if(m<5){
    		return m;
    	}
        if(m/10==0){
        	rem10=m;
        }else{
        	count10=m/10;
        	rem10=m%10;
        }
        if(rem10/5==0){
        	count1=rem10;
        }else{
        	count5=rem10/5;
        	count1=rem10%5;
        }
        total = count10+count5+count1;
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

