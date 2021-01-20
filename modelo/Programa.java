package banco.modelo;

import javax.swing.JOptionPane;

import banco.excecao.ClienteNaoEncontradoException;
import banco.persistencia.IPersistenciaCliente;
import banco.persistencia.PersistenciaEmArquivoCliente;


public class Programa {
	
	public static void main(String[] args) {
		
		IPersistenciaCliente pac = new PersistenciaEmArquivoCliente();
		
		
		ICliente cliente1 = new ClientePessoaFisica("111");
		ICliente cliente2 = new ClientePessoaJuridica("456", "Empresa", "");
		
		IConta conta1 = new ContaCorrente("123", "BB", "10/10/10");
		
		cliente2.cadastrarConta(conta1);
		
		pac.cadastrarCliente(cliente1);
		pac.cadastrarCliente(cliente2);
		
		ICliente obj = null;
		try {
			obj = pac.localizarClientePorCPF("000");
		} catch (ClienteNaoEncontradoException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		ICliente obj2 = pac.localizarClientePorCNPJ("456");
		
		System.out.println(obj);
		System.out.println(obj2);
		
		//TEMA DA PRÓXIMA AULA, BLZ? VOU FAZER AQUI SÓ PRA VC CAMINHAR COM SUAS PERNAS....
		

	}
	
}