package randomExamples;

import java.util.*;

/**
 * Created by anandmishra on 15/02/17.
 */
public class NonDivisibleSubsets {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named randomExamples.Solution. */
        Scanner in = new Scanner(System.in);
        Set<Integer> newSet = new HashSet<>();
        List<Integer> inputs = new ArrayList<>();

        int size = in.nextInt();
        int k = in.nextInt();
        for (int j = 0; j < size; j++) {
            inputs.add(in.nextInt());
        }
        for (int i = 0; i < inputs.size() - 1; i++) {
            System.out.println(inputs.get(i) + " first loop ");
            for (int m = i + 1; m < inputs.size(); m++) {
                int sum = inputs.get(i) + inputs.get(m);
                System.out.println("sum: " + sum);
                if ( sum % k == 0) {
                    if( inputs.get(i) > inputs.get(m)){
                        inputs.remove(inputs.get(m));
                    } else{
                        inputs.remove(inputs.get(i));
                    }
                    m = m - 1;
                }
            }
        }
        System.out.println(inputs);
        System.out.println(inputs.size());
    }
}
