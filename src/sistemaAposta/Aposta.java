package sistemaAposta;

public class Aposta {
	
	private String apostador;
	
	private boolean previsao;
	
	private int valor;
	
	public Aposta(String nome, int valor, boolean prev) {
		this.apostador = nome;
		this.previsao = prev;
		this.valor = valor;
	}
	
	public String getApostador() {
		return this.apostador;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public boolean getPrevisao() {
		return this.previsao;
	}
	
	@Override
	public String toString() {
		String complemento = previsao ? "N VAI ACONTECER": "VAI ACONTECER";
		return this.apostador + " - R$ " + this.valor + " - " + complemento;
	}
	
	/**
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		} else if (!this.getClass().equals(obj.getClass())) {
			return false;
		} else {
			Aposta aposta = (Aposta) obj;
			if (this.apostador.equals(aposta.apostador) && this.previsao == aposta.previsao) {
				return true;
			} else {
				return false;
			}
		} 
	}
	
	@Override
	public int hashCode() {
		return this.apostador.hashCode();
	}*/
	
}
