package vista;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import estructura.ArbolBinario;
import estructura.Dato;
import estructura.ExploracionTablaHash;
import estructura.NodoBinario;
import estructura.TablaExploracionLineal;
import lib.CantidadDigitosException;
import lib.NumerosException;
import lib.Validacion;
import lib.letraException;
import modelo.Persona;






public class Operaciones {
	
	static Scanner scanner = new Scanner(System.in); 
	static int select = -1;
	


	public static void CargarPersona(ExploracionTablaHash e, TablaExploracionLineal l) {
		try {
			System.out.println("Introduce el nombre de la persona");
			String nombre = scanner.nextLine();
			Validacion.soloLetras(nombre);
			
			System.out.println("Introduce el apellido");
			String apellido = scanner.nextLine();
			Validacion.soloLetras(apellido);
			
			System.out.println("Introduzcasexo(m/f)");
			String sexo = scanner.nextLine();
			
			System.out.println("Introduce el dni");
			String dni = scanner.nextLine();
			Validacion.numeroCorrecto(dni);
			Validacion.cantidadDigitosDni(dni);
			
			
			
			Persona p = new Persona(nombre,apellido,dni,sexo);
			l.insertar(p);
			l.listar();
			
		} catch (NumerosException | CantidadDigitosException | letraException e2) {
			System.out.println(e2.getMessage());
		}
		
	}

	public static void VerficarExistencia(ExploracionTablaHash e, TablaExploracionLineal l) {
		try {

			System.out.println("Introduce el dni de la persona a buscar");
			String dni = scanner.nextLine();
			Validacion.numeroCorrecto(dni);
			Validacion.cantidadDigitosDni(dni);


			Persona p = new Persona(null, null, dni, null);
			if(l.buscar(p,p.getDni())==1){
				System.out.println("la persona se encuentra en la tabla");
			}else{
				System.out.println("la persona no se encuentra en la tabla");
			}

		} catch (NumerosException | CantidadDigitosException e2) {
			System.out.println(e2.getMessage());
		}

	}

	public static void eliminarPersona(TablaExploracionLineal l) {
		try {

			System.out.println("Introduce el dni de la persona a eliminar");
			String dni = scanner.nextLine();
			Validacion.numeroCorrecto(dni);
			Validacion.cantidadDigitosDni(dni);
			Persona p = new Persona(null, null, dni, null);
			l.eliminar(p);
			

		} catch (NumerosException | CantidadDigitosException e2) {
			System.out.println(e2.getMessage());
		}
		
	}

	public static void listar(TablaExploracionLineal l) {
		l.listar();
		
	}

	public static void sumarFemenino(TablaExploracionLineal l) {
		System.out.println("la cantidad de personas de sexo femenino son:  "+l.listarFemenino());
		
	}

	


}