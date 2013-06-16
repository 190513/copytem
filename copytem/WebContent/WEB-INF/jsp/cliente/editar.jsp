<div class="row-fluid">
	<div class="span12">
		<div class="box">
			<div class="box-title">
				<h3>
					<i class="icon-list"></i>Adicionar Cliente
				</h3>
			</div>
			<div class="box-content nopadding">
				<form action="<c:url value="/cliente/edita"/>" method="POST"
					class='form-horizontal form-column form-bordered'>
					<div class="span6">
						<div class="control-group">
						<input type="hidden" name="cliente.id" value="${cliente.id }"
									placeholder="Nome/Fantasia do cliente" class="input-xlarge">
							<label for="textfield" class="control-label">Nome/Fantasia</label>
							<div class="controls">
								<input type="text" name="cliente.nome" value="${cliente.nome }" id="cliente.nome"
									placeholder="Nome/Fantasia do cliente" class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Tipo do cliente</label>
							<div class="controls">
								<label class='radio'> <input value="M²" type="radio"
									name="cliente.tipo" value="juridica"> Pessoa Jurídica
								</label> <label class='radio'> <input value="UN" type="radio"
									name="cliente.tipo" value="fisica"> Pessoa Física
								</label>
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">CNPJ</label>
							<div class="controls">
								<input type="text" name="cliente.cnpj" value="${cliente.cnpj }" id="cliente.cnpj"
									placeholder="CNPJ" class="input-large">
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">CPF</label>
							<div class="controls">
								<input type="text" name="cliente.cpf" value="${cliente.cpf }" id="cliente.cpf"
									placeholder="CPF" class="input-large">
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">E-mail</label>
							<div class="controls">
								<input type="text" name="cliente.email" value="${cliente.email }" id="cliente.email"
									placeholder="E-mail" class="input-Large">
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">Crédito </label>
							<div class="controls">
								<select name="cliente.credito" id="cliente.credito"
									class='input-medium'>
									<option value="0"></option>
									<option value="Liberado">Liberado</option>
									<option value="Aguardando">Aguardando</option>
								</select>
							</div>
						</div>
					</div>
					<div class="span6">
						<div class="control-group">
							<label for="textfield" class="control-label">Endereço</label>
							<div class="controls">
								<input type="text" value="${cliente.endereco }" name="cliente.endereco" id="cliente.endereco"
									placeholder="Endereço" class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">Bairro</label>
							<div class="controls">
								<input type="text" name="cliente.bairro" value="${cliente.bairro }" id="cliente.bairro"
									placeholder="Bairro" class="input-medium">
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">Cidade</label>
							<div class="controls">
								<input type="text" name="cliente.cidade" value="${cliente.cidade }" id="cliente.cidade"
									placeholder="Cidade" class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">Estado</label>
							<div class="controls">
								<input type="text" name="cliente.estado" value="${cliente.estado }" id="cliente.estado"
									placeholder="Estado" class="input-small">
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">CEP</label>
							<div class="controls">
								<input type="text" value="${cliente.cep }" name="cliente.cep"
									id="cliente.cep" placeholder="CEP"
									class="input-small">
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">Telefone</label>
							<div class="controls">
								<input type="text" value="${cliente.telResidencial }" name="cliente.telResidencial"
									id="cliente.telResidencial" placeholder="Telefone"
									class="input-small">
							</div>
						</div>
						<div class="control-group">
							<label for="textfield" class="control-label">Celular</label>
							<div class="controls">
								<input type="text" name="cliente.telCelular"
									id="cliente.telCelular" value="${cliente.telCelular }" placeholder="Celular"
									class="input-small">
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