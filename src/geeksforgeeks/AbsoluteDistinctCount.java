package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anandmishra on 08/06/17.
 */
public class AbsoluteDistinctCount {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0 ; i < testCases; i++) {
            int size = scan.nextInt();
            List<Integer> numbers = new ArrayList<Integer>();
            for (int j = 0; j < size; j++){
                int number = Math.abs(scan.nextInt());
                if (!numbers.contains(number)){
                    numbers.add(number);
                }
            }
            System.out.println(numbers.size());
        }
    }
}
