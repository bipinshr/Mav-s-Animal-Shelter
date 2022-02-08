import java.util.Scanner;
public class Quint
{
	public static void main(String[] args) 
	{
		
		WordList wordlist = new WordList();
		Puzzle puzzle = new Puzzle(wordlist.getWord());
		System.out.println("==========");
		System.out.println("Q U I N T");
		System.out.println("==========\n\n");
		System.out.println("Guess a 5- letter word");
		System.out.print("guess ");
		Scanner in = new Scanner(System.in);
		
		int i=0;
		while(!puzzle.isSolved())
		{
			String guess = in.nextLine();
			String Ans_try = puzzle.compareGuess(guess);
			System.out.print(Ans_try);
			//System.out.print();
		}
		
		
		System.out.print("Total number of try is " + i);
	}
}