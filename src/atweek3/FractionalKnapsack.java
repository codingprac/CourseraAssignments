package atweek3;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.*;

public class FractionalKnapsack {
		
	private static double getOptimalValue(double capacity, double[] values, double[] weights) {
		double value = 0;		
		double fracWeight = 0;

		for(int i=0;i<values.length;i++){
			for(int j=0;j<values.length;j++){
				if(values[i]/weights[i] > values[j]/weights[j]){
					double tempValue = values[i];
					double tempWeight = weights[i];
					values[i] = values[j];
					weights[i] = weights[j];
					values[j]=tempValue;
					weights[j]=tempWeight;
				}
			}
		}
		
		for(int i=0;i<values.length;i++){
			if(capacity==0)
				return value;
			fracWeight = minWeight(weights[i],capacity);
			value = value + fracWeight*(values[i]/weights[i]);
			weights[i] = weights[i] - fracWeight;
			capacity = capacity - fracWeight;
		}
		
		return value;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		double capacity = scanner.nextInt();
		double[] values = new double[n];
		double[] weights = new double[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
			weights[i] = scanner.nextInt();
		}
		System.out.println(String.format("%.4f",getOptimalValue(capacity, values, weights)));
	}
	
	public static double minWeight(double weight, double capacity){
		if(weight<=capacity){
			return weight;
		}else{
			return capacity;
		}
	}
} 
