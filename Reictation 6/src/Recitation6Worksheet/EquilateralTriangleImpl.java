package Recitation6Worksheet;

public class EquilateralTriangleImpl extends TriangleImpl implements Triangle {
	
	public EquilateralTriangleImpl(int one, int two, int three) {
		super(one, two, three);
	}
	
	public String getType() {
		return "Equilateral";
	}
}
