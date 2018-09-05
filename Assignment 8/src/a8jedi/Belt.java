package a8jedi;

import java.util.NoSuchElementException;
import java.util.Observable;

import comp401.sushi.Plate;

public class Belt extends Observable {

	private AgedPlate belt[];

	public Belt(int size) {
		if (size < 1) {
			throw new IllegalArgumentException("Belt size must be greater than zero.");
		}

		belt = new AgedPlate[size];
	}

	public int getSize() {
		return belt.length;
	}

	public Plate getPlateAtPosition(int position) {
		position = normalizePosition(position);
		if(belt[position] != null) {
			return belt[position].getWrapped();
		}
		return null;
		
	}

	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		position = normalizePosition(position);

		if (plate == null) {
			throw new IllegalArgumentException("Plate is null");
		}

		if (belt[position] != null) {
			throw new BeltPlateException(position, plate, this);
		}
		
		AgedPlate agedPlate = new AgedPlateImpl(plate);
		
		belt[position] = agedPlate;
		
		setChanged();
		PlateEvent temp = new PlateEvent(PlateEvent.EventType.PLATE_PLACED, belt[position].getWrapped(), position);
		notifyObservers(temp);
	}

	public void clearPlateAtPosition(int position) {
		position = normalizePosition(position);
		setChanged();
		PlateEvent temp = new PlateEvent(PlateEvent.EventType.PLATE_REMOVED, belt[position].getWrapped(), position);
		notifyObservers(temp);
		belt[position] = null;
	}

	public Plate removePlateAtPosition(int position) {
		Plate plate = getPlateAtPosition(position);
		if (plate == null) {
			throw new NoSuchElementException();
		}
		clearPlateAtPosition(position);
		return plate;
	}

	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		for (int i=0; i<getSize(); i++) {
			try {
				setPlateAtPosition(plate, position);
				setChanged();
				PlateEvent temp = new PlateEvent(PlateEvent.EventType.PLATE_PLACED, plate, position);
				notifyObservers(temp);
				return normalizePosition(position);
			} catch (BeltPlateException e) {
				position += 1;
			}
		}
		throw new BeltFullException(this);
	}

	private int normalizePosition(int position) {
		int normalized_position = position%getSize();

		if (position < 0) {
			normalized_position += getSize();
		}

		return normalized_position;
	}

	public void rotate() {
		AgedPlate last_plate = belt[getSize()-1];
		
		for (int i = getSize () - 1; i > 0; i--) {
			belt[i] = belt[i-1];
		}
		
		belt[0] = last_plate;
		
		for(int i = 0; i < getSize(); i++) {
			//increment age
			if(belt[i] != null) {
				belt[i].setAge(belt[i].getAge() + 1);
				
				//check if spoiled and notify observers
				if(belt[i].getContents().getHasShellfish() && belt[i].getAge() >= belt.length) {
					setChanged();
					notifyObservers(new PlateEvent(PlateEvent.EventType.PLATE_SPOILED, belt[i].getWrapped(), i));
				} else if(belt[i].getContents().getIsVegetarian() && belt[i].getAge() >= 3 * belt.length) {
					setChanged();
					notifyObservers(new PlateEvent(PlateEvent.EventType.PLATE_SPOILED, belt[i].getWrapped(), i));
				} else if(!belt[i].getContents().getIsVegetarian() && belt[i].getAge() >= 2 * belt.length) {
					setChanged();
					notifyObservers(new PlateEvent(PlateEvent.EventType.PLATE_SPOILED, belt[i].getWrapped(), i));
				}
			}
		}
	}
	
	public int getAgeOfPlateAtPosition(int position) {
		position = normalizePosition(position);
		
		if(belt[position] == null) {
			return -1;
		}
		
		return belt[position].getAge();
	}
}
