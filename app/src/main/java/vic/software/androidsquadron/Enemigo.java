package vic.software.androidsquadron;

public class Enemigo {
	private int x;
	private int y;
	private int n;
	private int m;
	private int res;
	private boolean danado;
	private int dan;
	private int esp;
	private int poder_disparo;
	public Enemigo() {
		super();
	}
	public Enemigo(int x, int y, int n, int m, int res, int p_d) {
		super();
		this.x = x;
		this.y = y;
		this.n=n;
		this.m=m;
		this.setRes(res);
		this.setDan(0);
		this.setDanado(false);
		this.setEsp(0);
		this.setPoder_disparo(p_d);
		
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
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public boolean isDanado() {
		return danado;
	}
	public void setDanado(boolean danado) {
		this.danado = danado;
	}
	public int getDan() {
		return dan;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	public int getEsp() {
		return esp;
	}
	public void setEsp(int esp) {
		this.esp = esp;
	}
	public int getPoder_disparo() {
		return poder_disparo;
	}
	public void setPoder_disparo(int poder_disparo) {
		this.poder_disparo = poder_disparo;
	}
	
}
