package cl.talentodigital.modelo;

public class Cliente {
	private int id;
	private String nombre;
	private String rut;
	private int telefono;
	private String direccion;
	
	
	public Cliente(int id, String nombre, String rut, int telefono, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rut = rut;
		this.telefono = telefono;
		this.direccion = direccion;
		
	}
	
	public Cliente() {
		
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
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

}
