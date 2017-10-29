package randomExamples;

import java.util.*;

/**
 * Created by anandmishra on 17/02/17.
 */
public class EqualizeTheArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        List<Integer> inputs = new ArrayList<>();
        List<Integer> unique = new ArrayList<>();
        Set uniqueInputs = new HashSet();
        for (int i = 0; i < size; i++) {
            Integer number = in.nextInt();
            inputs.add(number);
            uniqueInputs.add(number);
        }
        unique.addAll(uniqueInputs);
        int min = Integer.MAX_VALUE;
        for (Integer number : unique) {
            int count = Collections.frequency(inputs,number);
            int removal = inputs.size() - count;
            if( removal < min){
                min = removal;
            }
        }
        System.out.print(min);

    }
}
