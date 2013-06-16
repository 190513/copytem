<div class="row-fluid">
	<div class="span12 class="theme-lightgrey"">
		<div class="box-title">
			<h3>
				<i class="icon-table"></i> Funcionários
			</h3>
		</div>
		<div class="box-content nopadding">
			<table
				class="table table-hover table-nomargin dataTable table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>CPF</th>
						<th>Data Nascimento</th>
						<th>Perfil</th>
						<th>Editar</th>
						<th>Excluir</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${funcionarioList}" var="funcionario">
						<tr>
							<td>${funcionario.id}</td>
							<td>${funcionario.nome}</td>
							<td>${funcionario.cpf}</td>
							<td>${funcionario.dataNascimento}</td>
							<td>${funcionario.perfil }
							<td><a
								href="<c:url value="/funcionario/editar?id=${funcionario.id }"/>"
								class="glyphicon-edit"></a></td>
							<td><a
								href="<c:url value="/funcionario/deletar?id=${funcionario.id }"/>"
								class="glyphicon-delete" data-toggle="modal"></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
