package a2jedi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		//Loop through ingredients and store each one as an object in a list.
		
		int ingredientNumber = s.nextInt();
		List<Ingredient> ingredientList = new ArrayList<Ingredient>();
		for(int i = 0; i < ingredientNumber; i++) {
			ingredientList.add(new Ingredient(s.next(), s.nextDouble(), s.nextBoolean(), s.nextDouble()));
		}
		
		int menuLength = s.nextInt();
		List<MenuItem> menu = new ArrayList<MenuItem>();
		
		// Add MenuItems to a list
		
		for(int i = 0; i < menuLength; i++) {
			menu.add(new MenuItem(s.next()));
			int tempIngredientNumber = s.nextInt();
			
			/* Loop through ingredients needed for each menu item.
			 * Find each ingredient by comparing the temp ingredient
			 * name to the *.name values of the elements of ingredientList.
			 * Add each ingredient to the ingredients list in the MenuItem.
			 */
			
			for(int j = 0; j < tempIngredientNumber; j++) {
				String tempIngredientName = s.next();
				Ingredient tempIngredient = new Ingredient("temp", s.nextDouble());
				
				for(int k = 0; k < ingredientList.size(); k++) {
					if(ingredientList.get(k).name.equals(tempIngredientName)) {
						tempIngredient.name = ingredientList.get(k).name;
						menu.get(i).ingredients.add(tempIngredient);
						break;
					}
				}
			}
		}
		
		/* While there are tokens for the scanner to read, read
		 * each new order and check the order name against the menu.
		 * Once found in the menu, loop through the ingredients of the
		 * item and add the amount needed for the order to the overall
		 * amountNeeded value for that ingredient in ingredientList.
		 * If the next token is "EndOrder" break and print output. 
		 */
		while(s.hasNext()) {
			String tempMenuItemName = s.next();
			if (tempMenuItemName.equals("EndOrder")) {
				break;
			}
			for(int k = 0; k < menu.size(); k++) {
				if(menu.get(k).name.equals(tempMenuItemName)) {
					for(int j = 0; j < menu.get(k).ingredients.size(); j++) {
						for(int m = 0; m < ingredientList.size(); m++) {
							if(ingredientList.get(m).name.equals(menu.get(k).ingredients.get(j).name)) {
								ingredientList.get(m).amountNeeded += 
										menu.get(k).ingredients.get(j).amountNeeded;
								ingredientList.get(m).amountNeeded = Math.floor(ingredientList.get(m).amountNeeded * 100) / 100;
								
								break;
							}
						}
					}
				}
			}
		}
		System.out.println("The order will require: ");
		for(int i = 0; i < ingredientList.size(); i++) {
			System.out.println(ingredientList.get(i).amountNeeded + " ounces of " + ingredientList.get(i).name);
		}
	}
}

