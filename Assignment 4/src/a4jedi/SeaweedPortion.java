package a4jedi;

public class SeaweedPortion extends IngredientPortionImpl {
	public SeaweedPortion(double amount) {
		super(new Seaweed());
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
			return new SeaweedPortion(this.getAmount() + other.getAmount());
		} else {
			throw new RuntimeException("Cannot combine two different types of ingredient portion.");
		}
	}
}
