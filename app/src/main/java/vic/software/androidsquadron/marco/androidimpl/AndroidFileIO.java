package vic.software.androidsquadron.marco.androidimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import vic.software.androidsquadron.marco.FileIO;

import android.content.res.AssetManager;
import android.content.Context;

public class AndroidFileIO implements FileIO {
	AssetManager assets;
	String rutaAlmacenamientoExterno;

	public AndroidFileIO(Context context) {
		this.assets = context.getAssets();
		this.rutaAlmacenamientoExterno = context.getFilesDir().getAbsolutePath() + File.separator;
	}

	
	public InputStream leerAsset(String nombreArchivo) throws IOException {
		return assets.open(nombreArchivo);
	}

	
	public InputStream leerArchivo(String nombreArchivo) throws IOException {
		return new FileInputStream(rutaAlmacenamientoExterno + nombreArchivo);
	}
	
	
	public OutputStream escribirArchivo(String nombreArchivo) throws IOException {
	return new FileOutputStream(rutaAlmacenamientoExterno + nombreArchivo);
	}

}










