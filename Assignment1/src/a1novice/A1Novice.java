package a1novice;

import java.util.Scanner;

public class A1Novice {

	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);
	}
	/* Loop through the list of students
	 * and calculate a student grade each time.
	 * Print in the form
	 * F. Last_Name Grade
	 */
	public static void process(Scanner s) {
		// Determine the number of loops needed
		int j = s.nextInt();

		while (j > 0) {
			// Initialize vars for the name part of final output
			String firstInitial = String.valueOf(s.next().charAt(0));
			String lastName = s.next();

			// Calculate numerical grade
			double assignmentGrade = s.nextDouble();
			double participationGrade = s.nextDouble();
			double midterm = s.nextDouble();
			double finalExam = s.nextDouble();

			double weightAvg = (assignmentGrade * 0.4) + (participationGrade * 0.15) + (midterm * 0.2) + (finalExam * 0.25);

			// Assign a letter grade based on weightAvg
			String letterGrade;
			if (weightAvg >= 94) {
				letterGrade = "A";
			} else if (weightAvg >= 90 && weightAvg < 94) {
				letterGrade = "A-";
			} else if (weightAvg >= 86 && weightAvg < 90) {
				letterGrade = "B+";
			} else if (weightAvg >= 83 && weightAvg < 86) {
				letterGrade = "B";
			} else if (weightAvg >= 80 && weightAvg < 83) {
				letterGrade = "B-";
			} else if (weightAvg >= 76 && weightAvg < 80) {
				letterGrade = "C+";
			} else if (weightAvg >= 73 && weightAvg < 76) {
				letterGrade = "C";
			} else if (weightAvg >= 70 && weightAvg < 73) {
				letterGrade = "C-";
			} else if (weightAvg >= 65 && weightAvg < 70) {
				letterGrade = "D+";
			} else if (weightAvg >= 60 && weightAvg < 65) {
				letterGrade = "D";
			} else {
				letterGrade = "F";
			} 

			j--;
			// Print final output
			System.out.println(firstInitial + ". " + lastName + " " + letterGrade);
		}
	}	
}
