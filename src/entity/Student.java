package entity;

import java.util.List;

public class Student {
	private Long id;
	private String name;
	private List<Exam> exams;

	public void addExam(Exam exam) {
		exams.add(exam);
	}
	public Double calculateAverageScore() {
		if (exams.isEmpty()) return 0.0;
		Double sum = exams.stream().map((Exam::getScore)).reduce(0.0, Double::sum);
		return sum / exams.size();
	}
	public boolean hasPassedAllExams() {
		if (exams.isEmpty()) return false;
		var failedExamBoxed = exams.stream().filter((exam -> !exam.isPassed())).findFirst();
		return failedExamBoxed.isEmpty();

	}

	public Boolean isPassed() {
		return calculateAverageScore() >= 60.0 && hasPassedAllExams();
	}

	@Override
	public String toString() {
		return "Student " +
				"ID =" + id +
				", Name ='" + name + '\'' +
				", Exams =" + exams +
				"Average score = " + calculateAverageScore() +
				"Status = " + isPassed();
	}
}
