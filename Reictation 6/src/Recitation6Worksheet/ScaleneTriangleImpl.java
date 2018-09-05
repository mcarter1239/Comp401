package Recitation6Worksheet;

public class ScaleneTriangleImpl extends TriangleImpl implements Triangle {
	
	public ScaleneTriangleImpl(int one, int two, int three) {
		super(one, two, three);
	}
	
	public String getType() {
		return "Scalene";
	}


}
