//Author: Gurpal Jabble
//This program calculates a bonus to be given to an employee given a rating on how well they worked and how much
//profit they made.

import java.util.*;

class bonusscheme
{
	public static void main (String[] p)
	{
		employee e = createemployee();
		print("Profit score?");
	    e = setProfitscore(e);
		print("Hard Work Score?");
		e = setHardworkscore(e);
		int performancescore = performancescore(e);
		print("Your Performance Score this year is " + performancescore + " out of 10.");
		int bonus = caclulatebonus(performancescore);
		print("Your bonus is " + bonus + " pounds.");

	}
    //given a profit score entered by the user, updates it to be used for further calculations.
	public static int updateprofitscore(int profitscore)
	{
		profitscore = profitscore*2;
		return profitscore;
	}
 
	public static int updatehardworkscore(int hardworkscore)
	{
		hardworkscore = hardworkscore*5;
		return hardworkscore;
	}
    //calculates the users overall performance score given their profit score and hard work score.
	public static int performancescore(employee e)
	{
		int profitscore = updateprofitscore(e.profitscore);
		int hardworkscore = updatehardworkscore(e.hardworkscore);
		int total = hardworkscore + profitscore;
		int perfscore = total/7;
		return perfscore;

	}

	public static int caclulatebonus(int performancescore)
	{
		int bonus = performancescore*5000;
		return bonus;
	}

	public static employee createemployee()
	{
		employee e = new employee();
		e.profitscore = 0;
		e.hardworkscore = 0;
		return e;
	}

	public static void print(String a)
	{
		System.out.println(a);
	}
    //method which returns the scores entered by the user, only valid for inputs between 0 and 10.
	public static int inputint()
	{
		Scanner scanner = new Scanner(System.in);
		int ans = Integer.parseInt(scanner.nextLine());
		while((ans>10 || ans<0))
		{
			print("Please enter a valid number between 0 and 10.");
			ans = Integer.parseInt(scanner.nextLine());
		}
		return ans;		
	}

	public static employee setProfitscore(employee e)
	{
		int profitscore = inputint();
		e.profitscore = profitscore;
		return e;
	}

	public static employee setHardworkscore(employee e)
	{
		int hardworkscore = inputint();
		e.hardworkscore = hardworkscore;
		return e;
	}

	public static int getHardworkscore(employee e)
	{
		return e.hardworkscore;
	}

	public static int getProfitscore(employee e)
	{
		return e.profitscore;
	}
}

class employee
{
	int profitscore;
	int hardworkscore;
}