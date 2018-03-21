//Author: Gurpal Jabble
// This program will tell the user what underground zone a station is in
// given their input.

import java.util.*;

class undergroundzones
{
	//main method calls for the userinputmethod while taking the first message as an argument
	
	public static void main (String[] param)
	{
		userinput("What station do you need to know the zone of?");
		System.exit(0);
	}
	
	// method for userinput includes the if statement with all the stations the program
	// knows of and calls the respective method to return the integer value for the station 
	// the user typed in.
	
	public static void userinput(String message)
	{
		String station;
		int zone;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(message);
		station = scanner.nextLine();
		
		if (station.equals("Mile End"))
		{
			zone = mileend();
			System.out.println("Mile End is in " + zone);
		}
		else if (station.equals("Liverpool Street"))
		{
			zone = liverpoolstreet();
			System.out.println("Liverpool Street is in " + zone);
		}
		else if (station.equals("Woodford"))
		{
			zone = woodford();
			System.out.println("Woodford is in zone " + zone);
		}
		else if (station.equals("Bethnal Green"))
		{
			zone = bethnalgreen();
			System.out.println("Bethnal Green is in zone " + zone);
		}
		else if (station.equals("Acton Town"))
		{
			zone = actontown();
			System.out.println("Acton Town is in zone " + zone);
		}
		else
		{
			System.out.println("Is " + station + " a london underground station? Maybe check your spelling.");
		}
	} // END userinput
	
	//the following are functions for each respective station named in the header.
    
	public static int mileend()
	{
		return 2;
	}// END mileend
	
	public static int liverpoolstreet()
	{
		return 1;
	} // END liverpoolstreet
	
	public static int woodford()
	{
		return 4;
	} // END woodford
	
	public static int bethnalgreen()
	{
		return 2;
	} // END bethnalgreen
	
	public static int actontown()
	{
		return 3;
	} // END actontown
}// END class undergroundzones
