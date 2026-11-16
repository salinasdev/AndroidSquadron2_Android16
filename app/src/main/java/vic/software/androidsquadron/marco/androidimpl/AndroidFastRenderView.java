package vic.software.androidsquadron.marco.androidimpl;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class AndroidFastRenderView extends SurfaceView implements Runnable {
    private static final long FRAME_TIME_NS = 1_000_000_000L / 60;

    AndroidJuego juego;
    Bitmap framebuffer;
    Thread renderThread = null;
    SurfaceHolder holder;
    volatile boolean running = false;
    
    public AndroidFastRenderView(AndroidJuego juego, Bitmap framebuffer) {
        super(juego);
        this.juego = juego;
        this.framebuffer = framebuffer;
        this.holder = getHolder();
    }

    public void resume() { 
        running = true;
        renderThread = new Thread(this);
        renderThread.start();         
    }      
    
    public void run() {
        Rect dstRect = new Rect();
        long startTime = System.nanoTime();
        while(running) {  
            long frameStart = System.nanoTime();
            if(!holder.getSurface().isValid()) {
                try { Thread.sleep(16); } catch (InterruptedException ignored) {}
                continue;
            }           
            
            float deltaTime = (System.nanoTime()-startTime) / 1000000000.0f;
            startTime = System.nanoTime();

            juego.getCurrentScreen().update(deltaTime);
            juego.getCurrentScreen().present(deltaTime);
            
            Canvas canvas = holder.lockCanvas();
            if (canvas != null) {
                try {
                    canvas.getClipBounds(dstRect);
                    canvas.drawBitmap(framebuffer, null, dstRect, null);
                } finally {
                    holder.unlockCanvasAndPost(canvas);
                }
            }

            long remainingFrameTime = FRAME_TIME_NS - (System.nanoTime() - frameStart);
            if (remainingFrameTime > 0) {
                long sleepMillis = remainingFrameTime / 1_000_000L;
                int sleepNanos = (int) (remainingFrameTime % 1_000_000L);
                try {
                    Thread.sleep(sleepMillis, sleepNanos);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    running = false;
                }
            }
        }
    }

    public void pause() {                        
        running = false;                        
        if (renderThread == null) return;
        while(true) {
            try {
                renderThread.join();
                break;
            } catch (InterruptedException e) {
                // retry
            }
        }
    }        
}