package randomExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anandmishra on 19/02/17.
 */
public class GemStones {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        List<String> inputs = new ArrayList<String>();
        for (int i = 0; i < number; i++) {
            inputs.add(scan.next());
        }
        String value1 = inputs.get(0);
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < value1.length(); i++) {
            if (!characters.contains(value1.charAt(i))) {
                characters.add(value1.charAt(i));
            }
        }
        int count = 0;
        for (Character character : characters) {
            boolean contains = true;
            for (int j = 1; j < number ; j++) {
                if (inputs.get(j).indexOf(character) == -1) {
                    contains = false;
                    break;
                }
            }
            if(contains){
                count++;
            }
        }
        System.out.println(count);
    }
}
