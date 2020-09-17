package estructura;

import modelo.Persona;

public class ExploracionTablaHash implements TablaHash{

	private static final int TAMANYO_TABLA_POR_DEFECTO = 11;
	protected Persona [] vector;
	private int tamanyoActual;
	private String valor;
	
	public ExploracionTablaHash(){
		crearVector(TAMANYO_TABLA_POR_DEFECTO);
	}
	private final void crearVector(int tamanyoVector){
		vector= new Persona[tamanyoVector];
	}
	@Override
	public void insertar(Hashable x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Hashable x) {
		int posicionActual = x.hash(vector.length);
		if (vector[posicionActual] != null) {
			vector[posicionActual]=null;
			System.out.println("Se elimino corrctamente");
		} else {
			System.out.println("No se encuentra en la lista");
		}
		
	}

	@Override
	public int buscar(Hashable x, String valor) {
		int posicionActual = x.hash(vector.length);
		int i = 0;
		int encontrado = 0;
		while (i != 11) {
			i++;
			if (vector[posicionActual] != null) {
				if (valor.equals(vector[posicionActual].getDni())) {
					encontrado = 1;
					return encontrado;
				}
				if (posicionActual == vector.length) {
					posicionActual = 0;
				}
			}

		}
		return encontrado;

	}
		
	

	@Override
	public void vaciar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void listar() {
		for (Persona persona : vector) {
			if(persona!=null){
				System.out.println(persona.toString());
			}
			
		}
		
	}
	
	public int listarFemenino(){
		int cantidad=0;
		for (Persona persona : vector) {
			if(persona!=null && persona.getSexo().equals("f")){
				cantidad++;
			}
		}
		return cantidad;
	}
	
}
