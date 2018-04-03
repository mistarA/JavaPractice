package testExamples;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] inArr = {1, 2, 5, -7, 2, 5};
        int[] inArr1 = {-846930886, -1714636915, 424238335, -1649760492};
        int[] inArr2 = {-1, -1, -1, -1, -1};
        int[] inArr3 = {756898537, -1973594324, -2038664370, -184803526, 1424268980};
        int[] inArr4 = {0, 0, -1, 0};
        int[] inArr5 = {336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421};
        Solution solution = new Solution();

        int[] temp = {0, 0, 4, 4, 6, 0, 9, 6, 5, 1};

        //System.out.print(Arrays.toString(solution.maxSetEfficient(inArr5)));
        //System.out.print(Arrays.toString(solution.plusOne(temp)));
        //countLastWord();
        reverseString();
    }

    public int[] maxSetEfficient(int[] A) {

        List<Integer> tempList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();
        long maxSum = 0;
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                tempList.add(A[i]);
                sum = sum + A[i];
            } else {
                System.out.println("Clearing List: " + tempList);
                tempList = new ArrayList<>();
                sum = 0;
            }
            if ((maxSum < sum) || ((maxSum == sum) && (tempList.size() > maxList.size()))) {
                maxSum = sum;
                maxList = tempList;
            }
        }
        if (maxList.size() == 0) {
            return new int[0];
        } else {
            int[] outArr = new int[maxList.size()];
            for (int i = 0; i < outArr.length; i++) {
                outArr[i] = maxList.get(i);
            }
            return outArr;
        }
    }

    public int[] maxset(int[] A) {

        long maxSum = Integer.MIN_VALUE;
        List<List<Long>> subArrayList = new ArrayList<>();
        List<Long> tempArray = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            System.out.println("In element: " + A[i]);
            if (A[i] < 0) {
                if (tempArray.size() > 0) {
                    List<Long> tempArrayList = new ArrayList<>(tempArray);
                    subArrayList.add(tempArrayList);
                    tempArray.clear();
                }
            } else {
                tempArray.add((long) A[i]);
                if (i == A.length - 1) {
                    subArrayList.add(tempArray);
                }
            }
        }
        System.out.print(subArrayList);
        int outSubArrayIndex = -1;
        for (int i = 0; i < subArrayList.size(); i++) {
            long sum = 0;
            List<Long> currentList = subArrayList.get(i);
            for (int j = 0; j < currentList.size(); j++) {
                sum = sum + subArrayList.get(i).get(j);
            }
            if (maxSum < sum) {
                maxSum = sum;
                outSubArrayIndex = i;
            }
            if (maxSum == sum) {
                if (subArrayList.get(i).size() > subArrayList.get(outSubArrayIndex).size()) {
                    outSubArrayIndex = i;
                }
            }
        }
        if (outSubArrayIndex == -1) {
            return new int[0];
        } else {
            int[] outArr = new int[subArrayList.get(outSubArrayIndex).size()];
            for (int i = 0; i < outArr.length; i++) {
                outArr[i] = (Integer.parseInt(String.valueOf(subArrayList.get(outSubArrayIndex).get(i))));
            }
            return outArr;
        }

    }

    public int[] plusOne(int[] A) {
        if (A.length == 1) {
            if (A[0] < 9) {
                A[0] = A[0] + 1;
                return A;
            }
        }
        int i = 0;
        if (A[0] == 0) {
            while (A[i] == 0) {
                A[i] = -999;
                i++;
            }
            int[] temp = new int[A.length - i];
            int indexForNewArray = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] != -999) {
                    temp[indexForNewArray++] = A[j];
                }
            }
            A = temp;
        }
        int countOfNine = 0;
        for (i = A.length - 1; i >= 0; i--) {
            if (A[i] < 9) {
                A[i] = A[i] + 1;
                break;
            } else {
                A[i] = 0;
                countOfNine++;
            }
        }
        if (countOfNine == A.length) {
            int[] newArr = new int[A.length + 1];
            newArr[0] = 1;
            int indexForNew = 1;
            for (i = 0; i < A.length; i++) {
                newArr[indexForNew++] = A[i];
            }
            return newArr;
        }
        return A;
    }

    public static void countLastWord() {
        int length = 0;
        String input = "d";
        input = input.trim();
        input = input.toLowerCase();
        int i = input.length() - 1;
        while (i >= 0 && (input.charAt(i)>= 97 && input.charAt(i)<= 122)) {
            i--;
            length++;
        }
        System.out.println(length);
    }

    public static void reverseString() {
        String input = "the     sky    is  blue";
        StringBuilder output = new StringBuilder("");
        int i = input.length() - 1;
        int insertAt = 0;
        while(i >= 0) {
            if (input.charAt(i) != ' ') {
                output = output.insert(insertAt, input.charAt(i));
            } else {
                if (insertAt != output.length()) {
                    output = output.append(' ');
                    insertAt = output.length();
                }
            }
            i--;
        }
        System.out.println(output);
    }
}
