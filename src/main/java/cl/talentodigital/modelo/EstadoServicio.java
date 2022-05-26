package cl.talentodigital.modelo;

public enum EstadoServicio {
	PENDIENTE(1, "Pendiente"), ENREPARACION(2, "En Reparacion"), REPARADO(3, "Reparado"), SINSOLUCION(4, "Sin Solucion");
	
	private int id;
	private String nombre;
	private EstadoServicio(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static EstadoServicio fromId(int id) {
		for (EstadoServicio type: values()) {
			 if (type.getId() == id) {
                 return type;
             }
         }
         return null;
	}

}
