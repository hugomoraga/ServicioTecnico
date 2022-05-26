
<%@include file="includes/header.jsp"%>

<div class="container">
	<div class="col-md-8 offset-md-2">
	
	<%@page import="java.util.ArrayList"%>
	<%@page import="java.util.List"%>
	<%@page import="cl.talentodigital.daoimpl.ClienteDaoImpl"%>
	<%@page import="cl.talentodigital.daoimpl.OrdenDeServicioDaoImpl"%>

	<%@page import="cl.talentodigital.dao.IClienteDao"%>
	
    <%@page import="cl.talentodigital.dao.IOrdenDeServicioDao" %>
	
	<%@page import="cl.talentodigital.modelo.Cliente"%>
    <%@page import="cl.talentodigital.modelo.OrdenDeServicio"%>
	

	<%
	IClienteDao clienteDao = new ClienteDaoImpl();
	IOrdenDeServicioDao ordenesDao = new OrdenDeServicioDaoImpl();
	Cliente cliente = new Cliente();
	int clienteId = Integer.parseInt(request.getParameter("idCliente"));
	%>
	<%
	cliente = clienteDao.obtenerCliente(clienteId);
	List<Cliente> listaCliente = clienteDao.obtenerClientes();
	List<OrdenDeServicio> listaOrdenesCliente = ordenesDao.obtenerOrdenesdeCliente(cliente);
	%>

	<div class="py-3">
		<h1 class="py-2"> Listado de Ordenes</h1>
		<h3> <%= cliente.getNombre() %></h3>
		<%
	if (listaOrdenesCliente != null) {
	%>
	<table class="table table-striped table-hover shadow-sm ">

		<tr>
			<th>ID</th>
			<th>Electrodomestico</th>
			<th>Estado del Servicio</th>
			<th>Fecha Solicitud</th>
		    <th>Fecha Actualizacion</th>
		   			
			
			<th width="30%">Acciones</th>
		</tr>
		<%
		for (int i = 0; i < listaOrdenesCliente.size(); i++) {
		%>
		<tr>
			<td><%=listaOrdenesCliente.get(i).getId()%></td>
			<td><%=listaOrdenesCliente.get(i).getTipoElectrodomestico()%></td>
			<td><%=listaOrdenesCliente.get(i).getEstadoServicio()%></td>
			<td><%=listaOrdenesCliente.get(i).getFechaSolicitud()%></td>
			<td><%=listaOrdenesCliente.get(i).getFechaActualizacion()%></td>
			
			
			
			<td>

				<div class="row d-flex-inline ">
					<div class="col">
						<form action="modificarservicio.jsp" method="post">
							<input type="hidden" name="idOrden"
								value="<%=listaOrdenesCliente.get(i).getId()%>" /> 
							<input type="submit" name="accion" value="Modificar Orden de Servicio"
								class="btn btn-success" />

						</form>


					</div>
	
				</div>

			</td>
		</tr>
		<%
		}
		%>

	</table>

	<%
	} else {
	%>
	<p>No hay datos</p>
	<%
	}
	%>
	
	</div>

	</div>
</div>
<script>

</script>
</body>
</html>>