package geeksforgeeks;

import java.util.Scanner;

/**
 * Created by anandmishra on 07/06/17.
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0 ; i < testCases; i++) {
            String input = scan.nextLine();
            if (!input.contains(" ")){
                System.out.println(input.length());
                continue;
            }
            if (input.length() == 0){
                System.out.println(0);
                continue;
            }
            int index = input.lastIndexOf(" ");
            int length = input.substring(index+1).length();
            System.out.println(length);
        }
    }
}
