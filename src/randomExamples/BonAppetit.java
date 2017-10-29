package randomExamples;

import java.util.Scanner;

public class BonAppetit {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named randomExamples.Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int indexAnnaSaidNo = in.nextInt();
        int a[] = new int[n];
        int sumShared = 0;
        int annaUnshared =0;
        for(int a_i=0; a_i < n; a_i++){
            if(indexAnnaSaidNo != a_i){
                sumShared = sumShared + in.nextInt();

            } else{
                annaUnshared = in.nextInt();
            }
        }
        int split = sumShared/2;
        int bCharged = in.nextInt();
        if(bCharged == split){
            System.out.println("Bon Appetit");
        } else{
            System.out.println(bCharged - split);
        }

    }
}
