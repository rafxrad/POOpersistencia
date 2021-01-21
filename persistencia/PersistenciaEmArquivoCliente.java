package banco.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import banco.excecao.ClienteJaCadastradoException;
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
		if(!clientesCadastrados.contains(obj)) {
			clientesCadastrados.add(obj);
			salvarEmArquivo();
		}
	}

	@Override
	public ICliente localizarClientePorCPF(String cpf) {
		// TODO Auto-generated method stub
		ICliente cliente = new ClientePessoaFisica(cpf);
		
		if(clientesCadastrados.contains(cliente))
		{
			int index = clientesCadastrados.indexOf(cliente);
			cliente = clientesCadastrados.get(index);
		}

		return cliente;
	}

	@Override
	public ICliente localizarClientePorCNPJ(String cnpj) {
		// TODO Auto-generated method stub
		ICliente cliente = new ClientePessoaJuridica(cnpj);
		
		if(clientesCadastrados.contains(cliente))
		{
			int index = clientesCadastrados.indexOf(cliente);
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	

}