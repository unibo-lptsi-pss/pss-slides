package a03b.sol1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConferenceReviewingImpl implements ConferenceReviewing {
	
	private final List<Pair<Integer,Map<Question, Integer>>> reviews = new ArrayList<>();

	@Override
	public void loadReview(int article, Map<Question, Integer> scores) {
		if (scores.size() < Question.values().length) {
			throw new IllegalArgumentException();
		}
		reviews.add(new Pair<>(article,new EnumMap<>(scores)));
	}

	@Override
	public void loadReview(int article, int relevance, int significance, int confidence, int fin) {
		Map<Question,Integer> map = new EnumMap<>(Question.class);
		map.put(Question.RELEVANCE, relevance);
		map.put(Question.SIGNIFICANCE, significance);
		map.put(Question.CONFIDENCE, confidence);
		map.put(Question.FINAL, fin);
		reviews.add(new Pair<>(article,map));
	}
	
	@Override
	public List<Integer> orderedScores(int article, Question question) {
		return reviews.stream()
				      .filter(p -> p.getX() == article)
				      .map(p -> p.getY().get(question))
				      .sorted()
				      .collect(Collectors.toList());
	}
	
	@Override
	public double averageFinalScore(int article) {
		return reviews.stream()
			      .filter(p -> p.getX() == article)
			      .mapToInt(p -> p.getY().get(Question.FINAL))
			      .average()
			      .getAsDouble();
	}
	
	private boolean accepted(int article) {
		return averageFinalScore(article) > 5.0 && 
			   reviews.stream()
			          .filter(p -> p.getX()==article)
			          .map(Pair::getY)
			          .map(Map::entrySet)
			          .flatMap(Set::stream)
			          .anyMatch(e -> e.getKey()==Question.RELEVANCE && e.getValue() >= 8);
	}

	@Override
	public Set<Integer> acceptedArticles() {
		return reviews.stream()
				      .map(Pair::getX)
				      .distinct()
				      .filter(this::accepted)
				      .collect(Collectors.toSet());
	}

	@Override
	public List<Pair<Integer,Double>> sortedAcceptedArticles() {
		return this.acceptedArticles()
				   .stream()
				   .map(e -> new Pair<>(e,this.averageFinalScore(e)))
				   .sorted((e1,e2)->e1.getY().compareTo(e2.getY()))
				   .collect(Collectors.toList());
	}
	
	private double averageWeightedFinalScore(int article) {
		return reviews.stream()
				      .filter(p -> p.getX() == article)
				      .mapToDouble(p -> p.getY().get(Question.FINAL) * p.getY().get(Question.CONFIDENCE) / 10.0)
				      .average().getAsDouble();
	}

	@Override
	public Map<Integer, Double> averageWeightedFinalScoreMap() {
		return reviews.stream()
				      .map(Pair::getX)
				      .distinct()
				      .collect(Collectors.toMap(Function.identity(), this::averageWeightedFinalScore));
	}


}
