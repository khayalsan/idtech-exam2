import entity.Exam;
import entity.Student;
import service.StudentService;

import java.util.Optional;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		StudentService service = new StudentService();

		int choice;

		do {

			System.out.println("\n1. Add student");
			System.out.println("2. Add exam to student");
			System.out.println("3. Show all students");
			System.out.println("4. Show pass/fail status");
			System.out.println("5. Show top student");
			System.out.println("0. Exit");

			System.out.print("Choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

				case 1:

					System.out.print("Student ID: ");
					int id = scanner.nextInt();
					scanner.nextLine();

					System.out.print("Student name: ");
					String name = scanner.nextLine();

					service.addStudent(new Student(id, name));

					System.out.println("Student added.");
					break;

				case 2:

					System.out.print("Student ID: ");
					int studentId = scanner.nextInt();
					scanner.nextLine();

					Optional<Student> studentBoxed = service.findStudentById(studentId);

					if (studentBoxed.isEmpty()) {
						System.out.println("Student not found.");
						break;
					}
					var student = studentBoxed.get();
					System.out.print("Subject: ");
					String subject = scanner.nextLine();

					double score;

					do {
						System.out.print("Score (0-100): ");
						score = scanner.nextDouble();

						if (score < 0 || score > 100) {
							System.out.println("Invalid score!");
						}

					} while (score < 0 || score > 100);

					student.addExam(new Exam(subject, score));

					System.out.println("Exam added.");

					break;

				case 3:

					for (Student s : service.getAllStudents()) {
						System.out.println("----------------------");
						System.out.println(s);
					}

					break;

				case 4:

					service.printStudentsWithStatus();

					break;

				case 5:

					Student top = service.findTopStudent();

					if (top == null) {
						System.out.println("No valid student.");
					} else {
						System.out.println("Top Student:");
						System.out.println(top);
					}

					break;

				case 0:

					System.out.println("Goodbye!");
					break;

				default:

					System.out.println("Invalid choice.");
			}

		} while (choice != 0);

		scanner.close();
	}
}