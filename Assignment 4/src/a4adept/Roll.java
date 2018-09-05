package a4adept;

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
		this.ingredients = roll_ingredients.clone();
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
		double temp = 0;
		for(int i = 0; i < this.getIngredients().length; i++) {
			temp += this.getIngredients()[i].getCalories();
		}
		return (int) Math.round(temp);
	}

	@Override
	public double getCost() {
		double temp = 0;
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
