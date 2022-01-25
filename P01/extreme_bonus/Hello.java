//import java.util.Scanner;
public class Hello
{
	public static void main(String[] args) 
	{
		//System.out.print("What is your name? ");
		//Scanner in = new Scanner(System.in);
		String username = System.getProperty("user.name");
		System.out.println("Hello, " + username + "!");
	}
}