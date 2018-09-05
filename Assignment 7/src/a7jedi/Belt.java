package a7jedi;

import java.util.NoSuchElementException;
import java.util.Observable;

import comp401.sushi.Plate;

public class Belt extends Observable {
	private Customer[] customers;
	private Plate belt[];

	public Belt(int size) {
		if (size < 1) {
			throw new IllegalArgumentException("Belt size must be greater than zero.");
		}

		belt = new Plate[size];
		customers = new Customer[size];
	}

	public int getSize() {
		return belt.length;
	}

	public Plate getPlateAtPosition(int position) {
		position = normalizePosition(position);
		return belt[position];
	}

	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		position = normalizePosition(position);

		if (plate == null) {
			throw new IllegalArgumentException("Plate is null");
		}

		if (belt[position] != null) {
			throw new BeltPlateException(position, plate, this);
		}
		belt[position] = plate;
		setChanged();
		//making new plate event specific to this method
		PlateEvent temp = new PlateEvent(PlateEvent.EventType.PLATE_PLACED, belt[position], position);
		notifyObservers(temp);
	}

	public void clearPlateAtPosition(int position) {
		position = normalizePosition(position);
		setChanged();
		PlateEvent temp = new PlateEvent(PlateEvent.EventType.PLATE_REMOVED, belt[position], position);
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
		Plate last_plate = belt[getSize()-1];
		for (int i=getSize()-1; i>0; i--) {
			belt[i] = belt[i-1];
		}
		belt[0] = last_plate;
		
		//notify customers
		for(int i = 0; i < customers.length; i++) {
			if(customers[i] != null) {
				customers[i].observePlateOnBelt(this, belt[i], i);
			}
		}
	}
	
	//assign a customer to a spot on the customers list.  Throw exceptions when needed.
	public void registerCustomerAtPosition(Customer c, int position) {
		position = normalizePosition(position);
		
		if(c == null) {
			throw new IllegalArgumentException("The customer object is null");
		}
		
		if (customers[position] != null) {
			throw new RuntimeException("There is already a customer at position " + position);
		}
		
		for(int i = 0; i < customers.length; i++) {
			if(customers[i] == c) {
				throw new RuntimeException("This customer is already registered at another spot.");
			}
		}
		
		customers[position] = c;
	}
	
	// set position passed to null customer. Return customer that was there.
	public Customer unregisterCustomerAtPosition(int position) {
		position = normalizePosition(position);
		Customer temp = customers[position];
		customers[position] = null;
		return temp;
	}
	
}
