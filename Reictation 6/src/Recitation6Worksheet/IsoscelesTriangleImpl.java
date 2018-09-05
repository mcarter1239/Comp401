package Recitation6Worksheet;

public class IsoscelesTriangleImpl extends TriangleImpl implements Triangle {
	
	public IsoscelesTriangleImpl(int one, int two, int three) {
		super(one, two, three);
	}
	
	public String getType() {
		return "Isosceles";
	}

}
