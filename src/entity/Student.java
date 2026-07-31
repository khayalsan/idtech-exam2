package entity;

import enums.ExamStatus;

import java.util.ArrayList;
import java.util.List;

import static enums.ExamStatus.FAIL;
import static enums.ExamStatus.PASS;

public class Student {
	private Integer id;
	private String name;
	private final List<Exam> exams = new ArrayList<>();

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
		return exams.stream().map((Exam::getScore)).reduce(0.0, Double::sum) / exams.size();
	}
	public boolean hasPassedAllExams() {
		if (exams.isEmpty()) return false;
		var failedExamBoxed = exams.stream().filter((exam -> !exam.isPassed())).findFirst();
		return failedExamBoxed.isEmpty();
	}

	public Boolean isPassed() {
		return calculateAverageScore() >= 60.0 && hasPassedAllExams();
	}

	public ExamStatus getStatus() {
		return isPassed() ? PASS : FAIL;
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
