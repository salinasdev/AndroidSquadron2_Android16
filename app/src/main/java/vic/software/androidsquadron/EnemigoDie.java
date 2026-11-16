package vic.software.androidsquadron;

import vic.software.androidsquadron.marco.Pixmap;

public class EnemigoDie {
	
	private int x,y;
	private Pixmap asset;
	private int cont;
	private int retard;
	
	public EnemigoDie(int x, int y, Pixmap asset, int cont) {
		super();
		this.x = x;
		this.y = y;
		this.asset = asset;
		this.cont = cont;
		this.retard=0;
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
	public Pixmap getAsset() {
		return asset;
	}
	public void setAsset(Pixmap asset) {
		this.asset = asset;
	}
	public int getCont() {
		return cont;
	}
	public void setCont(int cont) {
		this.cont = cont;
	}
	public int getRetard() {
		return retard;
	}
	public void setRetard(int retard) {
		this.retard = retard;
	}
	
	

}
