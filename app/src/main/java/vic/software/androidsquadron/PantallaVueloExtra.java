package vic.software.androidsquadron;

import java.util.ArrayList;
import java.util.List;

import vic.software.androidsquadron.marco.Graficos;
import vic.software.androidsquadron.marco.Input.TouchEvent;
import vic.software.androidsquadron.marco.Juego;
import vic.software.androidsquadron.marco.Musica;
import vic.software.androidsquadron.marco.Pantalla;
import vic.software.androidsquadron.marco.Pixmap;


public class PantallaVueloExtra extends Pantalla {




	enum EstadoJuego {
		Preparado, Ejecutandose, Pausado, FinJuego
	}

	private Datos d=new Datos();

	//Parametros principales del nivel
	private static int RAT_FUEL; //Cada RAT_FUEL Aviones soltamos un fuel
	private static int RAT_TOR; //Cada RAT_TOR Aviones puede haber una tormenta
	private static int RAT_ITEM; //Cada RAT_ITEM Aviones soltamos un item [SIEMPRE QUE NO SE VAYA A SACAR FUEL]
	private static int RES_SIZE; //RES_SIZE + MIN_RES es el MAXIMO de restencia que un avion enemio puede tener
	private static int MIN_RES; //Minimo de resistencia de un enegigo
	private static int NUM_ENE; //Numero de enemigos que aparecer�n en el nivel
	private static int TIME_ENEMIGO; //Intervalo de aparicion de enemigos (mas bajo, menos tardan)
	private static int TIME_BALA; //Intervalo de disparo enemigo
	private static int TIME_FUEL; //Intervalo de gasto de fuel
	private static int VIDA_TOTAL; //Vida de nuestro personaje
	private static int FUEL_TOTAL; //Capacidad total de fuel
	private static Musica musica;
	private static int ACO_RATIO_DISPARO;
	private static int LETRERO;

	//Otros parametros:
	private int n_ene=0; //Contador de enemigos
	private boolean creamos=true;
	private int contf=0; //Contador item fuel
	private int conti=0; //Contador otros items
	private EstadoJuego estado = EstadoJuego.Preparado;
	private Graficos g;
	private int mitime=0;
	private int balatime=0;
	private int srcYfondo;
	private int oldx;
	private Pixmap miavion;
	private Pixmap bala=Assets.disparo;
	private int danos=0; //MAX VIDA_TOTAL
	private int fuel=0; //MAX 18
	private int cfuel=0;
	private int ddfuel=0;
	private int item=0; //Cursor de menu pausa (0 resume, 1 main menu)
	private int itemy=224;
	private boolean lowfuel=false;
	private int caida=0;
	private int deltacaida=0;
	private int pdano=1; //Poder de disparo
	private int cdano=0; //Contador de disparos
	private int enemigos_destruidos=0; //Contador de enemigos destruidos
	private int n_dopado;//Atributo que define cuando saldra el avion dopado. Si esta a 0 no sale.
	private int contador_igneus=0;
	private boolean igneus_activo=false;

	// Declaramos nuestros objetos
	private Avion avion;
	private ArrayList<Disparo> disparos;
	private ArrayList<Enemigo> enemigos;
	private ArrayList<DisparoEnemigo> dispenemigo;
	private ArrayList<Nube> nubes;
	private ArrayList<Impacto> impactos;
	private ArrayList<Item> items;
	private ArrayList<ItemsGets> itemsgets;
	private ArrayList<EnemigoDie> enemigosdie;
	private ArrayList<Pompa> pompas;
	private boolean dfuel=false;
	private int rfuel=0;
	private boolean ddano=false;
	private int ddanos=0;
	private int drdano=0;
	private int rlow;
	private boolean muriendo=false;
	private boolean ganando=false;
	private int desp;
	private boolean sonando=false;
	private boolean completado;
	private boolean recordGuardado=false;
	private int ultimoConteoTormenta=0;
	//Tormenta
	private boolean tormenta=false;
	private int xt=0,yt=-960;
	private int late_tor=0;
	private int ntor=0; //Si es 5 hay relampago
	//Atributos de transacciones
	private boolean nosvamos=false;
	private boolean venimos=true;
	private int timegoto=0;
	private int thetimegoto=10;
	private int timetogo=10;
	private int thetimetogo=0;

	//Atributos de animacion Level Complete y Game over
	private int x_subMsg=-Assets.subMsgLevel.getWidth(); //Este entra por la derecha, por eso es lo que mide en negativo
	private int x_msg=320; //Este entra por la izquierda, por eso empieza em 320 (ancho de la pantalla)
	private int cont_msg=0; //Contador para la aparicion del letrero de Game Over o Level Complete
	private int tempo_msg=0; //Atributo que controlara el tiempo de transicion del mensaje correspondiente
	private boolean fin_msg=false; //Atributo booleano que controla el fin de la transicion del mensaje
	private boolean fincaida;
	private int msgx=360; //Atributo que se usa para el fondo oscuro de los mensajes
	private boolean listo=false; //Hasta que no este atrue no sucedera nada (Mensajes)
	private boolean finmensaje=false;
	private boolean animacionFuel=false;

	//Atributos jefe final
	private boolean sw_jefefinal=false; //Hasta que no este activo no se iniciera el jefe
	private Acorazado acorazado=new Acorazado(200,35,-280,false,0,20);
    private boolean sw_entrada=true; //Para que entre el jefe mas despacio
	private boolean aco_derecha=true; //Comenzará a moverse hacia la derecha
    private boolean acorzado_ataca=false;
	private int aco_waitime; //Contador ataque acorazdo
	private boolean letrero=false;
	private boolean finataque;
	private int wait_atack=0;
	private int sprite_acorazado=0;
	private ArrayList<Explosiones> explosiones;
	private boolean aco_muriendo=false;
	private int time_explosiones=0;
	private int TIME_EXPLO=20;
	private int time_sprite_aco=0;
	private int TIME_SPRI_ACO=200;
	private int time_disp_aco=0;
	private int RATE_ACO=30;
	private int igneus_time=0;
	private int RATE_IGNEUS=40;
	private boolean carga_disparo=false;
	private boolean igneus=false;
	private int cañon=1;
	private int carga_disp_rate=0;
	private int frame_carga=0;
	private boolean igneus_fire=false;
	private boolean igneus_dado=false;
	private int IGNEUS_X;
    private boolean carga_ice=false;
    private boolean ice=false;
    private int ICE_Y=90;
    private int frame_bala_ice=0;
    private boolean disparo_ice=false;
    private boolean congelado=false;
    private int congelado_rate=0;
    private int frame_congelado=3;
	private boolean radio=false;
	private boolean radiolocation=false;
	private boolean misil=false;
	private int ratio_radio=0;
	private boolean muestra_radio=false;
	private int ratio_escaneo=0;
	private int x_misil=0;
	private int y_misil=0;
	private boolean pinta_misil=false;
	private int frame_misil=0;
	private int ratio_misil=0;


	public PantallaVueloExtra(Juego juego) {
		super(juego);
		RAT_FUEL=d.getRAT_FUEL(); //Cada RAT_FUEL Aviones soltamos un fuel
		RAT_TOR=d.getRAT_TOR(); //Cada RAT_TOR Aviones puede haber una tormenta
		RAT_ITEM=d.getRAT_ITEM(); //Cada RAT_ITEM Aviones soltamos un item [SIEMPRE QUE NO SE VAYA A SACAR FUEL]
		RES_SIZE=d.getRES_SIZE(); //RES_SIZE + MIN_RES es el MAXIMO de restencia que un avion enemio puede tener
		MIN_RES=d.getMIN_RES(); //Minimo de resistencia de un enegigo
		NUM_ENE=d.getNUM_ENE(); //Numero de enemigos que aparecer�n en el nivel
		TIME_ENEMIGO=d.getTIME_ENEMIGO(); //Intervalo de aparicion de enemigos (mas bajo, menos tardan)
		TIME_BALA=d.getTIME_BALA(); //Intervalo de disparo enemigo
		TIME_FUEL=d.getTIME_FUEL(); //Intervalo de gasto de fuel	
		VIDA_TOTAL = d.getVIDA_TOTAL(); //Vida de nuestro personaje
		FUEL_TOTAL = d.getFUEL_TOTAL(); //Capacidad total de fuel
		ACO_RATIO_DISPARO=500; //Ratio ataque acorazado
		musica=d.getMusica();
		g = juego.getGraphics();
		n_dopado=0; //Atributo que define cuando saldra el avion dopado. Si esta a 0 no sale.
		miavion=Assets.avion;
		oldx=(g.getWidth()/2)-30;		
		//Instanciamos nuestros objetos
		avion=new Avion((g.getWidth()/2)-30, g.getWidth()-140); //Instanciamos el avion
		disparos=new ArrayList<Disparo>(); //Instanciamos un Array para los disparos
		enemigos=new ArrayList<Enemigo>(); //Instanciamos un Array para los enemigos
		dispenemigo=new ArrayList<DisparoEnemigo>(); //Instanciamos un Array para los disparos enemigos
		nubes=new ArrayList<Nube>(); //Instanciamos un Array para las nubes
		impactos=new ArrayList<Impacto>(); //Instanciamos un Array para los impactos
		items=new ArrayList<Item>(); //Instanciamos un Array para los items
		itemsgets=new ArrayList<ItemsGets>();
		enemigosdie=new ArrayList<EnemigoDie>(); //Instancioamos un array para la muerte de los enemigos
		pompas=new ArrayList<Pompa>(); //Instanciamos el array de pompas
		explosiones=new ArrayList<Explosiones>(); //Instanciamos array para las explosiones
		//A�adimos las nubes al array
		nubes.add(new Nube(0, 0, 1)); 
		nubes.add(new Nube(70, 250, 2));
		nubes.add(new Nube(150, 300, 3));
		//Maximo valor de la Y para el fondo:
		srcYfondo=960;
		avion.setY(g.getHeight() - 80); //Damos al avion el valor de su Y en el eje de coordenadas
		
		//Calculo cuando saldr� el avi�n dopado:
		//Niveles tarde
		if((Datos.getN_NIVEL()==1) || (Datos.getN_NIVEL()==4) || (Datos.getN_NIVEL()==7) ){
			n_dopado=(int) (Math.random()*NUM_ENE)+1;
		}
		//Niveles noche
		if((Datos.getN_NIVEL()==2) || (Datos.getN_NIVEL()==8) || (Datos.getN_NIVEL()==5) ){
			n_dopado=(int) (Math.random()*NUM_ENE)+1;
		}
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();

		if (estado == EstadoJuego.Preparado)
			updateReady(touchEvents);
		if (estado == EstadoJuego.Ejecutandose) {
			updateRunning(touchEvents, deltaTime);
		}
		if (estado == EstadoJuego.Pausado)
			updatePaused(touchEvents);
		if (estado == EstadoJuego.FinJuego)
			updateGameOver(touchEvents);
		
	}

	private void updateReady(List<TouchEvent> touchEvents) {
		// el juego empieza nada m�s pulsar sobre la pantalla
		if(venimos==false){
			if (touchEvents.size() > 0 && listo){
				touchEvents.clear(); //Borramos todos los touch pa no joderla
				estado = EstadoJuego.Ejecutandose;
				if (Assets.sonido){
					musica.setLooping(true);
					musica.play();
				}
			}
		}
		if(!finmensaje){
			if(msgx==0){
				listo=true;
				finmensaje=true;
			}else{
				msgx-=10; //Vamos metiendo el mensaje			
			}
		}
	}
	

	private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
		//Reinicio valores de menus pausa, etc...
		msgx=360;
		listo=false;
		finmensaje=false;
		
		// que se mueva lo que tenga que moverse
		for(int i=0;i<touchEvents.size();i++){
			//Si estamos muriendo, no hacemos caso de naaaaaa
			if(!muriendo && !ganando){
			//Compruebo si han tocado para mover el avion, y si los han hecho ademas con un Dragged:

				if(touchEvents.get(i).y>(g.getHeight()-80) && touchEvents.get(i).type==touchEvents.get(i).TOUCH_DRAGGED){
                    if(!congelado){
					//Si cambia de posicion, cambiamos por el sprite correspondiente:
					if(touchEvents.get(i).x==oldx){
						miavion=Assets.avion; //Avion normal
					}else if(touchEvents.get(i).x-2>oldx){
						miavion=Assets.avder; //Avion a la derecha
					}else if(touchEvents.get(i).x+2<oldx){
						miavion=Assets.avizq; //Avion a la izquierda
					}
					//Movemos el avion y las explosiones del mismo si las hubiese
					avion.ponte(touchEvents.get(i).x);
					for(int ii=0;ii<impactos.size();ii++){
						impactos.get(ii).setX(avion.getX()+impactos.get(ii).getN());						
					}
					oldx=touchEvents.get(i).x;
                    }
				}else if(touchEvents.get(i).y>(g.getHeight()-80) && touchEvents.get(i).type==touchEvents.get(i).TOUCH_DOWN){
                    if(!congelado){
					//if(mitime==20){
						if(pdano>1){
							cdano++;
							if(cdano>10){
								pdano=1;
								cdano=0;
								bala=Assets.disparo;
							}
						}
						disparos.add(new Disparo(avion.getX()+8, g.getHeight()-80));
						disparos.add(new Disparo((avion.getX()+Assets.avion.getWidth())-15, g.getHeight()-80));
						if (Assets.sonido)
							Assets.sdisparo.play(1);
					}
				}else if(touchEvents.get(i).y<64 && touchEvents.get(i).x<64){
					//Pausa
					estado = EstadoJuego.Pausado;
				}else{
					miavion=Assets.avion;
				}
            }

		}
		
		//Muevo los disparos:		
		for(int i=disparos.size()-1;i>=0;i--){
			disparos.get(i).setY(disparos.get(i).getY()-10);
			if(disparos.get(i).getY()<0){
				disparos.remove(i);
			}
		}
		//Movemos los disparos de los enemigos
		for(int i=dispenemigo.size()-1;i>=0;i--){
			dispenemigo.get(i).setY(dispenemigo.get(i).getY()+7);
			if(dispenemigo.get(i).getY()>g.getHeight()){
				dispenemigo.remove(i);
			}
		}
		
			
		//Muevo los enemigos:
		for(int i=enemigos.size()-1;i>=0;i--){
			enemigos.get(i).setY(enemigos.get(i).getY()+Datos.getVELOCIDAD_ENEMIGO());
			if(enemigos.get(i).getY()>g.getHeight()){
				enemigos.remove(i);
			}
		}
		//Muevo los items
		for(int i=items.size()-1;i>=0;i--){
			items.get(i).setY(items.get(i).getY()+2);
			if(items.get(i).getY()>g.getHeight()){
				items.remove(i);
			}
		}
		
		//Muevo la tormenta
		if(tormenta && !ganando && !muriendo){
			yt+=2;											
			if(yt>=960){
				tormenta=false;
			}
			//Calculamos si hay relampago:
			ntor=(int) (Math.random()*20)+1;
		}
		
		//Comprobamos impactos de disparo:
		if(!acorazado.isActivo()) {
			for (int i = disparos.size() - 1; i >= 0; i--) {
				for (int j = enemigos.size() - 1; j >= 0; j--) {
					if (disparos.get(i).getY() <= enemigos.get(j).getY() && (disparos.get(i).getX() >= enemigos.get(j).getX() && disparos.get(i).getX() <= (enemigos.get(j).getX() + 72))) {
						//Hay impacto
						disparos.remove(i); //Eliminamos el disparo
						enemigos.get(j).setRes(enemigos.get(j).getRes() - pdano); //Quitamos vida al enemigo
						if (enemigos.get(j).getRes() <= 0) {
							//Si la vida es 0 o menor
							enemigos_destruidos++; //A�adimos 1 al contador de enemigos destruidos
							contf++; //Sumamos 1 al contador de fuel
							conti++; //Sumamos 1 al contador Items
							//Comprobamos si hay que soltar algun objeto
							compruebaItem(enemigos.get(j).getX(), enemigos.get(j).getY());
							compruebaFuel(enemigos.get(j).getX(), enemigos.get(j).getY());
							//Aqui van los demas items posibles
							if (Assets.sonido) {
								Assets.enemyDestoryPlane.play(1);
							}
							enemigosdie.add(new EnemigoDie(enemigos.get(j).getX(), enemigos.get(j).getY(), dameenemigo(enemigos.get(j).getN()), 0));
							enemigos.remove(j); //Eliminamos al enemigo
						} else {
							//Si la vida es 1 o mayor:
							enemigos.get(j).setDanado(true); //Le ponemos en estado da�ado para la animacion
							enemigos.get(j).setDan(0);
							enemigos.get(j).setEsp(0);
						}
						break; //Cada disparo solo puede impactar a un enemigo.
					}
				}
			}
		}else {
			//Comprobamos impacto al Acorazado
			if (sw_jefefinal && acorazado.isActivo() && !aco_muriendo) {
				//Solo comprobamos si el acorazado esta en pantalla y a terminado la animacion del entrada
				for (int i = disparos.size() - 1; i >= 0; i--) {
					if (disparos.get(i).getY() <= acorazado.getY() + 180 && disparos.get(i).getX() >= acorazado.getX() + 118 && disparos.get(i).getX() <= acorazado.getX() + 126) {
						disparos.remove(i); //Eliminamos el disparo
						acorazado.setVida(Math.max(0, acorazado.getVida() - pdano));
						if (Assets.sonido) {
							Assets.enemyDestoryPlane.play(1);
						}
						if (acorazado.getVida() == 0) {
							aco_muriendo = true;
							break;
						}
					}
				}
			}
			if(igneus_activo) {
				//Comprobamos impacto IGNEUS
				if (!igneus_dado) {
					//if (IGNEUS_X < avion.getX() && (IGNEUS_X + 43) > avion.getX()) {
					if ((IGNEUS_X>avion.getX() && IGNEUS_X<(avion.getX()+65))){
						danos += 5; //sumamos los danos
						ddano = true; //Esta variable es para el efecto del da�o. Se pintara el efecto al colocarla a true
						igneus_dado = true; //Ponemos true el switch para que no nos haga daño en cada loop del juego.
						if (Assets.sonido)
							Assets.damagePlane.play(1);
						if (danos < VIDA_TOTAL) {
							//Si los danos son menores que VIDA_TOTAL, seguimos vivos.
							//impactos.add(new Impacto(dispenemigo.get(i).getX()-30, avion.getY()+210, dispenemigo.get(i).getX()-(avion.getX())));
						} else {
							//Si los danos son 12 o mas, perdemos:
							muriendo = true; //Empezamos a morirnos, xD
							if (Assets.sonido && !sonando) {
								Assets.protaDestoryPlane.play(1);
								sonando = true;
								musica.stop();
								Assets.gameover.play();

							}
						}
					}
				} else {
					//Si hemos entrado por aqui, es que nos ha dado antes el ataque.
					//Esperamos unos segundos hasta que nos pueda volver a afectar
					if (contador_igneus >= 200) {
						igneus_dado = false;
						contador_igneus = 0;
					} else {
						contador_igneus++;
					}

				}
			}
            if(ice && disparo_ice){
                //COMPRUEBO IMPACTO ICE
                if((ICE_Y>=g.getHeight()-80 && ICE_Y<=(g.getHeight()-80+51) && (dameXcañon(cañon)>avion.getX() && dameXcañon(cañon)<(avion.getX()+65)))){
                    //NOS HA DADO EL HIELO
                    congelado=true;
                    acorzado_ataca=false;
                    ice=false;
                    wait_atack=0;
                    disparo_ice=false;
                    frame_congelado=3;
                }
            }
            if(congelado){
                if (congelado_rate % 100 == 0) {
                    frame_congelado--;

                }
                if (frame_congelado < 0) {
                    congelado=false;
                    congelado_rate=0;
                    frame_congelado=3;
                }
                congelado_rate++;

            }
		}
		//Compruebo fin del juego
		if(!creamos && enemigos.size()==0){
			//Si no hay mas enemigos y hemos dejado de crear:
			//Aqui tenemos que activar el jefe final
			sw_jefefinal=true; //Activamos jefe final


//			ganando=true; //Comenzamos animacion de victoria
//			completado=true; //Indicamos que se ha completado el nivel
//			if(Assets.sonido){
//				musica.stop();
//				Assets.victory.play();
//			}
		}
		//Comprobamos impactos de disparo enemigos
		if(!muriendo)
		for(int i=dispenemigo.size()-1;i>=0;i--){
			if((dispenemigo.get(i).getY()>=g.getHeight()-80 && dispenemigo.get(i).getY()<=(g.getHeight()-80+51) && (dispenemigo.get(i).getX()>avion.getX() && dispenemigo.get(i).getX()<(avion.getX()+65)))){
				//Si nos han dado:
				
				danos+=dispenemigo.get(i).getPoder(); //sumamos los danos		
				ddano=true; //Esta variable es para el efecto del da�o. Se pintara el efecto al colocarla a true
				if (Assets.sonido)
					Assets.damagePlane.play(1);
				if(danos<VIDA_TOTAL){
					//Si los danos son menores que VIDA_TOTAL, seguimos vivos.
					impactos.add(new Impacto(dispenemigo.get(i).getX()-30, avion.getY()+210, dispenemigo.get(i).getX()-(avion.getX())));						
				}else{
					//Si los da�os son 12 o mas, perdemos:
					muriendo=true; //Empezamos a morirnos, xD
					if(Assets.sonido && !sonando){							
						Assets.protaDestoryPlane.play(1);
						sonando=true;						
						musica.stop();
						Assets.gameover.play();
						
					}
				}
				dispenemigo.remove(i); //Eliminamos el disparo enemigo
			}
		}
			
		//Comprobamos si hemos cogido algun item
		if(!ganando && !muriendo){//Si hemos ganado ya o hemos pedido ya no cogemos items :(
			for(int i=items.size()-1;i>=0;i--){
				if((items.get(i).getY()>=g.getHeight()-80 && items.get(i).getY()<=(g.getHeight()-80+51) && ((items.get(i).getX()+20)>avion.getX() && items.get(i).getX()<(avion.getX()+65)))){
					//Si hemos pasado por encima de un item:
					compruebaItem(items.get(i).getTipo());
					if(Assets.sonido){
						Assets.aceptoption.play(1);
					}
					items.remove(i); //Eliminamos el item
				}
			}
		}
		//Aqui llamamos al metodo que calcula si hay tormenta
		if(RAT_TOR > 0 && n_ene > 0 && n_ene % RAT_TOR == 0 && ultimoConteoTormenta != n_ene){
			ultimoConteoTormenta = n_ene;
			isTormenta();
		}

        //Muevo el acorazado
		if(sw_jefefinal && !aco_muriendo && !ganando) {
			if (!acorazado.isActivo()) {
				//Esta apareciendo
				//Inicializo por primera vez a 0 la variable de ataque
				aco_waitime=0;
                if(sw_entrada) {
                    acorazado.setY(acorazado.getY() + 1);
                    sw_entrada=false;
                }else{
                    sw_entrada=true;
                }

				if (acorazado.getY() > -5)
					acorazado.setActivo(true);
			} else {
                //Solo nos movemos si no vamos a atacar
                if(!acorzado_ataca) {
                    //Aqui lo movemos de derecha a izquierda
                    if (aco_derecha) {
                        //Movemos hacia la derecha +X
                        acorazado.setX(acorazado.getX() + 1);
                        if (acorazado.getX() >= 150) {
                            aco_derecha = false;
                        }
                    } else {
                        //Movemos hacia la izquierda -X
                        acorazado.setX(acorazado.getX() - 1);
                        if (acorazado.getX() <= -80) {
                            aco_derecha = true;
                        }
                    }
					aco_waitime++;
					if(aco_waitime == ACO_RATIO_DISPARO){
						acorzado_ataca=true;
						//Llamamos al metedo que calcula que ataque va a hacer
						calculaAtaque();
						aco_waitime=0;
					}

					//Creamos disparos
					time_disp_aco++;
					if(time_disp_aco>=RATE_ACO){
						dispenemigo.add(new DisparoEnemigo(acorazado.getX()+18,acorazado.getY()+40,1));
						dispenemigo.add(new DisparoEnemigo(acorazado.getX()+223,acorazado.getY()+40,1));
						time_disp_aco=0;
					}

                }else{

					wait_atack++;
					if(wait_atack==60){
						switch (LETRERO) {
							case 0:
								radio=true;
								radiolocation=true;
								misil=false;
								break;
                            case 1:
                                //ICE
                                carga_ice=true;
                                ice=true;
                                carga_disp_rate=0;
                                frame_carga=0;
                                if(Assets.sonido){
                                    Assets.cargar_rayo.play(20);
                                }
                                break;
							case 2:
								//IGNEUS BREATH
								carga_disparo=true;
								igneus=true;
                                carga_disp_rate=0;
                                frame_carga=0;
                                if(Assets.sonido){
                                    Assets.cargar_rayo.play(20);
                                }
								break;
							case 4:
								items.add(new Item(0, acorazado.getX() + 20, acorazado.getY() + 20));
								items.add(new Item(4, acorazado.getX() + 200, acorazado.getY() + 20));
                                if(Assets.sonido){
                                    Assets.error43.play(20);
                                }
								break;
						}
						letrero=false;

					}
					//RADIOLOCATION
					if(radiolocation){
						if(radio){
							if (ratio_radio % 5 == 0) {
								muestra_radio = true;
								ratio_escaneo++;
							}
							if (ratio_radio % 10 == 0){
								muestra_radio = false;
								ratio_radio=0;
							}
							ratio_radio++;
							if(ratio_escaneo == 50){
								radio = false;
							}
							//comprobamos si en algun momento hemos estado dentro del radio location
							if((avion.getX()>dameXcañon(cañon)-60) && (avion.getX()<((dameXcañon(cañon)-60)+154))){
								misil=true;
								x_misil=dameXcañon(cañon)-60;
								y_misil=75;
							}
						}else{
							//Evaluamos si sale el misil
							if(misil){
								muestra_radio=false;
								pinta_misil=true;
								y_misil+=5;
								if(avion.getX()+15>x_misil){
									x_misil+=4;
								}else if(avion.getX()+15<x_misil){
									x_misil-=4;
								}
								ratio_misil++;
								if (ratio_misil % 8 == 0) {
									frame_misil = 0;
									ratio_misil = 0;
								} else if (ratio_misil % 4 == 0) {
									frame_misil = 1;
								}
								if(((y_misil+51)>=g.getHeight()-80 && (y_misil+51)<=(g.getHeight()-80+51) && (x_misil>avion.getX() && x_misil<(avion.getX()+65)))){
									//Nos ha dado
									//el misil se fue por abajo
									danos+=5; //sumamos los danos
									ddano=true; //Esta variable es para el efecto del da�o. Se pintara el efecto al colocarla a true
									if (Assets.sonido)
										Assets.damagePlane.play(1);
									if(danos<VIDA_TOTAL){
										//Si los danos son menores que VIDA_TOTAL, seguimos vivos.
										impactos.add(new Impacto(x_misil-30, avion.getY()+210, (y_misil+51)-(avion.getX())));
									}else{
										//Si los da�os son 12 o mas, perdemos:
										muriendo=true; //Empezamos a morirnos, xD
										if(Assets.sonido && !sonando){
											Assets.protaDestoryPlane.play(1);
											sonando=true;
											musica.stop();
											Assets.gameover.play();

										}
									}



									acorzado_ataca=false;
									radiolocation=false;
									radio=false;
									muestra_radio = false;
									ratio_radio=0;
									wait_atack=0;
									ratio_escaneo=0;
									misil=false;
									pinta_misil=false;
									ratio_misil=0;

								}

								if(y_misil>g.getHeight()){
									//el misil se fue por abajo
									acorzado_ataca=false;
									radiolocation=false;
									radio=false;
									muestra_radio = false;
									ratio_radio=0;
									wait_atack=0;
									ratio_escaneo=0;
									misil=false;
									pinta_misil=false;
									ratio_misil=0;
								}
							}else{
								acorzado_ataca=false;
								radiolocation=false;
								radio=false;
								muestra_radio = false;
								ratio_radio=0;
								wait_atack=0;
								ratio_escaneo=0;
								misil=false;
								pinta_misil=false;
								ratio_misil=0;
							}

						}

					}

					//IGNEUS
					if(igneus){
						if(carga_disparo) {
							carga_disp_rate++;
							if (carga_disp_rate % 20 == 0) {
								frame_carga++;
							}
							if (frame_carga >= 4) {
								carga_disparo = false;
								frame_carga=0;
								carga_disp_rate=0;
							}

						}else{
							igneus_fire=true;
							igneus_time++;
							if(igneus_time==RATE_IGNEUS){
								igneus_fire=false;
								acorzado_ataca=false;
								igneus_time=0;
								igneus=false;
								wait_atack=0;
								igneus_activo=false;
                                igneus_dado=false;
							}
						}
					}
                    if(ice){
                        if(carga_ice){
                            //cargamos el hielo
                            if (carga_disp_rate % 30 == 0) {
                                frame_carga++;
                            }
                            if (frame_carga > 5) {
                                carga_ice = false;
                                frame_carga=0;
                                carga_disp_rate=0;
                                disparo_ice=true;
                            }

                        }else{
                            //disparamos el hielo
                            ICE_Y+=5;

                            //Tambien cambiamos el frame.
                            if (carga_disp_rate % 50 == 0) {
                                frame_bala_ice++;
                            }

                            if(frame_bala_ice > 4){
                                frame_bala_ice=0;
                                carga_disp_rate=0;
                            }

                            if(ICE_Y>g.getHeight()){
                                acorzado_ataca=false;
                                ice=false;
                                wait_atack=0;
                                disparo_ice=false;
                            }
                        }
                    }
					//Solo para el error 43
					if(wait_atack>=100 && LETRERO==4){
						wait_atack=0;
						acorzado_ataca=false;
					}
				}
			}
		}
		if(aco_muriendo){
			time_explosiones++;
			//Creamos explosiones
			if(time_explosiones==TIME_EXPLO){
				//Creo explosiones
				int x=(int) (Math.random()*240)+100;
				int y=(int) (Math.random()*180)+1;
				explosiones.add(new Explosiones(x,y,0,0));
				time_explosiones=0;
			}

			//Cambiando frame
			for(int i=explosiones.size()-1;i>=0;i--){
				if(explosiones.get(i).getCont()>=5){
					explosiones.get(i).setFrame(explosiones.get(i).getFrame()+1);
				}else{
					explosiones.get(i).setCont(explosiones.get(i).getCont()+1);
				}

				if(explosiones.get(i).getFrame()>14){
					explosiones.remove(i);
				}
			}
			//Cambiamos el sprite del acorazado
			time_sprite_aco++;
			if(time_sprite_aco==TIME_SPRI_ACO){
				sprite_acorazado++;
				time_sprite_aco=0;
			}
			//Comprobamos final de la animacion
			//Fin del juego
			if(sprite_acorazado==5){
				aco_muriendo=false;
				acorazado.setActivo(false);
				sw_jefefinal=false;
				ganando=true; //Comenzamos animacion de victoria
				completado=true; //Indicamos que se ha completado el nivel
				if(Assets.sonido){
					musica.stop();
					Assets.victory.play();
				}
			}

		}





		
	}// Fin de UpdateRunning

	private void calculaAtaque() {
		//Activamos el switch para que se pinte el letrero
		letrero=true;
		//Inventamos un numero al azar del 1 al 100
		int n=(int) (Math.random()*10)+1;
		//Calculamos cañon
		cañon=(int) (Math.random()*2)+1;
		switch (n){
			case 1:
			case 2:
				//RADIOLOCATION
				LETRERO=0;
				break;
			case 3:
			case 4:
				//ICY PRISION
				LETRERO=1;
				break;
			case 5:
			case 6:
				//IGNEUS BREATH
				LETRERO=2;
				break;
			case 7:
			case 8:
			case 9:
			case 10:
				//ERROR 43
				LETRERO=4;
				break;

		}
	}

	//Metodo que nos gestiona el tipo de item que hemos cogido, y llama al metodo que corresponda
	private void compruebaItem(int tipo) {
		switch (tipo) {
		case 0:
			incrementaFuel(5);		
			itemsgets.add(new ItemsGets(0, 4, Assets.getfuel, avion.getX()-(Assets.getfuel.getWidth()/2), avion.getY()-20,163,8));
			break;
		case 1:
			pdano=1;
			cdano=0;
			bala=Assets.disparo;
			itemsgets.add(new ItemsGets(0, 4, Assets.getnormal, avion.getX()-(Assets.getnormal.getWidth()/2), avion.getY()-20,191,9));
			break;
		case 2:
			pdano=2;
			cdano=0;	
			bala=Assets.disparom;
			itemsgets.add(new ItemsGets(0, 4, Assets.getmave, avion.getX()-(Assets.getmave.getWidth()/2), avion.getY()-20,163,9));
			break;
		case 3:
			pdano=3;
			cdano=0;
			bala=Assets.disparoh;
			itemsgets.add(new ItemsGets(0, 4, Assets.getharry, avion.getX()-(Assets.getharry.getWidth()/2), avion.getY()-20,179,9));
			break;
		case 4:
			incrementaVida(5);		
			itemsgets.add(new ItemsGets(0, 4, Assets.getrepa, avion.getX()-(Assets.getrepa.getWidth()/2), avion.getY()-20,183,10));
			break;
		case 5:
			decrementaFuel(5);
			pompas.add(new Pompa(avion.getX(),avion.getY(),1,2,2));
			pompas.add(new Pompa(avion.getX(),avion.getY(),2,2,0));
			pompas.add(new Pompa(avion.getX(),avion.getY(),3,2,2));
			if (Assets.sonido) {
				Assets.SoundLapsed.play(1);
			}
			animacionFuel=true;
			break;
		default:
			break;
		}
		
	}
	//Metodo que recibe el numero de fuel que se va a incrementar
	private void incrementaFuel(int f) {
		fuel-=f; //Recordamos que el valor fuel maximo es 0
		if(fuel<0)
			fuel=0; //Si el valor de fuel es menor que 0, lo dejamos en 0		
	}
	private void decrementaFuel(int f) {
		fuel+=f; //Recordamos que el valor fuel maximo es 0
		if(fuel>=18)
			fuel=17; //Si el valor de fuel es menor que 0, lo dejamos en 0		
	}
	//Metodo que recibe el numero de fuel que se va a incrementar
		private void incrementaVida(int v) {
			danos-=v; //Recordamos que el valor fuel maximo es 0
			if(danos<0)
				danos=0; //Si el valor de fuel es menor que 0, lo dejamos en 0		
		}



	//Eventos que suceden cuando el juego esta pausado
	private void updatePaused(List<TouchEvent> touchEvents) {
		if(nosvamos==false){
		int len = touchEvents.size(); //Guardamos en la variable len, el tama�o del array de los touch
		
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i); //Guardamos en una variable el touch i
			if (event.type == TouchEvent.TOUCH_UP && listo) {
				if (event.y > 220 && event.y <= 280) {
					if (event.x > 220 && event.x <= 320) { // Si nos pulsan en continuar
						if(item==0){ //Si el cursos ya esta en continuar, continuamos
							if (Assets.sonido){
								Assets.aceptoption.play(1);
								musica.playp();
							}
							
							estado = EstadoJuego.Ejecutandose;
							return;
						}else{ //Si el cursor no esta en continuar, lo colocamos en continuar
							itemy=224;
							if (Assets.sonido){
								Assets.selectoption.play(1);
							}
							item=0;
						}
					}
					if (event.x > 5 && event.x < 135) { //Si nos pulsan en salir
						if(item==1){ //Si el cursor ya esta en salir, salimos
							if (Assets.sonido){
								Assets.aceptoption.play(1);
								musica.stop();
							}
							nosvamos=true;
							return;
						}else{ //Si el cursor no esta en salir, lo colocamos en salir.
							itemy=243;
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
		if(!finmensaje){
			if(msgx==0){
				listo=true;
				finmensaje=true;
			}else{
				msgx-=10; //Vamos metiendo el mensaje			
			}
		}
	}

//Eventos de Game Over
	private void updateGameOver(List<TouchEvent> touchEvents) {
		if(nosvamos==false){
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) { //Si pulsan en cualquier parte de la pantalla, volvemos la menu principal
				if (Assets.sonido)
					Assets.pulsar.play(1);
				nosvamos=true;
				return;
				
			}
		}
		}
	}
	//	

	@Override
	public void present(float deltaTime) {
		// Renderizamos la nueva situaci�n del juego pintando los objetos
		// se suponen en diferente posicion desde el ultimo detaTime
		
		
		//pintamos el fondo	
		g.drawPixmap(d.getNivel(), 0, 0, 0, srcYfondo, 321, 481);
		
		
		
				
				
		//pintamos las nubes:
		//Si es un nivel de noche, no hay nubes. Si es de dia tampoco
		if(!(Datos.getN_NIVEL()==2) && !(Datos.getN_NIVEL()==8) && !(Datos.getN_NIVEL()==5) && !(Datos.getN_NIVEL()==0) && !(Datos.getN_NIVEL()==3) && !(Datos.getN_NIVEL()==6) ){
			for (int i=0;i<nubes.size();i++){
				g.drawPixmap(damenube(nubes.get(i).getId()), nubes.get(i).getX(), nubes.get(i).getY());
			}
		}
		//Pinto los items
		for(int i=0;i<items.size();i++){
			g.drawPixmap(dameItem(items.get(i).getTipo()), items.get(i).getX(), items.get(i).getY());
		}
		
		
		
		//Creacion de enemigo
		if(mitime==TIME_ENEMIGO && creamos){
			//creamos un enemigo
			//invento la posicion del enemigo con respecto al eje X
			int xene=(int) (Math.random()*(g.getWidth()-44));
			//invento la resistencia del enemigo
			int res=(int) (Math.random()*RES_SIZE)+MIN_RES;
			//invento que enemigo quiero:
			int n=(int) (Math.random()*10)+1;
			int m=(int) (Math.random()*2)+1;
			
			if(n_dopado!=0){
				if(n_ene==n_dopado){
					//Niveles tarde
					if((Datos.getN_NIVEL()==1) || (Datos.getN_NIVEL()==4) || (Datos.getN_NIVEL()==7) ){
						enemigos.add(new Enemigo(xene,-32,n,m,5,2));					
					}
					//Niveles noche
					if((Datos.getN_NIVEL()==2) || (Datos.getN_NIVEL()==8) || (Datos.getN_NIVEL()==5) ){
						enemigos.add(new Enemigo(xene,-32,n,m,5,3));						
					}
				}else{			
					enemigos.add(new Enemigo(xene,-32,n,m,res,1));
				}
			}else{
				enemigos.add(new Enemigo(xene,-32,n,m,res,1));
			}
			mitime=0;
			n_ene++;
			if(n_ene==NUM_ENE){
				creamos=false;
			}
		}
        //Pintamos jefe
        if (sw_jefefinal){
            g.drawPixmap(d.getAcorazado(),acorazado.getX(),acorazado.getY(),243*sprite_acorazado,0,243,180); //Pintamos al jefe
        }

		//Pintamos las explosiones
		if(aco_muriendo){
			for(int i=explosiones.size()-1;i>=0;i--){
				g.drawPixmap(Assets.explosiones_acorazado,explosiones.get(i).getX(),explosiones.get(i).getY(),32*explosiones.get(i).getFrame(),0,32,33);
			}
		}

		//Pintamos letrero de ataque
		if(acorzado_ataca && letrero){
			g.drawPixmap(Assets.letrAcora,90,1,0,LETRERO*20,144,20);

		}

		if(acorzado_ataca && carga_disparo){
			g.drawPixmap(Assets.carga_igneus,dameXcañon(cañon),90,48*frame_carga,0,48,43);
		}

        if(acorzado_ataca && carga_ice && !disparo_ice){
            g.drawPixmap(Assets.ice_carga,dameXcañon(cañon),90,54*frame_carga,0,54,53);
            ICE_Y=90;
        }

        if(acorzado_ataca && !carga_ice && disparo_ice){
            g.drawPixmap(Assets.ice_bala,dameXcañon(cañon),ICE_Y,18*frame_bala_ice,0,18,24);
        }

		if(acorzado_ataca && igneus_fire && !carga_disparo){
			g.drawPixmap(Assets.igneus,dameXcañon(cañon),90);
			igneus_activo=true;
		}

		//Creamos disparon enemigos
		if(TIME_BALA==balatime){
			if(enemigos.size()>0){
				int d=(int) (Math.random()*enemigos.size());
				dispenemigo.add(new DisparoEnemigo(enemigos.get(d).getX(),enemigos.get(d).getY(),enemigos.get(d).getPoder_disparo()));
				dispenemigo.add(new DisparoEnemigo(enemigos.get(d).getX()+Assets.e1.getWidth()-10,enemigos.get(d).getY(),enemigos.get(d).getPoder_disparo()));
			}
			balatime=0;
		}
		//Restamos fuel
		if(cfuel==TIME_FUEL){
			if(fuel<FUEL_TOTAL){
				fuel++;
				dfuel=true;
			}else{
				if(!aco_muriendo){
					//SI EL ACORAZADO ESTA MURIENDO, NO MOLA QUE NOS QUEDEMOS SIN GASOLINA :(
					muriendo=true;
					//Reproducimos sonido de caida
					if(Assets.sonido && !sonando){
						Assets.protaDestoryPlane.play(1);
						sonando=true;
					
						musica.stop();
						Assets.gameover.play();
					
					}
				}

			}
			cfuel=0;
		}
		if(fuel>(FUEL_TOTAL-3)){
			lowfuel=true;
		}else{
			lowfuel=false;
		}
		
		//pinto las vidas:
//		for(int i=0;i<vidas;i++){
//			g.drawPixmap(Assets.apeque, g.getWidth()-((18*(i+1)+18)), 10);
//		}
		
				
		//pinto los disparos:
		for(int i=0;i<disparos.size();i++){
			g.drawPixmap(bala, disparos.get(i).getX(), disparos.get(i).getY());
		}
		
		//Pinto explosiones prota
		for(int i=impactos.size()-1;i>=0;i--){
			
			if(impactos.get(i).incReta()==2){
				impactos.get(i).incN();					
			}
			if(impactos.get(i).getN()<6){
				g.drawPixmap(Assets.explosion, avion.getX()+impactos.get(i).getXi(), avion.getY(),impactos.get(i).getN()*36,0,36,33);
			}else{
				impactos.remove(i);
				
			}
		}
		
		
		//pinto enemigos:
		for(int i=0;i<enemigos.size();i++){
			g.drawPixmap(dameenemigo(enemigos.get(i).getN()), enemigos.get(i).getX(), enemigos.get(i).getY());
			if(enemigos.get(i).isDanado()){
				if(enemigos.get(i).getEsp()==3){
					if(enemigos.get(i).getDan()==7){
						enemigos.get(i).setDanado(false);
						enemigos.get(i).setDan(0);
						enemigos.get(i).setEsp(0);
					}else{
						enemigos.get(i).setDan(enemigos.get(i).getDan()+1);
						enemigos.get(i).setEsp(0);
					}
				}else{
					enemigos.get(i).setEsp(enemigos.get(i).getEsp()+1);
				}
				//Vuelvo a comprobar
				if(enemigos.get(i).isDanado()){
					//Pintamos efecto de da�o a enemigo aqui
					g.drawPixmap(Assets.enedamrec, enemigos.get(i).getX(), enemigos.get(i).getY(), enemigos.get(i).getDan()*72, 0, 72, 34);
				}
			}
		}
		//pinto disparos de enemigos:
		for(int i=0;i<dispenemigo.size();i++){
			g.drawPixmap(damedisparo(dispenemigo.get(i).getPoder()), dispenemigo.get(i).getX(), dispenemigo.get(i).getY());
		}
		//Pinto misil
		if(pinta_misil){
			g.drawPixmap(Assets.misil, x_misil, y_misil, 10*frame_misil, 0, 10, 51);
		}
		//Pinto animacion muerte enemigo
		for (int i=enemigosdie.size()-1;i>=0;i--){
			if(enemigosdie.get(i).getCont()<12){ //La animacion de muerte tiene 12 sprites
				//Retardo
				int r= enemigosdie.get(i).getRetard(); 
				r++;
				enemigosdie.get(i).setRetard(r);
				//Movemos enemigo
				int y=enemigosdie.get(i).getY();
				y+=2;
				enemigosdie.get(i).setY(y);
				//Pintamos
				g.drawPixmap(enemigosdie.get(i).getAsset(), enemigosdie.get(i).getX(), enemigosdie.get(i).getY());
				g.drawPixmap(Assets.enemyDie, enemigosdie.get(i).getX(), enemigosdie.get(i).getY(),enemigosdie.get(i).getCont()*72,0,72,34);
				
				int cont=enemigosdie.get(i).getCont();
				if(enemigosdie.get(i).getRetard()==2){
					cont++;
					enemigosdie.get(i).setRetard(0);
				}
				enemigosdie.get(i).setCont(cont);
			}else{
				enemigosdie.remove(i);
			}
		}
		// Pintamos el avion:
				if(!muriendo && !ganando){
					//Pintamos el avion de forma normal, ya que no estamos muriendo ni hemos ganado
					desp=avion.getY();
					if(estado!= EstadoJuego.FinJuego)
						//Si el estado del juego es diferente a FinJuego y Muriendo
						g.drawPixmap(miavion, avion.getX(), g.getHeight() - 80); //Pintamos el avion		
				}else{
					//Estamos muriendo o ganando
					if(muriendo){
						//Si estamos muriendo, iniciamos la animacion correspondiente:
						if(deltacaida==15){
							//Comprobamos estado caida:
							if(caida<=17){
								caida++;
							}else{
								fincaida=true;
							}
							deltacaida=0;
						}
						deltacaida++;
						if(caida<9) //Si es menor que 9, estamos cayendo
							g.drawPixmap(Assets.caida, avion.getX(), avion.getY(), caida*72, 0, 72, 47); //Avion cayendo
						else{
							g.drawPixmap(Assets.caida, avion.getX(), desp, caida*72, 0, 72, 47); //Avion explosion (se mueve con el fondo)
						desp++;
						}
						
						//Pinto la tormenta mientras perdemos
						if(tormenta && !ganando && muriendo){
							//late_tor++;
							g.drawPixmap(Assets.torment, xt, yt);
							//Calculamos si hay relampago:
							int n=(int) (Math.random()*20)+1;
							if(n==5){
								g.drawPixmap(Assets.ltorment, xt, yt);
								Assets.storment.play(1);
							}																							
							if(yt>=960){
								tormenta=false;
							}
						}
						
						g.drawPixmap(Assets.msgLevel, x_msg, 200);
						g.drawPixmap(Assets.subMsgLevel, x_subMsg, 250);
						//Primero metemos los fondos del mensaje
						if(x_msg>0){
							x_msg=x_msg-4;
						}
						if(x_subMsg<0){
							x_subMsg=x_subMsg+4;
						}
						
						//Cuando los fondos terminen, vamos metiendo el mensaje
						if(x_msg==0 && x_subMsg==0){
							g.drawPixmap(Assets.game_over, 60, 205, 202*cont_msg, 0, 202, 69);
							tempo_msg++;
							if(tempo_msg==5 && !fin_msg){
								cont_msg++;
								tempo_msg=0;
							}
							if(cont_msg == 4){
								fin_msg=true;
							}
						}
						if(fincaida && fin_msg){
							estado= EstadoJuego.FinJuego;
						}else{
							yt+=2;
						}
						
					}else if(ganando){
						//Si hemos ganado, iniciamos la animacion correspondiente:				
						avion.setY(avion.getY()-2);	//Vamos avanzando de 2 en 2 hacia arriba			
						g.drawPixmap(Assets.avion, avion.getX(), avion.getY());
						g.drawPixmap(Assets.msgLevel, x_msg, 200);
						g.drawPixmap(Assets.subMsgLevel, x_subMsg, 250);
						
						//Si hay tormenta mientras ganamos:
						//Pinto la tormenta mientras ganamos
						if(tormenta && ganando && !muriendo){
							//late_tor++;
							g.drawPixmap(Assets.torment, xt, yt);
							//Calculamos si hay relampago:
							int n=(int) (Math.random()*20)+1;
							if(n==5){
								g.drawPixmap(Assets.ltorment, xt, yt);
								Assets.storment.play(1);
							}
							if(yt>=960){
								tormenta=false;
							}
						}
						
						//Primero metemos los fondos del mensaje
						if(x_msg>0){
							x_msg=x_msg-4;
						}
						if(x_subMsg<0){
							x_subMsg=x_subMsg+4;
						}
						//Cuando los fondos terminen, vamos metiendo el mensaje
						if(x_msg==0 && x_subMsg==0){
							g.drawPixmap(Assets.levelcomplete, 10, 205, 297*cont_msg, 0, 297, 67);
							tempo_msg++;
							if(tempo_msg==5 && !fin_msg){
								cont_msg++;
								tempo_msg=0;
							}
							if(cont_msg == 4){
								fin_msg=true;
							}
							
						}
						if(avion.getY()<=0 && fin_msg){
							//Cuando el avion se va, cambiamos el estado:
							estado= EstadoJuego.FinJuego;
						}else{
							yt+=2;
						}
					}
				}
		//pinto letreros de items
		for(int i=itemsgets.size()-1;i>=0;i--){
			
			if(itemsgets.get(i).getCont()<100){
				if(itemsgets.get(i).getCont()<10){
					itemsgets.get(i).setY(itemsgets.get(i).getY()-1);
					if(itemsgets.get(i).getCont()<=50 && itemsgets.get(i).getCass()>0){
						itemsgets.get(i).setCass(itemsgets.get(i).getCass()-1);
					}
				}else if(itemsgets.get(i).getCont()>90){
					if(itemsgets.get(i).getCont()%2==0){
						itemsgets.get(i).setCass(itemsgets.get(i).getCass()+1);
					}
				}
				
				g.drawPixmap(itemsgets.get(i).getAsset(), (avion.getX()-(itemsgets.get(i).getAsset().getWidth()/2))+40, (g.getHeight() - 80) + itemsgets.get(i).getY(), 0, itemsgets.get(i).getCass()*itemsgets.get(i).getSy(), itemsgets.get(i).getSx(), itemsgets.get(i).getSy());
				itemsgets.get(i).setCont(itemsgets.get(i).getCont()+1);
			}else{
				itemsgets.remove(i);
			}
		}
		
		//Pinto las pomas
		if(animacionFuel){
			for(int i=pompas.size()-1;i>=0;i--){
				Pompa p=pompas.get(i);
				switch (pompas.get(i).getTipo()) {
				case 1:
					g.drawPixmap(Assets.AnimLapsed, (avion.getX()+(Assets.avion.getWidth())/2)-p.getMx(), (avion.getY()+(Assets.avion.getHeight())/2)-p.getMy(), 13*p.getAni(), 0, 13, 13);					
					break;
				case 2:
					g.drawPixmap(Assets.AnimLapsed, (avion.getX()+(Assets.avion.getWidth())/2), (avion.getY()+(Assets.avion.getHeight())/2)-p.getMy(), 13*p.getAni(), 0, 13, 13);
					break;
				case 3:
					g.drawPixmap(Assets.AnimLapsed, (avion.getX()+(Assets.avion.getWidth())/2)+p.getMx(), (avion.getY()+(Assets.avion.getHeight())/2)-p.getMy(), 13*p.getAni(), 0, 13, 13);
					break;
				
				}
				if(p.getCani()<=30){
					//Primera parte de la animacion
					if(p.getCani()%3==0){
						switch (p.getAni()) {
						case 0:
							p.setMx(p.getMx()+2);
							p.setMy(p.getMy()+2);
							p.setAni(1);
							break;
						case 1:
							p.setAni(0);
							break;						
						}
					}
					
				}else{
					//Segunda parte de la animacion
					if(p.getCani()<40){
						p.setAni(2);
					}else{
						p.setAni(3);
					}
					p.setMx(p.getMx()+1);
					p.setMy(p.getMy()+1);
					
					if(p.getCani()==42){
						pompas.remove(i);
					}
				}
				p.setCani(p.getCani()+1);
			}
			if(pompas.size()==0){
				animacionFuel=false;
			}
		
		}
        //Pintamos congelado
        if(congelado){
            g.drawPixmap(Assets.ice_congelado, avion.getX()-15, avion.getY()-50, 98*frame_congelado, 0, 98, 118);
        }

		//Pintamos radio
		if(muestra_radio){
			g.drawPixmap(Assets.radio,dameXcañon(cañon)-60,90);
		}
		
		
		//Pinto la tormenta
				if(tormenta && !ganando && !muriendo){
					//late_tor++;
					g.drawPixmap(Assets.torment, xt, yt);
					g.drawPixmap(Assets.b1, 0, 0);					
					if(ntor==5){
						g.drawPixmap(Assets.ltorment, xt, yt);
						Assets.storment.play(1); //Peta en BlueStacks
					
						ntor=0; //Lo ponemos a 0 para que no haya problemas en el pause
					}
					if(yt>=480){
						tormenta=false;
					}
						
				}
				//pintamos la barra de vida
				g.drawPixmap(Assets.damage, 0, 0, 0, 24*danos, 70, 24);
				//Pintamos danodano
						if(ddano){
							g.drawPixmap(Assets.danodano, 0, 0, 0, 24*ddanos, 70, 24);
							if(drdano==5){
								ddanos++;
								if(ddanos==5){
									ddano=false;
									ddanos=0;
								}
								drdano=0;
							}
							drdano++;
						}
				
				//pintamos el fuel
				g.drawPixmap(Assets.fuel, 320-57, 0, 57*fuel, 0, 58, 59);
				
				
				//Pintamos danofuel
				if(dfuel){
					g.drawPixmap(Assets.danofuel, 320-57, 0, 57*ddfuel, 0, 58, 59);
					if(rfuel==5){
						ddfuel++;
						if(ddfuel==5){
							dfuel=false;
							ddfuel=0;
						}
						rfuel=0;
					}
					rfuel++;
				}
				//Pinto Lowfuel
				if(estado!= EstadoJuego.FinJuego){
					if(lowfuel){
						if(rlow>10){
							g.drawPixmap(Assets.lowfuel, (g.getWidth()/2)-(Assets.lowfuel.getWidth()/2), 5);
						}
						rlow++;
						if(rlow==20){
							rlow=0;
							if(Assets.sonido){
								Assets.alertafuel.play(20);

							}
						}
					}
				}
		
		//drawNumber(g, puntos+"", 128, 10);
		if (estado == EstadoJuego.Preparado)
			drawReadyUI();
		if (estado == EstadoJuego.Ejecutandose){
			mitime++;
			balatime++;
			cfuel++;
			drawRunningUI();
		}
		if (estado == EstadoJuego.Pausado)
			drawPausedUI();
		if (estado == EstadoJuego.FinJuego){
			if(!muriendo && !recordGuardado){
				//Si no hemos muerto guardamos el record
				calculaRecord();
				recordGuardado=true;
			}
			drawGameOverUI();		
		}
		
	}

	private int dameXcañon(int cañon) {
		int x;
		if(cañon==1){
			x=acorazado.getX()+70;
			IGNEUS_X=x;
			return x;
		}else{
			x=acorazado.getX()+152;
			IGNEUS_X=x;
			return x;
		}
	}

	private Pixmap damedisparo(int poder) {
		switch (poder) {
		case 1:
			return Assets.disparoenemigo;
		case 2:
			return Assets.enemigom;
		case 3:
			return Assets.enemigoh;
		default:
			return Assets.disparoenemigo;
		}
	}

private void calculaRecord() {
		
		if(enemigos_destruidos<NUM_ENE){
			if(enemigos_destruidos>(NUM_ENE*0.6)){
				Records.addScore(3, Datos.getN_NIVEL());
			}else{
				Records.addScore(2, Datos.getN_NIVEL());
			}
		}else{
			Records.addScore(4, Datos.getN_NIVEL());			
		}
		//Comprobamos si se ha habilitado un nuevo modo de juego:
		//Lo hacemos solo si estan en 0
		if(Records.fondo()==2 && Records.maxPuntuaciones[10]==0){
			Records.addScore(1, 9);
			Records.addScore(1, 10);
		}else if(Records.fondo()==1 && Records.maxPuntuaciones[9]==0){
			Records.addScore(1, 9);
		}
		// Guardamos también los desbloqueos, una sola vez al terminar la partida.
		Records.save(juego.getFileIO());
	}

private Pixmap dameItem(int tipo) {
		switch (tipo) {
		case 0:
			return Assets.ifuel;
		case 1:
			return Assets.inormal;
		case 2:
			return Assets.imave;
		case 3:
			return Assets.iharry;
		case 4:
			return Assets.irepa;
		case 5:
			return Assets.lficon;
		default:
			return Assets.ifuel;
		}
	}
//Metodo que saca cualquier item (menos fuel)
private void compruebaItem(int x, int y) {
	if(conti==RAT_ITEM){
		if(contf==RAT_FUEL){
			conti--;
		}else{
			conti=0; //Reiniciamos contador
			int mirandom=(int) (Math.random()*5)+1;
			//A�adimos fuel:
			items.add(new Item(mirandom, x, y));
		}
	}
	
}
//Metodo que saca item de fuel
private void compruebaFuel(int x, int y) {
		if(contf==RAT_FUEL){
			contf=0; //Reiniciamos contador
			//A�adimos fuel:
			items.add(new Item(0, x, y));
		}
		
	}

	private Pixmap dameenemigo(int n) {
		switch (n) {
		case 1:
			return Assets.e1;
		case 2:
			return Assets.e2;
		case 3:
			return Assets.e3;
		case 4:
			return Assets.e4;
		case 5:
			return Assets.e5;
		case 6:
			return Assets.e6;
		case 7:
			return Assets.e7;
		case 8:
			return Assets.e8;
		case 9:
			return Assets.e9;
		case 10:
			return Assets.e10;
		default:
			return Assets.e1;
		}
	}

	private Pixmap damenube(int id) {
		switch (id) {
		case 1:
			return Assets.nube1;
		case 2:
			return Assets.nube2;
		case 3:
			return Assets.nube3;
		default:
			return Assets.nube1;
		}
	}
	
	//Metodo que activa la tormenta
	private void isTormenta(){
		int n=(int) (Math.random()*100)+1;
		//int n=2;
		if(n<30){
			tormenta=true;
			yt=-960;
			ntor=0;
		}
	}

	// Al inicio presentamo imagen para que pulsen para jugar...
	private void drawReadyUI() {
		Graficos g = juego.getGraphics();
		g.drawPixmap(Assets.msgLevel, msgx, 190);
		if(listo){
			g.drawPixmap(Assets.preparado, 0, 200);
		}
		//g.drawPixmap(Assets.msgLevel, 0, 190);
		//g.drawPixmap(Assets.preparado, 0, 200);
		
		if(venimos){
        	g.drawPixmap(dameAsset(timetogo), 0, 0);
        	timetogo--;
        	if(timetogo==thetimetogo){
        		venimos=false;
        	}
        }
		
	}

	// Ejecutando ademas de los objetos en movimiento, presentamos los botones
	// para jugar
	// Ademas de un pausa por si quieren descansar
	private void drawRunningUI() {
		Graficos g = juego.getGraphics();

		g.drawPixmap(Assets.bpausa, 0, 25);
		srcYfondo--;
		if (srcYfondo == 0)
			srcYfondo = 960;

		for (int i = 0; i < nubes.size(); i++) {
			nubes.get(i).setY(nubes.get(i).getY() + 2);
			if (nubes.get(i).getY() > g.getHeight() && !tormenta) {
				int n = (int) (Math.random() * -200) - 350;
				nubes.get(i).setY(n);
			}
		}
	}

	// Si nos pausan presentamos dos opcione seguir o volver al menu
	private void drawPausedUI() {
		Graficos g = juego.getGraphics();
		g.drawPixmap(Assets.msgLevel, msgx, 190);
		if(listo){
			g.drawPixmap(Assets.menupausa, 0, 200);
			if(item==0){
				g.drawPixmap(Assets.cursor2, 300, 242);
			}else{
				g.drawPixmap(Assets.cursor1, 135, 242);
			}
		}
		
		//g.drawPixmap(Assets.opacity, 0, 0);
		//g.drawPixmap(Assets.menupausa, 75, 200);
		//g.drawPixmap(Assets.pause_bar, 79, itemy);
		if(musica.isPlaying())
			musica.pause();
		
		if(nosvamos){
        	g.drawPixmap(dameAsset(timegoto), 0, 0);
        	timegoto++;
        	if(timegoto==thetimegoto){
        		juego.setScreen(new PantallaMenuInicio(juego));
        	}
        }
	}

	// Cuando termine el juego presentamos la pantalla de fin con un boton para
	// volver al menu
	private void drawGameOverUI() {
		Graficos g = juego.getGraphics();
//		if(completado)
//			g.drawPixmap(Assets.lvlcmp, 5, 210);
//		else
//			g.drawPixmap(Assets.finjuego, 62, 210);
		musica.stop();
		
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
		if (estado == EstadoJuego.Ejecutandose)
			estado = EstadoJuego.Pausado;
	}

	@Override
	public void resume() {

	}

	
	public void dispose() {
		
	}
	// metodo para pintar la puntuacion con digitos de imagenes (solo digitos, blancos y puntos)
//		public void drawNumber(Graficos g, String linea, int x, int y) {
//	    	
//	        int len = linea.length();
//	        int srcX;
//	        for (int i = 0; i < len; i++) {
//				char digito = linea.charAt(i);
//
//	            if (digito == ' ') {
//	                x += 10;
//	                continue;
//	            }
//	            if (digito == '.') {
//	                srcX = 130;
//	            } else {
//					srcX = (digito - '0') * 13;
//	            }
//				g.drawPixmap(Assets.digitos, x, y, srcX, 0, 13, 16);
//				x += 13;
//	        }
//	    }

}
