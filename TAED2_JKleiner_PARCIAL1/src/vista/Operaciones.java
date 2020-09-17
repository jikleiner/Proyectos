package vista;

import java.io.File;
import java.util.Scanner;

import Estructuras.Arbol;
import Estructuras.Nodo;
import controlador.MiException;
import controlador.Validaciones;
import modelo.Alumno;
import modelo.Materia;

public class Operaciones {
	static Scanner sc = new Scanner(System.in);

	public static void puntoUno(Arbol arbolB) {
		// TODO Auto-generated method stub
		arbolB.insertar(50);
		arbolB.insertar(25);
		arbolB.insertar(75);
		arbolB.insertar(20);
		arbolB.insertar(30);
		arbolB.insertar(60);
		arbolB.insertar(90);
		arbolB.insertar(29);
		arbolB.insertar(31);
		arbolB.recorrerPreOrden();
	}

	public static void puntoDos(Arbol arbolB) {
		// TODO Auto-generated method stub
		arbolB.eliminar(30);
		arbolB.recorrerPreOrden();
	}

	public static void puntoTres(Arbol arbolAlumnos) {
		// TODO Auto-generated method stub
		arbolAlumnos.insertar(new Alumno("pepito", "perez", 123));
		arbolAlumnos.insertar(new Alumno("juansito", "peralta", 321));
		arbolAlumnos.insertar(new Alumno("ramosito", "castro", 231));
		arbolAlumnos.insertar(new Alumno("gastonsito", "de la cruz", 111));
		arbolAlumnos.insertar(new Alumno("facundito", "caceres", 112));
	}

	public static void listarAlumnosPuntoCuatro(Arbol arbolAlumnos) {
		// TODO Auto-generated method stub
		arbolAlumnos.recorrerPostOrden();
	}

	public static void puntoCinco(Arbol arbolAlumnos) {
		// TODO Auto-generated method stub
		Alumno al1=new Alumno("pepito", "perez", 123);
		Nodo al1Nodo=arbolAlumnos.buscar(al1);
		Materia m1=new Materia("matematicas", 12);
		Materia m2=new Materia("lengua", 23);
		Materia m3=new Materia("fisica", 34);
		Materia m4=new Materia("quimica", 45);
		Materia m5=new Materia("historia", 56);
		((Alumno) al1Nodo.getDato()).getMaterias().insertar(m1, "12");
		((Alumno) al1Nodo.getDato()).getMaterias().insertar(m2, "23");
		((Alumno) al1Nodo.getDato()).getMaterias().insertar(m3, "34");
		((Alumno) al1Nodo.getDato()).getMaterias().insertar(m4, "45");
		((Alumno) al1Nodo.getDato()).getMaterias().insertar(m5, "56");
		Alumno al2=new Alumno("juansito", "peralta", 321);
		Nodo al2Nodo=arbolAlumnos.buscar(al2);
		((Alumno) al2Nodo.getDato()).getMaterias().insertar(m1, "12");
		((Alumno) al2Nodo.getDato()).getMaterias().insertar(m2, "23");
		((Alumno) al2Nodo.getDato()).getMaterias().insertar(m3, "34");
		((Alumno) al2Nodo.getDato()).getMaterias().insertar(m4, "45");
		((Alumno) al2Nodo.getDato()).getMaterias().insertar(m5, "56");
	}

	public static void puntoSeis(Arbol arbolAlumnos) {
		// TODO Auto-generated method stub
		try {
			System.out.println("ingrese legajo de alumno (por ejemplo 321)");
			String leg=sc.nextLine();
			Validaciones.numeroCorrecto(leg);
			Integer le=Integer.parseInt(leg);
			System.out.println("ingrese codigo de materia (por ejemplo 12)");
			String codM=sc.nextLine();
			Validaciones.numeroCorrecto(codM);
			Integer co=Integer.parseInt(codM);
			Alumno alu=new Alumno(le);
			if(arbolAlumnos.buscar(alu)==null){
				System.out.println("alumno no encontrado");
			}else{
				Nodo al=arbolAlumnos.buscar(alu);
				Materia m=new Materia(null, co);
				if(((Alumno) al.getDato()).getMaterias().buscar(m, codM)==0){
					System.out.println("materia no encontrada");	
				}else{
					System.out.println("alumno encontrado");
					System.out.println("materia encontrada");
				}
			}
		} catch (MiException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
	}

}
