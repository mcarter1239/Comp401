package recitation2;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(recursiveFactorial(n));
	}
	
	public static int factorial(int n) {
		int output = 1;
		while(n > 1) {
			output = output * n;
			n--;
			
		}
		return output;
	}
	
	public static int recursiveFactorial(int n) {
		if (n<=1) {
			return n;
		} else {
			return n * recursiveFactorial(n-1);
		}
	}
}

	