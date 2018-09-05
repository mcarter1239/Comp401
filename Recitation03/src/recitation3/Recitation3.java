package recitation3;

import java.util.Scanner;

/* Name: 
 * Onyen: 
 * Recitation Code: 
 */

public class Recitation3 {
	public static void main(String[] args) {
		
		Scanner s =  new Scanner(System.in);
		int size = s.nextInt();
		
		int[] numbers = fillArray(size);
		arrayToString(numbers);
		
		int[] numbersSorted = sortIntArray(numbers.clone());
		arrayToString(numbersSorted);
		arrayToString(numbers);
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
	public static int[] fillArray(int size) {
		int[] numbers = new int[size];
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 10);
		}
		
		return numbers;
	}
	public static void arrayToString(int[] arr) {
//		Loops through array and uses string concatenation to print out array values nicely
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
	
	public static int[] sortIntArray(int[]  arr) {
//		insertion sort algorithm used to sort numbers
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j > 0; j--) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
		return arr;
	}
	
	public static void twoDimensionalArrayToString(int[][] arr) {
//		loops through first array dimension and makes use of one dimensional print method to print out 2-d array
		for(int i = 0; i < arr.length; i++) {
			arrayToString(arr[i]);
		}
	}
}

