package entity;

import enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private Integer id;
	private String name;
	private final List<Exam> exams = new ArrayList<Exam>();

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void addExam(Exam exam) {
		exams.add(exam);
	}
	public Boolean hasAtLeastOneExam() {
		return !exams.isEmpty();
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

	public Status getStatus() {
		return isPassed() ? Status.PASS : Status.FAIL;
	}
	@Override
	public String toString() {
		return "Student " +
				"ID = " + id +
				", Name  ='" + name + '\'' +
				", Exams =" + exams +
				", Average score = " + calculateAverageScore() +
				", Status = " + getStatus();
	}

	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
