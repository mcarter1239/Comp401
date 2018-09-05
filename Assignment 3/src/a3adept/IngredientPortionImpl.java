package a3adept;

public class IngredientPortionImpl implements IngredientPortion {
	private Ingredient ing;
	private double amount;
	
	public IngredientPortionImpl(Ingredient ing, double amount) {
		if(ing == null) {
			throw new RuntimeException("Ingredient cannot be null.");
		} else {
			this.ing = ing;
		}
		if(amount < 0) {
			throw new RuntimeException("Amount cannot be negative.");
		} else {
			this.amount = amount;
		}
	}
	@Override
	public Ingredient getIngredient() {
		return ing;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public String getName() {
		return getIngredient().getName();
	}

	@Override
	public boolean getIsVegetarian() {
		return getIngredient().getIsVegetarian();
	}

	@Override
	public double getCalories() {
		return getAmount() * getIngredient().getCaloriesPerOunce();
	}

	@Override
	public double getCost() {
		return getAmount() * getIngredient().getPricePerOunce();
	}

	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if(other == null) {
			return this;
		} else if(other.getName().equals(getName())) {
			return new IngredientPortionImpl(ing, other.getAmount() + getAmount());
		} else {
			throw new RuntimeException("Two different ingredients cannot be combined into one Ingredient Portion.");
		}
	}

}
