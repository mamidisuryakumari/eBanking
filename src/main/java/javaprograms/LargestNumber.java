package javaprograms;

import java.util.Scanner;

public class LargestNumber {
	Scanner scanner = new Scanner(System.in);
	
	public void largestNumber() {
		System.out.println("Enter a number ");
		int a=scanner.nextInt();
		System.out.println("Enter b number ");
		int b=scanner.nextInt();
		
		
		if(a>b) {
			System.out.println("The largest number is : + a");
		}else if(b>a){
			System.out.println("The largest number is : + b");
		}else {
			System.out.println("Both are equal");
		}
	}
		public static void main(String args[]){
			LargestNumber largestNumber = new LargestNumber();
			largestNumber.largestNumber();
		}
	}


