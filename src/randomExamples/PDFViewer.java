package randomExamples;

import java.util.Scanner;

public class PDFViewer {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] h = new int[26];
		for(int h_i=0; h_i < 26; h_i++){
			h[h_i] = in.nextInt();
		}
		String word = in.next();
		int totalWidth = word.length();
		int maxHeight = Integer.MIN_VALUE;
		for(int i = 0; i < word.length(); i++){
			int index = word.charAt(i) - 97;
			int height = h[index];
			if( height > maxHeight){
				maxHeight = height;
			}
		}
		System.out.println(totalWidth * maxHeight);
	}
}
