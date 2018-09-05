package Recitation6Worksheet;

abstract public class TriangleImpl extends ShapeImpl implements Triangle {
	private int side_one;
	private int side_two;
	private int side_three;
	
	public TriangleImpl(int one, int two, int three) {
		super(3);
		side_one = one;
		side_two = two;
		side_three = three;
	}
	
	public double getArea() {
		double half_p = 0.5*(side_one+side_two+side_three);
		double result = Math.sqrt(half_p*(half_p-side_one)*(half_p-side_two)*(half_p-side_three));
		return result;
	}
	
	abstract public String getType();
	
	public boolean isRightTriangle() {
		int hyp = 0;
		int leg_one = 0;
		int leg_two = 0;
		if(side_one > side_two) {
			hyp = side_one;
			leg_one = side_two;
		}
		else {
			hyp = side_two;
			leg_one = side_one;
		}
		
		if (side_three > hyp) {
			leg_two = hyp;
			hyp = side_three;
		}
		else {leg_two = side_three;}
		
		int hyp_squared = hyp*hyp;
		int legs_squared = (leg_one*leg_one) + (leg_two*leg_two);
		
		if(hyp_squared == legs_squared) {
			return true;
		}
		else {return false;}
	}
	
	public double getPerimeter() {
		return side_one + side_two + side_three;
	}

}
