<div class="row-fluid">
	<div class="span12 class="theme-lightgrey"">
		<div class="box-title">
			<h3>
				<i class="icon-table"></i> Produtos
			</h3>
		</div>
		<div class="box-content nopadding">
			<table
				class="table table-hover table-nomargin dataTable table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Descrição</th>
						<th>Unidade</th>
						<th>Preço</th>
						<th>Editar</th>
						<th>Excluir</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${produtoList}" var="produto">
						<tr>
							<td>${produto.id}</td>
							<td>${produto.nome}</td>
							<td>${produto.descricao}</td>
							<td>${produto.unidadeMedida}</td>
							<td>${produto.preco}</td>
							<td><a
								href="<c:url value="/produto/editar?id=${produto.id }"/>"
								class="glyphicon-edit"></a></td>
							<td><a
								href="<c:url value="/produto/deletar?id=${produto.id }"/>"
								class="glyphicon-delete" data-toggle="modal"></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
