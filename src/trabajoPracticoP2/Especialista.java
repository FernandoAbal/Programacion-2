package trabajoPracticoP2;

//import java.util.HashSet;

public class Especialista {
	private int NumEsp;
	private String Nombre;
	private String Telefono;
	private String TipoServ;
	//private HashSet<Integer> Historial;
	
	
	Especialista(int NumEsp,String Nombre,String Telefono,String TipoServ){
		if (NumEsp <= 0)
			throw new RuntimeException();
		if (Nombre == null)
			throw new RuntimeException();
		if (Telefono == null || Telefono.length() < 4)
			throw new RuntimeException();
		if (TipoServ == null)
			throw new RuntimeException();
		
		this.NumEsp = NumEsp;
		this.Nombre = Nombre;
		this.Telefono = Telefono;
		this.TipoServ = TipoServ;
		//this.Historial = new HashSet<Integer>();

 }
	/*public void agregarServicio(int IdServ) {
		Historial.add(IdServ);
	}*/

	public int getNumEsp() {
		return NumEsp;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getTelefono() {
		return Telefono;
	}

	public String getTipoServ() {
		return TipoServ;
	}

	//public HashSet<Integer> getHistorial() {
	//	return Historial;
	//}
}
