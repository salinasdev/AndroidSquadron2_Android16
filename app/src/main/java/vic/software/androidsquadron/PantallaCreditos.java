package vic.software.androidsquadron;

import java.util.List;

import vic.software.androidsquadron.marco.Graficos;
import vic.software.androidsquadron.marco.Input.TouchEvent;
import vic.software.androidsquadron.marco.Juego;
import vic.software.androidsquadron.marco.Pantalla;
import vic.software.androidsquadron.marco.Pixmap;

	

public class PantallaCreditos extends Pantalla {	
	private boolean nosvamos=false;
	private boolean venimos=true;
	private int timegoto=0;
	private int thetimegoto=10;
	private int timetogo=10;
	private int thetimetogo=0;
    public PantallaCreditos(Juego juego) {    	
        super(juego);   
        juego.getInput().getKeyEvents().clear(); //Limpiamos los imputs
    }   

    @Override
    public void update(float deltaTime) {
        Graficos g = juego.getGraphics();
        if(nosvamos==false && venimos==false){
        	List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        	juego.getInput().getKeyEvents();       
        	int len = touchEvents.size();
        	for(int i = 0; i < len; i++) {
        		TouchEvent event = touchEvents.get(i);
        		if(event.type == TouchEvent.TOUCH_UP) { // Volver al menu
        			if(inBounds(event, (g.getWidth()/2)-50, g.getHeight()-30, 150, 32)) {
        				nosvamos=true;
                   
        			}
        		}
        	}
        }
    }
    
    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 && 
           event.y > y && event.y < y + height - 1) 
            return true;
        else
            return false;
    }

    @Override
    public void present(float deltaTime) {
        Graficos g = juego.getGraphics();
        g.drawPixmap(Assets.creditos, 0, 0);  
        
        if(venimos){
        	g.drawPixmap(dameAsset(timetogo), 0, 0);
        	timetogo--;
        	if(timetogo==thetimetogo){
        		venimos=false;
        	}
        }
        if(nosvamos){
        	g.drawPixmap(dameAsset(timegoto), 0, 0);
        	timegoto++;
        	if(timegoto==thetimegoto){
        		juego.setScreen(new PantallaMenuInicio(juego));
        	}
        }
    }
    private Pixmap dameAsset(int timegoto2) {
		switch (timegoto2) {
		case 0:
			return Assets.b1;
		case 1:
			return Assets.b1;
		case 2:
			return Assets.b2;
		case 3:
			return Assets.b2;
		case 4:
			return Assets.b3;
		case 5:
			return Assets.b3;
		case 6:
			return Assets.b4;
		case 7:
			return Assets.b4;
		case 8:
			return Assets.b5;
		case 9:
			return Assets.b5;
		case 10:
			return Assets.b5;

			
		
		};
		return Assets.b5;
	}
    
		
	

	@Override
    public void pause() {
    	// Guardar puntuacion por si acaso
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
