package ee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read {

	public static String Cad(){
        String temp = ""; 
        boolean error = false;
        
        BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));
    
        do{
	        try{
	            temp = teclat.readLine();
	        }catch(IOException e){
	            System.out.println("Error de lectura");
	            System.out.println("Espera cadena...");
	            error = true;
	        }
        }while(error);
        
       return temp;
	}
	
	public static char carac(){
        char temp = ' '; 

    try{
        temp = (char)System.in.read();
        System.in.read();
    }catch(IOException e){
        System.out.println("Error de lectura");
    }
    
    return temp;
    }
    
    public static int Int(){
    int temp = 0; 
    boolean error = false;
    
    BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));

    do{
        try{
            error = false;
            temp = Integer.parseInt(teclat.readLine());
        }catch(Exception e){
            System.out.println("Error d'entrada de dades "+e.getMessage());
            System.out.println("Dóna'm un número enter:");
            error = true;
        }
    }while(error);
        
    return temp;
    }
        
    public static float Float(){
    float temp = 0; 
    boolean error = false;
    
    BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));
    
    do{
    	try{
    		error = false;
    		temp = Float.parseFloat(teclat.readLine());
    	}catch(IOException e){
    		System.out.println("Error de lectura "+e.getMessage());
    		System.out.println("Dóna'm un número decimal:");
    		error = true;
    	}
    }while(error);
        
    return temp;
    }
}
