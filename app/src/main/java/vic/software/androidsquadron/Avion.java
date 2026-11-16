package vic.software.androidsquadron;

public class Avion {
	
	private int x;
	private int y;
	public Avion() {
		super();
	}
	public Avion(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void ponte(int x){
		this.x=(x-30);
	
	}

}
