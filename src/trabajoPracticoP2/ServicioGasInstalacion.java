package trabajoPracticoP2;

public class ServicioGasInstalacion extends ServicioGas{
	private int CantidadDeInstalaciones;
	private double ValorXInstalacion;
	private double ValorFinalGasInstalacion;
	private String TipoServ;
	
	public ServicioGasInstalacion(Especialista especialista,Cliente cliente,String Domicilio,int CantidadDeInstalaciones,double ValorXInstalacion) {
		super(especialista, cliente, Domicilio);
		this.CantidadDeInstalaciones = CantidadDeInstalaciones;
		this.ValorXInstalacion = ValorXInstalacion;
		this.TipoServ = "GasistaInstalacion";
	}
	@Override
	public double finalizar() {
		this.ValorFinalGasInstalacion = this.ValorXInstalacion * this.CantidadDeInstalaciones;
		return this.ValorFinalGasInstalacion;
	}
	@Override
	public String getTipoServ() {
		return TipoServ;
	}
}
