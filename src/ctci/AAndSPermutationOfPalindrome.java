package ctci;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anandmishra on 11/07/17.
 */
public class AAndSPermutationOfPalindrome {


    // tactcoa  tacocat
    // abcccba
    public static void main(String[] args) {
        List<Character> characters = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++){
            char val = input.charAt(i);
            if (characters.contains(val)){
                characters.remove(characters.indexOf(val));
            } else{
                characters.add(val);
            }
        }
        if (characters.size() == 1 || characters.size() == 0){
            System.out.print("Yes");
        } else{
            System.out.print("No");
        }
    }
}
