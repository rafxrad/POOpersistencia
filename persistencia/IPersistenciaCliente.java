package banco.persistencia;


import banco.excecao.ClienteNaoEncontradoException;
import banco.modelo.ICliente;

public interface IPersistenciaCliente {

	
	public void cadastrarCliente(ICliente obj);
	
	public ICliente localizarClientePorCPF(String cpf) throws ClienteNaoEncontradoException;
	
	public ICliente localizarClientePorCNPJ(String cnpj);
	
	public void removerCliente(ICliente obj);
}