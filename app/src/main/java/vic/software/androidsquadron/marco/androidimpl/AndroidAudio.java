package vic.software.androidsquadron.marco.androidimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vic.software.androidsquadron.marco.Audio;
import vic.software.androidsquadron.marco.Musica;
import vic.software.androidsquadron.marco.Sonido;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

public class AndroidAudio implements Audio {
    AssetManager assets;
    SoundPool soundPool;
    private final List<AndroidMusica> musicas = new ArrayList<>();

    public AndroidAudio(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
    }

    public Musica nuevaMusica(String filename) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            AndroidMusica musica = new AndroidMusica(assetDescriptor);
            musicas.add(musica);
            return musica;
        } catch (IOException e) {
            throw new RuntimeException("no se ha podido cargar archivo '" + filename + "'");
        }
    }

    public Sonido nuevoSonido(String filename) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            int soundId = soundPool.load(assetDescriptor, 0);
            return (Sonido) new AndroidSonido(soundPool, soundId);
        } catch (IOException e) {
            throw new RuntimeException("No se ha podido cargar archivo '" + filename + "'");
        }
    }

    @Override
    public void pause() {
        for (AndroidMusica musica : musicas) {
            musica.pauseForLifecycle();
        }
        soundPool.autoPause();
    }

    @Override
    public void resume() {
        soundPool.autoResume();
        for (AndroidMusica musica : musicas) {
            musica.resumeAfterLifecycle();
        }
    }
}








