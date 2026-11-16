package vic.software.androidsquadron;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.util.Log;

import vic.software.androidsquadron.marco.FileIO;


public class Records {
	// ---------------------------------------------TA1,TA2,TA3,SE1,SE2,SE3,
	public static int[] maxPuntuaciones = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 };

    public static String cargar(FileIO files) {
        BufferedReader in = null;
        String s="";
        try {
        	//Normal:
            in = new BufferedReader(new InputStreamReader(
                    files.leerArchivo("afg")));
            //BlueStacks:
            //in = new BufferedReader(new InputStreamReader(new FileInputStream("/mnt/sdcard/afg"))); 
            in.readLine(); //OJOOOO La primera linea esta en blanco, por eso hacemos un readLine para quitarla de el medio
            for (int i = 0; i < 11; i++) {
                maxPuntuaciones[i] = Integer.parseInt(in.readLine());
                s+=maxPuntuaciones[i];
                
            }
        } catch (IOException e) {
            // :( Est� bien aqu� deber�a ir algo
        } catch (NumberFormatException e) {
            // :/ Nadie es perfecto
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
            }
        }
		return null;
    }

    public static void save(FileIO files) {
        BufferedWriter out = null;
        try {
        	//Normal:
            out = new BufferedWriter(new OutputStreamWriter(
                    files.escribirArchivo("afg")));
        	//BlueStacks:
            // Persist only to app-private storage; the old BlueStacks override was destructive.
            out.write("\n"); //Esta es la linea en blanco maldita... xD
            for (int i = 0; i < 11; i++) {
                out.write(Integer.toString(maxPuntuaciones[i]));
                out.write("\n");
            }

        } catch (IOException e) {
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
            }
        }
    }

    public static void addScore(int score, int nivel) {
        if(maxPuntuaciones[nivel]<score){
        	maxPuntuaciones[nivel]=score;
        }
    }
    
    public static void setScore(int score, int nivel) {        
        	maxPuntuaciones[nivel]=score;        
    }
    
    public static int fondo(){
    	Log.e("fondo", "--------Entro en metodo fondo");
    	
    	boolean def=false;
    	boolean tor=false;
    	boolean all=false;
    	
    	for (int i = 0; i <= 8; i++) {
            if(maxPuntuaciones[i]==1){
            	def=true;
            }
            if(maxPuntuaciones[i]>1 && maxPuntuaciones[i]<4){
            	tor=true;
            }
            if(maxPuntuaciones[i]==4){
            	all=true;
            }
            
            
        }
    	if(def){
    		//Si def esta a verdadero es que aun no han jugado todos los niveles    		
    		return 0;	
    	}else{
    		//Si no, es que han jugado en todos los niveles
    		if(tor){
    			//Si tor es true es que han puntuado menos que 4 en algunos niveles    			
    			return 1;
    		}else{
    			//Si no, es que tienen 4 en todos los niveles    			
    			return 2;
    		}
    	}
    	
    }
}
