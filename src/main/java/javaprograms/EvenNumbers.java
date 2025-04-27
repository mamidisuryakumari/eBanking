package javaprograms;

import java.util.Scanner;

public class EvenNumbers {
	
	
	
	Scanner scanner = new Scanner(System.in);
	String choice;
	

	public void evenNumbers() {
		
		System.out.println("Enter number : ");
		int number = scanner.nextInt();
		
		System.out.println("Evern numbers are:");
		
		for(int i=1;i<= number;i++)
		{
			if(i%2==0)
			{
				System.out.print(i+" ");
			}
		}
		
	}
	
	public String askAgain()
	{
		System.out.println("You want to Continue.. Y/N");
		choice = scanner.next();
		
		return choice;
		
		
	}
	
	public static void main(String args[]){
		
		EvenNumbers evenNumbers = new EvenNumbers();
		evenNumbers.evenNumbers();
		evenNumbers.askAgain();
		while(evenNumbers.choice.equalsIgnoreCase("y"))
		{
			evenNumbers.evenNumbers();
			evenNumbers.askAgain();
		}
		System.out.println("Thank you see you again Bye Bye");
		
	}
}
