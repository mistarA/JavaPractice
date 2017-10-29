package randomExamples;

import java.util.Scanner;

public class AppendAndDelete {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String t = in.next();
		int k = in.nextInt();
		int operationalIndex = 0;
		String diff1 = "";
		String diff2 = "";
		if(t.length() == s.length()){
			if(k >= 2 * t.length()){
				System.out.println("Yes");
				System.exit(0);
			}
		}
		int length = s.length() < t.length() ? s.length() : t.length();
//		System.out.println(length);
		for(int i = 0; i < length ; i++){
//			System.out.print(t.charAt(i) + " ");
//			System.out.println(s.charAt(i));
            operationalIndex = i;
			if(t.charAt(i) != s.charAt(i)){
                	break;
			}
		}
//		System.out.println(operationalIndex);
		//hackerhappy
		//hackerrank
		diff1 = s.substring(operationalIndex, s.length());
		diff2 = t.substring(operationalIndex, t.length());
//		System.out.println(diff1);
//		System.out.println(diff2);


		if( k  >=  (diff1.length() + diff2.length())){
			System.out.println("Yes");
		} else{
			System.out.println("No");
		}
	}


}
