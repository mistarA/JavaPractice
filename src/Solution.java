import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan = new Scanner(System.in);
		int query = scan.nextInt();
		scan.nextLine();
		String queryOne[] = new String[query];
		String queryTwo[] = new String[query];
		for(int i=0;i<query;i++){
			queryOne[i] = scan.nextLine();
			queryTwo[i] = scan.nextLine();
		}
		for(int i=0;i<query;i++){
			if(queryOne[i].length()<queryTwo[i].length()){
				System.out.println("NO");
			}
			else if(queryOne[i].length()==queryTwo[i].length()){
				if(queryOne[i].toUpperCase().equals(queryTwo)){
					System.out.println("YES");
				}
				else{
					System.out.println("NO");
				}
			}
			else{
				int count = 0;
				int position = 0;
				queryOne[i] = queryOne[i].toUpperCase();
				for(int j=0; j<queryTwo[i].length(); j++){
					for(int k= position; k < queryOne[i].length(); k++ ){
						if(queryTwo[i].charAt(j) == queryOne[i].charAt(k)){
							count++;
							position = k + 1;
							break;
						}
					}
				}
				if(count == queryTwo[i].length()){
					System.out.println("YES");
				} else{
					System.out.println("NO");
				}
			} 
		scan.close();
		}
	}
}
