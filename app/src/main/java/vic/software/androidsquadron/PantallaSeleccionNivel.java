package vic.software.androidsquadron;

import java.util.List;

import vic.software.androidsquadron.marco.Graficos;
import vic.software.androidsquadron.marco.Graficos.PixmapFormat;
import vic.software.androidsquadron.marco.Input.TouchEvent;
import vic.software.androidsquadron.marco.Juego;
import vic.software.androidsquadron.marco.Pantalla;
import vic.software.androidsquadron.marco.Pixmap;

	

public class PantallaSeleccionNivel extends Pantalla {	
	private int item=0;
	private int ys=108;
	private int yys=108;
	private int n=38;
	//Atributos de las transacciones:
	private boolean nosvamos=false;
	private boolean venimos=true;
	private int timegoto=0;
	private int thetimegoto=10;
	private int timetogo=10;
	private int thetimetogo=0;
	private int opcion=0;
	//Atributos del selector:
	private int selector=0;
	private int selector_y=118;
	private int selector_x=8;
	
	
    public PantallaSeleccionNivel(Juego juego) {
    	
        super(juego);
        if(Assets.sonido){
        	Assets.smenu.play();
        }        
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
                touchEvents.get(i);
				//Taiga
                if(inBounds(event, 8, 118, 65, 66)&& touchEvents.get(i).type==TouchEvent.TOUCH_UP ) { 
                	if(item!=0){
                	selector=0;
                	selector_x=8;
                	selector_y=118;
                	movemosSelector(0);
                	if(Assets.sonido){
                		Assets.selectoption.play(100);
                	}
                	return;
                	}else{
                      opcion=0;
                      nosvamos=true;
                      if(Assets.sonido)
                          {Assets.aceptoption.play(1); 
                          if(Assets.smenu.isPlaying()){
                      		Assets.smenu.stop();                    	                    
                      		}
                          }                   
                      return;
                  	}
                }
                // Sea
                if(inBounds(event, 128, 118, 65, 66)&& touchEvents.get(i).type==TouchEvent.TOUCH_UP ) {
                	if(item!=1){
                    	movemosSelector(1);
                    	selector=1;
                    	selector_x=128;
                    	selector_y=118; 
                    	if(Assets.sonido){
                    		Assets.selectoption.play(100);
                    	}
                    	return;
                	}else{
                        opcion=1;
                        nosvamos=true;
                      if(Assets.sonido)
                          {Assets.aceptoption.play(1); 
                          if(Assets.smenu.isPlaying()){
                      		Assets.smenu.stop();                    	                    
                      		}
                          }                   
                      return;
                  	}
                }
                //Tunda
                if(inBounds(event, 247, 118, 65, 66)&& touchEvents.get(i).type==TouchEvent.TOUCH_UP ) {
                	if(item!=2){
                    	movemosSelector(2);
                    	selector=2;
                    	selector_x=247;
                    	selector_y=118; 
                    	if(Assets.sonido){
                    		Assets.selectoption.play(100);
                    	}
                    	return;
                	}else{
                		opcion=2;
                        nosvamos=true;
                      if(Assets.sonido)
                          {Assets.aceptoption.play(1); 
                          if(Assets.smenu.isPlaying()){
                      		Assets.smenu.stop();                    	                    
                      		}
                          }                   
                      return;
                  	}
                }
                //Taiga in the afternoon
              if(inBounds(event, 8, 214, 65, 66)&& touchEvents.get(i).type==TouchEvent.TOUCH_UP ) {
            	  if(item!=3){
                  	movemosSelector(3);
                  	selector=3;
                  	selector_x=8;
                  	selector_y=214;
                  	if(Assets.sonido){
                		Assets.selectoption.play(100);
                  	}
                  	return;
                  }else{
                	  opcion=3;
                      nosvamos=true;
//                   juego.setScreen(new PantallaJuego(juego));
                     if(Assets.sonido){
                    	 Assets.aceptoption.play(1); 
                         if(Assets.smenu.isPlaying()){
                        	 Assets.smenu.stop();                    	                    
                      	 }
                     }                   
                      return;
                  	}
              }
                  	
          
              //Sea afternoon
              if(inBounds(event, 128, 214, 65, 66)&& touchEvents.get(i).type==TouchEvent.TOUCH_UP ) {
            	  if(item!=4){
                    	movemosSelector(4);
                    	selector=4;
                    	selector_x=128;
                    	selector_y=214;
                    	if(Assets.sonido){
                  		Assets.selectoption.play(100);
                    	}
                    	return;
                    }else{
                    	opcion=4;
                        nosvamos=true;
//                     juego.setScreen(new PantallaJuego(juego));
                       if(Assets.sonido){
                      	 Assets.aceptoption.play(1); 
                           if(Assets.smenu.isPlaying()){
                          	 Assets.smenu.stop();                    	                    
                        	 }
                       }                   
                        return;
                    	}
                }
            //Tundra afternoon
              if(inBounds(event, 247, 214, 65, 66)&& touchEvents.get(i).type==TouchEvent.TOUCH_UP ) { 
            	  if(item!=5){
                    	movemosSelector(5);
                    	selector=5;
                    	selector_x=247;
                    	selector_y=214;
                    	if(Assets.sonido){
                  		Assets.selectoption.play(100);
                    	}
                    	return;
                    }else{
                    	opcion=5;
                        nosvamos=true;
//                     juego.setScreen(new PantallaJuego(juego));
                       if(Assets.sonido){
                      	 Assets.aceptoption.play(1); 
                           if(Assets.smenu.isPlaying()){
                          	 Assets.smenu.stop();                    	                    
                        	 }
                       }                   
                        break;
                    	}
                }
            //Taiga night
              if(inBounds(event, 8, 310, 65, 66)&& touchEvents.get(i).type==TouchEvent.TOUCH_UP ) { 
            	  if(item!=6){
                    	movemosSelector(6);
                    	selector=6;
                    	selector_x=8;
                    	selector_y=310;
                    	if(Assets.sonido){
                  		Assets.selectoption.play(100);
                    	}
                    	break;
                    }else{
                    	opcion=6;
                        nosvamos=true;
//                     juego.setScreen(new PantallaJuego(juego));
                       if(Assets.sonido){
                      	 Assets.aceptoption.play(1); 
                           if(Assets.smenu.isPlaying()){
                          	 Assets.smenu.stop();                    	                    
                        	 }
                       }                   
                        return;
                    	}
                }
            //Sea night
              if(inBounds(event, 128, 310, 65, 66) && touchEvents.get(i).type==TouchEvent.TOUCH_UP) { 
            	  if(item!=7){
                    	movemosSelector(7);
                    	selector=7;
                    	selector_x=128;
                    	selector_y=310;
                    	if(Assets.sonido){
                  		Assets.selectoption.play(100);
                    	}
                    	break;
                    }else{
                    	opcion=7;
                        nosvamos=true;
//                     juego.setScreen(new PantallaJuego(juego));
                       if(Assets.sonido){
                      	 Assets.aceptoption.play(1); 
                           if(Assets.smenu.isPlaying()){
                          	 Assets.smenu.stop();                    	                    
                        	 }
                       }                   
                        return;
                    	}
                }
            //Tundra night
              if(inBounds(event, 247, 310, 65, 66) && touchEvents.get(i).type==TouchEvent.TOUCH_UP) { 
            	  if(item!=8){
                    	movemosSelector(8);
                    	selector=8;
                    	selector_x=247;
                    	selector_y=310;
                    	if(Assets.sonido){
                  		Assets.selectoption.play(100);
                    	}
                    }else{
                    	opcion=8;
                        nosvamos=true;
//                     juego.setScreen(new PantallaJuego(juego));
                       if(Assets.sonido){
                    	   Assets.aceptoption.play(1); 
                           if(Assets.smenu.isPlaying()){
                          	  Assets.smenu.stop();                    	                    
                           }
                        }                   
                       
                    	}
                }
              
              //Volver al menu
              if(event.type == TouchEvent.TOUCH_UP) { // Volver al menu
                  if(inBounds(event, (g.getWidth()/2)-50, g.getHeight()-30, 150, 32)) {
                	  if(Assets.sonido){
                      	 Assets.smenu.stop();
                      } 
                  	opcion=9;
                  	nosvamos=true;
                    
                  }
              }

            }
        }
        }
        


    private void movemosSelector(int i) {
		item=i;
		ys=108+(n*item);		
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
        
        g.drawPixmap(Assets.fondo_niveles, 0, 0);
        g.drawPixmap(Assets.level_select, selector_x, selector_y,65*selector,0,65,66);
        	
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
        		vamonos(opcion);
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
    private void vamonos(int opcion2) {
    	Graficos g = juego.getGraphics();
    	Datos d=new Datos();
		switch (opcion2) {
		case 0:
			Datos.setN_NIVEL(0); //Numero de nivel
			d.setRAT_FUEL(6); //Cada RAT_FUEL Aviones soltamos un fuel
			d.setRAT_TOR(10); //Cada RAT_TOR Aviones puede haber una tormenta
			d.setRAT_ITEM(4); //Cada RAT_ITEM Aviones soltamos un item [SIEMPRE QUE NO SE VAYA A SACAR FUEL]
			d.setRES_SIZE(2); //RES_SIZE + MIN_RES es el MAXIMO de restencia que un avion enemio puede tener
			d.setMIN_RES(3); //Minimo de resistencia de un enegigo
			d.setNUM_ENE(30); //Numero de enemigos que aparecer�n en el nivel
			d.setTIME_ENEMIGO(100); //Intervalo de aparicion de enemigos (mas bajo, menos tardan)
			d.setTIME_BALA(70); //Intervalo de disparo enemigo
			d.setTIME_FUEL(200); //Intervalo de gasto de fuel	
			d.setVIDA_TOTAL(24); //Vida de nuestro personaje
			d.setFUEL_TOTAL(14); //Capacidad total de fuel
			Datos.setVELOCIDAD_ENEMIGO(2);			
			d.setNivel(g.newPixmap("fondo1_day.png", PixmapFormat.RGB565));
			d.setMusica(juego.getAudio().nuevaMusica("AFG_Taiga.ogg"));
			
			juego.setScreen(new PantallaJuego(juego));
			break;
		case 1:
			d.setN_NIVEL(3); //Numero de nivel
			d.setRAT_FUEL(6); //Cada RAT_FUEL Aviones soltamos un fuel
			d.setRAT_TOR(10); //Cada RAT_TOR Aviones puede haber una tormenta
			d.setRAT_ITEM(4); //Cada RAT_ITEM Aviones soltamos un item [SIEMPRE QUE NO SE VAYA A SACAR FUEL]
			d.setRES_SIZE(2); //RES_SIZE + MIN_RES es el MAXIMO de restencia que un avion enemio puede tener
			d.setMIN_RES(3); //Minimo de resistencia de un enegigo
			d.setNUM_ENE(30); //Numero de enemigos que aparecer�n en el nivel
			d.setTIME_ENEMIGO(100); //Intervalo de aparicion de enemigos (mas bajo, menos tardan)
			d.setTIME_BALA(70); //Intervalo de disparo enemigo
			d.setTIME_FUEL(200); //Intervalo de gasto de fuel	
			d.setVIDA_TOTAL(24); //Vida de nuestro personaje
			d.setFUEL_TOTAL(14); //Capacidad total de fuel
			Datos.setVELOCIDAD_ENEMIGO(2);
			d.setNivel(g.newPixmap("sea.png", PixmapFormat.RGB565));
			d.setMusica(juego.getAudio().nuevaMusica("AFG-Sea.mp3"));
			juego.setScreen(new PantallaJuego(juego));
			break;
		case 2:
			d.setN_NIVEL(6); //Numero de nivel
			d.setRAT_FUEL(6); //Cada RAT_FUEL Aviones soltamos un fuel
			d.setRAT_TOR(10); //Cada RAT_TOR Aviones puede haber una tormenta
			d.setRAT_ITEM(4); //Cada RAT_ITEM Aviones soltamos un item [SIEMPRE QUE NO SE VAYA A SACAR FUEL]
			d.setRES_SIZE(2); //RES_SIZE + MIN_RES es el MAXIMO de restencia que un avion enemio puede tener
			d.setMIN_RES(3); //Minimo de resistencia de un enegigo
			d.setNUM_ENE(30); //Numero de enemigos que aparecer�n en el nivel
			d.setTIME_ENEMIGO(100); //Intervalo de aparicion de enemigos (mas bajo, menos tardan)
			d.setTIME_BALA(70); //Intervalo de disparo enemigo
			d.setTIME_FUEL(200); //Intervalo de gasto de fuel	
			d.setVIDA_TOTAL(24); //Vida de nuestro personaje
			d.setFUEL_TOTAL(14); //Capacidad total de fuel
			Datos.setVELOCIDAD_ENEMIGO(2);
			d.setNivel(g.newPixmap("Tundra.png", PixmapFormat.RGB565));
			d.setMusica(juego.getAudio().nuevaMusica("AFG- Tundra.mp3"));
			juego.setScreen(new PantallaJuego(juego));
			break;
		case 3:
			d.setN_NIVEL(1); //Numero de nivel
			d.setRAT_FUEL(6); //Cada RAT_FUEL Aviones soltamos un fuel
			d.setRAT_TOR(10); //Cada RAT_TOR Aviones puede haber una tormenta
			d.setRAT_ITEM(4); //Cada RAT_ITEM Aviones soltamos un item [SIEMPRE QUE NO SE VAYA A SACAR FUEL]
			d.setRES_SIZE(2); //RES_SIZE + MIN_RES es el MAXIMO de restencia que un avion enemio puede tener
			d.setMIN_RES(3); //Minimo de resistencia de un enegigo
			d.setNUM_ENE(40); //Numero de enemigos que aparecer�n en el nivel
			d.setTIME_ENEMIGO(100); //Intervalo de aparicion de enemigos (mas bajo, menos tardan)
			d.setTIME_BALA(50); //Intervalo de disparo enemigo
			d.setTIME_FUEL(200); //Intervalo de gasto de fuel	
			d.setVIDA_TOTAL(24); //Vida de nuestro personaje
			d.setFUEL_TOTAL(14); //Capacidad total de fuel
			Datos.setVELOCIDAD_ENEMIGO(3);
			d.setNivel(g.newPixmap("AFG-TaigaAfternoon.png", PixmapFormat.RGB565));
			d.setMusica(juego.getAudio().nuevaMusica("AFG_Taiga.ogg"));
			juego.setScreen(new PantallaJuego(juego));
			break;
		case 4:
			d.setN_NIVEL(4); //Numero de nivel
			d.setRAT_FUEL(6); //Cada RAT_FUEL Aviones soltamos un fuel
			d.setRAT_TOR(10); //Cada RAT_TOR Aviones puede haber una tormenta
			d.setRAT_ITEM(4); //Cada RAT_ITEM Aviones soltamos un item [SIEMPRE QUE NO SE VAYA A SACAR FUEL]
			d.setRES_SIZE(2); //RES_SIZE + MIN_RES es el MAXIMO de restencia que un avion enemio puede tener
			d.setMIN_RES(3); //Minimo de resistencia de un enegigo
			d.setNUM_ENE(40); //Numero de enemigos que aparecer�n en el nivel
			d.setTIME_ENEMIGO(100); //Intervalo de aparicion de enemigos (mas bajo, menos tardan)
			d.setTIME_BALA(50); //Intervalo de disparo enemigo
			d.setTIME_FUEL(200); //Intervalo de gasto de fuel	
			d.setVIDA_TOTAL(24); //Vida de nuestro personaje
			d.setFUEL_TOTAL(14); //Capacidad total de fuel
			Datos.setVELOCIDAD_ENEMIGO(3);
			d.setNivel(g.newPixmap("sea-afternoon.png", PixmapFormat.RGB565));
			d.setMusica(juego.getAudio().nuevaMusica("AFG-Sea.mp3"));
			juego.setScreen(new PantallaJuego(juego));
			break;
		case 5:
			d.setN_NIVEL(7); //Numero de nivel
			d.setRAT_FUEL(6); //Cada RAT_FUEL Aviones soltamos un fuel
			d.setRAT_TOR(10); //Cada RAT_TOR Aviones puede haber una tormenta
			d.setRAT_ITEM(4); //Cada RAT_ITEM Aviones soltamos un item [SIEMPRE QUE NO SE VAYA A SACAR FUEL]
			d.setRES_SIZE(2); //RES_SIZE + MIN_RES es el MAXIMO de restencia que un avion enemio puede tener
			d.setMIN_RES(3); //Minimo de resistencia de un enegigo
			d.setNUM_ENE(40); //Numero de enemigos que aparecer�n en el nivel
			d.setTIME_ENEMIGO(100); //Intervalo de aparicion de enemigos (mas bajo, menos tardan)
			d.setTIME_BALA(50); //Intervalo de disparo enemigo
			d.setTIME_FUEL(200); //Intervalo de gasto de fuel	
			d.setVIDA_TOTAL(24); //Vida de nuestro personaje
			d.setFUEL_TOTAL(14); //Capacidad total de fuel
			Datos.setVELOCIDAD_ENEMIGO(3);
			d.setNivel(g.newPixmap("TundraAfternoon.png", PixmapFormat.RGB565));
			d.setMusica(juego.getAudio().nuevaMusica("AFG- Tundra.mp3"));
			juego.setScreen(new PantallaJuego(juego));
			break;
		case 6:
			d.setN_NIVEL(2); //Numero de nivel
			d.setRAT_FUEL(6); //Cada RAT_FUEL Aviones soltamos un fuel
			d.setRAT_TOR(10); //Cada RAT_TOR Aviones puede haber una tormenta
			d.setRAT_ITEM(4); //Cada RAT_ITEM Aviones soltamos un item [SIEMPRE QUE NO SE VAYA A SACAR FUEL]
			d.setRES_SIZE(2); //RES_SIZE + MIN_RES es el MAXIMO de restencia que un avion enemio puede tener
			d.setMIN_RES(3); //Minimo de resistencia de un enegigo
			d.setNUM_ENE(50); //Numero de enemigos que aparecer�n en el nivel
			d.setTIME_ENEMIGO(100); //Intervalo de aparicion de enemigos (mas bajo, menos tardan)
			d.setTIME_BALA(30); //Intervalo de disparo enemigo
			d.setTIME_FUEL(200); //Intervalo de gasto de fuel	
			d.setVIDA_TOTAL(24); //Vida de nuestro personaje
			d.setFUEL_TOTAL(14); //Capacidad total de fuel
			Datos.setVELOCIDAD_ENEMIGO(3);
			d.setNivel(g.newPixmap("AFG-TaigaNight.png", PixmapFormat.RGB565));
			d.setMusica(juego.getAudio().nuevaMusica("AFG_Taiga.ogg"));
			juego.setScreen(new PantallaJuego(juego));
			break;
		case 7:
			d.setN_NIVEL(5); //Numero de nivel
			d.setRAT_FUEL(6); //Cada RAT_FUEL Aviones soltamos un fuel
			d.setRAT_TOR(10); //Cada RAT_TOR Aviones puede haber una tormenta
			d.setRAT_ITEM(4); //Cada RAT_ITEM Aviones soltamos un item [SIEMPRE QUE NO SE VAYA A SACAR FUEL]
			d.setRES_SIZE(2); //RES_SIZE + MIN_RES es el MAXIMO de restencia que un avion enemio puede tener
			d.setMIN_RES(3); //Minimo de resistencia de un enegigo
			d.setNUM_ENE(50); //Numero de enemigos que aparecer�n en el nivel
			d.setTIME_ENEMIGO(100); //Intervalo de aparicion de enemigos (mas bajo, menos tardan)
			d.setTIME_BALA(30); //Intervalo de disparo enemigo
			d.setTIME_FUEL(200); //Intervalo de gasto de fuel	
			d.setVIDA_TOTAL(24); //Vida de nuestro personaje
			d.setFUEL_TOTAL(14); //Capacidad total de fuel
			Datos.setVELOCIDAD_ENEMIGO(3);
			d.setNivel(g.newPixmap("sea-night.png", PixmapFormat.RGB565));
			d.setMusica(juego.getAudio().nuevaMusica("AFG-Sea.mp3"));
			juego.setScreen(new PantallaJuego(juego));
			break;
		case 8:
			d.setN_NIVEL(8); //Numero de nivel
			d.setRAT_FUEL(6); //Cada RAT_FUEL Aviones soltamos un fuel
			d.setRAT_TOR(10); //Cada RAT_TOR Aviones puede haber una tormenta
			d.setRAT_ITEM(4); //Cada RAT_ITEM Aviones soltamos un item [SIEMPRE QUE NO SE VAYA A SACAR FUEL]
			d.setRES_SIZE(2); //RES_SIZE + MIN_RES es el MAXIMO de restencia que un avion enemio puede tener
			d.setMIN_RES(3); //Minimo de resistencia de un enegigo
			d.setNUM_ENE(50); //Numero de enemigos que aparecer�n en el nivel
			d.setTIME_ENEMIGO(100); //Intervalo de aparicion de enemigos (mas bajo, menos tardan)
			d.setTIME_BALA(30); //Intervalo de disparo enemigo
			d.setTIME_FUEL(200); //Intervalo de gasto de fuel	
			d.setVIDA_TOTAL(24); //Vida de nuestro personaje
			d.setFUEL_TOTAL(14); //Capacidad total de fuel
			Datos.setVELOCIDAD_ENEMIGO(3);
			d.setNivel(g.newPixmap("TundraNight.png", PixmapFormat.RGB565));
			d.setMusica(juego.getAudio().nuevaMusica("AFG- Tundra.mp3"));
			juego.setScreen(new PantallaJuego(juego));
			break;
		case 9:
			juego.setScreen(new PantallaMenuInicio(juego));
			break;
			
		}
		
		
	}
    
    @Override
    public void pause() {
    	// Guardar puntuaci�n por si acaso
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
