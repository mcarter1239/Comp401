package recitation3;

import java.util.Scanner;

public class Worksheet {

	public static void main(String[] args) {
		//Don't change the main method
				Scanner s = new Scanner(System.in);
				int size = s.nextInt();
				int[][] numbers = fill2DArray(size);
				twoDimensionalArrayToString(numbers);
				int max = findMax(numbers);
				int sum = findSum(numbers);
				int mode = findMode(numbers);
				System.out.println("Max: " + max);
				System.out.println("Sum: " + sum);
				System.out.println("Mode: " + mode);
	}
	
	public static int findMax(int[][] numbers) {
		int max = 0;
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers[i].length;j++) {
				if(numbers[i][j] > max) {
					max = numbers[i][j];
				}
			}
		}
		
		return max;
	}
	
	public static int findSum(int[][] numbers) {
		int sum = 0;
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers[i].length;j++) {
				sum += numbers[i][j];
			}
		}
		return sum;
	}
	
	public static int findMode(int[][] numbers) {
		int mode = 0;
		int[] counter = new int[10];
		
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers[i].length;j++) {
				counter[numbers[i][j]] += 1;
			}
		}
		for(int i = 0; i < counter.length; i++) {
			if(counter[i] > mode) {
				mode = i;
			}
		}
		return mode;
	}
	
	public static void twoDimensionalArrayToString(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			arrayToString(arr[i]);
		}
	}
	
	public static void arrayToString(int[] arr) {
//	Loops through array and uses string concatenation to print out array values nicely
		String arrayToString = "{ ";
		for(int i = 0; i < arr.length; i++) {
				if(i == arr.length - 1) {
					arrayToString += arr[i] + " }";
				}else {
					arrayToString += arr[i] + ", ";
				}
		}
	System.out.println(arrayToString);
	}

	public static int[][] fill2DArray(int size) {
		int[][] numbers = new int[size][size];
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers[i].length;j++) {
				numbers[i][j] = (int) (Math.random() * 10);
			}
		}
		return numbers;
		
	}
}

