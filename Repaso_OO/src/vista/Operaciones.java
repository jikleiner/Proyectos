package vista;

import java.util.ArrayList;
import java.util.Scanner;
import estructuras.ListaDoble;
import estructuras.Nodo;
import estructuras.NodoDoble;
import lib.NumerosException;
import lib.letraException;
import lib.Validacion;
import modelo.*;

public class Operaciones {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void cargarProveedor(ArrayList<Proveedor> listaProv, ArrayList<Vendedor> listaVend) {
		// TODO Auto-generated method stub
		try {
			System.out.println("ingrese nombre del proveedor:");
			String nom=scanner.nextLine();
			Validacion.soloLetras(nom);
			System.out.println("ingrese direccion");
			String dir=scanner.nextLine();
			System.out.println("ingrese telefono");
			String tel=scanner.nextLine();
			Validacion.numeroCorrecto(tel);
			System.out.println("indique legajo del vendedor");
			String lv=scanner.nextLine();
			Validacion.numeroCorrecto(lv);
			Vendedor v = null;
			int i=0;
			boolean enc=false;
			while(enc==false||i<listaVend.size()){
				v=(Vendedor) listaVend.get(i);
				if(v.compareTo(lv)==0){
					enc=true;
				}
				i++;
			}
			int teli=Integer.parseInt(tel);
			Proveedor p = new Proveedor(nom, dir, teli, v);
			listaProv.add(p);
		} catch (letraException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NumerosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

	public static void modificarNombreVendedor(ArrayList listaProv, ArrayList listaVend) {
		// TODO Auto-generated method stub
		try {
			System.out.println("ingrese nombre del proveedor:");
			String nom=scanner.nextLine();
			Validacion.soloLetras(nom);
			int i=0;
			boolean enc=false;
			Proveedor p=null;
			while(enc==false||i<listaProv.size()){
				p=(Proveedor) listaProv.get(i);
				if(p.compareTo(nom)==0){
					enc=true;
				}
				i++;
			}
			if(p!=null){
				System.out.println(p.getVendedor().toString());
				System.out.println("ingrese el nombre que desea asignar al vendedor");
				String sel=scanner.nextLine();
				p.getVendedor().setNombre(sel);
				System.out.println("Vendedor modificado con exito");
			}else{
				System.out.println("Vendedor no encontrado");
			}
		} catch (letraException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}		
	}

	public static void eliminarVendedor(ArrayList listaProv) {
		// TODO Auto-generated method stub
		try {
			System.out.println("ingrese nombre del proveedor:");
			String nom=scanner.nextLine();
			Validacion.soloLetras(nom);
			int i=0;
			boolean enc=false;
			Proveedor p=null;
			while(enc==false||i<listaProv.size()){
				p=(Proveedor) listaProv.get(i);
				if(p.compareTo(nom)==0){
					enc=true;
				}
				i++;
			}
			if(p!=null){
				System.out.println("el "+p.getVendedor().toString()+" fue eliminado del Proveedor "+p.toString());
				p.setVendedor(null);
			}else{
				System.out.println("proveedor no encontrado");
			}
		} catch (letraException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public static void cambiarVendedor(ArrayList listaProv, ArrayList listaVend) {
		// TODO Auto-generated method stub
		try {
			System.out.println("ingrese nombre del proveedor:");
			String nom=scanner.nextLine();
			Validacion.soloLetras(nom);
			int i=0;
			boolean enc=false;
			Proveedor p=null;
			while(enc==false||i<listaProv.size()){
				p=(Proveedor) listaProv.get(i);
				if(p.compareTo(nom)==0){
					enc=true;
				}
				i++;
			}
			if(p!=null){
				System.out.println(p.getVendedor().toString());
				System.out.println("seleccione el numero de vendedor que desea asignar");
				for(i=0;i<listaVend.size();i++){
					System.out.println(i+".- "+ ((Vendedor)listaVend.get(i)).toString()+"\n");
				}
				String sel=scanner.nextLine();
				Validacion.numeroCorrecto(sel);
				i=Integer.parseInt(sel);
				p.setVendedor((Vendedor)listaVend.get(i));
				System.out.println("Vendedor modificado con exito");
			}else{
				System.out.println("Vendedor no encontrado");
			}
		} catch (letraException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NumerosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}		
	}

	public static void listarSinVendedor(ArrayList listaProv) {
		// TODO Auto-generated method stub
		int i=0;
		boolean enc=false;
		Proveedor p;
		while(i<listaProv.size()|enc==false){
			p=(Proveedor) listaProv.get(i);
			if(p.getVendedor()==null){
				System.out.println(p.toString());;
			}
			i++;
		}
	}

	public static void listarMenosTresTel(ArrayList listaVend) {
		// TODO Auto-generated method stub
		int i=0;
		boolean enc=false;
		Vendedor v = null;
		while(i<listaVend.size()|enc==false){
			v=(Vendedor) listaVend.get(i);
			if(v.getTelefonosContacto().size()<3){
				System.out.println(v.toString());;
			}
			i++;
		}
	}

	public static void cargarVendedor(ArrayList listaVend) {
		// TODO Auto-generated method stub
		try {
			String tel;
			ArrayList listaTel=new ArrayList();
			System.out.println("ingrese nombre del vendedor:");
			String nom=scanner.nextLine();
			Validacion.soloLetras(nom);
			System.out.println("ingrese apellido:");
			String ape=scanner.nextLine();
			Validacion.soloLetras(ape);
			System.out.println("ingrese edad");
			String edad=scanner.nextLine();
			Validacion.numeroCorrecto(edad);
			System.out.println("ingrese legajo");
			String leg=scanner.nextLine();
			Validacion.numeroCorrecto(leg);
			System.out.println("indique cantidad de telefonos de contacto");
			String ct=scanner.nextLine();
			Validacion.numeroCorrecto(ct);
			int edadi=Integer.parseInt(edad);
			int legi=Integer.parseInt(leg);
			int cti=Integer.parseInt(ct);
			for(int i=0;i<cti;i++){
				System.out.println("ingrese el "+(i+1)+"er telefono");
				tel=scanner.nextLine();
				listaTel.add(tel);
			}
			Vendedor v=new Vendedor(nom, ape, edadi, legi, listaTel);
			listaVend.add(v);
		} catch (letraException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (NumerosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public static int factorial(int i) {
		// TODO Auto-generated method stub
		if(i==0){
			return 1;
		}else{
			return i*factorial(i-1);
		}
	} 
	
	public static int fibonacci(int n){
		if(n==1){
			return n;
		}else{
			return (n-1)+fibonacci(n-2);
		}
	}

}
