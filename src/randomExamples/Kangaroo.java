package randomExamples;

import java.util.Scanner;

public class Kangaroo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int v1 = in.nextInt();
		int x2 = in.nextInt();
		int v2 = in.nextInt();       
		if(x1 < x2 && v1 < v2){
			System.out.println("NO");
			System.exit(0);
		}
		while(x1 != x2){
			//0 2 5 3
			x1 = v1 + x1;
			x2 = v2 + x2;
			if(x1 == x2){
				System.out.println("YES");
				break;
			}
		}
	}
}
