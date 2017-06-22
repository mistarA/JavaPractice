import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RightCircularArray {


	public static void main(String args[]){

		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // size of array
		int k = in.nextInt(); // no of rotations
		int q = in.nextInt(); // no of queries
		List<Integer> inputList = new ArrayList<>();
		for(int a_i=0; a_i < n; a_i++){
			inputList.add(in.nextInt());
		}
		if(k >= n){
			k = k % n;
		} 
		while(k != 0){
			int temp =  inputList.get(n-1);
			inputList.add(0,temp);
			inputList.remove(inputList.size()-1);
			k--;
		} 
		for(int a0 = 0; a0 < q; a0++){			
			System.out.println(inputList.get(in.nextInt()));
		}

	}
}

//Shifting array
//Scanner in = new Scanner(System.in);
//int n = in.nextInt(); // size of array
//int k = in.nextInt(); // no of rotations
//int q = in.nextInt(); // no of queries
//int[] a = new int[n];
//for(int a_i=0; a_i < n; a_i++){
//	a[a_i] = in.nextInt();
//}
//if(k >= n){
//    k = k % n;
//} 
//while(k != 0){
//	int temp =  a[n-1];
//    for (int i = n-1; i >= 1; i--){
//	     a[i] = a[i-1];
//	}
//    a[0] = temp;
//	k--;
//} 
//for(int a0 = 0; a0 < q; a0++){			
//	System.out.println(a[in.nextInt()]);
//}
