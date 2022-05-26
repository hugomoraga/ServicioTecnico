<%@include file="includes/header.jsp"%>


<div class="container">

	<%@page import="java.util.ArrayList"%>
	<%@page import="java.util.List"%>
	<%@page import="cl.talentodigital.daoimpl.ClienteDaoImpl"%>
	<%@page import="cl.talentodigital.dao.IClienteDao"%>
	<%@page import="cl.talentodigital.modelo.Cliente"%>

	<%
	IClienteDao clienteDao = new ClienteDaoImpl();
	%>
	<%
	List<Cliente> listaCliente = clienteDao.obtenerClientes();
	%>

	<div class="py-3">
		<h1 class="py-2"> Listado de Clientes</h1>
		<%
	if (listaCliente != null) {
	%>
	<table class="table table-striped table-hover shadow-sm ">

		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Telefono</th>
			<th>Direccion</th>
			
			<th width="30%">Acciones</th>
		</tr>
		<%
		for (int i = 0; i < listaCliente.size(); i++) {
		%>
		<tr>
			<td><%=listaCliente.get(i).getId()%></td>
			<td><%=listaCliente.get(i).getNombre()%></td>
			<td><%=listaCliente.get(i).getTelefono()%></td>
			<td><%=listaCliente.get(i).getDireccion()%></td>
			
			<td>

				<div class="row d-flex-inline ">
					<div class="col">
						<form action="registroservicio.jsp" method="post">
							<input type="hidden" name="idCliente"
								value="<%=listaCliente.get(i).getId()%>" /> <input
								type="submit" name="accion" value="Agregar Orden de Servicio"
								class="btn btn-success" />

						</form>


					</div>
					<div class="col">
						<form action="ordenesporcliente.jsp" method="post">
							<input type="hidden" name="idCliente"
								value="<%=listaCliente.get(i).getId()%>" /> <input
								type="submit" name="accion" value="Ver Ordenes"
								class="btn btn-info" />

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


</body>
</html>