<div class="row-fluid">
	<div class="span12">
		<div class="box">
			<div class="box-title">
				<h3>
					<i class="icon-list"></i>Adicionar Funcionário
				</h3>
			</div>
			<div class="box-content nopadding">
				<form action="<c:url value="/funcionario/edita"/>" method="POST"
					class='form-horizontal form-column form-bordered'>
					<div class="span6">
						<div class="control-group">
							<div class="controls">
								<input type="hidden" name="funcionario.id" value="${funcionario.id }"
									placeholder="Nome do produto" class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">Nome</label>
							<div class="controls">
								<input type="text" name="funcionario.nome"
									value="${funcionario.nome }" id="funcionario.nome"
									placeholder="Nome do funcionário" class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">CPF</label>
							<div class="controls">
								<input value="${funcionario.cpf }" type="text" name="funcionario.cpf" id="funcionario.cpf"
									placeholder="CPF" class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">Data de
								Nascimento</label>
							<div class="controls">
								<input value="${funcionario.dataNascimento }" type="text" name="funcionario.dataNascimento"
									id="funcionario.dataNascimento"
									placeholder="Data de nascimento" class="input-medium">
							</div>
						</div>
					</div>
					<div class="span6">
						<div class="control-group">
							<label for="textfield" class="control-label">Telefone</label>
							<div class="controls">
								<input value="${funcionario.telefone }" type="text" name="funcionario.telefone"
									id="funcionario.telefone" placeholder="Telefone"
									class="input-medium">
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">Perfil </label>
							<div class="controls">
								<select name="cliente.credito" id="funcionario.perfil"
									class='input-medium'>
									<option value="0"></option>
									<option value="vendedor">Vendedor</option>
									<option value="gerente">Gerente</option>
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