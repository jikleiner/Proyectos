package lib;

import modelo.Estudiante;

public class Compa {
	public int compareTo(Object o) {
		if(o instanceof String){
			String estudiante = (String)o;
			return this.getLegajo().compareTo(estudiante);
		}else{
			Estudiante estudiante = (Estudiante)o;
			return this.getLegajo().compareTo(estudiante.getLegajo());
		}

}
