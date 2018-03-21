import java.util.*;

class ex9
{
	public static void main (String[] p)
	{
		film[] filmarray = createintarray();
		filmarray = fillarray(filmarray);
		printmovies(filmarray);
	}

	public static void printmovies(film[] filmarray)
	{
		for(int i=1;i<=filmarray.length;i++)
		{
			film f = filmarray[i-1];
			print("Screen " + i + ":" + getName(f) + "               " +  getHour(f) + ":" + getMinutes(f));
		}
	}

	public static film[] fillarray(film[] filmarray)
	{
		for(int i=1;i<=filmarray.length;i++)
		{
			film f = createfilm();
			print("Movie for screen " + i);
			f = setName(f);
			print("What time does it start? Hours");
			f = setHour(f);
			print("What time does it start? Minutes after the hour");
			f = setMinutes(f);
			filmarray[i-1] = f;
		}
		return filmarray;
	}

	public static film[] createintarray()
	{
		final int numoffilms = 4;
		film[] array = new film[numoffilms];
		return array;
	}

	public static film createfilm()
	{
		film f = new film();
		f.name = "";
		f.hour = 0;
		f.minutes = 0;
		return f;
	}

	public static String input()
	{
		Scanner scanner = new Scanner(System.in);
		String ans = scanner.nextLine();
		return ans;
	}
    //deals with user input for the hour the movie starts at.
	public static int inputintHour()
	{
		Scanner scanner = new Scanner(System.in);
		int ans = Integer.parseInt(scanner.nextLine());
		while((ans<6 || ans>11))
		{
			print("Please enter a value between 6 and 11 as these are evening showings.");
			ans = Integer.parseInt(scanner.nextLine());		
		}
		return ans;
	}
    //deals with the user input for the minute after the hour the movie starts at.
	public static int inputintMinute()
	{
		Scanner scanner = new Scanner(System.in);
		int ans = Integer.parseInt(scanner.nextLine());
		while((ans<0 || ans>=60))
		{
			print("Please enter a value between 0 and 59.");
			ans = Integer.parseInt(scanner.nextLine());
		}
		return ans;
	}

	public static void print(String a)
	{
		System.out.println(a);
	}

	public static film setName(film f)
	{
		String name = input();
		f.name = name;
		return f;
	}

	public static film setHour(film f)
	{
		int hour = inputintHour();
		f.hour = hour;
		return f;
	}

	public static film setMinutes(film f)
	{
		int minutes = inputintMinute();
		f.minutes = minutes;
		return f;
	}

	public static String getName(film f)
	{
		return f.name;
	}

	public static int getHour(film f)
	{
		return f.hour;
	}

	public static int getMinutes(film f)
	{
		return f.minutes;
	}
}
