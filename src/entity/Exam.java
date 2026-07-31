package entity;

public class Exam {
	private String subject;
	private Double score;

	public Exam(String subject, double score) {
		this.subject = subject;
		this.score = score;
	}

	public boolean isPassed() {
		return score >= 50;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Exam{" +
				"subject='" + subject + '\'' +
				", score=" + score +
				'}';
	}
}
