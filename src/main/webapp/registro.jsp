<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

</head>
<body>
	<div class="container">
		<h1 class="text-center p-3">Registro de Ordenes de Servicio</h1>

		<form class="p-3">
			<div class="mb-3">
				<label for="nombreCliente="form-label">Nombre de Cliente</label> <input
					type="text" class="form-control" name="nombreCliente">
			</div>
			<div class="mb-3">
				<label for="telefonoCliente" class="form-label">Telefono de
					Cliente</label> <input type="text" class="form-control"
					name="telefonoCliente">
			</div>
			<div class="mb-3">
				<label for="direccionCliente" class="form-label">Direccion
					de Cliente</label> <input type="text" class="form-control"
					name="direccionCliente">
			</div>
			<div class="mb-3">
				<label for="tipoElectrodomestico" class="form-label">Tipo de
					Electrodomestico</label> <select class="form-select"
					aria-label="Elegir Electrodomestico">
					<option selected>Selecciona</option>
					<option value="Lavadora">Lavadora</option>
					<option value="Refrigerador">Refrigerador</option>
					<option value="Microondas">Microondas</option>
				</select>
			</div>
			<div class="mb-3">
				<label for="estadoServicio" class="form-label">Estado del
					Servicio</label> <select class="form-select"
					aria-label="Elegir Estado del Servicio">
					<option selected>Selecciona</option>
					<option value="pendiente">Pendiente</option>
					<option value="enReparacion">En Reparacion</option>
					<option value="reparado">Reparado</option>
					<option value="sinSolucion">Sin Solucion</option>

				</select>
			</div>
			<div class="mb-3">
				<label for="estadoServicio" class="form-label">Estado del
					Servicio</label> <select class="form-select"
					aria-label="Elegir Estado del Servicio">
					<option selected>Selecciona</option>
					<option value="pendiente">Pendiente</option>
					<option value="enReparacion">En Reparacion</option>
					<option value="reparado">Reparado</option>
					<option value="sinSolucion">Sin Solucion</option>

				</select>
			</div>
			<div class="mb-3">
				<div class="col-5">
					<label for="date" class="col-1 col-form-label">Fecha
						Solicitud</label>
					<div class="input-group date" id="datepicker">
						<input type="text" class="form-control" id="date" /> <span
							class="input-group-append"> <span
							class="input-group-text bg-light d-block"> <i
								class="fa fa-calendar"></i>
						</span>
						</span>
					</div>
				</div>
				<div class="col-5">
					<label for="date" class="col-1 col-form-label">Fecha Actualizacion
					<div class="input-group date" id="datepicker">
						<input type="text" class="form-control" id="date" /> <span
							class="input-group-append"> <span
							class="input-group-text bg-light d-block"> <i
								class="fa fa-calendar"></i>
						</span>
						</span>
					</div>
				</div>
				
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
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