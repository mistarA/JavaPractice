package randomExamples;

import java.util.*;

/**
 * Created by anandmishra on 18/02/17.
 */
public class SuperReducedString {

    //aaabccddd abd
    //gfqqiwjdllsutxlpskxlrgmnunpobgvuimnudvtisdilhzaafarzlyjypvdcsvbpxdtsslszevkiclshpzbeuegxdnofgpuneduo
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        for (int j = 0; j < input.length() - 1;) {
            char val = input.charAt(j);
            if (val == input.charAt(j + 1)) {
                String temp = input.substring(j).replaceFirst(String.valueOf(val),"").replaceFirst(String.valueOf(val),"");
                input = input.substring(0, j).concat(temp);
                j = j - 1;
//                System.out.println("after replacing "+input);
            } else{
                j++;
            }
            if( j < 0){
                j = 0;
            }
        }
        System.out.println();
        if (input.length() == 0) {
            System.out.println("Empty String");
        } else {
            System.out.println(input);
        }
    }

    /*
    * gfqqiwjdllsutxlpskxlrgmnunpobgvuimnudvtisdilhzaafarzlyjypvdcsvbpxdtsslszevkiclshpzbeuegxdnofgpuneduo
    *
    * g, f, q == q, f, i, w, j, d, l == l, s, u
    * 0, 1, 2,      1, 2, 3, 4, 5, 6,      5, 6
    *
    *
    * */
}
