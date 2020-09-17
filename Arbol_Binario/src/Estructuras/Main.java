package Estructuras;

import java.util.Scanner;



public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static Arbol ABB = new Arbol();
	public static int sel=-1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] arbol=new String[10];
		for(int i=0; i<arbol.length;i++){
			System.out.println("escribir palabra");
			arbol[i]=sc.nextLine();
		}
		
		for(int i=0; i<arbol.length;i++){
			ABB.insertar(arbol[i]);
		}
		
		while(sel != 0){
			System.out.println("Elija opción:\n1.- recorrido pre\n" +
					"2.- recorrido in\n" +
					"3.- recorrido post\n" +
					"4.- encontrar elemento\n" +
					"5.- retornar mayor\n" +
					"6.- retornar menor\n" +
					"7.- calcular altura\n" +
					"8.- calcular tamaño\n" +
					"9.- eliminar nodo\n" +
					"0.- Salir");
			
			String sele=sc.nextLine();
			sel = Integer.parseInt(sele); 
			
			switch(sel){
			case 1:
				ABB.recorrerPreOrden();
				break;
			case 2:
				ABB.recorrerInOrden();
				break;
			case 3:
				ABB.recorrerPostOrden();
				break;
			case 4:
				System.out.println("escriba palabra a buscar");
				String dato=sc.nextLine();
				System.out.println(ABB.buscar(dato).toString());
				break;
			case 5:
				System.out.println(ABB.buscarMax().toString());
				break;
			case 6:
				System.out.println(ABB.buscarMin().toString());
				break;
			case 7:
				System.out.println(ABB.calcularAltura());
				break;
			case 8:
				System.out.println(ABB.calcularTamaño());
				break;
			case 9:
				System.out.println("escriba palabra a eliminar");
				String de=sc.nextLine();
				ABB.eliminar(de);
				System.out.println("el nodo fue eliminado");
				break;
			case 0: 
				System.out.println("Adios!");
				break;
			default:
				System.out.println("Número no reconocido");break;
			}
			
		}

	}

}
