import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SockMerchant {

	public static void main(String[] args) {
	     
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c[] = new int[n];
		int total = 0;
		Set<Integer> checkedData = new HashSet<>();
		for(int c_i = 0; c_i < n; c_i++){
			c[c_i] = in.nextInt();
			checkedData.add(c[c_i]);
		} 
		for(Integer input : checkedData){
			int pairCount = 0;
			int occurence = 0;
			for(int i = 0; i < c.length; i++){
				if(input == c[i]){
					occurence++;
				}
			}
			total = total + (int)(occurence/2);
		}
		System.out.println(total);
    }

}
