package mandelbrot;

class ColorPoint {
	private int x, y;
	private int[] color;

	public ColorPoint(int x, int y, int[] color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int[] getColor() {
		return color;
	}
}