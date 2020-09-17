package lib;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
	static Scanner sc = new Scanner(System.in); 
	
	//validad dni posee solo numeros
	public static void numeroCorrecto(String numero) throws MiException{
		if(!(numero.matches("[0-9]+"))){
			 throw new MiException("datos incorrectos(solo numeros)\n"); 
		}
	}
	
	//validar ingreso letras
	public static void soloLetras(String letras){
		if(!(letras.matches("[A-Za-z\\s]{2,}"))){
			System.out.print("Ingrese nuevamente (solo letras)\n");
			letras=sc.nextLine();
			soloLetras(letras);
		}
	}
	
	//valida solo un caracter de la A a la Z
	public static void soloChar(String letra) throws MiException{
		char[] chars = letra.toCharArray();

		int i=chars.length;
			if(i>1){
				throw new MiException("se permite solo una letra de la A a la Z");
			}
	}
	
	//Valida que se ingrese una letra que este dentro del rango especificado
	public static String rangoLetras(String letraInicio, String letraFin, String letraIngresada, String msj){
        try {
                String li = letraInicio.toUpperCase();
                String lf= letraFin.toUpperCase();
                String lIg =letraIngresada.toUpperCase();

                Pattern pat = Pattern.compile("["+li+"-"+lf+"]"); 
                Matcher mat = pat.matcher(lIg);
                if (mat.matches()) {
                	return letraIngresada;
                } else {
                    System.out.println(msj);
                    letraIngresada = sc.next();
                    lIg =letraIngresada.toUpperCase();
                    rangoLetras(li, lf, lIg, msj);
                    return letraIngresada;
                }
        } catch (Exception e) { 
            System.out.println("Error");
        }
        return letraIngresada;
    }
		 
	//valida si el dato ingresado es un entero positivo
	public static int esIntPositivo(String msj){
        try {
                int numero=Integer.parseInt(sc.next());
                if(numero >=0)
                    return numero;
                else{
                        System.out.println(msj);
                        return esIntPositivo(msj);
                }
            } catch (NumberFormatException nfe) {
                System.out.println(msj);
                return esIntPositivo(msj);
            }
    }
}
