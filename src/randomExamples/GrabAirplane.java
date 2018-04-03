package randomExamples;

import java.util.*;

/**
 * Created by anandmishra on 29/10/17.
 */
public class GrabAirplane {

    public static void main(String[] args) {

        int n = 1;
        String reservedStrings = "1A 1G 1D";
        Map<Integer, ArrayList<Character>> occurrences = new HashMap<Integer, ArrayList<Character>>();
        String[] arr = reservedStrings.split(" ");
        for (String input : arr) {
            Character column = input.charAt(input.length() - 1);
            Integer rowNumber = Integer.parseInt(input.replace(String.valueOf(column), ""));
            if (occurrences.get(rowNumber) != null) {
                occurrences.get(rowNumber).add(column);
            } else {
                ArrayList<Character> columns = new ArrayList<Character>();
                columns.add(column);
                occurrences.put(rowNumber, columns);
            }
        }

        int totalSum = 0;
        for (int i = 1; i <= n; i++) {
            if (occurrences.get(i) != null) {
                List<Character> characters = occurrences.get(i);
                int count = 0;
                if (!(characters.contains('A') || characters.contains('B') || characters.contains('C'))) {
                    count++;
                }
                if (!(characters.contains('H') || characters.contains('J') || characters.contains('K'))) {
                    count++;
                }
                if (!(characters.contains('E') || characters.contains('F')) && !(characters.contains('D') && characters.contains('G'))) {
                    count++;
                }
                totalSum = totalSum + count;
            } else {
                totalSum = totalSum + 3;
            }
        }

        System.out.println(occurrences);
        System.out.print(totalSum);

    }
}
