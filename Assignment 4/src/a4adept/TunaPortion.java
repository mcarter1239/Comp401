package a4adept;

public class TunaPortion extends IngredientPortionImpl {
	public TunaPortion(double amount) {
		super(new Tuna());
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
			return new TunaPortion(this.getAmount() + other.getAmount());
		} else {
			throw new RuntimeException("Cannot combine two different types of ingredient portion.");
		}
	}
}
