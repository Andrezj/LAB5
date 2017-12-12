package sistemaAposta;

import java.util.ArrayList;

public class Cenario {
	
	private String descricao;
	
	private String msg;
	
	private boolean estado;
	
	private static int contaInstancia = 0;
	
	private int numeracao;
	
	private ArrayList<Aposta> apostas;
	
	public Cenario(String desc) {
		this.descricao = desc;
		this.msg = "Nao Finalizado";
		Cenario.contaInstancia++;
		this.numeracao = contaInstancia;
	}
	
	public void cadastrarAposta(String nome, boolean prev, int valor) {
		Aposta ap = new Aposta(nome, valor, prev);
		this.apostas.add(ap);
	}
	
	public ArrayList<Aposta> getApostas(){
		return this.apostas;
	}
	
	public void setEstado(boolean ocorreu) {
		this.estado = ocorreu;
		String complemento = ocorreu ? " (n ocorreu)": " (ocorreu)";
		this.msg = "Finalizado";
		this.msg += complemento;
	}
	
	public boolean getEstado() {
		return this.estado;
	}
	
	public String getDesc() {
		return this.descricao;
	}
	
	public int getNum() {
		return this.numeracao;
	}
	
	@Override
	public String toString() {
		return String.join(" - ", Integer.toString(this.numeracao), this.descricao, this.msg);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		} else if (!this.getClass().equals(obj.getClass())) {
			return false;
		} else {
			Cenario cenario = (Cenario) obj;
			if (this.descricao.equals(cenario.descricao)) {
				return true;
			} else {
				return false;
			}
		} 
	}
	
	@Override
	public int hashCode() {
		return this.descricao.hashCode();
	}
	
}
