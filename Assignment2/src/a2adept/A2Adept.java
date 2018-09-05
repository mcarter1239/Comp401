package a2adept;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class A2Adept {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		/* Loop through ingredients and store each one as an object in a list.
		 * Then, loop through each menu item and calculate calories and cost
		 * by looping through the ingredients of the item.
		 */
		
		// Store Ingredient objects
		int ingredientNumber = s.nextInt();
		List<Ingredient> ingredientList = new ArrayList<Ingredient>();
		for(int i = 0; i < ingredientNumber; i++) {
			ingredientList.add(new Ingredient(s.next(), s.nextDouble(), s.nextBoolean(), s.nextDouble()));
		}
		
		int menuLength = s.nextInt();
		List<MenuItem> menu = new ArrayList<MenuItem>();
		
		/* Store MenuItem objects. Calculate calories and
		 * cost and determine vegetarian status by adding to
		 * MenuItem properties while reading info from
		 * ingredients list.  Output for each menu item.
		 */
		
		for(int i = 0; i < menuLength; i++) {
			menu.add(new MenuItem(s.next()));
			int tempIngredientNumber = s.nextInt();
			
			for(int j = 0; j < tempIngredientNumber; j++) {
				String tempIngredientName = s.next();
				Ingredient tempIngredient = new Ingredient("temp", 0, true, 0);
				double tempIngredientOzs = s.nextDouble();
				
				for(int k = 0; k < ingredientList.size(); k++) {
					if(ingredientList.get(k).name.equals(tempIngredientName)) {
						tempIngredient = ingredientList.get(k);
						break;
					}
				}
				
				menu.get(i).calories += tempIngredient.calories * tempIngredientOzs;
				menu.get(i).cost += tempIngredient.price * tempIngredientOzs;
				
				if(!(menu.get(i).isVegetarian && tempIngredient.isVegetarian)) {
					menu.get(i).isVegetarian = false;
				}
			}
			
			menu.get(i).calories = ((int) (menu.get(i).calories + 0.5));
			menu.get(i).cost = ((int) ((menu.get(i).cost * 100.0)+0.5))/100.0;
			
			System.out.println(menu.get(i).name + ":");
			System.out.println("  " + (int) menu.get(i).calories + " calories");
			System.out.println("  $" + menu.get(i).cost);
			System.out.println((menu.get(i).isVegetarian) ? "  Vegetarian" : "  Non-Vegetarian");
		}
	}
}

