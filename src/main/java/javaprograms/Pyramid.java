package javaprograms;

import java.util.Scanner;

public class Pyramid {
	
	
	Scanner scanner = new Scanner(System.in);
	String choice;
	
	public void pyramid()
	{
		System.out.println("How many rows needed : ");
		int rows = scanner.nextInt();
		
		
//		logic 
		
		for(int i=1;i<=rows;i++) {
			
//			Spaces
			for(int j=rows;j>=i;j--)
			{
				System.out.print(" ");
			}
			
			for(int k=1;k<=i;k++) {
				System.out.print("*"+" ");
			}
			System.out.println("\n");
		}
		

		
	}
//	Ask again
	
	public String askAgain()
	{
		System.out.println("Do you want to continue ... Y or N");
		choice = scanner.next();
		return choice;
		
	}

	public static void main(String[] args) {
		
		Pyramid pyramid = new Pyramid();
		pyramid.pyramid();
		pyramid.askAgain();
		
		while(pyramid.choice.equalsIgnoreCase("y"))
		{
			pyramid.pyramid();
			pyramid.askAgain();
		}
		
		System.out.println("Thanks you see you again Bye Bye!");
	}

}
