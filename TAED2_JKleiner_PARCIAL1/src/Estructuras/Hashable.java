package Estructuras;

public interface Hashable {
	public abstract int hash(int tablaSize);
	
	/*	implementar en clase a la cual se desee agregar en la tabla hash 
	 * 
	 *	public int hash(int tablaSize){
	 * 		int x = new Integer(this.xxxx)%tablaSize;
	 * 		return x;
	 * }
	 */
}
