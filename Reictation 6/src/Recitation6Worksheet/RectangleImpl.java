package Recitation6Worksheet;

public class RectangleImpl extends ShapeImpl implements Rectangle {
	
	private int pair_one;
	private int pair_two;
	
	public RectangleImpl(int one, int two, int side_num) {
		super(side_num);
		pair_one = one;
		pair_two = two;
	}
	
	public double getArea() {
		return pair_one*pair_two;
	}
	
	public double getPerimeter() {
		return 2*pair_one + 2*pair_two;
	}
	
	public boolean isSquare() {
		if(pair_one == pair_two) {return true;}
		else {return false;}
	}

}
