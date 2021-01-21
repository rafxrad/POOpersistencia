package banco.persistencia;


import banco.excecao.ClienteJaCadastradoException;
import banco.modelo.ICliente;

public interface IPersistenciaCliente {

	
	public void cadastrarCliente(ICliente obj);
	
	public ICliente localizarClientePorCPF(String cpf);
	
	public ICliente localizarClientePorCNPJ(String cnpj);
	
	public void removerCliente(ICliente obj);
}