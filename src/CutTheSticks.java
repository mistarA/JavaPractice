import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//hackerrank Question link
//https://www.hackerrank.com/challenges/cut-the-sticks?h_r=next-challenge&h_v=zen

public class CutTheSticks {

	public static void main(String args[]){

		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		scan.nextLine();
		List<Integer> inputList = new ArrayList<>();
		for( int i = 0; i< number ; i++){
			inputList.add(scan.nextInt());
		}
		while(inputList.size() > 0){
			System.out.println(inputList.size());
			List<Integer> updatedList = new ArrayList<>();
			//find the minimum number
			Collections.sort(inputList);
			int min = inputList.get(0);
			for( Integer value : inputList){
				int diff = value - min;
				if(diff != 0){
					updatedList.add(diff);
				}
			}
			inputList.clear();
			inputList.addAll(updatedList);
		}
	}
}
