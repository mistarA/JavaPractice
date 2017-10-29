package randomExamples;

import java.math.BigInteger;
import java.util.Scanner;

public class MiniMaxiSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long[] a = new long[5];
		for( int i =0; i< 5; i++){
			a[i] = in.nextLong();
		}
		long minSum = Long.MAX_VALUE;
		long maxSum = Long.MIN_VALUE;
		for( int i = 0; i< 5; i++){
			long temp = 0;
			for( int j = 0; j < 5; j++){
				if( i != j){
					temp = temp + a[j];
				}
			}
			if(temp < minSum){
				minSum = temp;
			}
			if(temp > maxSum){
				maxSum = temp;
			}
		}
		System.out.print(minSum +" "+ maxSum);
	}

}
