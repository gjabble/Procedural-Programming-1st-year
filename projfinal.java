//Author: Gurpal Jabble
//This program is a music quiz which asks the player(s) a question and gives points if the answer is correct.
//and then prints the scores of the player(s).
import java.util.*;
import java.io.*;
class projfinal
{
	public static void main (String[] param)
	{
		final int numofquestions = 4;
	    question[] questions = createquestionarray(numofquestions);
	    questions = fillarray(questions);
	    int players = askplayernumber();
		processplayers(players, questions);
	}
    //asks the user how many players are taking part in the quiz.
	public static int askplayernumber()
	{
		print("How many people are playing?");
		String numberofplayers = useranswer();
	    int players = Integer.parseInt(numberofplayers);
	    while(players<=0)
	    {
	    	print("Please enter a valid number of players.");
	    	numberofplayers = useranswer();
	    	players = Integer.parseInt(numberofplayers);
	    }
        return players;
	}
    //sets the questions and creates a database of them.
	public static question[] fillarray(question[] q)
	{
		question q1 = new question();
		q1 = setQuestion(q1, "Which artist released the single 'Hello' in 2015?");
		q1 = setAnswer(q1, "Adele");
		question q2 = new question();
		q2 = setQuestion(q2, "The lyrics 'Harder, better, faster, stronger' are by which group?");
		q2 = setAnswer(q2, "Daft Punk");
		question q3 = new question();
		q3 = setQuestion(q3, "Which song by Survivor famously featured in the 1982 movie 'Rocky III'?");
		q3 = setAnswer(q3, "Eye of the tiger");
		question q4 = new question();
		q4 = setQuestion(q4, "Which song by Rick Astley was played when a person got 'rick rolled'?");
		q4 = setAnswer(q4, "Never gonna give you up");
		q[0] = q1;
		q[1] = q2;
		q[2] = q3;
		q[3] = q4;
		return q;
	}
    //method which creates an array for questions
	public static question[] createquestionarray(final int numofquestions)
	{
		question[] a = new question[numofquestions];
		return a;
	}
    //creates integer array and initialises it.
	public static int[] createintarray(int size)
	{
		int[] a = new int[size];
		for(int i=0; i<size; i++)
		{
			a[i] = 0;
		}
		return a;
	}
    //depending on how many players are playing, the program either goes to single or multi player.
	public static void processplayers(int players, question[] questions)
	{
		if(players == 1)
		{
			singleplayer(questions);
		}
		else
		{
			multiplayer(questions, players);
		}
	}
    //this method processes single player. (if 1 is entered earlier).
	public static void singleplayer(question[] questions)
	{
		int total = 0;
		for(int i=0;i<questions.length;i++)
		{
			askquestion(questions, i);
			String answer = useranswer();
		    boolean check = checkanswer(answer, questions, i);
		    int score = processanswer(check);
		    if(score == 0)
		    {
		    	print("Unlucky you didn't get that question correct and scored 0.");
		    }
		    else
		    {
			    print("Congratulations, your answer was correct and you scored " + score + " points.");
			}
		    total = total + score;
        }
        print("The music quiz is over!");
        print("You scored " + total + " points in total!.");
	}
   	//this method processes multi player by asking each member the question and recording their scores.
	//it also directs the program to print quiz information after it is finished.
	public static void multiplayer(question[] questions, int players)
	{
		final int numofplayers = players;
		int[] arrayofscores = createintarray(numofplayers);
		int[] correctsofar = createintarray(questions.length);
		String answer = "";
		boolean check;
		int score = 0;
		for(int i=0;i<questions.length;i++)
		{
			question q = questions[i];
			for(int j=0;j<numofplayers;j++)
		    {
		    	print("Player " + j + ":" + getQuestion(q));
			    answer = useranswer();
                check = checkanswer(answer, questions, i);
                score = processanswer(check);
                processscore(score, arrayofscores, j);
                correctsofar = testcorrectsofar(correctsofar, check, i);
                q = processcorrectsofar(correctsofar, q, i);
                questions[i] = q;
		    }
		}
		int totalscore = addscores(arrayofscores);
        print("Your team scored " + totalscore + " points in total!\n");
        printindividualscores(arrayofscores);
        questions = checkeasiestquestion(questions);
        printdifficulty(questions);
	}
	//given the database of questions, answers and how many players got each question correct
	//this method will sort this information to find the easiest question i.e one with most
	//correct answers
	public static question[] checkeasiestquestion(question[] questions)
	{
		boolean sorted = false;
		while(!sorted)
		{
			sorted = true;
			for(int i=0;i<questions.length-1;i++)
			{
				question q1 = questions[i];
				question q2 = questions[i+1];
				if(getCorrectsofar(q1)>getCorrectsofar(q2))
				{
					question temp = q2;
					questions[i+1] = questions[i];
					questions[i] = temp;
					sorted = false;
				}
			}
		}
		return questions;
	}
	//prints how many people got each question correct and also prints a table of 
	//easiest question to hardest
	public static void printdifficulty(question[] questions)
	{
		String heading1 = ("Question");
		String heading2 = ("Correct Answers");
		print("\n---------------------------------");
		print("In order from easiest to hardest:");
		print("---------------------------------");
		int j = 0;
		for(int i=questions.length-1;i>=0;i--)
		{
			j = j+1;
			question q = questions[i];
			print(j + ": " + getQuestion(q));
		}
		print("-------------------------------");
		System.out.format("%-15s %-15s", heading1, heading2 + "\n");
		print("-------------------------------");
		int k = questions.length-1;
		for(int i = 1;i<=questions.length;i++)
		{
			question q = questions[k];
			print(i + "               " +  getCorrectsofar(q) +"\n");
			k = k-1;
		}
	}
    //this method keeps a track of how many people got each question correct.
	public static int[] testcorrectsofar(int[] correctsofar, boolean check, int i)
	{
		if(check)
		{
			correctsofar[i] = correctsofar[i] + 1;
		}
		return correctsofar;
	}
   //given how many people got that question correct, this method updates the record with it.
	public static question processcorrectsofar(int[] correctsofar, question q, int i)
	{
		q = setCorrectsofar(q, correctsofar[i]);
		return q;
	}
    //accumulator for scores for each individual player. Updates the array.
	public static int[] processscore(int score, int[] arrayofscores, int j)
	{
		arrayofscores[j] = arrayofscores[j] + score;
		return arrayofscores;
	}
   //prints the individual scores of all the players involved in a list
	public static void printindividualscores(int[] arrayofscores)
	{
		print("In particular...");
		for(int i=0;i<arrayofscores.length;i++)
		{
			print("Player " + i + " scored " + arrayofscores[i] + " points.");
		}
	}
   //adds the scores of all the players.
	public static int addscores(int[] arrayofscores)
	{
	    int totalscore = 0;
		for(int i=0;i<arrayofscores.length;i++)
		{
			totalscore = totalscore + arrayofscores[i];
		}
		return totalscore;
	}
    //checks whether the answer given by the player is correct
	public static boolean checkanswer(String answer, question[]  questions, int i)
	{
		question q = questions[i];
		if(answer.equals(getAnswer(q)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
    //this method processes the answer, if it is correct it gets a score
	public static int processanswer(boolean check)
	{
		int score = 0;
		if(check)
		{
			score = givescore();
		}
		return score;
	}
    //if the answer is correct, player is given a score. Only accessed if answer is correct.
	public static int givescore()
	{
		Random dice = new Random();
		int dicethrow = dice.nextInt(5)+1;
		int score;
		if(dicethrow<=5 && dicethrow>=1)
		{
			score = 3;
		}
		else
		{
			score = 6;
		}
		return score;
	}
    
	public static void askquestion(question[] questions, int i)
	{
		question q = questions[i];
		print(getQuestion(q));
	}

	public static String useranswer ()
	{
		Scanner scanner = new Scanner(System.in);
		String answer = scanner.nextLine();
		return answer;
	}

	public static void print (String a)
	{
		System.out.println(a);
	}

	public static question setQuestion(question q, String question)
	{
		q.question = question;
		return q;
	}

	public static question setAnswer(question q, String answer)
	{
		q.answer = answer;
		return q;
	}

	public static String getQuestion(question q)
	{
		return q.question;
	}

	public static String getAnswer(question q)
	{
		return q.answer;
	}

	public static question setCorrectsofar(question q, int correctsofar)
	{
		q.correctsofar = correctsofar;
		return q;
	}

	public static int getCorrectsofar(question q)
	{
		return q.correctsofar;
	}
}

class question
{
	String question;
	String answer;
	int correctsofar;
}