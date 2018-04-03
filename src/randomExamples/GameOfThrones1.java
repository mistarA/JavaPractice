package randomExamples;

import java.util.*;

/**
 * Created by anandmishra on 21/02/17.
 */
public class GameOfThrones1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        List<Character> characters= new ArrayList<Character>();

        for (int i = 0; i < input.length(); i++) {
            if (characters.contains(input.charAt(i))) {
                characters.remove(characters.indexOf(input.charAt(i)));
            } else{
                characters.add(input.charAt(i));
            }
        }
        if(characters.size() == 1 || characters.size() == 0){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
}

