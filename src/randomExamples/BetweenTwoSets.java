package randomExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BetweenTwoSets {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int gcdOfFactors = 0;
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        List<Integer> factors = new ArrayList<Integer>();
        for(int i =0; i < a.length-2; i++){
            int num1 = a[i];
            int num2 = a[i+1];
            if(num1 > num2){
                for(int j = 1; j < num1; j++){
                    if((num1 % j == 0) && (num2 % j ==0)){
                        factors.add(j);
                    }
                }
            }
            else if(num2 > num1){
                for(int j = 1; j < num2; j++){
                    if((num1 % j == 0) && (num2 % j == 0)){
                        factors.add(j);
                    }
                }
            }else{
                factors.add(num1);
                factors.add(num2);
            }
        }
        System.out.println(factors.toString());
        for(int i = 0; i < factors.size() - 2; i++){
            gcdOfFactors = GCF(factors.get(i), factors.get(i+1));
        }
        System.out.println(gcdOfFactors);
        int[] b = new int[m];
        int count = 0;
        /*for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
                if (b[b_i] % gcdOfFactors == 0){
                    count++;
                }    
        }*/
        //System.out.println(count);
    }
    
    public static int GCF(int a, int b) {
        if (b == 0){
            return a;  
        } else{
            return (GCF (b, a % b));
        } 
    }
}
