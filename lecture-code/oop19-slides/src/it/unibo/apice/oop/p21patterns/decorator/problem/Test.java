package it.unibo.apice.oop.p21patterns.decorator.problem;

import static org.junit.Assert.*;

import java.util.*;

/*
 * Considerare l'interfaccia Pizza e l'implementazione Margherita, con costo 6.50 Euro e ingredienti Mozzarella + Pomodoro.
 * Si vuole fornire la possibilità di aggiungere gli ingredienti Funghi (maggiorazione di 1 Euro) e Salsiccia 
 * (maggiorazione di 1.5 Euro), eventualmente anche in porzione doppia (p.e., doppia porzioni di funghi: 2 Euro).
 * Inoltre, la Pizza potrebbe anche essere "stesa", nel qual caso la maggiorazione è del 10% sul costo totale.
 * Queste variazioni vadano fornite attraverso il pattern "Decorator", ossia una Pizza con funghi e/o salsiccia e/o stesa
 * sia una decorazione di un pizza.
 * Si realizzino quindi le classi Funghi, Salsiccia e GlutFree come decoratori di Pizza, e quindi da usare in modo che il 
 * test qui sotto sia soddisfatto: si noti in particolare come se ne usano i costruttori.
 * Nel realizzare le classi si faccia attenzione a evitare il più possibile il codice duplicato, fattorizzando in 
 * classi astratte ovunque sia utile.
 * Per semplicità si assuma che la decorazione GlutFree venga applicata solo una volta e in posizione più esterna, 
 * come nel caso del test qui sotto, e senza ulteriori controlli.
 * Si consideri il test qui sotto (da scommentare) come riferimento.
  */

public class Test {
	
	// Completare l'assegnamento di p1,p2,p3,p4 opportunamente
	@org.junit.Test
	public void test(){
		Pizza p1 = null; // funghi + salsiccia su base margherita
		Pizza p2 = null; // margherita
		Pizza p3 = null; // doppia salsiccia su base margherita
		Pizza p4 = null; // come p3 ma stesa
		// stampe di comodo
		System.out.println(p1.getCost()+" "+p1.getIngredients());
		System.out.println(p2.getCost()+" "+p2.getIngredients());
		System.out.println(p3.getCost()+" "+p3.getIngredients());
		System.out.println(p4.getCost()+" "+p4.getIngredients());
		// test correttezza di costi e stringhe
		assertEquals(p1.getCost(),900); // 6.50 + 1.00 + 1.50
		assertEquals(p2.getCost(),650);
		assertEquals(p3.getCost(),950); // 6.50 + 1.50 + 1.50
		assertEquals(p4.getCost(),1045);// (6.50 + 1.50 + 1.50) + 10%
		assertEquals(p1.getIngredients(),"Pomodoro, Mozzarella, Salsiccia, Funghi");
		assertEquals(p2.getIngredients(),"Pomodoro, Mozzarella");
		assertEquals(p3.getIngredients(),"Pomodoro, Mozzarella, Salsiccia, Salsiccia");
		assertEquals(p4.getIngredients(),"[GF] Pomodoro, Mozzarella, Salsiccia, Salsiccia");
		
	}
	
}
