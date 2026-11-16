package vic.software.androidsquadron.marco.androidimpl;

import vic.software.androidsquadron.marco.Audio;
import vic.software.androidsquadron.marco.FileIO;
import vic.software.androidsquadron.marco.Graficos;
import vic.software.androidsquadron.marco.Input;
import vic.software.androidsquadron.marco.Juego;
import vic.software.androidsquadron.marco.Pantalla;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Build;
import android.view.View;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Window;
import android.view.WindowManager;

public abstract class AndroidJuego extends Activity implements Juego {
    AndroidFastRenderView renderView;
    Graficos graficos;
    Audio audio;
    Input input;
    FileIO fileIO;
    Pantalla pantalla;
    WakeLock wakeLock;

    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        int frameBufferWidth = isLandscape ? 480 : 320;
        int frameBufferHeight = isLandscape ? 320 : 480;
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth,
                frameBufferHeight, Config.RGB_565);
        
        @SuppressWarnings("deprecation")
		float scaleX = (float) frameBufferWidth
                / getWindowManager().getDefaultDisplay().getWidth();
        @SuppressWarnings("deprecation")
		float scaleY = (float) frameBufferHeight
                / getWindowManager().getDefaultDisplay().getHeight();

        renderView = new AndroidFastRenderView(this, frameBuffer);
        graficos = new AndroidGraficos(getAssets(), frameBuffer);
        fileIO = new AndroidFileIO(this);
        audio = new AndroidAudio(this);
        input = new AndroidInput(this, renderView, scaleX, scaleY);
        pantalla = getStartScreen();
        setContentView(renderView);
        
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        renderView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    }

    
    public void onResume() {
        super.onResume();
        // Screen stays awake using FLAG_KEEP_SCREEN_ON.
        pantalla.resume();
        audio.resume();
        renderView.resume();
    }

    
    public void onPause() {
        super.onPause();
        // No legacy wake lock to release.
        renderView.pause();
        pantalla.pause();
        audio.pause();

        if (isFinishing())
            pantalla.dispose();
    }

    
    public Input getInput() {
        return input;
    }

    
    public FileIO getFileIO() {
        return fileIO;
    }

    
    public Graficos getGraphics() {
        return graficos;
    }

    
    public Audio getAudio() {
        return audio;
    }

    
    public void setScreen(Pantalla pantalla) {
        if (pantalla == null)
            throw new IllegalArgumentException("Pantalla no debe ser null");

        this.pantalla.pause();
        this.pantalla.dispose();
        pantalla.resume();
        pantalla.update(0);
        this.pantalla = pantalla;
    }
    
    public Pantalla getCurrentScreen() {
        return pantalla;
    }
}