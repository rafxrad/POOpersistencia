package banco.modelo;

public interface ICliente {

	
	public void adicionarContaCliente(IConta contaCliente);
	
	public void adicionarTelefone(String telefone);
	
	public void removerTelefone(String telefone);
	
	public boolean contemContaCliente(IConta contaCliente);
	
	public void removerConta(IConta conta);
	
	

}
