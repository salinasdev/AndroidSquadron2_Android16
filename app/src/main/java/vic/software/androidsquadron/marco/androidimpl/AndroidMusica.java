package vic.software.androidsquadron.marco.androidimpl;

import java.io.IOException;

import vic.software.androidsquadron.marco.Musica;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class AndroidMusica implements Musica, OnCompletionListener {
	MediaPlayer mediaPlayer;
	boolean isPrepared = false;
	private boolean estabaSonandoAntesDePausar = false;

	public AndroidMusica(AssetFileDescriptor assetDescriptor) {
		mediaPlayer = new MediaPlayer();
		try {
			mediaPlayer.setDataSource(assetDescriptor.getFileDescriptor(),
					assetDescriptor.getStartOffset(),
					assetDescriptor.getLength());
			mediaPlayer.prepare();
			isPrepared = true;
			mediaPlayer.setOnCompletionListener(this);
		} catch (Exception e) {
			throw new RuntimeException("No se ha podido cargar la musica");
		}
	}

	
	public void dispose() {
		if (mediaPlayer.isPlaying())
			mediaPlayer.stop();
		mediaPlayer.release();
	}
	
	 
	    public boolean isLooping() {
	        return mediaPlayer.isLooping();
	    }

	    
	    public boolean isPlaying() {
	        return mediaPlayer.isPlaying();
	    }

	    
	    public boolean isStopped() {
	        return !isPrepared;
	    }
	    
	    
	    public void pause() {
	        if (mediaPlayer.isPlaying())
	            mediaPlayer.pause();
	    }

	void pauseForLifecycle() {
		estabaSonandoAntesDePausar = mediaPlayer.isPlaying();
		if (estabaSonandoAntesDePausar) {
			mediaPlayer.pause();
		}
	}

	void resumeAfterLifecycle() {
		if (estabaSonandoAntesDePausar) {
			estabaSonandoAntesDePausar = false;
			playp();
		}
	}
	
	    
	    public void play() {
	        if (mediaPlayer.isPlaying())
	            return;

	        try {
	            synchronized (this) {
	                if (!isPrepared)
	                    mediaPlayer.prepare();
			        mediaPlayer.seekTo(0); // anadir esta linea para que el stop funcione
				mediaPlayer.start();
	            }
	        } catch (IllegalStateException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void playp() {
	        if (mediaPlayer.isPlaying())
	            return;

	        try {
	            synchronized (this) {
	                if (!isPrepared)
	                    mediaPlayer.prepare();
	                
				mediaPlayer.start();
	            }
	        } catch (IllegalStateException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    public void setLooping(boolean isLooping) {
	        mediaPlayer.setLooping(isLooping);
	    }

	    
	    public void setVolume(float volume) {
	        mediaPlayer.setVolume(volume, volume);
	    }
	
	    
	    public void stop() {
	        mediaPlayer.stop();
	        
	        synchronized (this) {
	            isPrepared = false;
	        }
	    }
	
	    
	    public void onCompletion(MediaPlayer player) {
	        synchronized (this) {
	            isPrepared = false;
	        }
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
