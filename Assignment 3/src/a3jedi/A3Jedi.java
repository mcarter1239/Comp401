package a3jedi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A3Jedi {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		//Loop through ingredients and store each one as an object in a list.
		
		int ingredientNumber = s.nextInt();
		List<IngredientImpl> ingredientList = new ArrayList<IngredientImpl>();
		for(int i = 0; i < ingredientNumber; i++) {
			String name = s.next();
			double price = s.nextDouble();
			boolean isVeg = s.nextBoolean();
			int calories = s.nextInt();
			
			ingredientList.add(new IngredientImpl(name, price, calories, isVeg));
		}
		
		IngredientPortionImpl[] totalIngredients = new IngredientPortionImpl[ingredientList.size()];
		for(int i = 0; i < totalIngredients.length; i++) {
			totalIngredients[i] = new IngredientPortionImpl(ingredientList.get(i), 0);
		}
		
		int menuLength = s.nextInt();
		List<MenuItemImpl> menu = new ArrayList<MenuItemImpl>();
		
		// Add MenuItems to a list
		
		for(int i = 0; i < menuLength; i++) {
			String itemName = s.next();
			int tempIngredientNumber = s.nextInt();
			IngredientPortion[] ingredients = new IngredientPortion[tempIngredientNumber];
			
			/* Loop through ingredients needed for each menu item.
			 */
			
			for(int j = 0; j < tempIngredientNumber; j++) {
				IngredientImpl tempIngredient = null;
				String tempName = s.next();
				for(int l = 0; l < ingredientList.size(); l++) {
					if(ingredientList.get(l).getName().equals(tempName)) {
						tempIngredient = ingredientList.get(l);
					}
				}
				IngredientPortionImpl tempIngredientPortion = new IngredientPortionImpl(tempIngredient, s.nextDouble());
				ingredients[j] = tempIngredientPortion;
			}
			menu.add(new MenuItemImpl(itemName, ingredients));
		}
		
		/* While there are tokens for the scanner to read, read
		 * each new order and check the order name against the menu.
		 * If the next token is "EndOrder" break and print output. 
		 */
		while(s.hasNext()) {
			String tempMenuItemName = s.next();
			if (tempMenuItemName.equals("EndOrder")) {
				break;
			}
			for(int i = 0; i < menu.size(); i++) {
				if(menu.get(i).getName().equals(tempMenuItemName)) {
					for(int j = 0; j < menu.get(i).getIngredients().length; j++) {
						for(int k = 0; k < totalIngredients.length; k++) {
							if(totalIngredients[k].getIngredient() == menu.get(i).getIngredients()[j].getIngredient()) {
								totalIngredients[k] = (IngredientPortionImpl) totalIngredients[k].combine(menu.get(i).getIngredients()[j]);
							}
						}
					}
				}
			}
			
		}
		System.out.println("The order will require: ");
		for(int i = 0; i < totalIngredients.length; i++) {
			System.out.println(totalIngredients[i].getAmount() + " ounces of " + totalIngredients[i].getName());
		}

	}

}
