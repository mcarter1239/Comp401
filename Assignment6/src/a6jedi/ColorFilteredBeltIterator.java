package a6jedi;

import comp401.sushi.Plate;

public class ColorFilteredBeltIterator extends BeltIterator {
	private Plate.Color color;
	
	public ColorFilteredBeltIterator(Belt belt, int start_position, Plate.Color color_filter) {
		super(belt, start_position);
		this.color = color_filter;
	}
	
	public boolean hasNext() {
		for(int i = 0; i < this.belt.getSize(); i++) {
			if(this.belt.getPlateAtPosition(i) != null && this.belt.getPlateAtPosition(i).getColor() == this.color) {
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
				if(this.belt.getPlateAtPosition(i) != null && this.belt.getPlateAtPosition(i).getColor() == this.color) {
					this.startPostion++;
					this.canRemove = true;
					this.nextPointer = i;
					return(this.belt.getPlateAtPosition(i));
				}
			}
		}
	}
}
