package randomExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anandmishra on 21/02/17.
 */
public class CommonChild {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        List<Character> inputs1 = new ArrayList<>();
        List<Character> inputs2 = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            inputs1.add(str1.charAt(i));
        }
        for (int i = 0; i < str2.length(); i++) {
            inputs2.add(str2.charAt(i));
        }
        System.out.println(inputs1);
        System.out.println(inputs2);
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < inputs1.size(); i++) {
            StringBuilder sb = new StringBuilder();
            char character = inputs1.get(i);
            if (inputs2.contains(character)) {
                for (int j = inputs2.indexOf(character); j < inputs2.size(); j++) {
                    if (character == inputs2.get(j)){
                        sb = sb.append(character);
                        break;
                    }
                }
            }
            System.out.println(String.valueOf(character)+": "+sb);
            if(sb.length() > maxLength){
                maxLength = sb.length();
            }
        }
        System.out.println(maxLength);
        /*inputs1.retainAll(inputs2);
        inputs2.retainAll(inputs1);
        System.out.println(inputs1);
        System.out.println(inputs2);
        for (int i = 65; i <= 90; i++){
            int j = inputs1.indexOf(i);
        }*/
    }
}

/*
SHINCHAN
NOHARAAA

  HNHAN
  NHAAAA
*
* */

