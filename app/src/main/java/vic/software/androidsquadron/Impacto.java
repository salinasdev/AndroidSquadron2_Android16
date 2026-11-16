package vic.software.androidsquadron;

public class Impacto {
	
	private int x;
	private int xi;
	private int y;
	private int reta; //Retadordo de la animacion 3
	private int n; //Animacion
	public Impacto(int x, int y, int xi) {
		super();
		this.x = x;
		this.y = y;
		this.xi=xi;
		this.n = 0;
		this.reta = 0;
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
	
	public void incN(){
		this.n++;
	}
	public int getXi() {
		return xi;
	}
	public void setXi(int xi) {
		this.xi = xi;
	}
	public int getReta() {
		return reta;
	}
	public void setReta(int reta) {
		this.reta = reta;
	}
	
	public int incReta(){
		this.reta++;
		if(this.reta<3){
			
		}else{
			this.reta=0;
		}
		return reta;
	}
	

}
