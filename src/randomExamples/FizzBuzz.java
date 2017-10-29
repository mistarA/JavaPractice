package randomExamples;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by anandmishra on 18/02/17.
 */
public class FizzBuzz {

    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        */

        //Scanner
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();

        for (int i = 0; i < testCases; i++) {
            int number = s.nextInt();
            for( int j = 1; j <= number; j++){
                System.out.println(getOutPut(j));
            }

        }
    }
    public static String getOutPut(int value){
        if( value % 3 == 0 && value % 5 == 0){
            return "randomExamples.FizzBuzz";
        } else if( value % 3 == 0){
            return "Fizz";
        } else if(value % 5 == 0){
            return "Buzz";
        } else{
            return String.valueOf(value);
        }
    }
}
