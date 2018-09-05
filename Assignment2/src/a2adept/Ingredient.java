package a2adept;

public class Ingredient {
	String name;
	double price;
	boolean isVegetarian;
	double calories;
	
	public Ingredient(String name, double price, boolean isVegetarian, double calories) {
		this.name = name;
		this.price = price;
		this.isVegetarian = isVegetarian;
		this.calories = calories;
	}

}
