import java.math.BigInteger;
import java.util.Scanner;

public class SherlockAndSquares {

	public static void main(String[] args) {

		int m = 49;
		int sqrt1 = (int)Math.sqrt(m);
		if( sqrt1 * sqrt1  == m){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
        for(int i = 0; i < s ; i++){
              int start = in.nextInt();
              int end = in.nextInt();
              int count = 0;
              checkSquare(start,end);
            System.out.println(count);
        }
	}
	
	public static int checkSquare(int a, int b){
		if( a == b){
			int sqrt = (int)Math.sqrt(a);
			if( sqrt * sqrt  == a){
	              System.out.println(Math.floor(12) - Math.ceil(a) + 1);


			}
		} else{
			checkSquare(a,b--);
		}
		return 1;
	}
}
