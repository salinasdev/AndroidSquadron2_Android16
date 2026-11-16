package vic.software.androidsquadron;

/**
 * Created by elvic89 on 26/11/15.
 */
public class Explosiones {
    
    private int x;
    private int y;
    private int frame;
    private int cont;

    public Explosiones(int x, int y, int frame, int cont) {
        this.x = x;
        this.y = y;
        this.frame = frame;
        this.cont = cont;
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

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
}
