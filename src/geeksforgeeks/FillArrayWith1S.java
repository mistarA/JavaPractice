package geeksforgeeks;

import java.util.Scanner;

/**
 * Created by anandmishra on 08/06/17.
 */
public class FillArrayWith1S {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0 ; i < testCases; i++) {
            int size = scan.nextInt();
            int[] numbers = new int[size];
            for (int k = 0; k < size; k++){
                numbers[k] = scan.nextInt();
            }
            scan.nextLine();
            int count = 0;
            boolean areAllOne = true;
            for (int j = numbers.length + 1; j < size -1; j++) {
                    if (numbers[j] == 1){
                        numbers[j-1] = 1;
                        numbers[j+1] = 1;
                    } else{
                        areAllOne = false;
                    }
            }
        }
    }
}
