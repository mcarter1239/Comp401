package a6novice;

import comp401.sushi.Plate;

public class Belt {
	private int size;
	private Plate[] plates;
	
	public Belt(int size) {
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
		if (position < 0 || position >= getSize()) {
			throw new IllegalArgumentException();
		} else {
			return plates[position];
		}
	}
	
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		} else if (position < 0 || position >= getSize()) {
			throw new IllegalArgumentException();
		} else if (this.getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		} else {
			plates[position] = plate;
		}
	}
	
	public void clearPlateAtPosition(int position) {
		if (position < 0 || position >= getSize()) {
			throw new IllegalArgumentException();
		} else {
			plates[position] = null;
		}
	}
	
	public Plate removePlateAtPosition(int position) {
		if (position < 0 || position >= getSize()) {
			throw new IllegalArgumentException();
		} else if (this.getPlateAtPosition(position) == null) {
			throw new java.util.NoSuchElementException();
		} else {
			Plate temp = this.getPlateAtPosition(position);
			this.clearPlateAtPosition(position);
			return temp;
		}
	}
}
