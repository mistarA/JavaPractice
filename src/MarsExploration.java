import java.util.Scanner;

/**
 * Created by anandmishra on 21/02/17.
 */
public class MarsExploration {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int count = 0;
        int noOfMsg = S.length() / 3;
        int i = 0;
        System.out.println(S.length() + " length");
        while (noOfMsg != 0){
            //SOSSPSSQSSOR
            String temp = S;
            System.out.println(temp);
            if (temp.charAt(i) != 'S'){
                count++;
            }
            if (temp.charAt(i + 1) != 'O'){
                count++;
            }
            if (temp.charAt(i + 2) != 'S'){
                count++;
            }
            noOfMsg--;
            i = i + 3;
        }
        System.out.println(count);
    }
}
