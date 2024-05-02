package trabajoPracticoP2;

public class ServicioGasRevision extends ServicioGas{
	private int CantidadDeRevisiones;
	private double ValorXRevision;
	private double ValorFinalGasRevision;
	private String TipoServ;
	
	public ServicioGasRevision(Especialista especialista,Cliente cliente,String Domicilio,int CantidadDeRevisiones,double ValorXRevision) {
		super( especialista, cliente, Domicilio);
		this.CantidadDeRevisiones = CantidadDeRevisiones;
		this.ValorXRevision = ValorXRevision;
		this.TipoServ = "GasistaRevision";
	}

	
	@Override
	public double finalizar() {
		if(this.CantidadDeRevisiones < 5) {
		this.ValorFinalGasRevision =this.ValorXRevision * this.CantidadDeRevisiones;
		return this.ValorFinalGasRevision;
		}else {
			if(this.CantidadDeRevisiones>5 && this.CantidadDeRevisiones<=10) {
				this.ValorFinalGasRevision = ((this.ValorXRevision * this.CantidadDeRevisiones)/10)*9;
			return this.ValorFinalGasRevision;
			}
			else {
				this.ValorFinalGasRevision = ((this.ValorXRevision * this.CantidadDeRevisiones)/100)*85;
			return this.ValorFinalGasRevision;
			}
		}
		}
	@Override
	public String getTipoServ() {
		return TipoServ;
	}
}
