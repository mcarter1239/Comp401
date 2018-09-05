package a8jedi;

import java.util.Observable;
import java.util.Observer;

import comp401.sushi.IngredientPortion;

/* Remove the spoiled plate from the belt.
 * Keep track of the total cost of all of the spoiled sushi that it has observed.
 * Keep track of the total amount of spoiled shellfish (i.e., crab and shrimp) that it has observed.
 * Keep track of the total amount of spoiled seafood (i.e., crab, shrimp, salmon, tuna, and eel) that it has observed.
 * Keep track of the total amount of spoiled food (i.e., all ingredients) that it has observed.
 */
public class SpoilageCollector implements Observer {
	private double cost;
	private double shellfish;
	private double seafood;
	private double food;
	
	public SpoilageCollector(Belt b) {
		if(b == null) {
			throw new IllegalArgumentException("Observed belt cannot be null.");
		}
		b.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Belt b = (Belt) o;
		PlateEvent e = (PlateEvent) arg;
		IngredientPortion[] temp = e.getPlate().getContents().getIngredients().clone();
		if(e.getType().equals(PlateEvent.EventType.PLATE_SPOILED)) {
			
			b.removePlateAtPosition(e.getPosition());
			
			for(int i = 0; i < e.getPlate().getContents().getIngredients().length; i++) {
				
				this.food += e.getPlate().getContents().getIngredients()[i].getAmount();
				this.cost += e.getPlate().getContents().getIngredients()[i].getCost();
				
				if(e.getPlate().getContents().getIngredients()[i].getIsShellfish()) {

					this.shellfish += e.getPlate().getContents().getIngredients()[i].getAmount();
					this.seafood += e.getPlate().getContents().getIngredients()[i].getAmount();
					
				} else if (!e.getPlate().getContents().getIngredients()[i].getIsVegetarian()) {
					this.seafood += e.getPlate().getContents().getIngredients()[i].getAmount();
				}
				
			}
		}

	}
	
	public double getTotalSpoiledCost() {
		return this.cost;
	}
	public double getTotalSpoiledShellfish() {
		return this.shellfish;
	}
	public double getTotalSpoiledSeafood() {
		return this.seafood;
	}
	public double getTotalSpoiledFood() {
		return this.food;
	}

}
