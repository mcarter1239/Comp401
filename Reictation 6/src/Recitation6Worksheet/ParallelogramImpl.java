package Recitation6Worksheet;

public class ParallelogramImpl extends ShapeImpl implements Parallelogram{
	
	private int base;
	private int slant;
	private int height;
	
	public ParallelogramImpl(int base, int slant, int height, int side_num) {
		super(side_num);
		this.base = base;
		this.slant = slant;
		this.height = height;
	}
	
	public double getArea() {
		return base*height;
	}
	
	public double getPerimeter() {
		return 2*base + 2*slant;
	}
	
	public double getHeight() {
		return height;
	}
}
