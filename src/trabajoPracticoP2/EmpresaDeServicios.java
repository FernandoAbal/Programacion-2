package trabajoPracticoP2;


import java.util.HashMap;


public class EmpresaDeServicios {
	private HashMap<Integer,Cliente> Clientes;
	private HashMap<Integer,Especialista> Especialistas;
	private HashMap<Integer,Servicio> Servicios;
	private HashMap<String ,Double> FacturacionXServicio;
	private HashMap<String ,Integer> CantidadDeServiciosRealizadosPorTipo;
	private HashMap<Integer,StringBuilder> ListadosDeServiciosXEspecialista;
	private double FacturacionTotal;
	


	EmpresaDeServicios(){
	this.Clientes = 			new HashMap<>();
	this.Especialistas = 		new HashMap<>();
	this.Servicios = 			new HashMap<>();
	this.FacturacionXServicio = new HashMap<>();
	this.ListadosDeServiciosXEspecialista = new HashMap<>();
	this.CantidadDeServiciosRealizadosPorTipo = new HashMap<>();
	this.FacturacionXServicio.put("Electricidad", 0.0);
	this.FacturacionXServicio.put("GasistaInstalacion", 0.0);
	this.FacturacionXServicio.put("GasistaRevision", 0.0);
	this.FacturacionXServicio.put("Pintura", 0.0);
	this.FacturacionXServicio.put("PinturaEnAltura", 0.0);
	this.CantidadDeServiciosRealizadosPorTipo.put("Electricidad", 0);
	this.CantidadDeServiciosRealizadosPorTipo.put("GasistaInstalacion", 0);
	this.CantidadDeServiciosRealizadosPorTipo.put("GasistaRevision", 0);
	this.CantidadDeServiciosRealizadosPorTipo.put("Pintura", 0);
	this.CantidadDeServiciosRealizadosPorTipo.put("PinturaEnAltura", 0);
	this.FacturacionTotal = 0;
	
	}
	
	
	public void registrarCliente(int DNI,String Nombre,String Telefono) {
		validarDNINoRepetido(DNI);
		Cliente nuevoCliente = new Cliente(DNI,Nombre,Telefono);
		Clientes.put(DNI,nuevoCliente);
		
	}
	public void AgregarDomicilioAUnCliente(String domicilioNuevo,int DNI) {
		Clientes.get(DNI).AgregarDomicilio(domicilioNuevo);
	}
		
	private void validarDNINoRepetido(int DNI) {
		if (DNI==0)
			throw new RuntimeException();
		if (Clientes.containsKey(DNI))
			throw new RuntimeException("El DNI ya esta registrado.");
	}
	
	public void registrarEspecialista(int NumEsp,String Nombre,String Telefono, String TipoServ) {
		if (TipoServ == "GasistaInstalacion" || TipoServ == "GasistaRevision")
			TipoServ = "Gas";
		if (TipoServ == "PinturaEnAltura")
			TipoServ = "Pintura";
		validarNumEspNoRepetido(NumEsp);
		 if (!TipoServ.equals("Electricidad") && !TipoServ.equals("Pintura") && !TipoServ.equals("Gas"))
			throw new RuntimeException("no existe esa especialidad");
		StringBuilder Listado = new StringBuilder();
		ListadosDeServiciosXEspecialista.put(NumEsp, Listado);
		Especialista nuevoEspecialista = new Especialista(NumEsp,Nombre, Telefono, TipoServ);
		Especialistas.put(NumEsp,nuevoEspecialista);
	}
	
	private void validarNumEspNoRepetido(int NumEsp) {
		if (NumEsp==0)
			throw new RuntimeException();
		if (Especialistas.containsKey(NumEsp))
			throw new RuntimeException("El Número de especialista ya esta registrado.");
	}
	
	public int solicitarServicioElectricidad(int DNI, int NumEsp, String Domicilio,int HorasTrabajadas,int ValorXHora) {
		if (!(Especialistas.containsKey(NumEsp) && Clientes.containsKey(DNI)))
			throw new RuntimeException("problema");
		//if (!Clientes.get(DNI).getDomicilios().contains(Domicilio))
			//throw new RuntimeException();
		
		validarEspecialistaElectricidad(Especialistas.get(NumEsp));
		ServicioElectricidad nuevoServicio = new ServicioElectricidad(Especialistas.get(NumEsp),Clientes.get(DNI),Domicilio,HorasTrabajadas,ValorXHora);
		Servicios.put(nuevoServicio.getIdServ(),nuevoServicio);
		return nuevoServicio.getIdServ();
	}
	
	private void validarEspecialistaElectricidad(Especialista especialista) {
		if (especialista==null)
			throw new RuntimeException();
		if (especialista.getTipoServ() != "Electricidad")
			throw new RuntimeException("El especialista no se encarga de este tipo de trabajo.");
	}
	
	public int solicitarServicioGasistaRevision(int DNI,int NumEsp, String Domicilio,int CantidadDeRevisiones,double ValorXRevision) {
		if (!(Especialistas.containsKey(NumEsp) && Clientes.containsKey(DNI)))
			throw new RuntimeException();
		//if (!Clientes.get(DNI).getDomicilios().contains(Domicilio))
			//throw new RuntimeException();
		
		validarEspecialistaGas(Especialistas.get(NumEsp));
		ServicioGas nuevoServicio = new ServicioGasRevision(Especialistas.get(NumEsp),Clientes.get(DNI),Domicilio, CantidadDeRevisiones,ValorXRevision);
		Servicios.put(nuevoServicio.getIdServ(),nuevoServicio);
		return nuevoServicio.getIdServ();
	}
	
	public int solicitarServicioGasistaInstalacion(int DNI, int NumEsp, String Domicilio,int CantidadDeInstalaciones,double ValorXInstalacion) {
		if (!(Especialistas.containsKey(NumEsp) && Clientes.containsKey(DNI)))
			throw new RuntimeException();
		//if (!Clientes.get(DNI).getDomicilios().contains(Domicilio))
			//throw new RuntimeException();
		
		validarEspecialistaGas(Especialistas.get(NumEsp));
		ServicioGas nuevoServicio = new ServicioGasInstalacion(Especialistas.get(NumEsp),Clientes.get(DNI),Domicilio, CantidadDeInstalaciones,ValorXInstalacion);
		Servicios.put(nuevoServicio.getIdServ(),nuevoServicio);
		return nuevoServicio.getIdServ();
	}
	
	private void validarEspecialistaGas(Especialista especialista) {
		if (especialista==null)
			throw new RuntimeException();
		if (especialista.getTipoServ() != "Gas")
			throw new RuntimeException("El especialista no se encarga de este tipo de trabajo.");
	}
	
	public int solicitarServicioPintura(int DNI,int NumEsp , String Domicilio,int SuperficieAPintar,double ValorXm2) {
		if (!(Especialistas.containsKey(NumEsp) && Clientes.containsKey(DNI)))
			throw new RuntimeException();
		//if (!Clientes.get(DNI).getDomicilios().contains(Domicilio))
			//throw new RuntimeException();
		
		validarEspecialistaPintura(Especialistas.get(NumEsp));	
	ServicioPintura nuevoServicio = new ServicioPintura(Especialistas.get(NumEsp),Clientes.get(DNI),Domicilio,SuperficieAPintar,ValorXm2);
	Servicios.put(nuevoServicio.getIdServ(),nuevoServicio);
	return nuevoServicio.getIdServ();
	}
	
	public int solicitarServicioPintura(int DNI,int NumEsp, String Domicilio,int SuperficieAPintar,double ValorXm2,int Piso,double Seguro,double AlqAndamios) {
		if (!(Especialistas.containsKey(NumEsp) && Clientes.containsKey(DNI)))
		throw new RuntimeException();
		//if (!Clientes.get(DNI).getDomicilios().contains(Domicilio))
			//throw new RuntimeException();
		
	validarEspecialistaPintura(Especialistas.get(NumEsp));
	ServicioPinturaEnAltura nuevoServicio = new ServicioPinturaEnAltura(Especialistas.get(NumEsp),Clientes.get(DNI),Domicilio,SuperficieAPintar,ValorXm2,Piso,Seguro,AlqAndamios);
	Servicios.put(nuevoServicio.getIdServ(),nuevoServicio);
	return nuevoServicio.getIdServ();
	}
	
	private void validarEspecialistaPintura(Especialista especialista) {
		if (especialista==null)
			throw new RuntimeException();
		
		if (especialista.getTipoServ() != "Pintura")
			throw new RuntimeException("El especialista no se encarga de este tipo de trabajo.");
	}
	public boolean cambiarResponsable(int IdServ, int NumEsp) {
		if(!Servicios.containsKey(IdServ))
			throw new RuntimeException();
		
		if(!Especialistas.containsKey(NumEsp))
			throw new RuntimeException();
		String GasInstalacion = "GasInstalacion";
		String PinturaEnAltura = "PinturaEnAltura";
		String Pintura = "Pintura";
		String Electricidad = "Electricidad";
		String GasRevision = "GasRevision";
		String TipoDeServ = "Serv";
		if (Servicios.get(IdServ).getTipoServ().equals(PinturaEnAltura) || Servicios.get(IdServ).getTipoServ().equals(Pintura))
			TipoDeServ = "Pintura";
		if (Servicios.get(IdServ).getTipoServ().equals(Electricidad))
			TipoDeServ = "Electricidad";
		if (Servicios.get(IdServ).getTipoServ().equals(GasInstalacion) || Servicios.get(IdServ).getTipoServ().equals(GasRevision))
			TipoDeServ = "Gas";
		if (!TipoDeServ.equals(Especialistas.get(NumEsp).getTipoServ()))
			throw new RuntimeException("El especialista no se encarga de este tipo de trabajo.");
		
			
		Servicios.get(IdServ).cambiarEspecialista(Especialistas.get(NumEsp));
		return true;
	}
	
	public double finalizarServicio(int IdServ, double costoMateriales) {
		ListadosDeServiciosXEspecialista.put(Servicios.get(IdServ).getEspecialista().getNumEsp(),ListadosDeServiciosXEspecialista.get(Servicios.get(IdServ).getEspecialista().getNumEsp()).append(" + "));
		ListadosDeServiciosXEspecialista.put(Servicios.get(IdServ).getEspecialista().getNumEsp(),ListadosDeServiciosXEspecialista.get(Servicios.get(IdServ).getEspecialista().getNumEsp()).append("[ "));
		ListadosDeServiciosXEspecialista.put(Servicios.get(IdServ).getEspecialista().getNumEsp(),ListadosDeServiciosXEspecialista.get(Servicios.get(IdServ).getEspecialista().getNumEsp()).append(IdServ));
		ListadosDeServiciosXEspecialista.put(Servicios.get(IdServ).getEspecialista().getNumEsp(),ListadosDeServiciosXEspecialista.get(Servicios.get(IdServ).getEspecialista().getNumEsp()).append(" - "));
		ListadosDeServiciosXEspecialista.put(Servicios.get(IdServ).getEspecialista().getNumEsp(),ListadosDeServiciosXEspecialista.get(Servicios.get(IdServ).getEspecialista().getNumEsp()).append(Servicios.get(IdServ).getTipoServ()));
		ListadosDeServiciosXEspecialista.put(Servicios.get(IdServ).getEspecialista().getNumEsp(),ListadosDeServiciosXEspecialista.get(Servicios.get(IdServ).getEspecialista().getNumEsp()).append(" ] "));
		ListadosDeServiciosXEspecialista.put(Servicios.get(IdServ).getEspecialista().getNumEsp(),ListadosDeServiciosXEspecialista.get(Servicios.get(IdServ).getEspecialista().getNumEsp()).append(Servicios.get(IdServ).getDomicilio()));
		ListadosDeServiciosXEspecialista.put(Servicios.get(IdServ).getEspecialista().getNumEsp(),ListadosDeServiciosXEspecialista.get(Servicios.get(IdServ).getEspecialista().getNumEsp()).append("\n"));
		//Servicios.get(IdServ).getEspecialista().agregarServicio(IdServ);
		CantidadDeServiciosRealizadosPorTipo.put(Servicios.get(IdServ).getTipoServ(),(CantidadDeServiciosRealizadosPorTipo.get(Servicios.get(IdServ).getTipoServ())+1));
		FacturacionXServicio.put(Servicios.get(IdServ).getTipoServ(),(FacturacionXServicio.get(Servicios.get(IdServ).getTipoServ())+Servicios.get(IdServ).finalizar()+ costoMateriales));
		this.FacturacionTotal = this.FacturacionTotal + Servicios.get(IdServ).finalizar() + costoMateriales;
	return Servicios.get(IdServ).finalizar() + costoMateriales;
	
	}
	public HashMap<String,Integer> cantidadDeServiciosRealizadosPorTipo(){
		return CantidadDeServiciosRealizadosPorTipo;
	}
	
	public double facturacionTotalPorTipo(String tipoServicio) {
		return FacturacionXServicio.get(tipoServicio);
	}
	public double facturacionTotal() {
		return FacturacionTotal;
	}
	public String listadoServiciosAtendidosPorEspecialista(int nroEspecialista) {
		return ListadosDeServiciosXEspecialista.get(nroEspecialista).toString();
		/*StringBuilder listado = new StringBuilder();
		for (int IdServ : Especialistas.get(nroEspecialista).getHistorial()){
			listado.append(" + ");
			listado.append("[ ");
			listado.append(IdServ);
			listado.append(" - ");
			listado.append(Servicios.get(IdServ).getTipoServ());
			listado.append(" ] ");
			listado.append(Servicios.get(IdServ).getDomicilio());
			listado.append("\n");
		}
		return listado.toString();*/
	}
	public boolean AgregarDomicilioACliente(int DNI, String NuevoDomicilio) {
		Clientes.get(DNI).AgregarDomicilio(NuevoDomicilio);
		return true;
	}
	public String toString(EmpresaDeServicios emp) {
		return "Empresa de Servicios";
	}
}
	
	

