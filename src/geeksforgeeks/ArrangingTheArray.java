package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anandmishra on 07/06/17.
 */
//http://practice.geeksforgeeks.org/problems/arranging-the-array/0
public class ArrangingTheArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        List<Integer> positiveList = new ArrayList<Integer>();
        List<Integer> negativeList = new ArrayList<Integer>();
        for (int i = 0 ; i < testCases; i++){
            int size = scan.nextInt();
            positiveList.clear();
            negativeList.clear();
            for (int j = 0; j < size; j++){
                int number = scan.nextInt();
                if (number < 0){
                    negativeList.add(number);
                } else{
                    positiveList.add(number);
                }
            }
            negativeList.addAll(positiveList);
            printNumbers(negativeList);
        }
    }

    public static void printNumbers(List<Integer> numbers){
        for (Integer number : numbers){
            System.out.print(number +" ");
        }
        System.out.println();
    }
}
