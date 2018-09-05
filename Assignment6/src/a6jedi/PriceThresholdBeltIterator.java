package a6jedi;

import comp401.sushi.Plate;

public class PriceThresholdBeltIterator extends BeltIterator {
	private double maxPrice;
	
	public PriceThresholdBeltIterator(Belt belt, int start_position, double max_price) {
		super(belt, start_position);
		this.maxPrice = max_price;
	}
	
	public boolean hasNext() {
		for(int i = 0; i < this.belt.getSize(); i++) {
			if(this.belt.getPlateAtPosition(i) != null && this.belt.getPlateAtPosition(i).getPrice() <= this.maxPrice) {
				return true;
			}
		}
		return false;
	}
	
	public Plate next() {
		if(!hasNext()) {
			throw new java.util.NoSuchElementException();
		} else {
			for(int i = this.startPostion; true; i++) {
				if(i == this.belt.getSize()) {
					i = 0;
				}
				this.startPostion = i;
				if(this.belt.getPlateAtPosition(i) != null && this.belt.getPlateAtPosition(i).getPrice() <= this.maxPrice) {
					this.startPostion++;
					this.canRemove = true;
					this.nextPointer = i;
					return(this.belt.getPlateAtPosition(i));
				}
			}
		}
	}
	
}
