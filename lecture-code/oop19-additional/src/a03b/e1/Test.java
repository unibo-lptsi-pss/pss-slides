package a03b.e1;

import static org.junit.Assert.*;
import java.util.*;

import a03b.e1.ConferenceReviewing.Question;

/**
 * Si consulti la documentazione dell'interfaccia ConferenceReviewing, che modella i risultati del processo di revisione
 * degli articoli di una conferenza. Ogni articolo viene da revisionato da uno o più revisori anonimi, ognuno dei quali fornisce
 * una valutazione (score) da 0 a 10 per 4 diverse "domande", modellate da ConferenceReviewing.Question. Un articolo viene 
 * accettato se il valore medio della valutazione alla domanda "FINAL" è >5 e se ha almeno una valutazione "RELEVANCE" >= 8. 
 * 
 * Implementare ConferenceReviewing attraverso una classe ConferenceReviewingImpl con costruttore senza argomenti,
 * in modo che passi tutti i test di cui sotto, realizzati per essere autoesplicativi.
 *  
 * Sono considerati opzionali ai fini della possibilità di correggere l'esercizio, ma concorrono comunque al raggiungimento 
 * della totalità del punteggio:
 * - implementazione dei test opzionali (relativi alla realizzazione del metodo averageWeightedFinalScoreMap)
 * - la qualità della soluzione, in particolare con minimizzazione di ripetizioni e codice non inutilmente complesso
 * 
 * Indicazioni di punteggio:
 * - correttezza della parte obbligatoria: 9 punti
 * - correttezza della parte opzionale: 4 punti
 * - qualità della soluzione: 4 punti
 * 
 * Si tolga il commento al codice del test.
 */

public class Test {
	
	private ConferenceReviewing cr;
	
	/*
	
	// questo metodo istanzia ConferenceReviewing e gli carica delle revisioni 
	@org.junit.Before
	public void init() {
		this.cr = new ConferenceReviewingImpl();
		// carico una revisione per l'articolo 1:
		// - 8 per relevance, significance e final
		// - 7 per confidence
		// si ricordi che l'ordine delle domande è: relevance, significance, confidence, final
		cr.loadReview(1, 8, 8, 6, 8); // 4.8 è il voto finale pesato (usato da averageWeightedFinalScoreMap)
		// e simile per gli altri
		cr.loadReview(1, 9, 9, 6, 9); // 5.4 
		cr.loadReview(2, 9, 9, 10, 9); // 9.0
		cr.loadReview(2, 4, 6, 10, 6); // 6.0
		cr.loadReview(3, 3, 3, 3, 3); // 0.9
		cr.loadReview(3, 4, 4, 4, 4); // 1.6
		cr.loadReview(4, 6, 6, 6, 6); // 3.6
		cr.loadReview(4, 7, 7, 8, 7); // 5.6
		Map<Question,Integer> map = new EnumMap<>(Question.class);
		map.put(Question.RELEVANCE, 8);
		map.put(Question.SIGNIFICANCE, 8);
		map.put(Question.CONFIDENCE, 7); // 5.6
		map.put(Question.FINAL, 8);
		cr.loadReview(4,map);
		cr.loadReview(5, 6, 6, 6, 10); // 6.0
		cr.loadReview(5, 7, 7, 7, 10); // 7.0
	}
	
	@org.junit.Test
	public void testOrderedScores() {
		// l'articolo 2 ha preso su RELEVANCE i due voti 4,9
		assertEquals(cr.orderedScores(2, Question.RELEVANCE),Arrays.asList(4,9));
		// e simile per gli altri
		assertEquals(cr.orderedScores(4, Question.CONFIDENCE),Arrays.asList(6,7,8));
		assertEquals(cr.orderedScores(5, Question.FINAL),Arrays.asList(10,10));
	}
	
	@org.junit.Test
	public void testAverageFinalScore() {
		// l'articolo 1 ha preso voto medio su FINAL pari a 8.5, con scarto massimo 0.01
		assertEquals(cr.averageFinalScore(1),8.5,0.01);
		// e simile per gli altri
		assertEquals(cr.averageFinalScore(2),7.5,0.01);
		assertEquals(cr.averageFinalScore(3),3.5,0.01);
		assertEquals(cr.averageFinalScore(4),7.0,0.01);
		assertEquals(cr.averageFinalScore(5),10.0,0.01);
	}
	
	@org.junit.Test
	public void testAcceptedArticles() {
		// solo gli articoli 1,2,4 vanno accettati, avendo media finale >=5 e almeno un voto su RELEVANCE >= 8
		assertEquals(cr.acceptedArticles(),new HashSet<>(Arrays.asList(1,2,4)));
	}
	
	@org.junit.Test
	public void testSortedAcceptedArticles() {
		// articoli accettati, e loro voto finale medio
		assertEquals(cr.sortedAcceptedArticles(),Arrays.asList(new Pair<>(4,7.0),new Pair<>(2,7.5),new Pair<>(1,8.5)));
	}
	
	@org.junit.Test
	public void optionalTestAverageWeightedFinalScore() {
		// l'articolo 1 ha media pesata finale pari a (4.8+5.4)/2 = 5,1, con scarto massimo 0.01
		assertEquals(cr.averageWeightedFinalScoreMap().get(1),(4.8+5.4)/2,0.01);
		// e simile per gli altri
		assertEquals(cr.averageWeightedFinalScoreMap().get(2),(9.0+6.0)/2,0.01);
		assertEquals(cr.averageWeightedFinalScoreMap().get(3),(0.9+1.6)/2,0.01);
		assertEquals(cr.averageWeightedFinalScoreMap().get(4),(3.6+5.6+5.6)/3,0.01);
		assertEquals(cr.averageWeightedFinalScoreMap().get(5),(6.0+7.0)/2,0.01);
		assertEquals(cr.averageWeightedFinalScoreMap().size(),5);
	}
	
	*/
	
}
