package vic.software.androidsquadron;

public class DisparoEnemigo {
	private int x;
	private int y;
	private int poder;
	public DisparoEnemigo() {
		super();
	}
	public DisparoEnemigo(int x, int y,int poder) {
		super();
		this.x = x;
		this.y = y;
		this.setPoder(poder);
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
	public int getPoder() {
		return poder;
	}
	public void setPoder(int poder) {
		this.poder = poder;
	}
}
