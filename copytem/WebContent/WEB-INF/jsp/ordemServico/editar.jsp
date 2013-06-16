<div class="row-fluid">
	<div class="span12">
		<div class="box">
			<div class="box-title">
				<h3>
					<i class="icon-list"></i>Adicionar Produto
				</h3>
			</div>
			<div class="box-content nopadding">
				<form action="<c:url value="/produto/edita"/>" method="POST"
					class='form-horizontal form-column form-bordered'>
					<div class="span6">
						<div class="control-group">
							<div class="controls">
								<input type="hidden" name="produto.id" value="${produto.id }"
									placeholder="Nome do produto" class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">Nome</label>
							<div class="controls">
								<input type="text" name="produto.nome" value="${produto.nome }"
									placeholder="Nome do produto" class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<label for="textarea" class="control-label">Descrição</label>
							<div class="controls">
								<textarea name="produto.descricao" value="${produto.descricao }"
									rows="5" class="input-block-level"
									placeholder="Descrição do produto"></textarea>
							</div>
						</div>
					</div>
					<div class="span6">
						<div class="control-group">
							<label for="textfield" class="control-label">Preço</label>
							<div class="controls">
								<div class="input-prepend">
									<span class="add-on">$</span> <input type="text"
										placeholder="preço" name="produto.preco"
										value="${produto.preco }">
								</div>
							</div>
						</div>
						<div class="control-group">
							<div class="control-group">
								<label class="control-label">Unidade de medida</label>
								<div class="controls">
									<label class='radio'> <input value="M²" type="radio"
										name="produto.unidadeMedida"> M²
									</label> <label class='radio'> <input value="UN" type="radio"
										name="produto.unidadeMedida"> UN
									</label>
								</div>
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">Categoria </label>
							<div class="controls">
								<select name="produto.categoria" text="${produto.descricao }"
									class='input-large'>
									<option value="0"></option>
									<option value="1">Categoria 1</option>
									<option value="2">Categoria 2</option>
									<option value="3">Categoria 3</option>
								</select>
							</div>
						</div>

					</div>
					<div class="span12">
						<div class="form-actions">
							<button type="submit" class="btn btn-primary">Salvar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>