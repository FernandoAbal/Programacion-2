package trabajoPracticoP2;

public class CodigoCliente{
public static void main(String[] args){
 // La empresa dispone de los siguientes tipos de Servicios:
 // - Pintura
 // - PinturaEnAltura
 // - Electricidad
 // - GasistaInstalacion
 // - GasistaRevision
 EmpresaDeServicios empresa = new EmpresaDeServicios();
 empresa.registrarEspecialista(1001, "Electricista1", "1144556677", "Electricidad");
 empresa.registrarEspecialista(20, "Gasista" , "1144556688", "GasistaInstalacion");
 empresa.registrarEspecialista(33, "Pintor1" , "1144556699", "PinturaEnAltura");
 empresa.registrarEspecialista(452, "Electricista2", "1144557700", "Electricidad");
 empresa.registrarEspecialista(34, "Pintor2" , "1144557733", "PinturaEnAltura");
 
 empresa.registrarCliente(30449448, "Cliente1", "1146651100");
 empresa.registrarCliente(37223451, "Cliente2", "1146651111");
 
 int cli1_elec1=empresa.solicitarServicioElectricidad(30449448, 1001, "calle falsa 123", 700, 20);
 int cli1_pintor1=empresa.solicitarServicioPintura(30449448, 33, "calle falsa 123", 24, 4500,2,18000,5000);
 int cli2_elec2=empresa.solicitarServicioElectricidad(37223451, 452, "otra Calle 321", 650, 2);
 int cli2_gasista=empresa.solicitarServicioGasistaInstalacion(37223451, 20, "bulevar 333", 3, 3200);
 int cli1_elec2=empresa.solicitarServicioElectricidad(30449448, 452, "calle falsa 139", 650, 10);
 
 // El toString de empresa debe mostrar información útil, relevante y
 // ordenada para que se pueda entender el estado actual del sistema.
 System.out.println(empresa);
 System.out.println();
 
 empresa.finalizarServicio(cli1_elec1, 30000); 
 empresa.finalizarServicio(cli2_elec2, 10000);
 empresa.finalizarServicio(cli1_elec2, 5000);
 empresa.finalizarServicio(cli2_gasista, 1000);
 empresa.cambiarResponsable(cli1_pintor1, 34);
 
 System.out.println("Cantidad de servicios realizados por tipo: ");
 System.out.println(empresa.cantidadDeServiciosRealizadosPorTipo());
 System.out.println();
 System.out.println("Facturacion total en 'Electricidad': " +
 empresa.facturacionTotalPorTipo("Electricidad"));
 System.out.println();
 System.out.println("Facturacion total: " + empresa.facturacionTotal());
 System.out.println();
 System.out.println("Servicios realizados por 'Electricista2': ");
 System.out.println(empresa.listadoServiciosAtendidosPorEspecialista(452));
 System.out.println();
 
 System.out.println(empresa);
}













/*package trabajoPracticoP2;

public class Interfaz {
	public static void main(String[] args) {
		 // La empresa dispone de los siguientes tipos de Servicios:
		 // - Pintura
		 // - PinturaEnAltura
		 // - Electricidad
		 // - GasistaInstalacion
		 // - GasistaRevision
		 EmpresaDeServicios empresa = new EmpresaDeServicios();
		 empresa.registrarEspecialista(1001, "Electricista1", "1144556677", "Electricidad");
		 empresa.registrarEspecialista(20, "Gasista" , "1144556688", "Gas");
		 empresa.registrarEspecialista(33, "Pintor1" , "1144556699", "Pintura");
		 empresa.registrarEspecialista(452, "Electricista2", "1144557700", "Electricidad");
		 empresa.registrarEspecialista(34, "Pintor2" , "1144557733", "Pintura");
		 
		 empresa.registrarCliente(30449448, "Cliente1", "1146651100");
		 empresa.registrarCliente(37223451, "Cliente2", "1146651111");
		 
		 int cli1_elec1=empresa.solicitarServicioElectricidad(30449448, 1001, "calle falsa 123", 700, 20);
		 int cli1_pintor1=empresa.solicitarServicioPintura( 30449448,33, "calle falsa 123", 24, 4500,2,18000,5000);
		 int cli2_elec2=empresa.solicitarServicioElectricidad(37223451,452,  "otra Calle 321", 650, 2);
		 int cli2_gasista=empresa.solicitarServicioGasistaInstalacion(37223451,20,  "bulevar 333", 3, 3200);
		 int cli1_elec2=empresa.solicitarServicioElectricidad(30449448,452,  "calle falsa 139", 650, 10);
		 
		 // El toString de empresa debe mostrar información útil, relevante y
		 // ordenada para que se pueda entender el estado actual del sistema.
		 System.out.println(empresa);
		 System.out.println();
		 
		 empresa.finalizarServicio(cli1_elec1, 30000); 
		 empresa.finalizarServicio(cli2_elec2, 10000);
		 empresa.finalizarServicio(cli1_elec2, 5000);
		 empresa.finalizarServicio(cli2_gasista, 1000);
		 empresa.cambiarResponsable(cli1_pintor1, 34);
		 
		 
		 
		 System.out.println("Cantidad de servicios realizados por tipo: ");
		 System.out.println(empresa.cantidadDeServiciosRealizadosPorTipo());
		 System.out.println();
		 System.out.println("Facturacion total en 'Electricidad': " +
		 empresa.facturacionTotalPorTipo("GasistaInstalacion"));
		 System.out.println();
		 System.out.println("Facturacion total: " + empresa.facturacionTotal());
		 System.out.println();
		 System.out.println("Servicios realizados por 'Electricista2': ");
		 System.out.println(empresa.listadoServiciosAtendidosPorEspecialista(20));
		 System.out.println();
		 System.out.println(empresa.finalizarServicio(cli1_pintor1, 1000));
		 
		 System.out.println(empresa.toString(empresa));
		}
	
	
	*/
	/*
	public static void main(String[] args) {
		String MiEmpresa = "Tano Construcciones";
		Empresa empresa = new Empresa(MiEmpresa);
		empresa.registrarCliente(40251258, "Abal Fernando", "+5491166684418", "Baroni 3999");
		empresa.registrarEspecialista(1, "Juan", "4444444", "Electricidad");
		empresa.registrarEspecialista(2, "Juanpablo", "4444446", "Gas");
		empresa.registrarEspecialista(3, "Juancruz", "4444477", "Pintura");
		empresa.solicitarServicioElectricidad(1, 40251258, "JoseLeonSuarez 2000",20,20);
		empresa.solicitarServicioElectricidad(1, 40251258, "JoseLeonSuarez 2000",10,30);
		empresa.solicitarServicioGasRevision(2, 40251258, "CalleDeTierra 1212",7,15);
		empresa.solicitarServicioGasInstalacion(2, 40251258, "CalleDeTierra 1212",7,15);
		empresa.solicitarServicioPintura(3, 40251258, "JoseLeonSuarez 2000",50,10);
		empresa.solicitarServicioPinturaEnAltura(3, 40251258, "JoseLeonSuarez 2000",50,10,5);
		System.out.println(empresa.getServ(1).getTipoServ());
		System.out.println(empresa.finalizarServicio(1,0));
		System.out.println(empresa.finalizarServicio(2,30));
		System.out.println(empresa.finalizarServicio(3,50));
		System.out.println(empresa.finalizarServicio(4,190));
		System.out.println(empresa.finalizarServicio(5,190));
		System.out.println(empresa.finalizarServicio(6,190));
		System.out.println(empresa.facturacionTotalPorTipo("Electricidad"));
		System.out.println(empresa.facturacionTotal());
		System.out.println(empresa.listadoServiciosAtendidosPorEspecialista(2));
		System.out.println(empresa.cantidadDeServiciosRealizadosPorTipo());
		*/
		/* 
	Interfaz
	/**
	* Registra un nuevo cliente en el sistema dado su:
	* - dni,
	* - nombre y
	* - teléfono de contacto.
	*
	* Si el dni ya está en el sistema se debe generar una
	* excepción.
	/
	public void registrarCliente(int dni, String nombre, String telefono) ;
	
	
	
	
	/**
	* Registra un nuevo especialista en el sistema dados su:
	* - nroEspecialista,
	* - nombre,
	* - teléfono y
	* - tipo De servicio en el que se especializa.
	*
	* Si el nroEspecialista ya está registrado en el sistema
	* se debe generar una excepción.
	/
	public void registrarEspecialista(int nroEspecialista, String nombre,
	 String telefono, String especialidad);
	/**
	* Se registra la prestación de un servicio de tipo Electricidad en el sistema
	* ingresando los datos necesarios para solicitar un servicio y además:
	* - precio por hora de trabajo del especialista
	* - cantidad de horas estimadas que llevará realizar el trabajo.
	* 
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio por hora o las horas de trabajo estimado son menores o
	* iguales a 0, se debe generar una excepción.
	/
	public int solicitarServicioElectricidad(int dni, int nroEspecialista,
	 String direccion, double precioPorHora,
	 int horasTrabajadas);
	/**
	* Se registra la prestación de un servicio de tipo Pintura en el sistema
	* ingresando los datos necesarios para solicitar un servicio y además:
	* - precio por pintar un metro cuadrado
	* - cantidad de metros cuadrados a pintar.
	* 
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio por metro cuadrado o los metros cuadrados son menores o
	* iguales a 0, se debe generar una excepción.
	5 de 7
	/
	public int solicitarServicioPintura(int dni, int nroEspecialista,
	 String direccion, int metrosCuadrados,
	 double precioPorMetroCuadrado);
	/**
	* Se registra la prestación de un servicio de tipo PinturaEnAltura en el
	* sistema ingresando los datos necesarios para solicitar un servicio y además:
	* - precio por pintar un metro cuadrado
	* - cantidad de metros cuadrados a pintar
	* - nro de piso en el que se realizará el trabajo.
	* - costo del seguro
	* - costo del alquiler de los andamios.
	* 
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio por metro cuadrado o los metros cuadrados o el piso o el costo
	* del seguro o el costo del alquiler de los andamios son menores o iguales a 0,
	* se debe generar una excepción.
	/
	public int solicitarServicioPintura(int dni, int nroEspecialista,
	 String direccion, int metrosCuadrados,
	 double precioPorMetroCuadrado, int piso,
	 double seguro, double alqAndamios);
	/**
	* Se registra la prestación de un servicio de tipo GasistaInstalacion en el
	* sistema ingresando los datos necesarios para solicitar un servicio y además:
	* - cantidad de artefactos a instalar
	* - precio por la instalación de un artefacto.
	* 
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio de instalación o la cantidad de artefactos a instalar son
	* menores o iguales a 0, se debe generar una excepción.
	/
	public int solicitarServicioGasistaInstalacion(int dni, int nroEspecialista,
	 String direccion, int cantArtefactos,
	 double precioPorArtefacto);
	/**
	* Se registra la prestación de un servicio de tipo GasistaRevison en el
	* sistema ingresando los datos necesarios para solicitar un servicio y además:
	* - cantidad de artefactos a revisar
	* - precio por la revisión de un artefacto.
	* 
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	6 de 7
	* una excepción.
	* Si el precio de instalación o la cantidad de artefactos a revisar son
	* menores o iguales a 0, se debe generar una excepción.
	/
	public int solicitarServicioGasistaRevision(int dni, int nroEspecialista,
	 String direccion, int cantArtefactos,
	 double precioPorArtefacto);
	/**
	* Se registra que el servicio solicitado ya fué concluido. Para esto se debe
	* ingresar el costo de los materiales utilizados para poder realizar el
	* trabajo.
	*
	* Se devuelve el precio que se debe facturar al cliente.
	* Este precio se obtiene sumando el costo de los materiales con el costo del
	* servicio realizado. Cada tipo de servicio tiene su forma de calcular el
	* costo del trabajo.
	* 
	* Si el código de servicio no está en el sistema o el mismo ya fué finalizado,
	* se debe generar una excepción.
	*
	* Se debe realizar esta operación en O(1).
	/
	public double finalizarServicio(int codServicio, double costoMateriales);
	/**
	* Devuelve un diccionario cuya clave es el tipo de servicio y el valor es la
	* cantidad de servicios realizados de ese tipo.
	* Si un tipo de servicio no tuvo ninguna demanda, el valor de esa entrada debe
	* ser 0.
	/
	public Map<String,Integer> cantidadDeServiciosRealizadosPorTipo();
	/**
	* Devuelve la suma del precio facturado de todos los servicios finalizados que
	* son del tipo pasado por parámetro.
	* Si el tipo de servicio es invalido, debe generar una excepción.
	*
	* Se debe realizar esta operación en O(1).
	/
	public double facturacionTotalPorTipo(String tipoServicio);
	/**
	* Devuelve la suma del precio facturado de todos los servicios finalizados que
	* realizó la empresa.
	/
	public double facturacionTotal();
	/**
	* Debe cambiar el especialista responsable del servicio.
	* Si código de Servicio o el nroEspecialista no están registrados en el sistema
	* se debe generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	*
	*
	* Se debe realizar esta operación en O(1).
	/
	public void cambiarResponsable(int codServicio, int nroEspecialista);
	7 de 7
	/**
	* Devuelve un String con forma de listado donde cada renglón representa un
	* servicio realizado.
	* Cada renglón debe respetar el siguiente formato:
	* " + [ codServicio - GasistaInstalacion ] Dirección"
	* por ejemplo:
	* " + [ 1492 - GasistaInstalacion ] uan María Gutiérrez 1150"
	* Si el nroEspecialista no está registrado en el sistema, se debe generar una
	* excepción.
	* Si el especialista no ha realizado ningún servicio hasta el momento, se debe
	* devolver un String vacío.
	/
	public String listadoServiciosAtendidosPorEspecialista(int nroEspecialista)
*/
		
}

