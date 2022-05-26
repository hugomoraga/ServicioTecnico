

<%@include file="includes/header.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="cl.talentodigital.daoimpl.ClienteDaoImpl"%>
<%@page import="cl.talentodigital.daoimpl.OrdenDeServicioDaoImpl"%>

<%@page import="cl.talentodigital.dao.IOrdenDeServicioDao"%>
<%@page import="cl.talentodigital.dao.IClienteDao"%>

<%@page import="cl.talentodigital.modelo.Cliente"%>
<%@page import="cl.talentodigital.modelo.OrdenDeServicio"%>
<%
IOrdenDeServicioDao ordenDeServicioDao = new OrdenDeServicioDaoImpl();
%>
<%
IClienteDao clienteDao = new ClienteDaoImpl();
%>

<%
Cliente cliente = new Cliente();
%>
<%
String idStringCliente = request.getParameter("idCliente");
%>
<%
int idCliente = Integer.parseInt(idStringCliente);
%>

<%
cliente = clienteDao.obtenerCliente(idCliente);
%>


<div class="container">
	<h1 class="text-center p-3">Registro de Ordenes de Servicio</h1>


	<form class="p-3" action="registroservicio" method="post">
		<h5 class="mb-3">
			<strong>Cliente: </strong><%=cliente.getNombre()%>
		</h5>
		<h5 class="mb-3">
			<Strong>Direccion: </Strong>
			<%=cliente.getDireccion()%>
		</h5>
		<h5 class="mb-3">
			<Strong>Nueva orden de servicio: </Strong>
		</h5>

		<div class="mb-3">
			<label for="tipoElectrodomestico" class="form-label">Tipo de Electrodomestico</label> 
			<select name="tipoElectrodomestico" class="form-select" aria-label="Elegir Electrodomestico">
				<option value="1">Lavadora</option>
				<option value="2">Refrigerador</option>
				<option value="3">Microondas</option>
			</select>
		</div>
		<div class="mb-3">
			<label for="estadoServicio" class="form-label">Estado del Servicio</label> 
			<select name="estadoServicio" class="form-select" aria-label="Elegir Estado del Servicio">
S				<option value="1">Pendiente</option>
				<option value="2">En Reparacion</option>
				<option value="3">Reparado</option>
				<option value="4">Sin Solucion</option>

			</select>
		</div>

		<div class="mb-3">
			<div class="row">
				<div class="col-6">
					<label for="date" class="col-form-label">Fecha
						Solicitud</label>
					<div class="input-group date" id="dateSolicitud">
						<input type="text" class="form-control" id="fechaSolicitud" name="fechaSolicitud" /> <span
							class="input-group-append"> <span
							class="input-group-text bg-light d-block"> <i
								class="fa fa-calendar"></i>
						</span>
						</span>
					</div>
				</div>
								<div class="col-6">
					<label for="date" class="col-form-label">Fecha
						Actualizacion</label>
					<div class="input-group date" id="dateActualizacion">
						<input type="text" class="form-control" id="fechaActualizacion" name="fechaActualizacion" /> <span
							class="input-group-append"> <span
							class="input-group-text bg-light d-block"> <i
								class="fa fa-calendar"></i>
						</span>
						</span>
					</div>
				</div>
				
			</div>

		</div>
		<input type="hidden" value="<%=cliente.getId()%>" name="idCliente" />
		
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<script>
	$(function() {
		$("#dateSolicitud").datepicker({
			autoclose : true,
			todayHighlight : true
		}).datepicker('update', new Date());
		$("#dateActualizacion").datepicker({
			autoclose : true,
			todayHighlight : true
		}).datepicker('update', new Date());
	});
</script>
</body>
</html>