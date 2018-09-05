package a7adept;

import java.util.Observable;
import java.util.Observer;

import comp401.sushi.Plate;

/*track numbers of colored plates on belt. Throw exception if not assigned a belt.
 * Initialize for plates already on the belt.
 */

public class PlateCounter implements Observer {
	private int red;
	private int green;
	private int blue;
	private int gold;
	
	public PlateCounter(Belt b) {
		if(b == null) {
			throw new IllegalArgumentException("Observed belt cannot be null.");
		}
		b.addObserver(this);
		
		// Initialize for existing stuff on belt
		for(int i = 0; i < b.getSize(); i++) {
			if(b.getPlateAtPosition(i) != null) {
				if(b.getPlateAtPosition(i).getColor() == Plate.Color.BLUE) {
					this.blue += 1;
				} else if(b.getPlateAtPosition(i).getColor() == Plate.Color.RED) {
					this.red += 1;
				} else if(b.getPlateAtPosition(i).getColor() == Plate.Color.GOLD) {
					this.gold += 1;
				} else if(b.getPlateAtPosition(i).getColor() == Plate.Color.GREEN) {
					this.green += 1;
				}
			}
		}
	}
	
	public int getRedPlateCount() {
		return this.red;
	}
	
	public int getGreenPlateCount() {
		return this.green;
	}
	
	public int getBluePlateCount() {
		return this.blue;
	}
	
	public int getGoldPlateCount() {
		return this.gold;
	}

	// determine if placing/removing plate.  increment/decrement the correct counter variable
	@Override
	public void update(Observable b, Object plateEvent) {
		if(((PlateEvent) plateEvent).getType() == PlateEvent.EventType.PLATE_PLACED) {
			if(((PlateEvent) plateEvent).getPlate().getColor() == Plate.Color.BLUE) {
				this.blue += 1;
			} else if(((PlateEvent) plateEvent).getPlate().getColor() == Plate.Color.RED) {
				this.red += 1;
			} else if(((PlateEvent) plateEvent).getPlate().getColor() == Plate.Color.GOLD) {
				this.gold += 1;
			} else if(((PlateEvent) plateEvent).getPlate().getColor() == Plate.Color.GREEN) {
				this.green += 1;
			}
		} else if(((PlateEvent) plateEvent).getType() == PlateEvent.EventType.PLATE_REMOVED) {
			if(((PlateEvent) plateEvent).getPlate().getColor() == Plate.Color.BLUE) {
				this.blue -= 1;
			} else if(((PlateEvent) plateEvent).getPlate().getColor() == Plate.Color.RED) {
				this.red -= 1;
			} else if(((PlateEvent) plateEvent).getPlate().getColor() == Plate.Color.GOLD) {
				this.gold -= 1;
			} else if(((PlateEvent) plateEvent).getPlate().getColor() == Plate.Color.GREEN) {
				this.green -= 1;
			}
		}
	}

}
