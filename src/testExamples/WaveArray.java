package testExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.isDigit;

public class WaveArray {

    public static void main(String[] args) {

        int[] arr = {10, 5, 6, 3, 2, 20, 100, 80};
        int[] arr1 = {20, 10, 8, 6, 4, 2};
        int[] arr2 = {2, 4, 6, 8, 10, 20};
        int[] arr3 = {3, 6, 5, 10, 7, 20};


        // 10 5 6 3 2 20 100 80
        // 2 3 5 6 10 20 80 100 - Sorting
        //3 >= 2 <= 6 >= 5 <= 20 >= 10 <= 100 >= 80

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i = i + 2) {
            arr[i] = arr[i] + arr[i + 1];
            arr[i + 1] = arr[i] - arr[i + 1];
            arr[i] = arr[i] - arr[i + 1];
        }

        //System.out.println(Arrays.toString(arr));
        System.out.println(isPalindrome(""));

    }

    static int isPalindrome(String A) {
        A = "abba";
        A = A.toLowerCase();
        List<Character> occurences = new ArrayList<>();
        A = A.replaceAll(" ", "");
        boolean ifAllSpecialCharacters = true;
        for (Character character : A.toCharArray()) {
            if ((character >= 97 && character <= 122) || Character.isDigit(character)) {
                if (ifAllSpecialCharacters) {
                    ifAllSpecialCharacters = false;
                }
                if (occurences.contains(character)) {
                    occurences.remove(character);
                } else {
                    occurences.add(character);
                }
            }
        }
        System.out.println(occurences);
        if (occurences.size() <= 1 || ifAllSpecialCharacters) {
            return 1;
        } else {
            return 0;
        }
    }
}
