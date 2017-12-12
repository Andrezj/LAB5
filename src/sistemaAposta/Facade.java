package sistemaAposta;

import java.util.HashMap;
import java.util.HashSet;

public class Facade {
	
	private Sistema sys;
	
	public Facade() {

	}
	
	public void inicializarSystema(int caixa, int taxa){
		this.sys = new Sistema(caixa, taxa);
	}
	
	public int getCaixa() {
		return this.sys.getDinheiroEmCaixa();
	}
	
	public int cadastrarCenario(String desc) {
		return this.sys.cadastrarCenario(desc);
	}
	
	public String exibirCenario(int cenario) {
		return this.sys.exibirCenario(cenario);
	}
	
	public String exibirCenarios() {
		return this.sys.exibirCenarios();
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.sys.cadastrarAposta(cenario, apostador, previsao, valor);
	}
	
	public int valorTotalDeAposta(int cenario) {
		return this.sys.valorTotalDeApostas(cenario);
	}
	
	public int totalDeApostas(int cenario) {
		return this.sys.totalDeAposta(cenario);
	}
	
	public String exibeApostas(int cenario) {
		return this.sys.exibeApostas(cenario);
	}
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.sys.fecharAposta(cenario, ocorreu);
	}
	
	public int getCaixaCenario(int cenario) {
		return this.sys.getCaixaCenario(cenario);
	}
	
	public int getTotalRateio(int cenario) {
		return this.sys.getTotalRateio(cenario);
	}
}
