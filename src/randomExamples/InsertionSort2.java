package randomExamples;

import java.util.Scanner;

public class InsertionSort2 {
    public static void insertionSortPart2(int[] ar) {
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided

        int count = 0;
        for (int j = 1; j < ar.length; j++) {
            int rightMost = ar[j];
            for (int i = j - 1; i >= -1; i--) {
                if( i == -1){
                    ar[i +1] = rightMost;
                    break;
                }
                if (ar[i] > rightMost) {
                    ar[i + 1] = ar[i];
                    count++;
                } else{
                    ar[i +1] = rightMost;
                    break;
                }
            }
            //printArray(ar);
        }
        System.out.println(count);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortPart2(ar);
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
