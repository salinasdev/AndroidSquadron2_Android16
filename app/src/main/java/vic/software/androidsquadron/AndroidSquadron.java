package vic.software.androidsquadron;

import android.content.Intent;
import android.view.KeyEvent;
import vic.software.androidsquadron.marco.Pantalla;
import vic.software.androidsquadron.marco.androidimpl.AndroidJuego;

public class AndroidSquadron extends AndroidJuego {

	public Pantalla getStartScreen() {
		return new CargarJuego(this);
				
    }
	//Metodo que para la aplicacion al cerrarla
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			if ((keyCode == KeyEvent.KEYCODE_BACK)) {                               
				Intent i = new Intent();
		            i.setAction(Intent.ACTION_MAIN);
		            i.addCategory(Intent.CATEGORY_HOME);
		            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		            startActivity(i); 
		            android.os.Process.killProcess(android.os.Process.myPid());
		            
		        }
		        return false;
		    }

    
}
