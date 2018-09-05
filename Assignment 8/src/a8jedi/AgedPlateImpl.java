package a8jedi;

import comp401.sushi.Plate;
import comp401.sushi.PlatePriceException;
import comp401.sushi.Sushi;
import comp401.sushi.Plate.Color;

public class AgedPlateImpl implements AgedPlate {
	private Plate wrappedPlate;
	private int age;
	public AgedPlateImpl(Plate p) {
		this.wrappedPlate = p;
		this.age = 0;
	}
	@Override
	public Sushi getContents() {
		return wrappedPlate.getContents();
	}

	@Override
	public void setContents(Sushi s) throws PlatePriceException {
		wrappedPlate.setContents(s);
	}

	@Override
	public Sushi removeContents() {
		return wrappedPlate.removeContents();
	}

	@Override
	public boolean hasContents() {
		return wrappedPlate.hasContents();
	}

	@Override
	public double getPrice() {
		return wrappedPlate.getPrice();
	}

	@Override
	public Color getColor() {
		return wrappedPlate.getColor();
	}

	@Override
	public double getProfit() {
		return wrappedPlate.getProfit();
	}

	@Override
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int i) {
		this.age = i;
	}
	
	@Override
	public Plate getWrapped() {
		return this.wrappedPlate;
	}
}
