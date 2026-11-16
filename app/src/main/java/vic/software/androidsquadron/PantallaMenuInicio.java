package vic.software.androidsquadron;

import java.util.ArrayList;
import java.util.List;

import vic.software.androidsquadron.marco.Graficos;
import vic.software.androidsquadron.marco.Juego;
import vic.software.androidsquadron.marco.Pantalla;
import vic.software.androidsquadron.marco.Graficos.PixmapFormat;
import vic.software.androidsquadron.marco.Input.TouchEvent;
import vic.software.androidsquadron.marco.Pixmap;

	

public class PantallaMenuInicio extends Pantalla {
	private int mitime;
	private int thetime;
	private int ylogo=25;
	private int item=0;
	private int ys=220;
	private int opcion=0;
	private boolean venimos=true;
	private boolean nosvamos;
	private int timegoto=0;
	private int thetimegoto=10;
	private int timetogo=10;
	private int thetimetogo=0;
	//Para la animacion del logo
	private boolean animacion=true;
	private Pixmap logo=Assets.logo1;
	private int contlogo=0;
	private boolean logoaparece=true;
	private ArrayList<Impacto> impactos;
	private int mitimexp;
	private int nexp=0;
	private int thetimeexp=0;
	private boolean nomas=true;
    public PantallaMenuInicio(Juego juego) {
    	
        super(juego);
        if(Assets.sonido){
        	Assets.intro.setLooping(true);
        	Assets.intro.play();
        }
        nosvamos=false;
        thetime=0; //Contador de tiempo
        mitime=8; //Tiempo hasta que el titulo baja. Pasado este tiempo, aparece el menu
        mitimexp=8;
        impactos=new ArrayList<Impacto>();
    }   

    @Override
    public void update(float deltaTime) {
        Graficos g = juego.getGraphics();
        
        List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        
        juego.getInput().getKeyEvents();       
        
        
        if(!animacion && nosvamos==false && venimos==false){ //Si aun no ha bajado el logo, no atendemos a las pulsaciones del jugador
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) { // Habilitar/Deshabilitar Sonido
                if(inBounds(event, g.getWidth()-32, 0, 32, 32)) {
                    Assets.sonido = !Assets.sonido;
                    if(Assets.sonido){
                        Assets.pulsar.play(1);
                        Assets.intro.play();
                    }else{
                    	if(Assets.intro.isPlaying()){
                    		Assets.intro.stop();                    	                    
                    	}
                    }
                }
                
                if(inBounds(event, 78, 220  , 175, 25) ) { //    J U G A R
                	if(item!=0){
                	movemosSelector(0);
                	}else{
                		nosvamos=true;
                    	opcion=0;
                    if(Assets.sonido){
                    	
                    	Assets.pulsar.play(1); 
                        if(Assets.intro.isPlaying()){
                    		Assets.intro.stop();                    	                    
                    	}
                     }                   
                    return;
                	}
                }
                // Pantalla de Vuelo Extra
                if(inBounds(event, 78, 220 + 29, 175, 25) ) {
                	if(Records.fondo()>1){
                	if(item!=1){
                    	movemosSelector(1);
                    	}else{
						nosvamos=true;
						opcion=1;
						if(Assets.sonido){
							Assets.pulsar.play(1);
							if(Assets.intro.isPlaying()){
								Assets.intro.stop();
							}
                    	}
                	}
                }}
              //Pantalla de Torneo
                if(inBounds(event, 78, 220 + 58, 175, 25) ) { 
                	if(Records.fondo()>0){
                		if(item!=2){
                			movemosSelector(2);
                		}else{
                			nosvamos=true;
                			opcion=2;                    
                			if(Assets.sonido){
                				Assets.pulsar.play(1); 
                				if(Assets.intro.isPlaying()){
                            	Assets.intro.stop();                    	                    
                				}
                			}
                     
                		}
                	}
                }
                //Pantalla de Ranking
                if(inBounds(event, 78, 220 + 87, 175, 25) ) {
                	if(item!=3){
                    	movemosSelector(3);
                    	}else{
                    		nosvamos=true;
                        	opcion=3;                    
                    if(Assets.sonido)
                        Assets.pulsar.play(1);
                    return;
                    	}
                }
                //Pantalla de creditos
              if(inBounds(event, 78, 220 + 116, 175, 25) ) {
            	  if(item!=4){
                  	movemosSelector(4);
                  	
                  }else{
                	nosvamos=true;
                	opcion=4;
                	if(Assets.sonido)
                		Assets.pulsar.play(1);
                	return;
                  }
          }
              //Salir del juego
              if(inBounds(event, 78, 220 + 145, 175, 25) ) {
            	  if(item!=5){
                  	movemosSelector(5);
                  	}else{
                  		System.exit(0);
              return;
                  	}
          }
            }
        }
        }else{
        	if (touchEvents.size() > 0){
        		animacion=false; //Paramos la animacion
        		logo=Assets.logo5;
        	}
        }
    }
    
    private void movemosSelector(int i) {
		item=i;
		ys=220+(29*item);
		
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
        
        g.drawPixmap(Assets.finicio, 0, 0);
        g.drawPixmap(logo, 25, 110);
        
        //Animacion del title
        if(animacion){
        	thetime++;
        	if(thetime==mitime && logoaparece){
        		thetime=0;
        		logo=cambialogo();
        		if(contlogo==4){
        			logoaparece=false;  
        			
        		}
        	}
        	if(!logoaparece){
        		//Explosiones
        		thetimeexp++;
        		if(thetimeexp==mitimexp && nomas){
        			thetimeexp=0;
        			impactos.add(new Impacto(damex(), damey(), 0));
        			nexp++;
        			//metemos sonido a la explosion si procede:
        			if(Assets.sonido){
        				if(nexp<7)
        					Assets.exp_normal.play(1);
        				else
        					Assets.exp_final.play(1);
        			}
        			if(nexp==7){
        				nomas=false;
        			}
        		}
        		
        		//Pinto explosiones
        		for(int i=0;i<impactos.size();i++){
        			
        			if(impactos.get(i).incReta()==2){
        				impactos.get(i).incN();					
        			}
        			if(impactos.get(i).getN()<6){
        				g.drawPixmap(Assets.explosion, impactos.get(i).getX(), impactos.get(i).getY(),impactos.get(i).getN()*36,0,36,33);
        			}else{
        				impactos.remove(i);
        				
        			}
        		}
        		if(nexp==7 && impactos.size()==0){
        			animacion=false;
        		}
        		
        	}
        }else{
        	g.drawPixmap(Assets.fondo_menu_princi, 70, 210);
        	g.drawPixmap(Assets.selector, 0, ys);
        	g.drawPixmap(dameFondo(Records.fondo()), 78, 220);
        	if(Assets.sonido)
                g.drawPixmap(Assets.bsonido, g.getWidth()-40, 0, 0, 0, 38, 32);
            else
                g.drawPixmap(Assets.bsonido, g.getWidth()-40, 0, 38, 0, 38, 32);
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
        		vamonos(opcion);
        	}
        }
    }

    private Pixmap dameFondo(int v) {
		switch (v) {
		case 0:
			return Assets.menuprincipal;
		case 1:
			return Assets.menuprincipal_tor;
		case 2:
			return Assets.menuprincipal_all;		
		}
		return Assets.menuprincipal;
	}
    
    private int damey() {
		switch (nexp) {
		case 0:
			return 130;
		case 1:
			return 110;
		case 2:
			return 130;
		case 3:
			return 110;
		case 4:
			return 130;
		case 5:
			return 110;
		case 6:
			return 130;
		}
		return 0;
	}

	private int damex() {
		switch (nexp) {
		case 0:
			return 25;
		case 1:
			return 65;
		case 2:
			return 105;
		case 3:
			return 145;
		case 4:
			return 185;
		case 5:
			return 225;
		case 6:
			return 265;
		}
		return 0;
	}

	private Pixmap cambialogo() {
		switch (contlogo) {
		case 0:
			contlogo++;
			return Assets.logo2;
		case 1:
			contlogo++;
			return Assets.logo3;
		case 2:
			contlogo++;
			return Assets.logo4;
		case 3:
			contlogo++;
			return Assets.logo5;
			
		}
		return null;
		
	}

	private void vamonos(int opcion2) {
		Datos d=new Datos();
		Graficos g = juego.getGraphics();
		switch (opcion2) {
		case 0:
			juego.setScreen(new PantallaSeleccionNivel(juego));
			break;

		case 1:
			//NIVEL EXTRA 10
			d.setN_NIVEL(10);
			d.setRAT_FUEL(6); //Cada RAT_FUEL Aviones soltamos un fuel
			d.setRAT_TOR(10); //Cada RAT_TOR Aviones puede haber una tormenta
			d.setRAT_ITEM(4); //Cada RAT_ITEM Aviones soltamos un item [SIEMPRE QUE NO SE VAYA A SACAR FUEL]
			d.setRES_SIZE(2); //RES_SIZE + MIN_RES es el MAXIMO de restencia que un avion enemio puede tener
			d.setMIN_RES(3); //Minimo de resistencia de un enegigo
			d.setNUM_ENE(70); //Numero de enemigos que aparecer�n en el nivel
			d.setTIME_ENEMIGO(100); //Intervalo de aparicion de enemigos (mas bajo, menos tardan)
			d.setTIME_BALA(70); //Intervalo de disparo enemigo
			d.setTIME_FUEL(200); //Intervalo de gasto de fuel
			d.setVIDA_TOTAL(24); //Vida de nuestro personaje
			d.setFUEL_TOTAL(14); //Capacidad total de fuel
			Datos.setVELOCIDAD_ENEMIGO(2);
			d.setNivel(g.newPixmap("AFG-DestroyedMetropolis2.png", PixmapFormat.RGB565));
			d.setMusica(juego.getAudio().nuevaMusica("Destroyed Metropolis.mp3"));
			d.setAcorazado(g.newPixmap("AFG-acorazado43.png", PixmapFormat.ARGB4444));

			juego.setScreen(new PantallaVueloExtra(juego));
			break;
		case 2:

			//MODO TORNEO 9
			Datos.setN_NIVEL(9); //Numero de nivel
			d.setRAT_FUEL(6); //Cada RAT_FUEL Aviones soltamos un fuel
			d.setRAT_TOR(10); //Cada RAT_TOR Aviones puede haber una tormenta
			d.setRAT_ITEM(4); //Cada RAT_ITEM Aviones soltamos un item [SIEMPRE QUE NO SE VAYA A SACAR FUEL]
			d.setRES_SIZE(2); //RES_SIZE + MIN_RES es el MAXIMO de restencia que un avion enemio puede tener
			d.setMIN_RES(3); //Minimo de resistencia de un enegigo
			d.setNUM_ENE(100); //Numero de enemigos que aparecer�n en el nivel
			d.setTIME_ENEMIGO(100); //Intervalo de aparicion de enemigos (mas bajo, menos tardan)
			d.setTIME_BALA(50); //Intervalo de disparo enemigo
			d.setTIME_FUEL(200); //Intervalo de gasto de fuel	
			d.setVIDA_TOTAL(24); //Vida de nuestro personaje
			d.setFUEL_TOTAL(14); //Capacidad total de fuel
			Datos.setVELOCIDAD_ENEMIGO(3);			
			d.setNivel(g.newPixmap("sea.png", PixmapFormat.RGB565));
			d.setNext_nivel(g.newPixmap("AFG-Sea-Taiga.png", PixmapFormat.RGB565));
			d.setMusica(juego.getAudio().nuevaMusica("AFG-Tournament.mp3"));
			juego.setScreen(new PantallaModoTorneo(juego));
			break;
		case 3:
			juego.setScreen(new PantallaRecords(juego));
			break;
		case 4:
			juego.setScreen(new PantallaCreditos(juego));
			break;
			
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
    	// Guardar puntuaci�n por si acaso
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
