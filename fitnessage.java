//Author: Gurpal Jabble
//This program asks the user for two scores and calculates their PC Fit age

import java.util.Scanner;

class fitnessage
{
	public static void main (String[] param)
	{
		calculations();
		System.exit(0);
	}
	//does all calculations
	public static void calculations()
	{
		int score1;
		int score2;
		int totalscore;
		int avscore;
		int pcfitage;
		int difference;
		int age;
		score1 = test1();
		score2 = test2();
		totalscore = score1 + score2;
		avscore = totalscore / 2;
		System.out.println("Your average score is " + avscore +".");
		pcfitage = (avscore * 8) / 5 + 10;
		System.out.println("Your PC Fit age is " + pcfitage + " years old.");
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is your actual age?");
		age = Integer.parseInt(scanner.nextLine());
		difference = age - pcfitage;
		System.out.println("You are " + difference + " years away from your PC fit age.");	
		return;	
	}
	//gets score for test1.
	public static int test1()
	{
		int s1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Score for fitness test 1?");
		s1 = Integer.parseInt(scanner.nextLine());
		return s1;
	}
	//method to get score for second test
	public static int test2()
	{
		int s2;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Score for fitness test 2?");
		s2 = Integer.parseInt(scanner.nextLine());
		return s2;
	}
}