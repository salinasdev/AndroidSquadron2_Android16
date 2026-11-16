package vic.software.androidsquadron.marco.androidimpl;

import vic.software.androidsquadron.marco.Sonido;
import android.media.SoundPool;

public class AndroidSonido implements Sonido {
    int soundId;
    SoundPool soundPool;

    public AndroidSonido(SoundPool soundPool, int soundId) {
        this.soundId = soundId;
        this.soundPool = soundPool;
    }

    
    public void play(float volume) {
        soundPool.play(soundId, volume, volume, 0, 0, 1);
    }
    
    


    
    public void dispose() {
        soundPool.unload(soundId);
    }
    
    
    public void parar() {
        soundPool.stop(soundId);
    }

}
