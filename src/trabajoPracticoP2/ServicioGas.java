package trabajoPracticoP2;

public class ServicioGas extends Servicio {
	private double ValorFinalGas;
	private String TipoServ;
	
	public ServicioGas(Especialista especialista,Cliente cliente,String Domicilio) {
		super(especialista, cliente, Domicilio);
		this.TipoServ = "Gas";
	}
	
	@Override
	public double finalizar() {
		return this.ValorFinalGas;
	}
	
	public String getTipoServ() {
		return TipoServ;
	}
}
