//Author: Gurpal Jabble
// This program takes the userinput of 4 disability scores of 4 runners, adds them and checks
// whether the total is greater than 32, if so it prints that the team is not legal
// if not it prints that the team is legal.

import java.util.Scanner;

class paralympicrelay
{
    public static void main (String[] p)
	{
	   int total = disabilitypointscore(); //declared variable total and it gets its value from this method call
	   boolean legality = checklegality(total); // gets a true or false value from checklegality method taking
	   // the total score as an argument.
	   
	   
	   if (legality == true) // if statement to decide what to print to the screen.
	   {
		   System.out.println("That team has " + total + " points so is legal.");
		   		// prints that the team is legal if totalscore is below or equal to 32.
	   }
	   else
	   {
		   System.out.println("That team has " + total + " points so is NOT legal.");
		   // prints that the team is not legal if totalscore is greater than 32.
	   }
	} // END main
	
	public static int disabilitypointscore() // this method returns the total score
	{
	   int total = 0;
		
	   for (int i=1;i<=4;i++) // for loop keeps a total score by getting the userinput
       //from the disabilityclassinput method	   
	   {
	     total = total + disabilityclassinput(i);//for loop takes i as an argument which
		 // indicates the runner number.
	   }
	   
	   return total; // total score is returned to main method.
	   
	} // END disabilitypointscore
	
	public static int disabilityclassinput (int runner) //takes user input and returns it to
	// disabilitypointscore.
	{
	   Scanner scanner = new Scanner(System.in);
	   System.out.println("What is the disability class of Runner" + runner);
	   int disabilityscore = Integer.parseInt(scanner.nextLine());
	   
	   return disabilityscore;
	} // END disabilityclassinput
	
	public static boolean checklegality(int totalscore) // using the totalscore, this method
	// checks whether the value is more than 32.
	{
		boolean legality = true;
		
		if (totalscore > 32)
		{
			legality = false; // boolean value of false assigned to legality if totalscore
			// is greater than 32.
		}
		
		return legality; // returns true or false value given the input back to the main method.
	} // END checklegality
	
}// END class paralympicrelay





