package estructuras;

public class TablaConductores extends TablaExploracionLineal{
	
	public int contarConductores(){
		int ret=0;
		for(int i=0;i<vector.length;i++){
			if(vector[i]!=null){
				ret++;
			}
		}
		return ret;
	}
	
}
