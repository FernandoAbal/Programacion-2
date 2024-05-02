package trabajoPracticoP2;

import java.util.HashSet;


public class Cliente {
	private int DNI;
	private String Nombre;
	private String Telefono;
	private String Domicilio;
	private HashSet<String> Domicilios;
	
	

	Cliente(int DNI,String Nombre,String Telefono){
		if (DNI <= 0)
			throw new RuntimeException();
		if (Nombre == null)
			throw new RuntimeException();
		if (Telefono == null || Telefono.length() < 4)
			throw new RuntimeException();
		//if (Domicilio == null || Domicilio.length() < 4)
			//throw new RuntimeException();
		this.DNI = DNI;
		this.Nombre = Nombre;
		this.Telefono = Telefono;
		this.Domicilios = new HashSet<String>();
		this.Domicilios.add(Domicilio);
		
	}
	
	public int getDNI() {
		return DNI;
	}


	public String getNombre() {
		return Nombre;
	}

	public String getTelefono() {
		return Telefono;
	}

	public HashSet<String> getDomicilios() {
		return Domicilios;
	}

	void AgregarDomicilio(String NuevoDomicilio){
		Domicilios.add(NuevoDomicilio);
	}

	void CambiarNumero(String NuevoNumero) {
		Telefono = NuevoNumero;
	}

	public String getDomicilio() {
		return Domicilio;
	}
}
