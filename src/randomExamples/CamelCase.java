package randomExamples;

import java.util.Scanner;

/**
 * Created by anandmishra on 19/02/17.
 */
public class CamelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
                count++;
            }
        }
        System.out.println(count+1);
    }
}
