//Author: Gurpal Jabble
//This program asks the user about 5 endangered animals and asks how many there 
//left of each animal and then prints the information a comma seperated list.

import java.util.*;

class endangeredanimals
{
	public static void main (String[] param)
	{
		declarearrays();
		System.exit(0);
	}
	//storing animal name information and creatings storage space for population.
	public static void declarearrays()
	{
		int[] animalpopulation = new int[5];
		String[] animalname = new String[5];
		animalname[0] = "Komodo Dragon";
		animalname[1] = "Manatee";
		animalname[2] = "Kakapo";
		animalname[3] = "Florida Panther";
		animalname[4] = "White Rhino";
		userinput(animalpopulation, animalname);
		return;
	} 
	//takes user input of how many of each animal there are let.
	public static void userinput(int[] animalpopulation, String[] animalname)
	{
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<animalpopulation.length; i++)
		{
			System.out.println(animalname[i] + ":");
			System.out.println("How many are left in the Wild?");
			int answer = Integer.parseInt(scanner.nextLine());
			animalpopulation[i] = answer;
		}
		int minvalue = animalpopulation[0];
		int index = 0;
		for (int i=0; i<animalpopulation.length; i++)
		{
			if(minvalue > animalpopulation[i])
			{
				minvalue = animalpopulation[i];
				index = i;
			}
		}
		mostendangered(index, animalpopulation, animalname);
		animalinformation(animalpopulation, animalname);
	} 
	//prints out the most endangered animal
	public static void mostendangered (int index, int[] animalpopulation, String[] animalname)
	{
		System.out.println("");
		System.out.println("The most endangered animal is the " + animalname[index]);
		System.out.println("There are only " + animalpopulation[index] + " left in the wild");
		System.out.println("");
		
		return;
	}
	//prints all animal information in spreadsheet format
	public static void animalinformation(int[] animalpopulation, String[] animalname)
	{
		for (int i=0; i<animalname.length; i++)
		{
			System.out.println(animalpopulation[i] + "," + animalname[i]);
		}
		return;
	}	
}
