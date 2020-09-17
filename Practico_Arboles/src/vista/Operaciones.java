package vista;

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
	private static int ticket=1;
	
	public static void registrarProducto(ListaDoble productos) {
		// TODO Auto-generated method stub
		try {
			System.out.println("ingrese codigo de producto:");
			String cod=scanner.nextLine();
			Validacion.numeroCorrecto(cod);
			int cods=Integer.parseInt(cod);
			System.out.println("ingrese denominacion:");
			String denominacion=scanner.nextLine();	
			System.out.println("detalle la instalacion:");
			String detalle=scanner.nextLine();
			System.out.println("version del producto:");
			String version=scanner.nextLine();
			Producto prod=new Producto(cods, denominacion, detalle, version);
			productos.Insertar(prod);
		} catch (NumerosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
		

	public static void registrarRequerimiento(ListaDoble requerimientos, ListaDoble clientes, ListaDoble consultores) {
		// TODO Auto-generated method stub
		try {
			System.out.println("ingrese tipo de requerimiento:\n"
					+ "1.- Incidente\n"
					+ "2.- Cambios\n"
					+ "3.- Service Request");
			String tip = scanner.nextLine();
			Validacion.numeroCorrecto(tip);
			int tipo=Integer.parseInt(tip);
			if(tipo==1){
				Operaciones.incidente(requerimientos, clientes, consultores);
			}else if(tipo==2){
				Operaciones.changes(requerimientos, clientes, consultores);
			}else if(tipo==3){
				Operaciones.serviceRequest(requerimientos, clientes, consultores);
			}else{
				System.out.println("numero incorrecto");
			}
		} catch (NumerosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (letraException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void incidente(ListaDoble requerimientos, ListaDoble clientes, ListaDoble consultores) throws letraException{
		System.out.println("ingrese fecha de alta:");
		String fec=scanner.nextLine();
		System.out.println("ingrese descripcion:");
		String desc=scanner.nextLine();
		System.out.println("ingrese razon social del cliente:");
		String rz=scanner.nextLine();
		Validacion.soloLetras(rz);
		if(clientes.Buscar(rz)==true){
			Cliente cli=(Cliente)clientes.BuscarOb(rz);
			System.out.println("ingrese apellido del consultor:");
			String apeCon=scanner.nextLine();
			Validacion.soloLetras(apeCon);
			Consultor con=(Consultor)consultores.BuscarOb(apeCon);
			System.out.println("ingrese severidad (alta, media o baja):");
			String sev=scanner.nextLine();
			Incidentes inci=new Incidentes(cli, ticket, fec, desc, "Pendiente", con, sev);
			ticket=ticket++;
			con.getCasos().agregar(inci);
			requerimientos.Insertar(inci);
		}else{
			System.out.println("cliente no encontrado");
		}
	}
	
	public static void changes(ListaDoble requerimientos, ListaDoble clientes, ListaDoble consultores) throws letraException{
		System.out.println("ingrese fecha de alta:");
		String fec=scanner.nextLine();
		System.out.println("ingrese descripcion:");
		String desc=scanner.nextLine();
		System.out.println("ingrese razon social del cliente:");
		String apeC=scanner.nextLine();
		Validacion.soloLetras(apeC);
		Cliente cli=(Cliente)clientes.BuscarOb(apeC);
		System.out.println("ingrese apellido del consultor:");
		String apeCon=scanner.nextLine();
		Validacion.soloLetras(apeCon);
		Consultor con=(Consultor)consultores.BuscarOb(apeCon);
		Producto prod=cli.getProducto();
		System.out.println("ingrese fecha estimada:");
		String fecE=scanner.nextLine();
		Changes chan=new Changes(cli, ticket, fec, desc, "Pendiente", con, prod, fecE);
		ticket=ticket++;
		con.getCasos().agregar(chan);
		requerimientos.Insertar(chan);
	}

	
	public static void serviceRequest(ListaDoble requerimientos, ListaDoble clientes, ListaDoble consultores) throws letraException{
		System.out.println("ingrese fecha de alta:");
		String fec=scanner.nextLine();
		System.out.println("ingrese descripcion:");
		String desc=scanner.nextLine();
		System.out.println("ingrese razon social del cliente:");
		String apeC=scanner.nextLine();
		Validacion.soloLetras(apeC);
		Cliente cli=(Cliente)clientes.BuscarOb(apeC);
		System.out.println("ingrese apellido del consultor:");
		String apeCon=scanner.nextLine();
		Validacion.soloLetras(apeCon);
		Consultor con=(Consultor)consultores.BuscarOb(apeCon);
		System.out.println("explique detalle:");
		String det=scanner.nextLine();
		ServiceRequest ser=new ServiceRequest(cli, ticket, fec, desc, "Pendiente", con, det);
		ticket=ticket++;
		con.getCasos().agregar(ser);
		requerimientos.Insertar(ser);
	}


	public static void registrarCliente(ListaDoble clientes, ListaDoble productos) {
		// TODO Auto-generated method stub
		try{
			System.out.println("ingrese codigo de cliente:");
			String co=scanner.nextLine();
			Validacion.numeroCorrecto(co);
			int cod=Integer.parseInt(co);
			System.out.println("ingrese razon social:");
			String rs=scanner.nextLine();
			System.out.println("ingrese codigo de producto");
			String cp=scanner.nextLine();
			Validacion.numeroCorrecto(cp);
			int codp=Integer.parseInt(cp);
			Producto prod=(Producto) productos.BuscarOb(cp);
			Cliente cli=new Cliente(cod, rs, true, prod);
		} catch (NumerosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}


	public static void cambiarEstados(ListaDoble listaRequerimientos) {
		// TODO Auto-generated method stub
		try{
			System.out.println("ingrese numero de ticket:");
			String tick=scanner.nextLine();
			Validacion.numeroCorrecto(tick);
			Requerimientos req =(Requerimientos) listaRequerimientos.BuscarOb(tick);
			if(req.getCliente().isVigencia()){
				System.out.println("seleccione a cual estado desea cambiar este ticket:\n"
						+ "1.- En Proceso"
						+ "2.- Cerrado");
				String sel=scanner.nextLine();
				Validacion.numeroCorrecto(sel);
				int sele=Integer.parseInt(sel);
				if(sele==1){
					req.setEstado("En Proceso");
				}else if(sele==2){
					req.setEstado("Cerrado");
				}else{
					System.out.println("numero incorrecto");
				}
			}else{
				System.out.println("el cliente no se encuentra en vigencia");
			}
		} catch(NumerosException e){
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}


	public static void listarPendientes(ListaDoble listaRequerimientos) {
		// TODO Auto-generated method stub
		NodoDoble n=listaRequerimientos.getCabezera();
		while(n.getDato()!=null){
			if(((Requerimientos) n.getDato()).getEstado()=="Pendiente"){
				n.getDato().toString();
			}
			n=n.getSig();
		}
	}


	public static void listarEnProceso(ListaDoble listaRequerimientos) {
		// TODO Auto-generated method stub
		NodoDoble n=listaRequerimientos.getCabezera();
		while(n.getDato()!=null){
			if(((Requerimientos) n.getDato()).getEstado()=="En Proceso"){
				n.getDato().toString();
			}
			n=n.getSig();
		}		
	}

}