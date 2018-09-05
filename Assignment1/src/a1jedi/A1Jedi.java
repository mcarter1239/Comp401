package a1jedi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A1Jedi {

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
		// Assign storage variables for each letter grade and score category
		int a = 0;
		int aMinus = 0;
		int bPlus = 0;
		int b = 0;
		int bMinus = 0;
		int cPlus = 0;
		int c = 0;
		int cMinus = 0;
		int dPlus = 0;
		int d = 0;
		int f = 0;
		
		List<Double> participation = new ArrayList<Double>();
		List<Double> assignment = new ArrayList<Double>();
		List<Double> midterm = new ArrayList<Double>();
		List<Double> finals = new ArrayList<Double>();
			
		
		int studentNumber = s.nextInt();
		
		/* Process each line/student, calculate overall score
		 * for each score category, and store each to the 
		 * appropriate list variable.
		 */
		
		for(int j = 0; j < studentNumber; j++) {
			
			// Skip the first and last names
			s.next();
			s.next();
			
			// Calculate numerical grade and add to correct list
			double participationGrade = 100 * (s.nextDouble() / (participationPoints * 0.8));
			if(participationGrade > 100) {
				participationGrade = 100;
			}
			participation.add(participationGrade);
			
			double assignmentGrade = 0;
			for(int i = 0; i < assignmentNumber; i++) {
				assignmentGrade += s.nextDouble();
			}
			assignmentGrade = (assignmentGrade / assignmentPoints) * 100;
			assignment.add(assignmentGrade);
			
			midterm.add(s.nextDouble());
			
			finals.add(s.nextDouble());
		}
		
		// Calculate and store avg and stddev for final and midterm
		List<Double> midtermTemp = new ArrayList<Double>(midterm);
		List<Double> finalsTemp = new ArrayList<Double>(finals);
		double finalAvg = avg(finalsTemp);
		double finalStdDev = standardDev(finalsTemp);
		double midtermAvg = avg(midtermTemp);
		double midtermStdDev = standardDev(midtermTemp);
		
		/* Loop and calculate a final grade for each student.
		 * Increment the appropriate counter variable.
		 */
		for(int j = 0; j < studentNumber; j++) {
			double normalizedFinal = (finals.get(j) - finalAvg) / finalStdDev;
			double curvedFinal = curvedScore(normalizedFinal);
			double normalizedMidterm = (midterm.get(j) - midtermAvg) / midtermStdDev;
			double curvedMidterm = curvedScore(normalizedMidterm);
			
			double weightAvg = (assignment.get(j) * 0.4) + (participation.get(j) * 0.15) + (curvedMidterm * 0.2) + (curvedFinal * 0.25);

			// Assign a letter grade based on weightAvg
			if (weightAvg >= 94) {
				a += 1;
			} else if (weightAvg >= 90 && weightAvg < 94) {
				aMinus += 1;
			} else if (weightAvg >= 86 && weightAvg < 90) {
				bPlus += 1;
			} else if (weightAvg >= 83 && weightAvg < 86) {
				b += 1;
			} else if (weightAvg >= 80 && weightAvg < 83) {
				bMinus += 1;
			} else if (weightAvg >= 76 && weightAvg < 80) {
				cPlus += 1;
			} else if (weightAvg >= 73 && weightAvg < 76) {
				c += 1;
			} else if (weightAvg >= 70 && weightAvg < 73) {
				cMinus += 1;
			} else if (weightAvg >= 65 && weightAvg < 70) {
				dPlus += 1;
			} else if (weightAvg >= 60 && weightAvg < 65) {
				d += 1;
			} else {
				f += 1;
			} 
		}
		
		// Final output
		System.out.println("A : " + a);
		System.out.println("A-: " + aMinus);
		System.out.println("B+: " + bPlus);
		System.out.println("B : " + b);
		System.out.println("B-: " + bMinus);
		System.out.println("C+: " + cPlus);
		System.out.println("C : " + c);
		System.out.println("C-: " + cMinus);
		System.out.println("D+: " + dPlus);
		System.out.println("D : " + d);
		System.out.println("F : " + f);		
	}
	
	public static double avg(List<Double> list) {
		// A method for calculating average from a list of doubles
		double avg = 0;
		for(int i = 0; i < list.size(); i++) {
			avg += list.get(i);
		}
		avg = avg / list.size();
		return avg;
	}
	
	public static double standardDev(List<Double> list) {
		// A method for calculating standard deviation from a list of doubles
		double avg = avg(list);
		double sum = 0;
		for(int i = 0; i < list.size(); i++) {
			double temp = (list.get(i) - avg) * (list.get(i) - avg);
			list.set(i, temp);
			sum += list.get(i);
		}
		sum = sum / list.size();
		return Math.sqrt(sum);
	}
	
	public static double curvedScore(double normScore) {
		// A method for calculating the curved score of an exam
		
		double lowNorm = 0;
		double highNorm = 0;
		double lowCurved = 0;
		double highCurved = 0;
		
		if(normScore >= 2) {
			return 100;
		} else if(normScore == 1) {
			return 94;
		} else if(normScore == 0) {
			return 85;
		} else if(normScore == -1) {
			return 75;
		} else if(normScore == -1.5) {
			return 65;
		} else if(normScore == -2) {
			return 55;
		} else if(normScore == -3) {
			return 35;
		} else if(normScore <= -4) {
			return 0;
		} else if(normScore > 1 && normScore < 2) {
			lowNorm = 1;
			highNorm = 2;
			lowCurved = 94;
			highCurved = 100;
		} else if(normScore > 0 && normScore < 1) {
			lowNorm = 0;
			highNorm = 1;
			lowCurved = 85;
			highCurved = 94;
		} else if(normScore > -1 && normScore < 0) {
			lowNorm = -1;
			highNorm = 0;
			lowCurved = 75;
			highCurved = 85;
		} else if(normScore > -1.5 && normScore < -1) {
			lowNorm = -1.5;
			highNorm = -1;
			lowCurved = 65;
			highCurved = 75;
		} else if(normScore > -2 && normScore < -1.5) {
			lowNorm = -2;
			highNorm = -1.5;
			lowCurved = 55;
			highCurved = 65;
		} else if(normScore > -3 && normScore < -2) {
			lowNorm = -3;
			highNorm = -2;
			lowCurved = 35;
			highCurved = 55;
		} else if(normScore > -4 && normScore < -3) {
			lowNorm = -4;
			highNorm = -3;
			lowCurved = 0;
			highCurved = 35;
		}		
		
		double curvedScore = (((normScore - lowNorm) /
                 (highNorm - lowNorm)) *
               (highCurved - lowCurved)) + lowCurved;
		
		return curvedScore;
	}

}
