package vic.software.androidsquadron;

public class Pompa {

	private int x;
	private int y;
	private int tipo;
	private int mx;
	private int my;
	private int ani=0;
	private int pani=30;
	private int cani=1;
	public Pompa() {
		super();
	}
	public Pompa(int x, int y, int tipo, int mx, int my) {
		super();
		this.x = x;
		this.y = y;
		this.tipo = tipo;
		this.mx=mx;
		this.my=my;
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
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getMx() {
		return mx;
	}
	public void setMx(int mx) {
		this.mx = mx;
	}
	public int getMy() {
		return my;
	}
	public void setMy(int my) {
		this.my = my;
	}
	public int getAni() {
		return ani;
	}
	public void setAni(int ani) {
		this.ani = ani;
	}
	public int getPani() {
		return pani;
	}
	public void setPani(int pani) {
		this.pani = pani;
	}
	public int getCani() {
		return cani;
	}
	public void setCani(int cani) {
		this.cani = cani;
	}
	
	
}
