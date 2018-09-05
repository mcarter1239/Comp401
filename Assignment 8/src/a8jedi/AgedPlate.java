package a8jedi;

import comp401.sushi.Plate;

public interface AgedPlate extends Plate {
	int getAge();
	void setAge(int i);
	Plate getWrapped();
}
