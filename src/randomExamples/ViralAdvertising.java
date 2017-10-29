package randomExamples;

import java.util.Scanner;

public class ViralAdvertising {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int days = scanner.nextInt();
		System.out.println(days);

	}
	private int solve(int days){
		int numberLiked = 2;
		while(days != 0){
			int shares = numberLiked * 3;
			numberLiked = numberLiked + Math.floorDiv(shares, 2);
			days--;
		}
		return numberLiked;
	}
}
