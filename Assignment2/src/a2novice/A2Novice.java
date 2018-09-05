package a2novice;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		/* Loop through the list of ingredients, storing each name
		 * to a temp variable in the loop and calculating the cal/$ value
		 * of each.  Check against existing high and low cal/$ values and
		 * replace if necessary.  Output after loop finishes
		 */
		int ingredients = s.nextInt();
		int vegetarian = 0;
		double highCalPrice = Double.NEGATIVE_INFINITY;
		double lowCalPrice = Double.POSITIVE_INFINITY;
		String highName = "";
		String lowName = "";
		
		for(int i = 0; i < ingredients; i++) {
			String tempName = s.next();
			double tempPrice = s.nextDouble();
			if(s.nextBoolean()) {
				vegetarian++;
			}
			double tempCal = s.nextDouble();
			double tempCalPrice = tempCal / tempPrice;
			if(tempCalPrice > highCalPrice) {
				highCalPrice = tempCalPrice;
				highName = tempName;
			}
			if(tempCalPrice < lowCalPrice) {
				lowCalPrice = tempCalPrice;
				lowName = tempName;
			}
		}
		
		System.out.println("Number of vegetarian ingredients: " + vegetarian);
		System.out.println("Highest cals/$: " + highName);
		System.out.println("Lowest cals/$: " + lowName);
	}
}

