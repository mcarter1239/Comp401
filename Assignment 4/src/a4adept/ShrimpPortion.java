package a4adept;

public class ShrimpPortion extends IngredientPortionImpl {
	public ShrimpPortion(double amount) {
		super(new Shrimp());
		if(amount > 0) {
			this.amount = amount;
		} else {
			throw new RuntimeException("Amount must be greater than zero to create an ingredient portion.");
		}
	}
	@Override
	public IngredientPortion combine(IngredientPortion other) {
		if(other == null) {
			return this;
		} else if(this.getIngredient().equals(other.getIngredient())) {
			return new ShrimpPortion(this.getAmount() + other.getAmount());
		} else {
			throw new RuntimeException("Cannot combine two different types of ingredient portion.");
		}
	}

}
