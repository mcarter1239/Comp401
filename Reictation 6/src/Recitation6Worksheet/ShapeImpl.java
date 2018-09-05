package Recitation6Worksheet;

abstract public class ShapeImpl implements Shape {
	private int numOfSides;
	
	public ShapeImpl(int sides) {
		numOfSides = sides;
	}
	
	abstract public double getPerimeter();
	abstract public double getArea();

}
