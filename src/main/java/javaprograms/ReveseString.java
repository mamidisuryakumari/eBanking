package javaprograms;

import java.util.Scanner;

public class ReveseString {
	String choice;
	
	Scanner scanner=new Scanner(System.in);
	public void reverseString1() {
		System.out.println("Entear a name");
		String name=scanner.next();
		String reversed = new StringBuilder(name).reverse().toString();
    System.out.println(reversed);
	}
	public String askAgain()
	{
		System.out.println("Do you want to continue ... Y or N");
		choice = scanner.next();
		return choice;
		
	}

	public static void main(String[] args) {
		ReveseString reveseString= new ReveseString();
		reveseString.reverseString1();
		reveseString.askAgain();
		while(reveseString.choice.equalsIgnoreCase("y")) {
			reveseString.reverseString1();
			reveseString.askAgain();
			System.out.println("Thank you");
		}

	}

}
