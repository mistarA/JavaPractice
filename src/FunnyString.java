import java.util.Scanner;

/**
 * Created by anandmishra on 19/02/17.
 */
public class FunnyString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for( int i = 0 ; i < testCases; i++){
            String output = "Funny";
            String value = scan.next();
            String reverseValue = String.valueOf(new StringBuilder(value).reverse());
            for( int j = value.length() - 1; j >= 1; j--){
                int diffValue = Math.abs(value.charAt(j) - value.charAt(j-1));
                int diffReverseValue = Math.abs(reverseValue.charAt(j) - reverseValue.charAt(j-1));
                if( diffValue != diffReverseValue){
                    output = "Not Funny";
                    break;
                }
            }
            System.out.println(output);
        }
    }
}
