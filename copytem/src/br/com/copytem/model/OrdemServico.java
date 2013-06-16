package br.com.copytem.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordemServico")
public class OrdemServico {
		
	@Id
	@GeneratedValue
	private int id;
	private String data;
	private float precoFinal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "funcionario_venda_id")
	private Funcionario funcionarioVenda;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "funcionario_exec_id")
	private Funcionario funcionarioExec;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public float getPrecoFinal() {
		return precoFinal;
	}


	public void setPrecoFinal(float precoFinal) {
		this.precoFinal = precoFinal;
	}


	public Funcionario getFuncionarioVenda() {
		return funcionarioVenda;
	}


	public void setFuncionarioVenda(Funcionario funcionarioVenda) {
		this.funcionarioVenda = funcionarioVenda;
	}


	public Funcionario getFuncionarioExec() {
		return funcionarioExec;
	}


	public void setFuncionarioExec(Funcionario funcionarioExec) {
		this.funcionarioExec = funcionarioExec;
	}


	public Cliente getCliente() {
		return cliente;
	}

	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


}