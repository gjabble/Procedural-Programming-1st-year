// Author: Gurpal Jabble
// This program asks the user what room they are in and then uses the value they enter
// to provide information about a painting in that room. The program uses getter and setter
// methods for the painting and defines a new type called "painting" through the use of a record

import java.util.*;

class artgallery
{
	public static void main (String[] p)
	{
		
		userinput("What room are you in?");
		System.exit(0);
	
	} // END main
	
	
	
	public static void userinput (String message)
	{
		//creating the painting types.
		painting p1 = new painting();
		p1 = setDirection(p1, "on the left");
		p1 = setArtist(p1, "Olga Boznanska");
		p1 = setYear(p1, 1894);
		p1 = setTitle(p1, "Girl with Chrysanthemums");
		p1 = setHeight(p1, 88.5);
		p1 = setWidth(p1, 69.0);
		
		painting p2 = new painting();
		p2 = setDirection(p2, "ahead of you");
		p2 = setArtist(p2, "Mary Cassatt");
		p2 = setYear(p2, 1879);
		p2 = setTitle(p2, "Woman with a Pearl Necklace in a Loge");
		p2 = setHeight(p2, 81.3);
		p2 = setWidth(p2, 59.7);
		
		painting p3 = new painting(); 
		p3 = setDirection(p3, "ahead of you");
		p3 = setArtist(p3, "Rembrandt");
		p3 = setYear(p3, 1659);
		p3 = setTitle(p3, "Self-Portrait with Beret and Turned-Up Collar");
		p3 = setHeight(p3, 84.5);
		p3 = setWidth(p3, 66.0);
		
		painting p4 = new painting();
		p4 = setDirection(p4,"on your right");
		p4 = setArtist(p4,"Claude Monet");
		p4 = setYear(p4,1872);
		p4 = setTitle(p4,"Impression, Sunrise");
		p4 = setHeight(p4,48.0);
		p4 = setWidth(p4,63.0);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(message);
		int answer = Integer.parseInt(scanner.nextLine());
		//printing the painting information based on the room number
		if (answer == 1)
		{
			System.out.println("The painting " + getDirection(p1) + " is by " + getArtist(p1)
			+ ". It was painted in " + getYear(p1) + " and is called " + getTitle(p1) + ". It is " +
			getHeight(p1) + "cm by " + getWidth(p1) + "cm.");
		}
		else if (answer == 2)
		{
			System.out.println("The painting " + getDirection(p2) + " is by " + getArtist(p2)
			+ ". It was painted in " + getYear(p2) + " and is called " + getTitle(p2) + ". It is " +
			getHeight(p2) + "cm by " + getWidth(p2) + "cm.");
		}
		else if (answer == 3)
		{
			System.out.println("The painting " + getDirection(p3) + " is by " + getArtist(p3)
			+ ". It was painted in " + getYear(p3) + " and is called " + getTitle(p3) + ". It is " +
			getHeight(p3) + "cm by " + getWidth(p3) + "cm.");
		}
		else if (answer == 4)
		{
			System.out.println("The painting " + getDirection(p4) + " is by " + getArtist(p4)
			+ ". It was painted in " + getYear(p4) + " and is called " + getTitle(p4) + ". It is " +
			getHeight(p4) + "cm by " + getWidth(p4) + "cm.");
		}
		else
		{
			System.out.println("Please enter a valid room number");
		}
			
		
	}

	public static String getDirection(painting p)
	{
		return p.direction;
	} 
	
	public static String getTitle(painting p)
	{
		return p.title;
	} 
	
	public static String getArtist(painting p)
	{
		return p.artist;
	} 
	
	public static int getYear(painting p)
	{
		return p.year;
	}
	
	public static double getHeight(painting p)
	{
		return p.height;
	} 
	
	public static double getWidth(painting p)
	{
		return p.width;
	} 

	public static painting setDirection(painting p, String direction)
	{
		p.direction = direction;
		return p;
	}
	
	public static painting setTitle(painting p, String title)
	{
		p.title = title;
		return p;
	} 
	
	public static painting setArtist(painting p, String artist)
	{
		p.artist = artist;
		return p;
	}
	
	public static painting setYear(painting p, int year)
	{
		p.year = year;
		return p;
	}
	
	public static painting setHeight(painting p, double height)
	{
		p.height = height;
		return p;
	}
	
	public static painting setWidth(painting p, double width)
	{
		p.width = width;
		return p;
	}

} 
//record of type painting which includes all the information about a painting.	
class painting
{
	String direction;
	String title;
	String artist;
	int year;
	double height;
	double width;
	
} 
