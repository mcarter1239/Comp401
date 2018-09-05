package a4adept;

public class Nigiri implements Sushi {
	public enum NigiriType {TUNA, SALMON, EEL, CRAB, SHRIMP};
	private IngredientPortion[] ingredients = new IngredientPortion[2];
	
	public Nigiri(NigiriType type) {
		if(type == NigiriType.TUNA) {
			this.ingredients[0] = new TunaPortion(0.75);
		}
		if(type == NigiriType.SALMON) {
			this.ingredients[0] = new SalmonPortion(0.75);
		}
		if(type == NigiriType.EEL) {
			this.ingredients[0] = new EelPortion(0.75);
		}
		if(type == NigiriType.CRAB) {
			this.ingredients[0] = new CrabPortion(0.75);
		}
		if(type == NigiriType.SHRIMP) {
			this.ingredients[0] = new ShrimpPortion(0.75);
		}
		this.ingredients[1] = new RicePortion(0.5);
	}
	
	@Override
	public String getName() {
		return this.ingredients[0].getName() + " nigiri";
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
