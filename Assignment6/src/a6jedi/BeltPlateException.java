package a6jedi;

import comp401.sushi.Plate;

public class BeltPlateException extends Exception {
	private int position;
	private Plate plateToBeSet;
	private Belt belt;
	public BeltPlateException(int position, Plate plate_to_be_set, Belt belt) {
		super("Already a plate at that position.");
		this.position = position;
		this.plateToBeSet = plate_to_be_set;
		this.belt = belt;
	}
	
	public int getPosition() {
		return position;
	}
	public Plate getPlateToSet() {
		return plateToBeSet;
	}
	public Belt getBelt() {
		return belt;
	}
}
