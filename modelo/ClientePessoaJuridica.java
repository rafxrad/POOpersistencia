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
	String razaoSocial;
	String nomeFantasia;
	String email;
	
	
	HashSet<String> telefones = new HashSet<String>();
	
	private List<IConta> contas = new ArrayList<IConta>();
	
	public ClientePessoaJuridica(String cnpj) {
		this.cnpj = cnpj;
		
	}
	

	public ClientePessoaJuridica(String cnpj, String razaoSocial, String nomeFantasia, String email){
		
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.email = email;
	
	}



	@Override
	public String toString() {
		return "ClientePessoaJuridica [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia
				+ ", email=" + email + ", telefones=" + telefones + ", contas=" + contas + "]";
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientePessoaJuridica other = (ClientePessoaJuridica) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}


	public void adicionarContaCliente(IConta contaCliente)
	{
		this.contas.add(contaCliente);
		System.out.println("Conta adicionada com sucesso!");
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
	

