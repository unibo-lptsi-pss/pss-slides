package a02a.e1;

import static org.junit.Assert.*;
import java.util.*;

public class Test {
	
	/*
	 * Implementare l'interfaccia SequenceAcceptor fornita tramite una classe SequenceAcceptorImpl con costruttore senza argomenti.
	 * Realizza un concetto di consumatore di sequenze infinite di numeri interi.
	 * Sono possibili un insieme finito di sequenze, indicate nella enum SequenceAcceptor.Sequence.
	 * Il metodo reset in SequenceAcceptor serve per reiniziare la sequenza, così da consumare una sequenza daccapo.
	 * Il commento al codice di SequenceAcceptor, e i metodi di test qui sotto costituiscono la necessaria spiegazione del 
	 * problema.
	 * 
	 * Si noti che i test con annotazione @org.junit.Test(expected = ...) passano solo se viene lanciata l'eccezione indicata nei ...
	 * Si noti che i test con annotazione @org.junit.Test passano se non viene lanciata alcuna eccezione
	 * 
	 * Sono considerati opzionali ai fini della possibilità di correggere l'esercizio, ma concorrono comunque al raggiungimento 
	 * della totalità del punteggio:
	 * - implementazione dei test chiamati optionalTestXYZ (relativi ai metodi di reset e alla sequenza Fibonacci) 
	 * - la buona progettazione della soluzione, in particolare con minimizzazione di ripetizioni
	 * 
	 */
	
	/*
	
	@org.junit.Test
	public void testPower2OK() {
		final SequenceAcceptor sa = new SequenceAcceptorImpl();
		sa.reset(SequenceAcceptor.Sequence.POWER2);
		sa.acceptElement(1);
		sa.acceptElement(2);
		sa.acceptElement(4);
		sa.acceptElement(8);
		sa.acceptElement(16);
	}
	
	@org.junit.Test(expected = IllegalStateException.class)
	public void testPower2NO() {
		final SequenceAcceptor sa = new SequenceAcceptorImpl();
		sa.reset(SequenceAcceptor.Sequence.POWER2);
		sa.acceptElement(1);
		sa.acceptElement(2);
		sa.acceptElement(4);
		sa.acceptElement(8);
		sa.acceptElement(17); // da rifiutare con lancio d'eccezione
	}
	
	@org.junit.Test
	public void testFlipOK() {
		final SequenceAcceptor sa = new SequenceAcceptorImpl();
		sa.reset(SequenceAcceptor.Sequence.FLIP);
		sa.acceptElement(1);
		sa.acceptElement(0);
		sa.acceptElement(1);
		sa.acceptElement(0);
		sa.acceptElement(1);
	}
	
	@org.junit.Test(expected = IllegalStateException.class)
	public void testFlipNO() {
		final SequenceAcceptor sa = new SequenceAcceptorImpl();
		sa.reset(SequenceAcceptor.Sequence.FLIP);
		sa.acceptElement(1);
		sa.acceptElement(0);
		sa.acceptElement(1);
		sa.acceptElement(0);
		sa.acceptElement(0); // da rifiutare
	}
	
	@org.junit.Test
	public void testRambleOK() {
		final SequenceAcceptor sa = new SequenceAcceptorImpl();
		sa.reset(SequenceAcceptor.Sequence.RAMBLE);
		sa.acceptElement(0);
		sa.acceptElement(1);
		sa.acceptElement(0);
		sa.acceptElement(2);
		sa.acceptElement(0);
		sa.acceptElement(3);
	}
	
	@org.junit.Test(expected = IllegalStateException.class)
	public void testRambleNO() {
		final SequenceAcceptor sa = new SequenceAcceptorImpl();
		sa.reset(SequenceAcceptor.Sequence.RAMBLE);
		sa.acceptElement(0);
		sa.acceptElement(1);
		sa.acceptElement(0);
		sa.acceptElement(2);
		sa.acceptElement(0);
		sa.acceptElement(0); // da rifiutare
	}
	
	// da qui in poi solo test "opzionali"
	
	@org.junit.Test
	public void optionalTestFiboOK() {
		final SequenceAcceptor sa = new SequenceAcceptorImpl();
		sa.reset(SequenceAcceptor.Sequence.FIBONACCI);
		sa.acceptElement(1);
		sa.acceptElement(1);
		sa.acceptElement(2);
		sa.acceptElement(3);
		sa.acceptElement(5);
		sa.acceptElement(8);
		sa.acceptElement(13);
	}

	@org.junit.Test(expected = IllegalStateException.class)
	public void optionalTestFiboNO() {
		final SequenceAcceptor sa = new SequenceAcceptorImpl();
		sa.reset(SequenceAcceptor.Sequence.FIBONACCI);
		sa.acceptElement(1);
		sa.acceptElement(1);
		sa.acceptElement(2);
		sa.acceptElement(3);
		sa.acceptElement(5);
		sa.acceptElement(8);
		sa.acceptElement(14); // da rifiutare
	}

	@org.junit.Test
	public void optionalTestReset() {
		// test con dei reset e cambio di sequenza
		final SequenceAcceptor sa = new SequenceAcceptorImpl();
		sa.reset(SequenceAcceptor.Sequence.FIBONACCI);
		sa.acceptElement(1);
		sa.acceptElement(1);
		sa.acceptElement(2);
		sa.acceptElement(3);
		sa.acceptElement(5);
		sa.reset(SequenceAcceptor.Sequence.POWER2);
		sa.acceptElement(1);
		sa.acceptElement(2);
		sa.acceptElement(4);
		sa.reset(SequenceAcceptor.Sequence.POWER2);
		sa.acceptElement(1);
		sa.acceptElement(2);
		sa.acceptElement(4);
	}
	
	@org.junit.Test
	public void optionalTestResetEmpty() {
		// test con dei reset senza cambio di sequenza
		final SequenceAcceptor sa = new SequenceAcceptorImpl();
		sa.reset(SequenceAcceptor.Sequence.FIBONACCI);
		sa.acceptElement(1);
		sa.acceptElement(1);
		sa.acceptElement(2);
		sa.acceptElement(3);
		sa.acceptElement(5);
		sa.reset();
		sa.acceptElement(1);
		sa.acceptElement(1);
		sa.acceptElement(2);
		sa.acceptElement(3);
		sa.acceptElement(5);
		sa.reset();
		sa.acceptElement(1);
		sa.acceptElement(1);
		sa.acceptElement(2);
	}
	
	@org.junit.Test(expected = IllegalStateException.class)
	public void optionalTestWrongReset() {
		final SequenceAcceptor sa = new SequenceAcceptorImpl();
		// non si può resettare senza sapere da quale sequenza si parte
		sa.reset(); 
	}
	
	@org.junit.Test(expected = IllegalStateException.class)
	public void optionalTestNoReset() {
		final SequenceAcceptor sa = new SequenceAcceptorImpl();
		// non si può produrre un elemento senza aver resettato all'inizio
		sa.acceptElement(0);
	}
	
	*/

}

