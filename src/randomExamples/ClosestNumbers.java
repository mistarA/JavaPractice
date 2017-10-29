package randomExamples;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClosestNumbers {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named randomExamples.Solution. */
		Scanner in = new Scanner(System.in);
		List<Integer> inputList = new ArrayList<>();
		int n = in.nextInt(); // size of array
		int[] a = new int[n];
		for(int a_i=0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
		}
		int lowest = 999999;
		for(int i = 0; i < a.length; i++){
			int min = -999999;
			for( int j = i+1; j < a.length; i++){
				int diff = a[i]-a[j];
				if (min > diff){
					min = diff;
				}	
			}
			if( min < lowest){
				lowest = min;
			}
			
		}
	}
}
