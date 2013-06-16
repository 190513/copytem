<div class="theme-lightgrey box box-bordered" style="width: 550px; margin: 0 0 0 2px; float: left;">
	<div class="box-title">
		<h3><i class="icon-table"></i> Produtos</h3>
	</div>
	<div class="box-content nopadding">
		<table class="table table-condensed" id="produto" style="text-align: center;">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>UN. Medida</th>
					<th>Preço</th>
					<th>Descrição</th>
					<th>Comprar</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</div>

<div class="theme-lightgrey box box-bordered" style="width: 450px; float: right; margin: 0 3px 0 0;">
			<div class="box-title">
				<h3><i class="icon-list"></i>Ordem de Serviço</h3>
			</div>
			<div class="box-content nopadding">
				<form action="<c:url value="/ordemServico/adiciona"/>" method="POST"
					class='form-horizontal form-column form-bordered'>
					<div class="span6">
						<div class="control-group">
							<label for="ordemServicoCliente" class="control-label">Cliente</label>
							<div class="controls">
								<input id="item_id" type="hidden" name="ordemServico.cliente.id" class="input-mini" /> 
								<input id="ordemServicoCliente" type="text" class="input-large" />
							</div>
						</div>
						<div class="control-group">
							<label for="ordemServicoData" class="control-label">Data</label>
							<div class="controls">
								<input id="ordemServicoData" type="text"
									name="ordemServico.data" class="input-small" />
							</div>
						</div>
						
					</div>

					<div class="span6">
						<div class="control-group">
							<label for="ordemServicoFuncionario" class="control-label">Vendedor</label>
							<div class="controls">
								<input id="ordemServicoFuncionario" type="text"
									name="ordemServico.funcionario" class="input-large" />
							</div>
						</div>
						<div class="control-group">
							<label for="ordemServicoFuncionario" class="control-label">Funcionário</label>
							<div class="controls">
								<input id="ordemServicoFuncionario" type="text"
									name="ordemServico.funcionario" class="input-large" />
							</div>
						</div>
						<div class="control-group">

							<div class="controls">
								<button type="submit" class="btn btn-primary">Salvar</button>
							</div>
						</div>

					</div>

				</form>
			</div>
			
			<div class="box-content nopadding">
				<table class="table table-condensed">
								<thead>
									<tr>
										<th>Nome</th>
										<th>Descrição</th>
										<th>Preço</th>
										<th>Qtde</th>
										<th>Total</th>
										<th>Excluir</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${carrinho.itens}" var="item" varStatus="s">
										<tr>
											<td>${item.produto.nome }</td>
											<td>${item.produto.descricao }</td>
											<td><fmt:formatNumber type="currency"
													value="${item.produto.preco }" /></td>
											<td>${item.quantidade }</td>
											<td><fmt:formatNumber type="currency"
													value="${item.quantidade * item.produto.preco }" /></td>
	
											<td style="text-align: center;">
												<form action="<c:url value="/carrinho/${s.index }"/>" method="POST">
													<button name="_method" value="DELETE"  style=" border: none; background: none; cursor: pointer;"><i class="icon-remove"></i></button>
												</form>
											</td>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="2"></td>
										<th colspan="2">Total:</th>
										<th><fmt:formatNumber type="currency"
												value="${carrinho.total }" /></th>
									</tr>
								</tfoot>
							</table>
						</div>			
		</div>

<script>
	$(function() {
		function log(message) {
			$("<div>").text(message).prependTo("#log");
			$("#log").scrollTop(0);
		}

		$("#ordemServicoCliente")
				.autocomplete(
						{
							source : function(request, response) {
								$
										.ajax({
											url : "<c:url value="/cliente/busca.json"/>",
											//url: "http://ws.geonames.org/searchJSON",
											dataType : "json",
											data : {
												featureClass : "P",
												style : "full",
												maxRows : 12,
												name_startsWith : request.term
											},
											success : function(data) {
												response($
														.map(
																data,
																function(item) {
																	document
																			.getElementById("item_id").value = item.id;
																	return {
																		label : item.nome,
																		value : item.nome,
																		id : item.id,
																	};

																}));
											}
										});
							},
							minLength : 2,
							select : function(event, ui) {//aqui é quando seleciona o valor

								log(ui.item ? "Selected: " + ui.item.label
										: "Nothing selected, input was "
												+ this.value);
							},
							open : function() {
								$(this).removeClass("ui-corner-all").addClass(
										"ui-corner-top");
							},
							close : function() {
								$(this).removeClass("ui-corner-top").addClass(
										"ui-corner-all");
							}

						}

				);

	});
</script>
