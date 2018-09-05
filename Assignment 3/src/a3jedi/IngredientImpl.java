package a3jedi;

public class IngredientImpl implements Ingredient {
	private String name;
	private double price;
	private boolean is_vegetarian;
	private int calories;
	
	public IngredientImpl(String name, double price, int calories, boolean is_vegetarian) {
		if(name == null) {
			throw new RuntimeException("Name cannot be null.");
		} else {
			this.name = name;
		}
		if(price < 0) {
			throw new RuntimeException("Price cannot be negative.");
		} else {
			this.price = price;
		}
		if(calories < 0) {
			throw new RuntimeException("Calories cannot be negative.");
		} else {
			this.calories = calories;
		}
		this.is_vegetarian = is_vegetarian;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean getIsVegetarian() {
		return this.is_vegetarian;
	}

	@Override
	public double getPricePerOunce() {
		return this.price;
	}

	@Override
	public int getCaloriesPerOunce() {
		return this.calories;
	}

	@Override
	public double getCaloriesPerDollar() {
		return (this.calories / this.price);
	}

}
