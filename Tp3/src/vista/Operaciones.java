package vista;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


import estructura.ListaSimple;
import estructura.Nodo;

import lib.CantidadDigitosException;
import lib.CantidadDigitosLegajoException;
import lib.NumerosException;
import lib.Validacion;
import lib.letraException;
import lib.notaException;
import modelo.Butaca;
import modelo.Caja;
import modelo.Cliente;

import modelo.Entrada;

import modelo.Sala;
import modelo.Snack;


public class Operaciones {
	
	static Scanner scanner = new Scanner(System.in); 
	static int select = -1; 
	

	/**
	 * Carga los datos correspondientes a los clientes en un arraylist.
	 * @param listaCliente
	 */
	public static void CargarCliente(ArrayList listaCliente) {
		try {
		System.out.println("Introduce DNI del cliente:");
		String dni = scanner.nextLine();
		Validacion.cantidadDigitosDni(dni);
		Validacion.numeroCorrecto(dni);
		int dniEn=Integer.parseInt(dni);
		
		System.out.println("Introduce nombre del cliente:");
		String nombre = scanner.nextLine();
		Validacion.soloLetras(nombre);
		
		
		System.out.println("Introduce apellido del cliente:");
		String apellido = scanner.nextLine();
		Validacion.soloLetras(apellido);
		
		System.out.println("Introduce Fecha de Nacimiento(formato dd/MM/yyyy ):");
		String fecha = scanner.next();
		Date fechaInscripcion;
	    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    fechaInscripcion = formatter.parse(fecha);
		
		Cliente cliente=new Cliente(dniEn,nombre,apellido,fecha);
		listaCliente.add(cliente);
		System.out.println("Datos cargados correctamente");
		scanner.nextLine();
		
		} catch (CantidadDigitosException e) {
			System.out.println(e.getMessage());
		}catch(NumerosException e ){
			System.out.println(e.getMessage());
		} catch (letraException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		
	}
	

	/**
	 * Metodo utilizado para cargar los datos de las entradas compradas
	 * 
	 * @param listaCliente
	 * @param listaEntrada
	 * @param caja
	 * @param sala
	 */
	public static void ComprarEntrada(ArrayList<Cliente> listaCliente, ListaSimple listaEntrada,ArrayList<Caja> caja) {
		try {
			
			System.out.println("Elija el numero de caja(1,2 o 3):");
			String cajaSeleccionada=scanner.nextLine();
			Validacion.numeroCorrecto(cajaSeleccionada);
			
			int cajaSeleccionadaEn=Integer.parseInt(cajaSeleccionada);
			
			if(cajaSeleccionadaEn > 0 && cajaSeleccionadaEn < 4){
				System.out.println("Elija el numero de sala(1 o 2):");
				String salaSeleccionada=scanner.nextLine();
				Validacion.numeroCorrecto(salaSeleccionada);
				int salaSeleccionadaEn=Integer.parseInt(salaSeleccionada);
				if(salaSeleccionadaEn > 0 && salaSeleccionadaEn < 3){
					System.out.println("Introduce DNI del cliente:");
					String dni = scanner.nextLine();
					Validacion.cantidadDigitosDni(dni);
					Validacion.numeroCorrecto(dni);
					int dniEn=Integer.parseInt(dni);
					
					boolean encontrado=false;
					for(Cliente cliente:listaCliente){
						if(cliente.getDni()==dniEn){
							java.util.Date fecha = new Date();
							encontrado=true;
							Sala sala=new Sala(salaSeleccionadaEn);
							ArrayList<Butaca> butaca=sala.getButaca();
							boolean hayLugar=false;
							for (Butaca butacas : butaca) {
								if(!butacas.isOcupado()){
									butacas.setOcupado(true);
									Entrada entrada = new Entrada(sala,fecha.toString(),butacas,cliente);
									listaEntrada.Insertar(entrada);
									Caja cajas=new Caja(cajaSeleccionadaEn,entrada);
									caja.add(cajas);								
									hayLugar=true;
									break;
								}
							}
							if(hayLugar==false){
								System.out.println("no hay lugar en la sala");
							}
						}
					}
					
					if(!encontrado){
						System.out.println("No se encontro cliente con dni especificado");
					}
					scanner.nextLine();
				}else{
					
				}	
			}else{
				System.out.println("El valor seleccionado no corresponde a una caja");
			}
						
			
			
			} catch (CantidadDigitosException e) {
				System.out.println(e.getMessage());
			}catch(NumerosException e ){
				System.out.println(e.getMessage());
			}
		
	}


	public static void ComprarSnack(ArrayList<Caja> caja) {
		ArrayList snacks=new ArrayList<Snack>();
		String op="";
		System.out.println("Elija el numero de caja(1,2 o 3):");
		String cajaSeleccionada=scanner.nextLine();
		int cajaSeleccionadaEn=Integer.parseInt(cajaSeleccionada);
		if(cajaSeleccionadaEn > 0 && cajaSeleccionadaEn < 4){
			do {
				System.out.println("Elija un snack(1-gaseosa o 2-pochoclo):");
				int articuloSeleccionado=scanner.nextInt();
				System.out.println("Elija un tamaño(1-chico , 2-mediano o 3-grande):");
				int tamaño=scanner.nextInt();
				System.out.println("Ingrese cantidad a comprar:");
				int cantidad=scanner.nextInt();
				String articulo ="";
				if(articuloSeleccionado==1){
					articulo="gaseosa";
				}else{
					articulo="pochoclo";
				}
				
				Snack snack=new Snack(articulo,tamaño,cantidad);
				snacks.add(snack);
				
				Caja cajas=new Caja(cajaSeleccionadaEn,snacks);
				caja.add(cajas);
				System.out.println("Presion cualquier tecla para comprar otro snack de lo contrario presione s para salir");
				scanner.nextLine();
				op=scanner.nextLine();
			} while (!op.equals("s"));
			
		}else{
			System.out.println("El valor seleccionado no corresponde a una caja");
		}
		
		
	}


	public static void CalcularMontoSala(ArrayList<Caja> cajas) {
		int montoSala1 = 0;
		int montoSala2 = 0;
		
		for (Caja caja : cajas) {
			if(caja.getListaEntrada() != null && caja.getListaEntrada().getSala().getCodigo()==1){
				montoSala1=montoSala1+caja.getListaEntrada().obtenerMonto();
			}
			if(caja.getListaEntrada() != null && caja.getListaEntrada().getSala().getCodigo()==2){
				montoSala2=montoSala2+caja.getListaEntrada().obtenerMonto();
			}
		}
		
		if(montoSala1 == 0 && montoSala2 == 0){
			System.out.println("No hubo ventas de entradas");
		}else{
			System.out.println("Ingresos por Salas [Sala 1=" + montoSala1 + ", Sala 2=" + montoSala2 + "]");
		}
		
	}


	public static void CalcularSnack(ArrayList<Caja> cajas) {
		int montoGaseosa = 0;
		int montoPochoclo = 0;
		
		for (Caja caja : cajas) {
			if(caja.getSnack()!=null){
				ArrayList<Snack> snacks=caja.getSnack();
				for (Snack snack : snacks) {
					if(snack.getNombre().equals("gaseosa")){
						montoGaseosa = montoGaseosa+snack.getMontoTotal();
					}else{
						montoPochoclo = montoPochoclo+snack.getMontoTotal();
					}
				}
			}
		}
		if(montoGaseosa == 0 && montoPochoclo == 0){
			System.out.println("No hubo ventas de entradas");
		}else{
			System.out.println("Ingresos por Snacks [Gaseosas=" + montoGaseosa + ", Pochoclos=" + montoPochoclo + "]");
		}
	}


	public static void CalcularIngresoTotal(ArrayList<Caja> cajas) {
		int montoTotal = 0;
		int montoSalas = 0;
		int montoSnacks = 0;
		
		for (Caja caja : cajas) {
			if(caja.getListaEntrada()!=null){
				montoSalas=montoSalas+caja.getListaEntrada().obtenerMonto();
			}
			if(caja.getSnack()!=null){
				ArrayList<Snack> snacks=caja.getSnack();
				for (Snack snack : snacks) {
					montoSnacks = montoSnacks+snack.getMontoTotal();
				}
			
			}
		}
		montoTotal=montoSalas+montoSnacks;
		if(montoTotal == 0){
			System.out.println("No se registraron ventas en la fecha");
		}else{
			System.out.println("Los ingresos totales son : "+montoTotal);
		}
	}
}			

