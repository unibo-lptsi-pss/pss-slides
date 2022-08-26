package a04.sol1;

import static org.junit.Assert.*;
import java.util.*;

/**
 * Si consulti la documentazione della interfaccia SimpleIterator, che modella un iteratore, e quella di
 * PowerIteratorsFactory, una factory per vari iteratori su interi. Si implementi quest'ultima attraverso
 * una classe PowerIteratorsFactoryImpl in modo che passino i test sottostanti.
 *  
 * Sono considerati opzionali ai fini della possibilità di correggere l'esercizio, ma concorrono comunque al raggiungimento 
 * della totalità del punteggio:
 * - implementazione dei test opzionali (denominati 'optionalTestXYZ', ossia solo l'ultimo) 
 * - minimizzazione di ripetizioni
 * - minimizzazione di sprechi di memoria, allocando oggetti di possibili grosse dimensioni inutilmente
 * 
 * Si osservi con attenzione il test seguente, che assieme ai commenti delle interfacce date
 * costituisce la definizione del problema da risolvere.
 * 
 * Si tolga il commento al codice del test.
 */


public class Test {
	
	private IntegerIteratorsFactory factory;
	
	@org.junit.Before
	public void init() {
		this.factory = new IntegerIteratorsFactoryImpl();
	}
    
    
    @org.junit.Test
    public void testEmpty() {
        assertFalse(this.factory.empty().next().isPresent()); // subito vuoto..
        assertFalse(this.factory.empty().next().isPresent()); // ..anche ritentando
    }
    
    @org.junit.Test
    public void testList() {
    	SimpleIterator<Integer> si = factory.fromList(Arrays.asList(10,20,30));
        assertEquals(si.next(),Optional.of(10)); // produce gli elementi della lista
        assertEquals(si.next(),Optional.of(20));
        assertEquals(si.next(),Optional.of(30));
        assertFalse(si.next().isPresent());
        assertFalse(si.next().isPresent()); // ..comunque non si procede
    }
    
    
    @org.junit.Test
    public void testRandom() { // semi-automatico, si controlleranno anche le stampe a video 
    	SimpleIterator<Integer> si = factory.random(4); // 4 elementi compresi in 0..3
    	List<Integer> values = Arrays.asList(0,1,2,3);
    	int b1 = si.next().get();
    	int b2 = si.next().get();
    	int b3 = si.next().get();
    	int b4 = si.next().get();
    	System.out.println(b1+ " "+b2+ " "+b3+ " "+b4); // verifica a video della randomness
        assertTrue(values.contains(b1)); // b1 compreso in {0,1,2,3}...
        assertTrue(values.contains(b2)); // etc..
        assertTrue(values.contains(b3));
        assertTrue(values.contains(b4));
        assertFalse(si.next().isPresent());
        assertFalse(si.next().isPresent()); // ..comunque non si procede
    }
    
    @org.junit.Test
    public void testQuadratic() {  
    	SimpleIterator<Integer> si = factory.quadratic();
        assertEquals(si.next(),Optional.of(1));
        assertEquals(si.next(),Optional.of(2));
        assertEquals(si.next(),Optional.of(2));
        assertEquals(si.next(),Optional.of(3));
        assertEquals(si.next(),Optional.of(3));
        assertEquals(si.next(),Optional.of(3));
        assertEquals(si.next(),Optional.of(4));
        assertEquals(si.next(),Optional.of(4));
        assertEquals(si.next(),Optional.of(4));
        assertEquals(si.next(),Optional.of(4));
        assertEquals(si.next(),Optional.of(5));
        assertEquals(si.next(),Optional.of(5));
        for (int i=0;i<100;i++) {
        	assertTrue(si.next().isPresent()); // si continua a produrre..
        }
    }
    
    @org.junit.Test
    public void optionalTestRecurring() { 
    	SimpleIterator<Integer> si = factory.recurring();
        assertEquals(si.next(),Optional.of(0));
        assertEquals(si.next(),Optional.of(0));
        assertEquals(si.next(),Optional.of(1));
        assertEquals(si.next(),Optional.of(0));
        assertEquals(si.next(),Optional.of(1));
        assertEquals(si.next(),Optional.of(2));
        assertEquals(si.next(),Optional.of(0));
        assertEquals(si.next(),Optional.of(1));
        assertEquals(si.next(),Optional.of(2));
        assertEquals(si.next(),Optional.of(3));
        assertEquals(si.next(),Optional.of(0));
        assertEquals(si.next(),Optional.of(1));
        assertEquals(si.next(),Optional.of(2));
        assertEquals(si.next(),Optional.of(3));
        assertEquals(si.next(),Optional.of(4));
        for (int i=0;i<100;i++) {
        	assertTrue(si.next().isPresent());  // si continua a produrre..
        }
    }
        
}
