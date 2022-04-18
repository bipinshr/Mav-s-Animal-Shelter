import java.util.Scanner;
public class Polygon
{
	private static int sides;
	private static double[] perimeter;
	
	public static void addSide(double length)
	{
		perimeter[sides] = Double.valueOf(length);
		sides++;
	}
	
	public static int getSides()
	{
		Scanner scan = new Scanner(System.in);
		int sideslength = scan.nextInt();
		return sideslength;
	}	
	
	public static double getPerimeter()
	{
		double totalperimeter = 0.0;
		
		for(int i=0;i<=sides;i++)
		{
			totalperimeter += perimeter[i];
		}
		return totalperimeter;
	}
	public static void main(String[] args) 
	{
		
		System.out.print("Side Length (0 when done): ");
		int sideslen = getSides(); 
		int i = 0;
		while(sideslen>0)
		{
			
			addSide(sideslen);
			System.out.print("Side Length (0 when done): ");
			sideslen = getSides();
			
		}
		System.out.println("Perimeter of " + sides +"-sided polygon is " + getPerimeter());
	}
}