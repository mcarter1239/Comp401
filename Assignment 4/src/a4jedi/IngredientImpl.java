package a4jedi;

public class IngredientImpl implements Ingredient {
	private String name;
	private int caloriesPerOunce;
	private double pricePerOunce;
	private boolean isVegetarian;
	private boolean isRice;
	private boolean isShellfish;
	
	public IngredientImpl(String name, double pricePerOunce, int caloriesPerOunce, boolean isVegetarian, boolean isRice, boolean isShellfish) {
		this.name = name;
		this.pricePerOunce = pricePerOunce;
		this.caloriesPerOunce = caloriesPerOunce;
		this.isRice = isRice;
		this.isVegetarian = isVegetarian;
		this.isShellfish = isShellfish;
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getCaloriesPerDollar() {
		return this.getCaloriesPerOunce()/this.getPricePerOunce();
	}

	@Override
	public int getCaloriesPerOunce() {
		return caloriesPerOunce;
	}

	@Override
	public double getPricePerOunce() {
		return pricePerOunce;
	}

	@Override
	public boolean equals(Ingredient other) {
		if(other == null) {
			return false;
		}
		if(this.getName().equals(other.getName())) {
			if(this.getCaloriesPerOunce() == other.getCaloriesPerOunce()) {
				if(Math.abs(getPricePerOunce() - other.getPricePerOunce()) < 0.01) {
					if(getIsVegetarian() == other.getIsVegetarian()) {
						if(getIsRice() == other.getIsRice()) {
							if(getIsShellfish() == other.getIsShellfish()) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean getIsVegetarian() {
		return isVegetarian;
	}

	@Override
	public boolean getIsRice() {
		return isRice;
	}

	@Override
	public boolean getIsShellfish() {
		return isShellfish;
	}

}
