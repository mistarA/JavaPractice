package ctci;

import java.util.Scanner;

/**
 * Created by anandmishra on 09/07/17.
 */
public class AAndSCheckPermutation {

    //First check if length are different. If not print false for obvious reasons
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        if (input1.length() != input2.length()){
            System.out.print("Not Permutation of one another");
            System.exit(0);
        }
        if (sumOfCharacters(input1.toLowerCase()) == sumOfCharacters(input2.toLowerCase())){
            System.out.print("Is Permutation of one another");
        } else {
            System.out.print("Not Permutation of one another");
        }
    }

    private static int sumOfCharacters(String value) {
        int sum = 0;
        for (Character c : value.toCharArray()) {
            sum = sum + c;
        }
        return sum;
    }
}
