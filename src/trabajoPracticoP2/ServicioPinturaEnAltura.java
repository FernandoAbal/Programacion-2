package trabajoPracticoP2;

public class ServicioPinturaEnAltura extends ServicioPintura{
	private int Piso;
	private double CostoDelSeguro;
	private double CostoAlquilerAndamios;
	private double ValorFinalPinturaEnAltura;
	private String TipoServ;
	
	public ServicioPinturaEnAltura(Especialista especialista,Cliente cliente,String Domicilio,int SuperficieAPintar,double ValorXm2,int Piso,double Seguro, double AlqAndamios) {
		super(especialista, cliente, Domicilio, SuperficieAPintar,ValorXm2);
		this.TipoServ = "PinturaEnAltura";
		this.Piso = Piso;
		this.CostoDelSeguro = Seguro;
		this.CostoAlquilerAndamios = AlqAndamios;
	}
	
	@Override
	public double finalizar() {
		if (this.Piso < 5) {
			this.ValorFinalPinturaEnAltura = this.ValorXm2 * this.SuperficieAPintar + this.CostoDelSeguro + this.CostoAlquilerAndamios;
		return this.ValorFinalPinturaEnAltura;
		}else {
			this.ValorFinalPinturaEnAltura = this.ValorXm2 * this.SuperficieAPintar + this.CostoDelSeguro + (this.CostoAlquilerAndamios/10)*12;
		return this.ValorFinalPinturaEnAltura;
		}
	}
	@Override
	public String getTipoServ() {
		return TipoServ;
	}

	

}
