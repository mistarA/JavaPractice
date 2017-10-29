package randomExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anandmishra on 19/02/17.
 */
public class TwoCharacters {

    //106
    //muqqzbcjmyknwlmlcfqjujabwtekovkwsfjrwmswqfurtpahkdyqdttizqbkrsmfpxchbjrbvcunogcvragjxivasdykamtkinxpgasmwz
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        int maxLength = Integer.MIN_VALUE;
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (!characters.contains(s.charAt(i))) {
                characters.add(s.charAt(i));
            }
        }

        System.out.println(characters);
        for (int i = 0; i < characters.size() - 1; i++) {
            String temp = s;
            char char1 = characters.get(i);
            for (int j = i + 1; j < characters.size(); j++) {
                char char2 = characters.get(j);
                if (char1 != char2) {
                    String value = removeRestInString(temp, char1, char2);
                    if (isValid(value)) {
                        if (value.length() > maxLength) {
//                            System.out.println("maxLength " + value);
                            maxLength = value.length();
                        }
                    }
                }
            }
        }
        if (maxLength == Integer.MIN_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(maxLength);
        }
    }

    public static boolean isValid(String s) {

        boolean isValid = true;
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!characters.contains(s.charAt(i))) {
                characters.add(s.charAt(i));
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isValid = false;
                break;
            }
        }
//        System.out.println(" string " + s + " length " + characters.size());
        return isValid && characters.size() == 2;
    }

    public static String removeRestInString(String str, Character ch1, Character ch2) {
//        System.out.print("removeString  "+str+" chars  "+ch1 +" "+ch2);
        StringBuilder sbr = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (c == ch1 || c == ch2) {
                sbr = sbr.append(String.valueOf(c));
            }
        }
//        System.out.println("  "+sbr);
        return sbr.toString();
    }
}
