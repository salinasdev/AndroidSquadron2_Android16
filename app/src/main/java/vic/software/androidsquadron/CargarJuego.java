package vic.software.androidsquadron;


import vic.software.androidsquadron.marco.Graficos;
import vic.software.androidsquadron.marco.Juego;
import vic.software.androidsquadron.marco.Pantalla;
import vic.software.androidsquadron.marco.Graficos.PixmapFormat;

// Clase que se encarga de cargar en memoria todo lo necesario, imagenes, sonidos, ficheros
// y temima con presentar la pantalla Inicial del juego (El Menu de Inicio).

public class CargarJuego extends Pantalla{
    public CargarJuego(Juego juego) {
        super(juego);
    }

    @Override
    public void update(float deltaTime) {
        // cargamos todas las imagenes y sonidos
    	Graficos g = juego.getGraphics();
    	Records.cargar(juego.getFileIO());
    	Assets.fondo = g.newPixmap("fondo3.png", PixmapFormat.RGB565);
        Assets.avion = g.newPixmap("av1.png", PixmapFormat.ARGB4444);
        
        
        Assets.disparoenemigo = g.newPixmap("dispEne.png", PixmapFormat.ARGB4444);
        
        Assets.logo = g.newPixmap("titulo.png", PixmapFormat.ARGB4444);
        
        Assets.preparado = g.newPixmap("AFG-Start.png", PixmapFormat.ARGB4444);        
        Assets.menupausa = g.newPixmap("AFG-OpcionesPausa.png", PixmapFormat.ARGB4444);
        Assets.finjuego = g.newPixmap("gameover.png", PixmapFormat.ARGB4444);
        
        
        Assets.nube1= g.newPixmap("nube1.png", PixmapFormat.ARGB4444);
        Assets.nube2= g.newPixmap("nube2.png", PixmapFormat.ARGB4444);
        Assets.nube3= g.newPixmap("nube3.png", PixmapFormat.ARGB4444);
        Assets.mar1= g.newPixmap("sea1.png", PixmapFormat.RGB565);
        Assets.mar2= g.newPixmap("sea2.png", PixmapFormat.RGB565);
        
        Assets.e1= g.newPixmap("e1.png", PixmapFormat.RGB565);
        Assets.e2= g.newPixmap("e2.png", PixmapFormat.RGB565);
        Assets.e3= g.newPixmap("e3.png", PixmapFormat.RGB565);
        Assets.e4= g.newPixmap("e4.png", PixmapFormat.RGB565);
        Assets.e5= g.newPixmap("e5.png", PixmapFormat.RGB565);
        Assets.e6= g.newPixmap("e6.png", PixmapFormat.RGB565);
        Assets.e7= g.newPixmap("e7.png", PixmapFormat.RGB565);
        Assets.e8= g.newPixmap("e8.png", PixmapFormat.RGB565);
        Assets.e9= g.newPixmap("e9.png", PixmapFormat.RGB565);
        Assets.e10= g.newPixmap("e10.png", PixmapFormat.RGB565);
        Assets.finicio= g.newPixmap("AFG-MainTitle.png", PixmapFormat.RGB565);
        Assets.avizq= g.newPixmap("avizq.png", PixmapFormat.ARGB4444);
        Assets.avder= g.newPixmap("avder.png", PixmapFormat.ARGB4444);
        Assets.t1= g.newPixmap("t1.png", PixmapFormat.RGB565);
        Assets.t2= g.newPixmap("t2.png", PixmapFormat.RGB565);
        Assets.t3= g.newPixmap("t3.png", PixmapFormat.RGB565);
        Assets.t4= g.newPixmap("t4.png", PixmapFormat.RGB565);
        Assets.t5= g.newPixmap("t5.png", PixmapFormat.RGB565);
        Assets.t6= g.newPixmap("t6.png", PixmapFormat.RGB565);
        Assets.t7= g.newPixmap("t7.png", PixmapFormat.RGB565);
        Assets.t8= g.newPixmap("t8.png", PixmapFormat.RGB565);
        Assets.t9= g.newPixmap("t9.png", PixmapFormat.RGB565);
        Assets.t10= g.newPixmap("t10.png", PixmapFormat.RGB565);
        Assets.t11= g.newPixmap("t11.png", PixmapFormat.RGB565);
        Assets.bsonido= g.newPixmap("sonido2.png", PixmapFormat.RGB565);
        Assets.bpausa= g.newPixmap("AFG-pause.png", PixmapFormat.RGB565);
        Assets.creditos= g.newPixmap("AFG-credits.png", PixmapFormat.RGB565);
        Assets.damage= g.newPixmap("AFG-Vida.png", PixmapFormat.ARGB4444);
        
        Assets.selector = g.newPixmap("AFG-TitleSelectBar.png", PixmapFormat.RGB565);
        Assets.fondo_niveles = g.newPixmap("AFG-Levels.png", PixmapFormat.RGB565);
        Assets.selector_niveles = g.newPixmap("AFG-SelectLevelBar.png", PixmapFormat.ARGB4444);
        Assets.fuel = g.newPixmap("AFG-Fuel.png", PixmapFormat.ARGB4444);
        Assets.opacity = g.newPixmap("AFG-Opacity.png", PixmapFormat.ARGB4444);
        Assets.pause_bar = g.newPixmap("AFG-SelecOptionsBar.png", PixmapFormat.ARGB4444);
        Assets.danofuel = g.newPixmap("AFG-DanoFuel.png", PixmapFormat.ARGB4444);
        Assets.danodano = g.newPixmap("AFG-DanoVida.png", PixmapFormat.ARGB4444);
        Assets.lowfuel = g.newPixmap("AFG-LowFuel.png", PixmapFormat.ARGB4444);
        Assets.enedamrec = g.newPixmap("damageEne.png", PixmapFormat.ARGB4444);
        Assets.caida = g.newPixmap("AFG-ProtaDie.png", PixmapFormat.ARGB4444);
        Assets.explosion = g.newPixmap("AFG-ProtaDamage.png", PixmapFormat.ARGB4444);        
        Assets.lvlcmp = g.newPixmap("lvlcp.png", PixmapFormat.ARGB4444);              
        Assets.enemyDie = g.newPixmap("AFG-EnemyDie.png", PixmapFormat.ARGB4444);
        Assets.b1 = g.newPixmap("b1.png", PixmapFormat.ARGB4444);
        Assets.b2 = g.newPixmap("b2.png", PixmapFormat.ARGB4444);
        Assets.b3 = g.newPixmap("b3.png", PixmapFormat.ARGB4444);
        Assets.b4 = g.newPixmap("b4.png", PixmapFormat.ARGB4444);
        Assets.b5 = g.newPixmap("b5.png", PixmapFormat.ARGB4444);
        Assets.level_select = g.newPixmap("AFG-Levels-Select.png", PixmapFormat.ARGB4444);
        Assets.fondo_menu_princi = g.newPixmap("AFG-MainTitle-Shadow.png", PixmapFormat.ARGB4444);
        
        //Menu principal
        Assets.menuprincipal = g.newPixmap("AFG-OptionsDefault.png", PixmapFormat.ARGB4444);
        Assets.menuprincipal_tor=g.newPixmap("AFG-OptionsTournament.png", PixmapFormat.ARGB4444);
        Assets.menuprincipal_all=g.newPixmap("AFG-AllOptionsExtra.png", PixmapFormat.ARGB4444);
        
        //Logo transicion:
        Assets.logo1 = g.newPixmap("AFG-NewTitle_20.png", PixmapFormat.ARGB4444);
        Assets.logo2 = g.newPixmap("AFG-NewTitle_40.png", PixmapFormat.ARGB4444);
        Assets.logo3 = g.newPixmap("AFG-NewTitle_60.png", PixmapFormat.ARGB4444);
        Assets.logo4 = g.newPixmap("AFG-NewTitle_80.png", PixmapFormat.ARGB4444);
        Assets.logo5 = g.newPixmap("AFG-NewTitle_100.png", PixmapFormat.ARGB4444);
        
        //Assets de LevelComplete y Game Over
        Assets.msgLevel = g.newPixmap("AFG-MsgLevels.png", PixmapFormat.ARGB4444);
        Assets.subMsgLevel = g.newPixmap("AFG-SubMsgLevels.png", PixmapFormat.ARGB4444);
        Assets.levelcomplete = g.newPixmap("AFG-LevelCompleted.png", PixmapFormat.ARGB4444);
        Assets.game_over = g.newPixmap("AFG-LevelGameOver.png", PixmapFormat.ARGB4444);
        //Assets de Items:
        Assets.ifuel = g.newPixmap("iFuel.png", PixmapFormat.ARGB4444);
        Assets.iharry = g.newPixmap("iharry.png", PixmapFormat.ARGB4444);
        Assets.imave = g.newPixmap("imave.png", PixmapFormat.ARGB4444);
        Assets.inormal = g.newPixmap("inormal.png", PixmapFormat.ARGB4444);
        Assets.irepa = g.newPixmap("irepa.png", PixmapFormat.ARGB4444);
        //Gets Items:
        Assets.getfuel = g.newPixmap("mfuel.png", PixmapFormat.ARGB4444);
        Assets.getnormal = g.newPixmap("mnormal.png", PixmapFormat.ARGB4444);
        Assets.getmave = g.newPixmap("mmave.png", PixmapFormat.ARGB4444);
        Assets.getharry = g.newPixmap("mharry.png", PixmapFormat.ARGB4444);
        Assets.getrepa = g.newPixmap("mrepa.png", PixmapFormat.ARGB4444);
        //Balas:
        Assets.disparo = g.newPixmap("bnormal.png", PixmapFormat.ARGB4444);
        Assets.disparoh = g.newPixmap("bharry.png", PixmapFormat.ARGB4444);
        Assets.disparom = g.newPixmap("bmave.png", PixmapFormat.ARGB4444);
        
        Assets.enemigoh = g.newPixmap("eharry.png", PixmapFormat.ARGB4444);
        Assets.enemigom = g.newPixmap("emave.png", PixmapFormat.ARGB4444);
        //Tormenta
        Assets.torment = g.newPixmap("AFG-Storm.png", PixmapFormat.ARGB4444);
        Assets.ltorment = g.newPixmap("AFG-StormFlash.png", PixmapFormat.ARGB4444);
        Assets.storment = juego.getAudio().nuevoSonido("AFG-Storm.wav");
        //Cursores
        Assets.cursor1 = g.newPixmap("cursor1.png", PixmapFormat.ARGB4444);
        Assets.cursor2 = g.newPixmap("cursor2.png", PixmapFormat.ARGB4444);
        //Lapsed Fuel
        Assets.AnimLapsed = g.newPixmap("AFG-AnimLapsedFuel.png", PixmapFormat.ARGB4444);
        Assets.lficon = g.newPixmap("lficon.png", PixmapFormat.ARGB4444);
        Assets.SoundLapsed = juego.getAudio().nuevoSonido("AFG-LapsedFuel.wav");
        
        //Niveles (Fondos)
        //Los mapas se cargaran segun lo que se seleccione, para no usar tanta memoria.
        
        //Acorazado
        Assets.letrAcora = g.newPixmap("AFG-carteles-especiales.png", PixmapFormat.ARGB4444);
        Assets.explosiones_acorazado = g.newPixmap("AFG-boss-explosiones.png", PixmapFormat.ARGB4444);
        Assets.igneus = g.newPixmap("AFG-igneousbreath.png", PixmapFormat.ARGB4444);
        Assets.carga_igneus = g.newPixmap("AFG-igneousbreath-carga.png", PixmapFormat.ARGB4444);
        Assets.ice_bala = g.newPixmap("AFG-ice_bala.png", PixmapFormat.ARGB4444);
        Assets.ice_carga = g.newPixmap("AFG-ice_carga.png", PixmapFormat.ARGB4444);
        Assets.ice_congelado = g.newPixmap("AFG-congelado.png", PixmapFormat.ARGB4444);
        Assets.radio = g.newPixmap("AFG-radiolocation.png",PixmapFormat.ARGB4444);
        Assets.misil = g.newPixmap("AFG-misil.png",PixmapFormat.ARGB4444);

        //Rankings
        Assets.r0 = g.newPixmap("AFG-R0.png", PixmapFormat.RGB565); //   -
        Assets.r1 = g.newPixmap("AFG-R1.png", PixmapFormat.RGB565); //  None
        Assets.r2 = g.newPixmap("AFG-R2.png", PixmapFormat.RGB565); //Improvable
        Assets.r3 = g.newPixmap("AFG-R3.png", PixmapFormat.RGB565); //  Good
        Assets.r4 = g.newPixmap("AFG-R4.png", PixmapFormat.RGB565); // Perfect
        
        //Rankings menus:
        Assets.fondo1 = g.newPixmap("AFG-Ranking_Default.png", PixmapFormat.RGB565);
        Assets.fondo2 = g.newPixmap("AFG-Ranking_Tournament.png", PixmapFormat.RGB565);
        Assets.fondo3 = g.newPixmap("AFG-Ranking_Desbloqueado.png", PixmapFormat.RGB565);
        
        //Reiniciar Rankings
        Assets.reiniciar = g.newPixmap("AFG-ReiniciarRanking.png", PixmapFormat.RGB565);
        
        //Musica Niveles       
        //La musica se cargara cuando se seleccione el nivel para no usar tanta memoria
        
        //Fanfarreas
        Assets.victory = juego.getAudio().nuevaMusica("AFG- Level Completed.mp3");
        Assets.gameover = juego.getAudio().nuevaMusica("AFG- Game Over.mp3");
        
        Assets.pun = juego.getAudio().nuevoSonido("pun.ogg");
        Assets.pulsar = juego.getAudio().nuevoSonido("pulsar.ogg");
        Assets.sdisparo = juego.getAudio().nuevoSonido("AFG-ProtaShots.ogg");
        Assets.selectoption = juego.getAudio().nuevoSonido("AFG-SelectOption.wav");
        Assets.aceptoption = juego.getAudio().nuevoSonido("AFG-AcceptOption.ogg");
        Assets.exp_normal = juego.getAudio().nuevoSonido("AFG-Title_Explosion_normal.wav");
        Assets.exp_final = juego.getAudio().nuevoSonido("AFG-Title_Explosion_end.wav");
        Assets.alertafuel = juego.getAudio().nuevoSonido("AFG-AlertaFuel.ogg");
        Assets.cargar_rayo = juego.getAudio().nuevoSonido("AFG-cargar_rayo.ogg");
        Assets.error43 = juego.getAudio().nuevoSonido("AFG-error_43.ogg");
        
        Assets.intro = juego.getAudio().nuevaMusica("AFG-Main Title.mp3");
        Assets.smenu = juego.getAudio().nuevaMusica("menuselect.mp3");
        
        Assets.damagePlane = juego.getAudio().nuevoSonido("AFG-DamagePlane.wav");
        Assets.protaDestoryPlane = juego.getAudio().nuevoSonido("AFG-ProtaDestroyPlane.wav");
        Assets.enemyDestoryPlane = juego.getAudio().nuevoSonido("AFG-EnemyDestroyPlane.wav");
        Assets.sonido=true;
        // cargamos la primera pantalla que ser� siempre una pantalla de presentacion
        // y desde esta podremos pasar a Jugar
        juego.setScreen(new PantallaLogo(juego));
        
    }

    @Override
    public void present(float deltaTime) {

    }

    @Override
    public void pause() {
    	
    	}
    

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
    	
    }
}