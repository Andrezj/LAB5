import static org.junit.Assert.*;

import org.junit.Test;

import sistemaAposta.Aposta;

public class ApostaTest {

	@Test
	public void criaApostasComuns() {
		Aposta ap = new Aposta("Cesar", 1000, true);
		Aposta ap1 = new Aposta("Cesar", 0, false);
		Aposta ap2 = new Aposta("Anonimo", 1, true);
		Aposta ap3 = new Aposta("C", 1000, true);
		Aposta ap4 = new Aposta("Caio", 10000, true);
		Aposta ap5 = new Aposta("Caio", 10000, false);
	}
	
	@Test(expected=NullPointerException.class)
	public void testaApostaComValorNegativo() {
		Aposta ap = new Aposta("Cesar", -100, true);
	}

}
