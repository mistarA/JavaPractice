package randomExamples;

import java.util.Scanner;

//7 11
//5 15
//3 2
//-2 2 1
//5 -6

public class ApplesAndOranges {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();
		int sumApples = 0;
		int sumOranges = 0;
		for(int apple_i=0; apple_i < m; apple_i++){
			int position = in.nextInt();
			int range = position +a;
			if(range >= s && range <= t){
				sumApples++;
			}	
		}
		for(int orange_i=0; orange_i < n; orange_i++){
			int position = in.nextInt();
			int range = position + b;
			if(range >= s && range <= t){
				sumOranges++;
			}		
		}
		System.out.print(sumApples + "\n" + sumOranges);
	}
}
