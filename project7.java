//Author: Gurpal Jabble
//This program is a music quiz which asks the player(s) a question and gives points if the answer is correct.
//and then prints the scores of the player(s).
import java.util.*;
class project7
{
	public static void main (String[] param)
	{
	    question[] questions = createarray();
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
	    while(players<0)
	    {
	    	print("Please enter a valid number of players.");
	    	numberofplayers = useranswer();
	    	int players = Integer.parseInt(numberofplayers);
	    }
        return players;
	}

	public static question[] fillarray(question[] q)
	{
		question q1 = new question();
		q1 = setQuestion(q1, "Which artist released the single 'Hello' in 2015?");
		q1 = setAnswer(q1, "Adelle");
		question q2 = new question();
		q2 = setQuestion(q2, "question2");
		q2 = setAnswer(q2, "answer2");
		question q3 = new question();
		q3 = setQuestion(q3, "question3");
		q3 = setAnswer(q3, "answer3");
		q[0] = q1;
		q[1] = q2;
		q[2] = q3;
		return q;
	}
    //method which creates an array for questions
	public static question[] createarray()
	{
		final int numofquestions = 3;
		question[] a = new question[numofquestions];
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
	public static void multiplayer(question[] questions, int players)
	{
		final int numofplayers = players;
		int[] arrayofscores = new int[numofplayers];
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
		    }
		}
		int totalscore = addscores(arrayofscores);
        print("Your team scored " + totalscore + " points in total!");
        printindividualscores(arrayofscores);
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
}

class question
{
	String question;
	String answer;
}