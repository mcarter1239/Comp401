package a8adept;

import java.util.Observable;
import java.util.Observer;

public class ProfitCounter implements Observer {
	private double totalProfit;
	private int plates;
	
	public ProfitCounter(Belt b) {
		if(b == null) {
			throw new IllegalArgumentException("Observed belt cannot be null.");
		}
		b.addObserver(this);
		
		// Initialize for existing stuff on belt
		for(int i = 0; i < b.getSize(); i++) {
			if(b.getPlateAtPosition(i) != null) {
				this.plates += 1;
				this.totalProfit += b.getPlateAtPosition(i).getProfit();
			}
		}
	}
	
	public double getTotalBeltProfit() {
		return this.totalProfit;
	}
	
	public double getAverageBeltProfit() {
		if (plates == 0) {
			return 0.0;
		}
		return this.totalProfit / this.plates;
	}
	

	@Override
	public void update(Observable o, Object e) {
		if(((PlateEvent) e).getType().equals(PlateEvent.EventType.PLATE_PLACED)) {
			this.totalProfit += ((PlateEvent) e).getPlate().getProfit();
			this.plates += 1;
		} else if(((PlateEvent) e).getType().equals(PlateEvent.EventType.PLATE_REMOVED)){
			this.totalProfit -= ((PlateEvent) e).getPlate().getProfit();
			this.plates -= 1;
		}
	}
}
