package vic.software.androidsquadron;

import vic.software.androidsquadron.marco.Pixmap;

public class ItemsGets {
	
	private int cont;
	private int cass;
	private Pixmap asset;
	private int x,y,sx,sy;
	

	public ItemsGets() {
		super();
	}

	public ItemsGets(int cont, int cass, Pixmap a, int x, int y, int sx, int sy) {
		super();
		this.cont = cont;
		this.asset = a;
		this.cass=cass;
		this.sx=sx;
		this.sy=sy;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public Pixmap getAsset() {
		return asset;
	}

	public void setAsset(Pixmap asset) {
		this.asset = asset;
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

	public int getCass() {
		return cass;
	}

	public void setCass(int cass) {
		this.cass = cass;
	}

	public int getSx() {
		return sx;
	}

	public void setSx(int sx) {
		this.sx = sx;
	}

	public int getSy() {
		return sy;
	}

	public void setSy(int sy) {
		this.sy = sy;
	}
	
	

}
