package randomExamples;

import java.util.Scanner;

//Can do easily with String, but wanted to learn this way also
public class ReverseNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int count = 0;
        for(int m = i; m <= j; m++){
            int number = m;
            int value = m;
            int reversednumber = 0;
             while(number > 9){
                int rem = number % 10;
                reversednumber = reversednumber * 10 + rem; 
                number = (int)number / 10;
             }
             reversednumber = reversednumber * 10 + number; 
             if(Math.abs(value - reversednumber) % k == 0){
                count++;
             }
        }
        System.out.println(count);
	}
}
