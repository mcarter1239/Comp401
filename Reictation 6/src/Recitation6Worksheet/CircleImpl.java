package Recitation6Worksheet;

public class CircleImpl extends ShapeImpl implements Circle{
	
	private int radius;
	
	public CircleImpl(int radius) {
		super(1);
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return(radius*radius)*3.14;
	}
	
	public double getPerimeter() {
		return 2*3.14*radius;
	}

}
