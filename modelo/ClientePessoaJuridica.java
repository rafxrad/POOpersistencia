package banco.modelo;

import java.io.Serializable;
import java.util.ArrayList;  
import java.util.HashSet;
import java.util.List;

public class ClientePessoaJuridica implements ICliente, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String cnpj;
	String nome;
	String dataNascimento;
	String email;
	
	HashSet<String> telefones = new HashSet<String>();
	
	private List<IConta> contas = new ArrayList<IConta>();
	
	public ClientePessoaJuridica(String cnpj, String nome, String dataNascimento) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public ClientePessoaJuridica(String cnpj)
	{
		this.cnpj = cnpj;
	}

	

	@Override
	public String toString() {
		return "Cliente [cnpj=" + cnpj + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", telefones="
				+ telefones + ", contas=" + contas + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		ClientePessoaJuridica other = (ClientePessoaJuridica) obj;
		if (this.cnpj == null) 
		{
			if (other.cnpj != null)
			{
				return false;
			}
		} else if (!this.cnpj.equals(other.cnpj))
		{
			return false;
		}
		return true;
	}
	
	
	protected void adicionarContaCliente(IConta contaCliente)
	{
		this.contas.add(contaCliente);
	}
	
	public boolean contemContaCliente(IConta conta)
	{
		return this.contas.contains(conta);
	}
	
	public void removerConta(IConta conta)
	{
		if(contas.contains(conta))
		{
			contas.remove(conta);
			System.out.println("Conta removida com sucesso!");
		}
		else
		{
			System.out.println("Conta inexistente!");
		}
	}
	
	public void adicionarTelefone(String telefone)
	{
		this.telefones.add(telefone);
	}
	
	public void removerTelefone(String telefone)
	{
		if(telefones.contains(telefone))
		{
			telefones.remove(telefone);
		}
		else
		{
			System.out.println("Cliente nao tem o referido telefone");
		}
	}
	
}
