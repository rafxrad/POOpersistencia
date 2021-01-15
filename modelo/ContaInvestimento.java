package banco.modelo;


public class ContaInvestimento implements IConta{

	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	
	public ContaInvestimento(String numeroConta, String agencia, String dataAbertura) {
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = 0f;
		this.status = true;
		this.dataAbertura = dataAbertura;
	}

	@Override
	public void sacar(float valorSacado) {
		// TODO Auto-generated method stub
		if(valorSacado<=this.saldo && this.status)
		{
			this.saldo -= (valorSacado + (valorSacado*CUSTO_SACAR_CONTA_INVESTIMENTO));
		}
	}
	

	@Override
	public void depositar(float valorDepositado) {
		// TODO Auto-generated method stub
		if(valorDepositado>0 && this.status)
		{
			this.saldo += valorDepositado;
		}
	}
	
	@Override
	public void desativarConta() {
		// TODO Auto-generated method stub
		this.status = false;
	}

	@Override
	public void transferencia(IConta contaDestino, float valorTransferido){
		// TODO Auto-generated method stub		
		if(contaDestino != null)
		{
			 if (valorTransferido <= this.saldo && this.status == true) {
				 contaDestino.depositar(valorTransferido);
				 this.saldo -= valorTransferido;
			 }
		}
	}
	
	@Override
	public void ativarConta() {
		// TODO Auto-generated method stub
		this.status = true;
	}

	@Override
	public String toString() {
		return "ContaInvestimento [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo
				+ ", status=" + status + ", dataAbertura=" + dataAbertura + "]";
	}
	
}
	
