package a1adept;

import java.util.Scanner;

public class A1Adept {
	
	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
		
	}
	
	public static void process(Scanner s) {
		/* Assign a variable for the number of assignments, 
		 * a variable to contain the assignment points list,
		 * and a variable for the possible participation points.
		 */
		int assignmentNumber = s.nextInt();
		s.nextLine();
		String[] splitAssignments = s.nextLine().split(" ");
		int assignmentPoints = 0;
		for(int i = 0; i < splitAssignments.length; i++) {
			assignmentPoints += Integer.parseInt(splitAssignments[i]);
		}
		int participationPoints = s.nextInt();
		
		// Determine the number of loops needed
		
		
		int j = s.nextInt();

		while (j > 0) {
			// Initialize vars for the name part of final output
			String firstInitial = String.valueOf(s.next().charAt(0));
			String lastName = s.next();

			// Calculate numerical grade
			double participationGrade = 100 * (s.nextDouble() / (participationPoints * 0.8));
			if(participationGrade > 100) {
				participationGrade = 100;
			}
			double assignmentGrade = 0;
			for(int i = 0; i < assignmentNumber; i++) {
				assignmentGrade += s.nextDouble();
			}
			assignmentGrade = (assignmentGrade / assignmentPoints) * 100;
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
