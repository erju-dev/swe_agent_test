package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ControladorDiccionario {
	
	private static Properties lang_dicc;
	
	public static void EstablecerIdioma(String lang) throws IOException {
		System.out.println(lang);
		lang_dicc = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try(InputStream resourceStream = loader.getResourceAsStream(lang+".properties")) {
            lang_dicc.load(resourceStream);
            System.out.println("set language: "+lang);
        }catch(Exception e){
        	System.out.println("ERROR. No ha sido posible cargar el diccionario");
        }
	}
	
	public static String Traducir(String str) throws UnsupportedEncodingException {
		if(lang_dicc != null) {
    		String translate = lang_dicc.getProperty(str);
    		//convertir a utf8 o algo
    		return translate;
    	}else {
    		return "null";
    	}	
    }
	
}