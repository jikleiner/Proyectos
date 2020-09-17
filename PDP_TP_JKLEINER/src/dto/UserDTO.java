package dto;

public class UserDTO {
	private String nombre;
	private String pass;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String rol) {
		this.pass = rol;
	}

	public String toString() {
		return "Nombre: " + nombre + " - Password: " + pass;
		
	}
}
