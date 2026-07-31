package entity;

public class Exam {
	private String subject;
	private Double score;

	public boolean isPassed() {
		return score >= 50;
	}
	public Double getScore() {
		return score;
	}
}
