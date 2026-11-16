package vic.software.androidsquadron;

import java.util.List;

import vic.software.androidsquadron.marco.Graficos;
import vic.software.androidsquadron.marco.Input.TouchEvent;
import vic.software.androidsquadron.marco.Juego;
import vic.software.androidsquadron.marco.Pantalla;
import vic.software.androidsquadron.marco.Pixmap;
import android.util.Log;

public class PantallaRecords extends Pantalla{
	
	private boolean nosvamos=false;
	private boolean venimos=true;
	private int timegoto=0;
	private int thetimegoto=10;
	private int timetogo=10;
	private int thetimetogo=0;
	private boolean menu_reiniciar=false;	
	private int item=0;	
	private int msgx=360;
	private boolean listo=false;
	private boolean finmensaje=false;
	
	
    public PantallaRecords(Juego juego) {    	
        super(juego);   
        juego.getInput().getKeyEvents().clear(); //Limpiamos los imputs
    }   

    @Override
    public void update(float deltaTime) {
        Graficos g = juego.getGraphics();
        if(Records.cargar(juego.getFileIO())!=null)
        Log.e("p", Records.cargar(juego.getFileIO()));
        
        
        if(nosvamos==false && venimos==false){
        	List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        	juego.getInput().getKeyEvents();       
        	int len = touchEvents.size();
        	for(int i = 0; i < len; i++) {
        		TouchEvent event = touchEvents.get(i);        		        	
        		if(event.type == TouchEvent.TOUCH_UP) { // Volver al menu
        			if(!menu_reiniciar){
        				if(inBounds(event, 0, g.getHeight()-30, 140, 32)) {
        					nosvamos=true;                   
        				}
        				if(inBounds(event, 175, g.getHeight()-30, 140, 32)) {
            				menu_reiniciar=true;                 
            			}
        			}else{
        				//Acciones del menu reiniciar
        				if (event.y > 220 && event.y <= 280) {
        				if (event.x > 220 && event.x <= 320) { // Si nos pulsan en continuar
    						if(item==0){ //Si el cursos ya esta en NO, salimos
    							if (Assets.sonido){
    								Assets.aceptoption.play(1);
    								
    							}
    							msgx=360;
    							listo=false;
    							finmensaje=false;
    							menu_reiniciar=false;
    							
    							return;
    						}else{ //Si el cursor no esta en continuar, lo colocamos en continuar
    							
    							if (Assets.sonido){
    								Assets.selectoption.play(1);
    							}
    							item=0;
    						}
    					}
    					if (event.x > 5 && event.x < 135) { //Si nos pulsan en salir
    						if(item==1){ //Si el cursor ya esta en SI,Borramos
    							if (Assets.sonido){
    								Assets.aceptoption.play(1);
    								
    							}
    							for (int i1=0;i1<9;i1++){
									Records.setScore(1, i1);
								}
								Records.setScore(0, 9);
								Records.setScore(0, 10);
								Records.save(juego.getFileIO());
								msgx=360;
    							listo=false;
    							finmensaje=false;
    							menu_reiniciar=false;
    							return;
    						}else{ //Si el cursor no esta en salir, lo colocamos en salir.
    							
    							if (Assets.sonido){
    								Assets.selectoption.play(1);
    							}
    							item=1;
    						}
    					}
        				}
        				
        			}
        			
        			
        		}
        	}
        }
        if(menu_reiniciar){
        	if(!finmensaje){
        		if(msgx==0){
        			listo=true;
        			finmensaje=true;
        		}else{
        			msgx-=10; //Vamos metiendo el mensaje			
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
        g.drawPixmap(dameFondo(Records.fondo()), 0, 0);  
        
        g.drawPixmap(dameAssets(Records.maxPuntuaciones[0]), 235, 157); //Taiga
        g.drawPixmap(dameAssets(Records.maxPuntuaciones[5]), 235, 176); //Sea at night
        g.drawPixmap(dameAssets(Records.maxPuntuaciones[6]), 235, 195); //Tundra
        g.drawPixmap(dameAssets(Records.maxPuntuaciones[1]), 235, 214); //Taiga in the afternoon
        g.drawPixmap(dameAssets(Records.maxPuntuaciones[3]), 235, 233); //Sea
        g.drawPixmap(dameAssets(Records.maxPuntuaciones[7]), 235, 252); //Tundra in the afternoon
        g.drawPixmap(dameAssets(Records.maxPuntuaciones[2]), 235, 272); //Taiga at night
        g.drawPixmap(dameAssets(Records.maxPuntuaciones[4]), 235, 291); //Sea in the afternoon
        g.drawPixmap(dameAssets(Records.maxPuntuaciones[8]), 235, 309); //Tundra at night
        g.drawPixmap(dameAssets(Records.maxPuntuaciones[9]), 235, 328); //Tournament
        g.drawPixmap(dameAssets(Records.maxPuntuaciones[10]), 235, 347); //Metropolis Destruida
        
        if(menu_reiniciar){
        	g.drawPixmap(Assets.b1, 0, 0);	
        	g.drawPixmap(Assets.msgLevel, msgx, 190);
    		if(listo){
    			g.drawPixmap(Assets.reiniciar, 0, 200);
    			if(item==0){
    				g.drawPixmap(Assets.cursor2, 300, 242);
    			}else{
    				g.drawPixmap(Assets.cursor1, 135, 242);
    			}
    		}
        }
        
        
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
    
    private Pixmap dameFondo(int v) {
		switch (v) {
		case 0:
			return Assets.fondo1;
		case 1:
			return Assets.fondo2;
		case 2:
			return Assets.fondo3;		
		}
		return Assets.fondo1;
	}
	private Pixmap dameAssets(int v) {
		switch (v) {
		case 0:
			return Assets.r0;
		case 1:
			return Assets.r1;
		case 2:
			return Assets.r2;
		case 3:
			return Assets.r3;
		case 4:
			return Assets.r4;
		}
		return Assets.r0;
		
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
