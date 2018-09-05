package a3jedi;

public class MenuItemImpl implements MenuItem {
	private String name;
	private IngredientPortion[] ingredients;
	
	public MenuItemImpl(String name, IngredientPortion[] ingredients) {
		if(name == null) {
			throw new RuntimeException("Name cannot be null.");
		} else {
			this.name = name;
		}
		if(ingredients != null && ingredients.length > 0) {
			for(int i = 0; i < ingredients.length; i++) {
				if (ingredients[i] == null) {
					throw new RuntimeException("One of the input ingredient portions is null.");
				}
			}
			this.ingredients = ingredients.clone();
		} else {
			throw new RuntimeException("Ingredient portion input was null.");
		}
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public IngredientPortion[] getIngredients() {
		return ingredients.clone();
	}

	@Override
	public int getCalories() {
		int temp = 0;
		for(int i = 0; i < ingredients.length; i++) {
			temp += (int) ingredients[i].getCalories();
		}
		return temp;
	}

	@Override
	public double getCost() {
		double temp = 0;
		for(int i = 0; i < ingredients.length; i++) {
			temp += ingredients[i].getCost();
		}
		return Math.round(temp * 100) / 100;
	}

	@Override
	public boolean getIsVegetarian() {
		boolean temp = true;
		for(int i = 0; i < ingredients.length; i++) {
			if(!ingredients[i].getIsVegetarian()) {
				temp = false;
			}
		}
		return temp;
	}

}
