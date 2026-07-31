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
	public void setScore(Double score) {
		if (score >= 0.0 && score <= 100.0) {
			this.score = score;
			return;
		}
		System.out.println("Score needs to be between 0 and 100");
	}
}
