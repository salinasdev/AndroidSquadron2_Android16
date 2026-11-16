package vic.software.androidsquadron;

/**
 * Created by elvic89 on 9/8/15.
 */
public class Acorazado {

    private int vida; //Vida del Acorazado
    private int x; //Posicion X en el eje de coordenadas
    private int y; //Posicion Y en el eje de coordenadas
    private boolean activo; //Al estar activo este switch es que se e puede golpear.
    private int count_ataque; //Contador que cada nataque veces realice un ataque.
    private int nataque; //Cada nataque lanzará un ataque.

    public Acorazado(int vida, int x, int y, boolean activo, int count_ataque, int nataque) {
        this.vida = vida;
        this.x = x;
        this.y = y;
        this.activo = activo;
        this.count_ataque = count_ataque;
        this.nataque = nataque;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getCount_ataque() {
        return count_ataque;
    }

    public void setCount_ataque(int count_ataque) {
        this.count_ataque = count_ataque;
    }

    public int getNataque() {
        return nataque;
    }

    public void setNataque(int nataque) {
        this.nataque = nataque;
    }
}
