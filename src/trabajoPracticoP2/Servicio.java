package trabajoPracticoP2;


public class Servicio {
	private static int siguienteId = 1;
	
	private int IdServ;
	private String TipoServ;
	private Especialista especialista;
	private Cliente cliente;
	private String Domicilio;
	private double ValorFinal;
	
	Servicio(Especialista especialista,Cliente cliente,String Domicilio){
		this.IdServ = IdServ + siguienteId++;
		this.TipoServ = "Serv";
		this.especialista = especialista;
		this.cliente = cliente;
		this.Domicilio = Domicilio;
		
		
		if (especialista == null || cliente == null)
			throw new RuntimeException();
		if (Domicilio == null || Domicilio.length() < 4)
			throw new RuntimeException();

}
	public double finalizar() {
		return this.ValorFinal;
		
	}
	
	public void cambiarEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}

	public int getIdServ() {
		return IdServ;
	}
	public String getTipoServ() {
		return TipoServ;
	}

	public Especialista getEspecialista() {
		return especialista;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getDomicilio() {
		return Domicilio;
	}
	

	
}