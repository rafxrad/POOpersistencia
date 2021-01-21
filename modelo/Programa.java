package banco.modelo;

import javax.swing.JOptionPane;

import banco.excecao.ClienteJaCadastradoException;
import banco.persistencia.IPersistenciaCliente;
import banco.persistencia.PersistenciaEmArquivoCliente;


public class Programa {
	
	public static void main(String[] args) {
		
		PersistenciaEmArquivoCliente pac = new PersistenciaEmArquivoCliente();
		
		 	// Criando clientes
		
			ICliente pj1 = new ClientePessoaJuridica("033", "Bla", "Blue", "@");
			ICliente pf1 = new ClientePessoaFisica("032", "Rafa", "12/08/93", "rwsc@discente");
			
			// Print clientes com informações iniciais
			
			System.out.println(pj1);
			System.out.println(pf1);
			
			// Cadastrando clientes na persistência
			pac.cadastrarCliente(pf1);
			pac.cadastrarCliente(pj1);
			
			// Criando contas
			
			IConta conta1 = new ContaCorrente("1A", "BB", "12/02/21");
			IConta conta2 = new ContaPoupanca("2A", "BB", "12/02/21");
			
			// Localizando clientes por CNPJ e CPF
		
			ICliente obj = pac.localizarClientePorCNPJ("033");
			ICliente obj2 = pac.localizarClientePorCPF("032");
			
			
			// Associando contas aos clientes
			pj1.adicionarContaCliente(conta1);
			pf1.adicionarContaCliente(conta2);
			
			// Adicionando telefones
			
			pj1.adicionarTelefone("82-90183190");
			pj1.adicionarTelefone("894132166");
			pf1.adicionarTelefone("908099089");
			
			
			// Exibindo informações finais dos clientes
			System.out.println(pj1);
			System.out.println(pf1);
			
	}
	
}