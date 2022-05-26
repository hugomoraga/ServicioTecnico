package cl.talentodigital.modelo;

public enum TipoElectrodomestico {
	LAVADORA(1, "Lavadora"), REFRIGERADOR(2, "Refrigerador"), MICROONDAS(3, "Microondas");

	private int id;
	private String nombre;
	
	private TipoElectrodomestico(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	private TipoElectrodomestico() {
		
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
	
	 public static TipoElectrodomestico fromId(int id) {
         for (TipoElectrodomestico type : values()) {
             if (type.getId() == id) {
                 return type;
             }
         }
         return null;
     }
	
}
