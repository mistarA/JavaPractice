package randomExamples;

import java.util.Scanner;

/**
 * Created by anandmishra on 21/02/17.
 */
public class BeautifulBinaryString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String s = in.next();
        int count = 0;
        if (!s.contains("010")) {
            System.out.println(0);
        }
        for (int i = 0; i < length - 2; ) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i + 1) == '1') {
                    if (s.charAt(i + 2) == '0') {
                        count++;
                        i = i + 3;
                    } else {
                        i++;
                    }
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        System.out.println(count);
    }
}
