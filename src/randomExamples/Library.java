package randomExamples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//Hackerank link
// https://www.hackerrank.com/challenges/library-fine?h_r=next-challenge&h_v=zen

public class Library {

	public static void main(String args[]){
		
		int da, ma, ya, de, me, ye;
	    Scanner scan = new Scanner(System.in);
	    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named randomExamples.Solution. */
	
	    Calendar calendar1 = Calendar.getInstance();
	    Calendar calendar2 = Calendar.getInstance();
	    da = scan.nextInt();
	    ma = scan.nextInt();
	    ya = scan.nextInt();
	    scan.nextLine();
	    de = scan.nextInt();
	    me = scan.nextInt();
	    ye = scan.nextInt();
	    String dayActual = "";
	    String dayExpected = "";
	    String monthActual = "";
	    String monthExpected = "";
	    if( da <= 9){
	    	dayActual = "0"+ String.valueOf(da);
	    } else{
	    	dayActual = String.valueOf(da);
	    }
	    if( de <= 9){
	    	dayExpected = "0"+ String.valueOf(de);
	    }else{
	    	dayExpected = String.valueOf(de);
	    }
	    if( ma <= 9){
	    	monthActual = "0"+ String.valueOf(ma);
	    }else{
	    	monthActual = String.valueOf(ma);
	    }
	    if( me <= 9){
	    	monthExpected = "0"+ String.valueOf(me);
	    }else{
	    	monthExpected = String.valueOf(me);
	    }
	   
	    String actualDateString = dayActual.concat(monthActual).concat(String.valueOf(ya));
	    String expectedDateString = dayExpected.concat(monthExpected).concat(String.valueOf(ye));

	    Date actualDate = new Date();
	    Date expectedDate = new Date();

	    SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
	    try {
			actualDate = sdf.parse(actualDateString);
			expectedDate = sdf.parse(expectedDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    calendar1.setTime(actualDate);
	    calendar2.setTime(expectedDate);
	    if(actualDate.compareTo(expectedDate) <= 0){
	    	System.out.println(0);
	        System.exit(0);
	    }
	  
	    if(  calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)){
	        if( calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH) ){
	           System.out.println( 15 * (da-de) );
	        } else{
	           System.out.println( 500 * (ma-me) );
	        }   
	    } else{
	        System.out.println(10000);
	    }
	}
	
	
}
