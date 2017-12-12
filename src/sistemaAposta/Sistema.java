package sistemaAposta;

import java.util.ArrayList;
import java.util.HashMap;

public class Sistema {
	
	private int dinheiroEmCaixa;
	
	private double taxa;
	
	private HashMap<String, Integer> descricoes;
	
	private HashMap<Integer, Cenario> cenarios;
	
	public Sistema(int qtdAtualDeDinheiro, double porcent) {
		this.dinheiroEmCaixa = qtdAtualDeDinheiro;
		this.taxa = porcent;
	}
	
	public int getDinheiroEmCaixa() {
		return this.dinheiroEmCaixa;
	}
	
	public int cadastrarCenario(String desc) {
		Cenario cena = new Cenario(desc);
		this.descricoes.put(desc, cena.getNum());
		this.cenarios.put(cena.getNum(), cena);
		return cena.getNum();
	}
	
	public String exibirCenario(int indice) {
		return this.cenarios.get(indice).toString();
	}
	
	public String exibirCenarios() {
		String saida = "";
		for(int i : this.cenarios.keySet()) {
			saida += this.cenarios.get(i).toString() + System.lineSeparator();
		}
		return saida;
	}
	
	public void cadastrarAposta(int cenario, String nome, String previsao, int valor) {
		boolean prev;
		if(previsao.equals("VAI ACONTECER")) {
			prev = true;
		} else {
			prev = false;
		}
		this.cenarios.get(cenario).cadastrarAposta(nome, prev, valor);
	}
	
	public int valorTotalDeApostas(int cenario) {
		int soma = 0;
		for (Aposta i : cenarios.get(cenario).getApostas()) {
			soma += i.getValor();
		}
		return soma;
	}
	
	public int totalDeAposta(int cenario) {
		return this.cenarios.get(cenario).getApostas().size();
	}
	
	public String exibeApostas(int cenario) {
		String saida = "";
		for (Aposta i : cenarios.get(cenario).getApostas()) {
			saida += i.toString() + System.lineSeparator();
		}
		return saida;
	}
	
	private int calculaCaixaCenario(int cenario) {
		double soma = 0;
		for(Aposta i : this.cenarios.get(cenario).getApostas()) {
			if(i.getPrevisao() == this.cenarios.get(cenario).getEstado()) {
				soma += this.taxa * i.getValor();
			}
		}
		return (int) Math.floor(soma);
	}
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		cenarios.get(cenario).setEstado(ocorreu);
		this.dinheiroEmCaixa += this.calculaCaixaCenario(cenario);
	}
	
	public int getCaixaCenario(int cenario) {
		return this.calculaCaixaCenario(cenario);
	}
	
	public int getTotalRateio(int cenario) {
		return this.valorTotalDeApostas(cenario) - calculaCaixaCenario(cenario);
	}
	
}