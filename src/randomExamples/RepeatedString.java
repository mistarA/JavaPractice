package randomExamples;

import java.util.Scanner;

/**
 * Created by anandmishra on 16/02/17.
 */
public class RepeatedString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        int asinInput = 0;
        for(int i =0; i < s.length(); i++){
            if(s.charAt(i) == 97){
                asinInput++;
            }
        }
//        System.out.println(asinInput);
//        System.out.println(s.length());
        if( s.length() == asinInput ){
            System.out.println(n);
            System.exit(0);
        }
        long repetition = n % s.length();
//        System.out.println("repetition "+repetition);
        if( repetition == 0){
            System.out.println(asinInput * (n/s.length()));
            System.exit(0);
        } else{
            int occurrencesInRemainder = 0;
            for (int i = 0; i< repetition ; i++){
                if(s.charAt(i) == 97){
                    occurrencesInRemainder++;
                }
            }
            long quotient = (n - repetition)/s.length();
            long output = quotient * asinInput + occurrencesInRemainder;
//            System.out.println("occurrencesInRemainder "+occurrencesInRemainder);
            System.out.println(output);
        }
        //41107102139


    }
}
