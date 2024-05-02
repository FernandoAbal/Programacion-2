package trabajoPracticoP2;

public class ServicioElectricidad extends Servicio {
    private int HorasTrabajadas;
    private double ValorXHora;
    private double ValorFinalElectricidad;
    private String TipoServ;
    
    public ServicioElectricidad(Especialista especialista,Cliente cliente,String Domicilio,int HorasTrabajadas,double ValorXHora) { 
    	super(especialista, cliente, Domicilio);
        this.HorasTrabajadas = HorasTrabajadas;
        this.ValorXHora = ValorXHora;
        this.TipoServ = "Electricidad";
    }
    @Override
    public double finalizar() {
    	this.ValorFinalElectricidad = this.ValorXHora * this.HorasTrabajadas;
    return this.ValorFinalElectricidad;
    }
    @Override
    public String getTipoServ() {
		return TipoServ;
	}
    
}


