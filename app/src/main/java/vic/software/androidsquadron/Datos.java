package vic.software.androidsquadron;

import vic.software.androidsquadron.marco.Musica;
import vic.software.androidsquadron.marco.Pixmap;

public class Datos {
	
	private static int N_NIVEL; //Numero de nivel
	private static int RAT_FUEL; //Cada RAT_FUEL Aviones soltamos un fuel
	private static int RAT_TOR; //Cada RAT_TOR Aviones puede haber una tormenta
	private static int RAT_ITEM; //Cada RAT_ITEM Aviones soltamos un item [SIEMPRE QUE NO SE VAYA A SACAR FUEL]
	private static int RES_SIZE; //RES_SIZE + MIN_RES es el MAXIMO de restencia que un avion enemio puede tener
	private static int MIN_RES; //Minimo de resistencia de un enegigo
	private static int NUM_ENE; //Numero de enemigos que aparecer�n en el nivel
	private static int TIME_ENEMIGO; //Intervalo de aparicion de enemigos (mas bajo, menos tardan)
	private static int TIME_BALA; //Intervalo de disparo enemigo
	private static int TIME_FUEL; //Intervalo de gasto de fuel	
	private static int VIDA_TOTAL; //Vida de nuestro personaje
	private static int FUEL_TOTAL; //Capacidad total de fuel
	private static int VELOCIDAD_ENEMIGO;
	private static Pixmap nivel; //Pantalla
	private static Pixmap next_nivel; //Pantalla siguiente (Modo torneo)
	private static Musica musica;
	private static Pixmap acorazado; //Solo para ultimo nivel
	
	public Datos(){
		
	}
	
	public Datos(int rAT_FUEL, int rAT_TOR, int rAT_ITEM, int rES_SIZE,
			int mIN_RES, int nUM_ENE, int tIME_ENEMIGO, int tIME_BALA,
			int tIME_FUEL, int vIDA_TOTAL, int fUEL_TOTAL, Pixmap p, Musica m) {
		super();
		RAT_FUEL = rAT_FUEL;
		RAT_TOR = rAT_TOR;
		RAT_ITEM = rAT_ITEM;
		RES_SIZE = rES_SIZE;
		MIN_RES = mIN_RES;
		NUM_ENE = nUM_ENE;
		TIME_ENEMIGO = tIME_ENEMIGO;
		TIME_BALA = tIME_BALA;
		TIME_FUEL = tIME_FUEL;
		VIDA_TOTAL = vIDA_TOTAL;
		FUEL_TOTAL = fUEL_TOTAL;
		nivel=p;
		musica=m;
	}
	
	
	public static Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		Datos.musica = musica;
	}

	public Pixmap getNivel() {
		return nivel;
	}

	public void setNivel(Pixmap nivel) {
		Datos.nivel = nivel;
	}

	public int getRAT_FUEL() {
		return RAT_FUEL;
	}
	public void setRAT_FUEL(int rAT_FUEL) {
		RAT_FUEL = rAT_FUEL;
	}
	public int getRAT_TOR() {
		return RAT_TOR;
	}
	public void setRAT_TOR(int rAT_TOR) {
		RAT_TOR = rAT_TOR;
	}
	public int getRAT_ITEM() {
		return RAT_ITEM;
	}
	public void setRAT_ITEM(int rAT_ITEM) {
		RAT_ITEM = rAT_ITEM;
	}
	public int getRES_SIZE() {
		return RES_SIZE;
	}
	public void setRES_SIZE(int rES_SIZE) {
		RES_SIZE = rES_SIZE;
	}
	public int getMIN_RES() {
		return MIN_RES;
	}
	public void setMIN_RES(int mIN_RES) {
		MIN_RES = mIN_RES;
	}
	public int getNUM_ENE() {
		return NUM_ENE;
	}
	public void setNUM_ENE(int nUM_ENE) {
		NUM_ENE = nUM_ENE;
	}
	public int getTIME_ENEMIGO() {
		return TIME_ENEMIGO;
	}
	public void setTIME_ENEMIGO(int tIME_ENEMIGO) {
		TIME_ENEMIGO = tIME_ENEMIGO;
	}
	public int getTIME_BALA() {
		return TIME_BALA;
	}
	public void setTIME_BALA(int tIME_BALA) {
		TIME_BALA = tIME_BALA;
	}
	public int getTIME_FUEL() {
		return TIME_FUEL;
	}
	public void setTIME_FUEL(int tIME_FUEL) {
		TIME_FUEL = tIME_FUEL;
	}
	public int getVIDA_TOTAL() {
		return VIDA_TOTAL;
	}
	public void setVIDA_TOTAL(int vIDA_TOTAL) {
		VIDA_TOTAL = vIDA_TOTAL;
	}
	public int getFUEL_TOTAL() {
		return FUEL_TOTAL;
	}
	public void setFUEL_TOTAL(int fUEL_TOTAL) {
		FUEL_TOTAL = fUEL_TOTAL;
	}

	public static int getN_NIVEL() {
		return N_NIVEL;
	}

	public static void setN_NIVEL(int n_NIVEL) {
		N_NIVEL = n_NIVEL;
	}

	public static int getVELOCIDAD_ENEMIGO() {
		return VELOCIDAD_ENEMIGO;
	}

	public static void setVELOCIDAD_ENEMIGO(int vELOCIDAD_ENEMIGO) {
		VELOCIDAD_ENEMIGO = vELOCIDAD_ENEMIGO;
	}

	public Pixmap getNext_nivel() {
		return next_nivel;
	}

	public void setNext_nivel(Pixmap next_nivel) {
		Datos.next_nivel = next_nivel;
	}


	public Pixmap getAcorazado() {
		return acorazado;
	}

	public void setAcorazado(Pixmap acorazado) {
		this.acorazado = acorazado;
	}
}
