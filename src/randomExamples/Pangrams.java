package randomExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anandmishra on 19/02/17.
 */
public class Pangrams {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String output = "pangram";
        s = s.toLowerCase();
        s = s.replaceAll(" ","");
        List<Integer> characters = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!characters.contains((int)s.charAt(i))) {
                characters.add((int)s.charAt(i));
            }
        }
        Collections.sort(characters);
        for (int i = 97; i <= 122; i++){
            if(!characters.contains(i)){
                output = "not pangram";
                break;
            }
        }
        System.out.println(output);
    }
}
