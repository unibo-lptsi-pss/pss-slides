package a03b.e1;

import java.util.*;

/**
 * An interface modelling the results of reviewing articles of a conference
 * Each reviewer (revisore) reads an article (articolo), and answers to a number of questions
 * with a score from 0 (bad) to 10 (excellent).
 * Note that each article can be reviewed by many reviewers (typically, from 2 to 4), but the 
 * system does not keep track of the identity of reviewers
 * 
 */
public interface ConferenceReviewing {
	
	/**
	 * For each article, the reviewer has to reply to all the following questions
	 */
	enum Question {
		RELEVANCE,       // ("È importante per questa conferenza?"),
		SIGNIFICANCE, 	// ("Produce contributo scientifico?"),
		CONFIDENCE,   	// ("Ti senti competente a commentarlo?");
		FINAL;        	// ("É un articolo da accettare?")
	}
		
	/**
	 * @param article
	 * @param scores
	 * loads a review for the specified article, with complete scores as a map
	 */
	void loadReview(int article, Map<Question,Integer> scores);
	
	/**
	 * @param article
	 * @param relevance
	 * @param significance
	 * @param confidence
	 * @param fin
	 * loads a review for the specified article, with the 4 explicit scores
	 */
	void loadReview(int article, int relevance, int significance, int confidence, int fin);
	
	/**
	 * @param article
	 * @param question
	 * @return the scores given to the specified article and specified question, as an (ascending-ordered) list 
	 */
	List<Integer> orderedScores(int article, Question question);
	
	/**
	 * @param article
	 * @return the average score to question FINAL taken by the specified article
	 */
	double averageFinalScore(int article);
	
	/**
	 * An article is considered accept if its averageFinalScore (not weighted) is > 5, 
	 * and at least one RELEVANCE score that is >= 8.
	 * @return the set of accepted articles
	 */
	Set<Integer> acceptedArticles();
	
	
	/**
	 * @return accepted articles as a list of pairs article+averageFinalScore, ordered from worst to best based on averageFinalScore
	 */
	List<Pair<Integer,Double>> sortedAcceptedArticles();
	
	/**
	 * @return a map from articles to their average "weighted final score", namely,
	 * the average value of CONFIDENCE*FINAL/10  
	 * Note: this method is optional in this exam
	 */
	Map<Integer, Double> averageWeightedFinalScoreMap();
}