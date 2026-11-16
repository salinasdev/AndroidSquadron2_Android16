package vic.software.androidsquadron;

import java.util.List;

import vic.software.androidsquadron.marco.Graficos;
import vic.software.androidsquadron.marco.Juego;
import vic.software.androidsquadron.marco.Pantalla;
import vic.software.androidsquadron.marco.Pixmap;
import vic.software.androidsquadron.marco.Input.TouchEvent;

	

public class PantallaLogo extends Pantalla {
	private int mitime;
	private int thetime;
	private int ylogo=25;
	private int contador;
	private Pixmap ellogo;
	private boolean aparece=true;
    public PantallaLogo(Juego juego) {
    	
        super(juego);   
        contador=0;
        thetime=0; //Contador de tiempo
        mitime=200; //Tiempo hasta que el titulo baja. Pasado este tiempo, aparece el menu
        ellogo=Assets.t11;
    }   

    @Override
    public void update(float deltaTime) {
        Graficos g = juego.getGraphics();
        if(thetime==mitime){
        	//Cargamos el menu inicio
        	List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        	touchEvents.clear();
        	juego.setScreen(new PantallaMenuInicio(juego));
        }
        
    }
    
    @Override
    public void present(float deltaTime) {
        Graficos g = juego.getGraphics();
        
        
        g.drawPixmap(ellogo, 110, 150);
        
        if(aparece){
        if(thetime<mitime){
        	thetime++;
        	if(thetime%5==0){ 
        		if(contador<10){
        		changelogo(contador);
        		contador++;
        		if(contador==9){
        			aparece=false;
        		}
        		}
        	}
        }
    }else{
    	thetime++;
    	if(thetime<mitime && thetime>100){
        	
        	if(thetime%5==0){ 
        		if(contador>0){
        		changelogo(contador);
        		contador--;
        		
        		}else{
        			changelogo(10);
        		}
        	}
        }
    	
    }
    }

    private void changelogo(int contador) {
		switch (contador) {
		case 0:
			ellogo=Assets.t10;
			break;
		case 1:
			ellogo=Assets.t9;
			break;
		case 2:
			ellogo=Assets.t8;
			break;
		case 3:
			ellogo=Assets.t7;
			break;
		case 4:
			ellogo=Assets.t6;
			break;
		case 5:
			ellogo=Assets.t5;
			break;
		case 6:
			ellogo=Assets.t4;
			break;
		case 7:
			ellogo=Assets.t3;
			break;
		case 8:
			ellogo=Assets.t2;
			break;
		case 9:
			ellogo=Assets.t1;
			break;
		case 10:
			ellogo=Assets.t11;
			break;
		}
		
		
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
