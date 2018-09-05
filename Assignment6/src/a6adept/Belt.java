package a6adept;

import java.util.Iterator;

import comp401.sushi.Plate;

public class Belt implements Iterable<Plate> {
	private int size;
	private Plate[] plates;
	
	public Belt (int size){
		if (size > 0) {
			this.size = size;
			this.plates = new Plate[size];
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public Plate getPlateAtPosition(int position) {
		int temp = 0;
		if(position > 0) {
			temp = position % getSize();
		} else if (position < 0) {
			temp = (position % getSize()) + getSize();
		} else {
			temp = 0;
		}
		return plates[temp];
	}
	
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		} else if (this.getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		} else {
			int temp = 0;
			if(position > 0) {
				temp = position % getSize();
			} else if (position < 0) {
				temp = (position % getSize()) + getSize();
			} else {
				temp = 0;
			}
			plates[temp] = plate;
		}
	}
	
	public void clearPlateAtPosition(int position) {
		int temp = 0;
		if(position > 0) {
			temp = position % getSize();
		} else if (position < 0) {
			temp = (position % getSize()) + getSize();
		} else {
			temp = 0;
		}
		plates[temp] = null;
	}
	
	public Plate removePlateAtPosition(int position) {
		if (this.getPlateAtPosition(position) == null) {
			throw new java.util.NoSuchElementException();
		} else {
			int temp = 0;
			if(position > 0) {
				temp = position % getSize();
			} else if (position < 0) {
				temp = (position % getSize()) + getSize();
			} else {
				temp = 0;
			}
			Plate tempPlate = this.getPlateAtPosition(temp);
			this.clearPlateAtPosition(temp);
			return tempPlate;
		}
	}
	
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException, BeltPlateException {		
		boolean started = false;
		for(int i = position; true; i++) {
			if(i == getSize()) {
				i = 0;
			}
			
			if(this.getPlateAtPosition(i) == null) {
				this.setPlateAtPosition(plate, i);
				return i;
			}
			
			if(started && i == position) {
				throw new BeltFullException(this);
			}
			started = true;
		}
	}
	
	public Iterator<Plate> iterator() {
		return new BeltIterator(this, 0);
	}

	public Iterator<Plate> iteratorFromPosition(int position) {
		return new BeltIterator(this, position);
	}
	
	public void rotate() throws BeltPlateException {
		Plate temp = null;
		Plate temp2 = null;
		for(int i = 0; i < getSize(); i++) {
			if (this.getPlateAtPosition(i) != null) {
				temp2 = this.removePlateAtPosition(i);
			}
			if(temp != null) {
				this.setPlateAtPosition(temp, i);
			}
			temp = temp2;
			temp2 = null;
			if(i == getSize() - 1 && temp != null) {
				this.setPlateAtPosition(temp, 0);
			}
		}
	}
}

