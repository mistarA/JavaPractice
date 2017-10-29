package randomExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anandmishra on 26/02/17.
 */
public class AlternatingCharacters {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int inputs = in.nextInt();
        for (int i = 0; i < inputs; i++) {
            int count = 0;
            String input = in.next();

        }

        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        a2.add(1);
        a2.add(2);
        a2.add(3);
        a2.add(4);
        a2.add(5);
        System.out.print(a1.containsAll(a2));


    }
}