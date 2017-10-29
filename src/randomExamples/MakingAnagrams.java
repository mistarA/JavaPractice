package randomExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anandmishra on 21/02/17.
 */
public class MakingAnagrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        List<Integer> inputs1 = new ArrayList<>();
        List<Integer> inputs2 = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            inputs1.add((int) str1.charAt(i));
        }
        for (int i = 0; i < str2.length(); i++) {
            inputs2.add((int) str2.charAt(i));
        }
        for (int i = 97; i <= 122; i++) {
            int freq1 = Collections.frequency(inputs1, i);
            int freq2 = Collections.frequency(inputs2, i);
            if (freq1 == freq2) {
                continue;
            }
            if (freq1 == 0 || freq2 == 0) {
                count = count + freq2 + freq1;
            }
            if (freq1 != 0 && freq2 != 0 && freq1 >= 1 && freq2 >= 1) {
                count = count + Math.abs(freq2 - freq1);
            }
        }
        System.out.println(count);
    }
}

