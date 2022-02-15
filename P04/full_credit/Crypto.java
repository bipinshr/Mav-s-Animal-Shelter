import java.util.Scanner;
public class Crypto{
	public static void main(String[] args)
	{
		String key;
		if(args.length == 1)
		{
			key = args[0];
		}
		else
		{
			key = "ZEBRASCDFGHIJKLMNOPQTUVWXY";
		}
		
		Scanner in = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("(e)encrypt, (d)ecrypt or (q)uit?");
		char input =  in.next().charAt(0);
		Substitution sub = new Substitution(key);
		String ask=""; 
		while(input != 'q')
		{
			if(input=='e')
			{
				System.out.println("Enter text to encrypt");
				ask=sc.nextLine();
				System.out.println(sub.encrypt(ask));
			}
			else if(input=='d')
			{
				System.out.println("Enter text to decrypt");
				ask=sc.nextLine();
				System.out.println(sub.decrypt(ask));
			}
			
			System.out.println("(e)encrypt, (d)ecrypt or (q)uit?");
		    input =  in.next().charAt(0);
			
		}
			
		
	}
}