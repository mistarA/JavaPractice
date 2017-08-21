package geeksforgeeks;

import java.util.Scanner;

/**
 * Created by anandmishra on 21/08/17.
 */
public class ArraySortingZeroesAndOnesInOneGo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inputs = in.nextInt();
        for (int l = 0; l < inputs; l++) {
            int length = in.nextInt();
            int arr[] = new int[length];
            for (int k = 0; k < length; k++){
                arr[k] = in.nextInt();
            }
            for (int i = 0; i < arr.length; i++) {
                //  1 0 1 0 1 0 1 1
                //  0 1 1 0 1 0 1 1
                //  0 0 1 1 1 0 1 1
                //  0 0 0 1 1 1 1 1
                // start from beginning, once you find 1 interchange it from next 0
                if (arr[i] == 1) {
                    int temp = arr[i];
                    for (int j = i; j < arr.length; j++) {
                        if (arr[j] == 0) {
                            arr[i] = arr[j];
                            arr[j] = temp;
                            break;
                        }
                    }
                }
            }
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
