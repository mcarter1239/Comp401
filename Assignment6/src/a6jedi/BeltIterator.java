package a6jedi;

import java.util.Iterator;

import comp401.sushi.Plate;

public class BeltIterator implements Iterator<Plate> {
	protected Belt belt;
	protected int startPostion;
	protected boolean canRemove;
	protected int nextPointer;
	
	public BeltIterator(Belt belt, int start_position) {
		this.belt = belt;
		int temp = 0;
		if(start_position > 0) {
			temp = start_position % belt.getSize();
		} else if (start_position < 0) {
			temp = (start_position % belt.getSize()) + belt.getSize();
		} else {
			temp = 0;
		}
		this.startPostion = temp;
	}
	
	public boolean hasNext() {
		for(int i = 0; i < this.belt.getSize(); i++) {
			if(this.belt.getPlateAtPosition(i) != null) {
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
				if(this.belt.getPlateAtPosition(i) != null) {
					this.startPostion++;
					this.canRemove = true;
					this.nextPointer = i;
					return(this.belt.getPlateAtPosition(i));
				}
			}
		}
	}
	
	public void remove() {
		if(this.canRemove) {
			this.belt.removePlateAtPosition(this.nextPointer);
			this.canRemove = false;
		} else {
			throw new IllegalStateException();
		}
	}
}
