package a4adept;

abstract public class IngredientPortionImpl implements IngredientPortion {
	private Ingredient ingredient;
	public double amount;
	
	public IngredientPortionImpl(Ingredient ingredient) {
		if(ingredient == null) {
			throw new RuntimeException("Cannot make an ingredient portion of null.");
		}
		this.ingredient = ingredient;
	}
	@Override
	public Ingredient getIngredient() {
		return this.ingredient;
	}

	@Override
	public String getName() {
		return this.getIngredient().getName();
	}

	@Override
	public double getAmount() {
		return this.amount;
	}

	@Override
	public double getCalories() {
		return this.getIngredient().getCaloriesPerOunce() * this.getAmount();
	}

	@Override
	public double getCost() {
		return this.getIngredient().getPricePerOunce() * this.getAmount();
	}

	@Override
	public boolean getIsVegetarian() {
		return this.getIngredient().getIsVegetarian();
	}

	@Override
	public boolean getIsRice() {
		return this.getIngredient().getIsRice();
	}

	@Override
	public boolean getIsShellfish() {
		return this.getIngredient().getIsShellfish();
	}

	@Override
	abstract public IngredientPortion combine(IngredientPortion other);

}
