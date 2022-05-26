package cl.talentodigital.modelo;

import java.time.LocalDate;

public class OrdenDeServicio {
	private int id;
	public TipoElectrodomestico tipoElectrodomestico;
	public EstadoServicio estadoServicio;
	LocalDate fechaSolicitud;
	LocalDate fechaActualizacion;
	public Cliente cliente;
	
	public OrdenDeServicio(int id, TipoElectrodomestico tipoElectrodomestico, EstadoServicio estadoServicio,
			LocalDate fechaSolicitud, LocalDate fechaActualizacion, Cliente cliente) {
		super();
		this.id = id;
		this.tipoElectrodomestico = tipoElectrodomestico;
		this.estadoServicio = estadoServicio;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaActualizacion = fechaActualizacion;
		this.cliente = cliente;
	}
	
	public OrdenDeServicio() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoElectrodomestico getTipoElectrodomestico() {
		return tipoElectrodomestico;
	}

	public void setTipoElectrodomestico(TipoElectrodomestico tipoElectrodomestico) {
		this.tipoElectrodomestico = tipoElectrodomestico;
	}

	public EstadoServicio getEstadoServicio() {
		return estadoServicio;
	}

	public void setEstadoServicio(EstadoServicio estadoServicio) {
		this.estadoServicio = estadoServicio;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public LocalDate getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDate fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	

}
