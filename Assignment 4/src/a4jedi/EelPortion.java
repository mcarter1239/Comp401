package a4jedi;

public class EelPortion extends IngredientPortionImpl{
	public EelPortion(double amount) {
		super(new Eel());
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
			return new EelPortion(this.getAmount() + other.getAmount());
		} else {
			throw new RuntimeException("Cannot combine two different types of ingredient portion.");
		}
	}
}
