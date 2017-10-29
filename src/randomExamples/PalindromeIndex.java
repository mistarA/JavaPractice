package randomExamples;

import java.util.Scanner;

/**
 * Created by anandmishra on 21/02/17.
 */
public class PalindromeIndex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int j = 0; j < testCases; j++) {
            String s = in.next();
            StringBuilder temp = new StringBuilder(s);
            if (s.equals(temp.reverse().toString())) {
                System.out.println(-1);
                continue;
            }
            int length = s.length();
            int index = 0;
            for (int i = 0; i < length / 2; i++) {
                if (s.charAt(i) != s.charAt(length - i - 1)) {
                    StringBuilder sb1 = new StringBuilder(s).deleteCharAt(i);
                    StringBuilder sb2 = new StringBuilder(s).deleteCharAt(length - i - 1);
                    if( sb1.toString().equals(sb1.reverse().toString())){
                        index = i;
                    } else if(sb2.toString().equals(sb2.reverse().toString())){
                        index = length - i - 1;
                    }
                    break;
                }
            }
            System.out.println(index);
        }
    }
}
/*
* 5
bbb
cbca
aaab
baa
aaa
* */
