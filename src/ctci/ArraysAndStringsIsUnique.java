package ctci;

import java.util.Scanner;

/**
 * Created by anandmishra on 09/07/17.
 */
public class ArraysAndStringsIsUnique {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (Character c : input.toCharArray()){
            if (frequencyOfCharacter(input, c) > 1){
                System.out.print("Not Unique");
                System.exit(0);
            }
        }
        System.out.print("Unique");
    }

    public static int frequencyOfCharacter(String value, Character c){
        int count = 0;
        for (Character x : value.toCharArray()){
            if (x.equals(c)){
                count++;
            }
        }
        return count;
    }
}
