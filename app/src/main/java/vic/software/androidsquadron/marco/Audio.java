package vic.software.androidsquadron.marco;

public interface Audio {
    public Musica nuevaMusica(String nombreArchivo);
    public Sonido nuevoSonido(String nombreArchivo);
    public void pause();
    public void resume();
}
