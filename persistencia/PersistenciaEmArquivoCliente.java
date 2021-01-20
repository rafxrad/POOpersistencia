package banco.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import banco.excecao.ClienteNaoEncontradoException;
import banco.modelo.ClientePessoaFisica;
import banco.modelo.ClientePessoaJuridica;
import banco.modelo.ICliente;

public class PersistenciaEmArquivoCliente implements IPersistenciaCliente{

	private List<ICliente> clientesCadastrados = new ArrayList<ICliente>();
	
	
	public PersistenciaEmArquivoCliente()
	{
		lerConteudoArquivo();
	}
	
	@Override
	public void cadastrarCliente(ICliente obj) {
		// TODO Auto-generated method stub
		//Trecho de código está impedindo de atualizar um elemento já existente 

			clientesCadastrados.add(obj);
			salvarEmArquivo();
		
	}

	@Override
	public ICliente localizarClientePorCPF(String cpf) throws ClienteNaoEncontradoException{
		// TODO Auto-generated method stub
		ICliente cliente = new ClientePessoaFisica(cpf);
		
		if(clientesCadastrados.contains(cliente))
		{
			int index = clientesCadastrados.indexOf(cliente);
			cliente = clientesCadastrados.get(index);
		}
		else
			throw new ClienteNaoEncontradoException("Cliente não encontrado!");
		return cliente;
	}

	@Override
	public ICliente localizarClientePorCNPJ(String cnpj) {
		// TODO Auto-generated method stub
		ICliente cliente = new ClientePessoaJuridica(cnpj);
		
		if(clientesCadastrados.contains(cliente))
		{
			int index = clientesCadastrados.indexOf(cliente);
			cliente = null;
			cliente =clientesCadastrados.get(index);
		}
		return cliente;
	}

	@Override
	public void removerCliente(ICliente obj) {
		// TODO Auto-generated method stub
		if(clientesCadastrados.contains(obj))
		{
			clientesCadastrados.remove(obj);
			salvarEmArquivo();
		}
			
		
		
	}
	
	private void salvarEmArquivo()
	{
		try 
		{
			FileOutputStream fos = new FileOutputStream("persistencia_cliente.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clientesCadastrados);
			oos.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void lerConteudoArquivo()
	{
		try 
		{
			FileInputStream fis = new FileInputStream("persistencia_cliente.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			clientesCadastrados = (ArrayList<ICliente>)obj;
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//de duas uma: iremos precisar alterar o equals ou declaramos um método privado para comprar os atributos dos objetos 
	
	//vou ver isso depois, ok?
	// certo. joia. até mais!
	// valeu pela atenção professor
	// blz

}