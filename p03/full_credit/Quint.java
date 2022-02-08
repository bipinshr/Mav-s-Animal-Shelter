import java.util.Scanner;
public class Quint
{
	public static void main(String[] args) 
	{
		String guess;
		String Ans_try;
		WordList wordlist = new WordList();
		Puzzle puzzle = new Puzzle(wordlist.getWord());
		System.out.println("\n==========");
		System.out.println("Q U I N T");
		System.out.println("==========\n");
		System.out.println("Guess a 5- letter word");
		System.out.print("guess ");
		Scanner in = new Scanner(System.in);
		
		int i=0;
		while(!puzzle.isSolved())
		{
			guess = in.nextLine();
			Ans_try = puzzle.compareGuess(guess);
			System.out.print(Ans_try + " ");
			i+=1;
		}
		
		System.out.println("\nGuessed in " + i + " tries" );
	
	}
}