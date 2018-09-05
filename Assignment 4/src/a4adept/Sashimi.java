package a4adept;

public class Sashimi implements Sushi {
	public enum SashimiType {TUNA, SALMON, EEL, CRAB, SHRIMP};
	private IngredientPortion seafood;
	
	public Sashimi(SashimiType type) {
		if(type == SashimiType.TUNA) {
			this.seafood = new TunaPortion(0.75);
		}
		if(type == SashimiType.SALMON) {
			this.seafood = new SalmonPortion(0.75);
		}
		if(type == SashimiType.EEL) {
			this.seafood = new EelPortion(0.75);
		}
		if(type == SashimiType.CRAB) {
			this.seafood = new CrabPortion(0.75);
		}
		if(type == SashimiType.SHRIMP) {
			this.seafood = new ShrimpPortion(0.75);
		}
	}
	@Override
	public String getName() {
		return this.seafood.getName() + " sashimi";
	}

	@Override
	public IngredientPortion[] getIngredients() {
		IngredientPortion[] temp = new IngredientPortion[1];
		temp[0] = this.seafood;
		return temp.clone();
	}

	@Override
	public int getCalories() {
		int temp = 0;
		for(int i = 0; i < this.getIngredients().length; i++) {
			temp += this.getIngredients()[i].getCalories();
		}
		return Math.round(temp);
	}

	@Override
	public double getCost() {
		int temp = 0;
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
