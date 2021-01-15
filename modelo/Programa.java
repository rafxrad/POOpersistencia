package banco.modelo;

import banco.persistencia.IPersistenciaCliente;
import banco.persistencia.PersistenciaEmArquivoCliente;


public class Programa {
	
	public static void main(String[] args) {
		
		IPersistenciaCliente pac = new PersistenciaEmArquivoCliente();
		
		
		//ICliente cliente1 = new ClientePessoaFisica("111");
		ICliente cliente2 = new ClientePessoaJuridica("456");
		
		//pac.cadastrarCliente(cliente1);
		pac.cadastrarCliente(cliente2);
		
		//ICliente obj = pac.localizarClientePorCPF("000");
		ICliente obj2 = pac.localizarClientePorCNPJ("456");
		
		//System.out.println(obj);
		System.out.println(obj2);
		

	}
	
}