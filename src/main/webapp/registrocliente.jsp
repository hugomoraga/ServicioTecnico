
<%@include file="includes/header.jsp"%>

<div class="container">
	<div class="col-md-8 offset-md-2">
		<div class="card shadow-sm mt-3">
			<h1 class="text-center p-3 fs-2">Registro de Cliente</h1>

			<form class="p-3" action="registrocliente" method="post">
				<div class="mb-3">
					<label for="nombre="form-label">Nombre de Cliente</label> <input
						type="text" class="form-control" name="nombre">
				</div>
				<div class="mb-3">
					<label for="rut="form-label">Rut de Cliente</label> <input
						type="text" class="form-control" name="rut">
				</div>
				<div class="mb-3">
					<label for="telefono" class="form-label">Telefono de
						Cliente</label> <input type="text" class="form-control"
						name="telefono">
				</div>
				<div class="mb-3">
					<label for="direccion" class="form-label">Direccion
						de Cliente</label> <input type="text" class="form-control"
						name="direccion">
				</div>




				<button type="submit" class="btn btn-primary">Submit</button>

			</form>
		</div>

	</div>
</div>
<script>
	$(function() {
		$("#datepicker").datepicker({
			autoclose : true,
			todayHighlight : true
		}).datepicker('update', new Date());
	});
</script>
</body>
</html>