package vic.software.androidsquadron.marco;


import vic.software.androidsquadron.marco.Graficos.PixmapFormat;

public interface Pixmap {
    public int getWidth();

    public int getHeight();

    public PixmapFormat getFormat();

    public void dispose();
}
