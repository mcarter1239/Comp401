package a2jedi;

public class Ingredient {
	String name;
	double amountNeeded = 0;
	
	public Ingredient(String name, double price, boolean isVegetarian, double calories) {
		this.name = name;
	}
	
	public Ingredient(String name, double amountNeeded) {
		this(name, 0, true, 0);
		this.amountNeeded = amountNeeded;
	}
}
