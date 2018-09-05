package a3jedi;

public interface MenuItem {
	String getName();
	IngredientPortion[] getIngredients();
	int getCalories();
	double getCost();
	boolean getIsVegetarian();
}
