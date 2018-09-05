package a4jedi;

public class Roll implements Sushi {
	private String name;
	private IngredientPortion[] ingredients;
	
	public Roll(String name, IngredientPortion[] roll_ingredients) {
		this.name = name;
		if(roll_ingredients == null) {
			throw new RuntimeException("Ingredients of a roll cannot be null.");
		}
		for(int i = 0; i < roll_ingredients.length; i++) {
			if(roll_ingredients[i] == null) {
				throw new RuntimeException("An ingredient of a roll cannot be null.");
			}
		}
		
		
		IngredientPortion[] temp = roll_ingredients.clone();
		int counter = 0;
		
		
		for(int i = 0; i < temp.length; i++) {
			for(int j = i + 1; j < temp.length - i; j++) {
				if(temp[i] != null && temp[j] != null) {
					if(temp[i].getIngredient().equals(temp[j].getIngredient())) {
						temp[i] = temp[i].combine(temp[j]);
						temp[j] = null;
					}
				}
			}
		}
		
		for(int i = 0; i < temp.length; i++) {
			if(temp[i] != null) {
				counter += 1;
			}
		}
		
		IngredientPortion[] temp2 = new IngredientPortion[counter];
		counter = 0;
		IngredientPortion[] temp3;
		boolean seaweed = false;
		
		for(int i = 0; i < temp.length; i++) {
			if(temp[i] != null) {
				temp2[counter] = temp[i];
				counter++;
			}
		}
		
		for(int i = 0; i < temp2.length; i++) {
			if(temp2[i].getIngredient().getName() == "seaweed") {
				if(!(temp2[i].getAmount() >= 0.1)) {
					temp2[i] = new SeaweedPortion(0.1);
					seaweed = true;
					break;
				}
			}
		}
		if(seaweed) {
			temp3 = temp2.clone();
		} else {
			temp3 = new IngredientPortion[temp2.length + 1];
			for(int i = 0; i < temp2.length; i++) {
				temp3[i] = temp2[i];
			}
			temp3[temp2.length] = new SeaweedPortion(0.1);
		}
		
		this.ingredients = temp3.clone();
	}
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		return this.ingredients.clone();
	}

	@Override
	public int getCalories() {
		int temp = 0;
		for(int i = 0; i < this.getIngredients().length; i++) {
			temp += this.getIngredients()[i].getCalories();
		}
		return Math.round(temp);
	}

	@Override
	public double getCost() {
		int temp = 0;
		for(int i = 0; i < this.getIngredients().length; i++) {
			temp += this.getIngredients()[i].getCost();
		}
		temp = Math.round(temp * 100) / 100;
		return temp;
	}

	@Override
	public boolean getHasRice() {
		for(int i = 0; i < this.getIngredients().length; i++) {
			if(this.getIngredients()[i].getIsRice()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getHasShellfish() {
		for(int i = 0; i < this.getIngredients().length; i++) {
			if(this.getIngredients()[i].getIsShellfish()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getIsVegetarian() {
		for(int i = 0; i < this.getIngredients().length; i++) {
			if(!this.getIngredients()[i].getIsVegetarian()) {
				return false;
			}
		}
		return false;
	}

}
