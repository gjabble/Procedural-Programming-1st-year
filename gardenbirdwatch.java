//Author: Gurpal Jabble
//This program asks the user to name a bird and how many they saw until
//"END" is typed. It then prints the most common bird they saw.

import java.util.*;

class gbw1
{
	public static void main (String[] p)
	{
		loop();
		System.exit(0);
	}
	
	//asks the user for first bird and how many, then stores it as the most common bird
	public static String input()
	{
		Scanner scanner = new Scanner(System.in);
        String ans1 = scanner.nextLine();
        return ans1;
	}

    public static int inputint()
    {
    	Scanner scanner = new Scanner(System.in);
        int ans2 = Integer.parseInt(scanner.nextLine());
        return ans2;
    }
	//while loop which takes more inputs and makes note of most common bird and how many there were
	//it then prints the most common bird and how many if "END" is typed by user.
	public static void loop ()
	{
        String ans1 = "";
        int ans2 = 0;
        String mostseen = ans1;
        int howmany = ans2;
		final String stop = "END";
		while(!(ans1.equals(stop)))
		{
			print("Which bird have you seen?");
			ans1 = input();
			if (ans1.equals(stop))
			{
				break;
			}
			else
			{
				print("How many were in your garden at once?");
				ans2 = inputint();
			}
			if (ans2 > howmany)
			{
				howmany = ans2;
				mostseen = ans1;
			}
		}
		if(howmany == 0)
		{
			System.exit(0);
		}
		else
		{
			print("You saw " + howmany + " " + mostseen + "s.");
		    print("It was the most common bird seen at one time in your garden.");
		}
	}
  
	public static void print(String a)
	{
		System.out.println(a);
	}
	
		
}




