package a3adept;

public interface IngredientPortion {
	Ingredient getIngredient();
	double getAmount();
	String getName();
	boolean getIsVegetarian();
	double getCalories();
	double getCost();
	IngredientPortion combine(IngredientPortion other);
}
