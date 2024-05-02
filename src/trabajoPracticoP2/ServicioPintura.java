package trabajoPracticoP2;

public class ServicioPintura extends Servicio{
	public int SuperficieAPintar;
	public double ValorXm2;
	public double ValorFinalPintura;
	private String TipoServ;
	
	public ServicioPintura(Especialista especialista,Cliente cliente,String Domicilio,int SuperficieAPintar,double ValorXm2) {
		super(especialista, cliente, Domicilio);
		this.SuperficieAPintar = SuperficieAPintar;
		this.ValorXm2 = ValorXm2;
		this.TipoServ= "Pintura";
	}
	
	@Override
	public double finalizar() {
		this.ValorFinalPintura = this.ValorXm2 * this.SuperficieAPintar;
		return this.ValorFinalPintura;
	}
	
	public String getTipoServ() {
		return TipoServ;
	}

}
