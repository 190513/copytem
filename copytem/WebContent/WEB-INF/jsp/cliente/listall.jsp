<div class="row-fluid">
	<div class="span12 class="theme-lightgrey"">
		<div class="box-title">
			<h3>
				<i class="icon-table"></i> Clientes
			</h3>
		</div>
		<div class="box-content nopadding">
			<table
				class="table table-hover table-nomargin dataTable table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome/Fantasia</th>
						<th>CNPJ</th>
						<th>CPF</th>
						<th>E-mail</th>
						<th>CEP</th>
						<th>Telefone</th>
						<th>Celular</th>
						<th>Editar</th>
						<th>Excluir</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${clienteList}" var="cliente">
						<tr>
							<td>${cliente.id}</td>
							<td>${cliente.nome}</td>
							<td>${cliente.cnpj}</td>
							<td>${cliente.cpf}</td>
							<td>${cliente.email}</td>
							<td>${cliente.cep}</td>
							<td>${cliente.telResidencial}</td>
							<td>${cliente.telCelular}</td>
							<td><a
								href="<c:url value="/cliente/editar?id=${cliente.id }"/>"
								class="glyphicon-edit"></a></td>
							<td><a
								href="<c:url value="/cliente/deletar?id=${cliente.id }"/>"
								class="glyphicon-delete" data-toggle="modal"></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
