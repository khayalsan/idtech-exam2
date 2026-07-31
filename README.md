# Java SE Final Exam – Student Exam Management System

## Important Rules

* You must use **Object-Oriented Programming (OOP)**.
* You must demonstrate the four OOP principles:

* Encapsulation
* Inheritance (if additional classes are permitted)
* Polymorphism (if additional classes are permitted)
* Abstraction (interface or abstract class, if additional classes are permitted)
* You must use **Composition (HAS-A relationship)**.
* You must use **Collections**.
* You must use **Generics** (e.g., a generic repository).
* You should use **Optional** instead of returning `null` where appropriate.
* No GUI.
* No files.
* No database.
* All input must come from the console.

---

# Project

Build a **Student Exam Management System**.
---

# Program Features

The program must allow the user to:

1. Add students
2. Add exams to students
3. Calculate average scores
4. Determine pass/fail status
5. Find the best student

---

# Required Classes

Create the following classes:

* `Exam`
* `Student`
* `StudentService`
* `Repository`
* `Main`
* You should use inheritance, polymorphism, and abstraction if additional classes are permitted.

---

# Exam Class

## Fields

* `subject`
* `score`
* maybe additional fields


## Methods

```java
boolean isPassed()
```

Returns:

* `true` if score ≥ 50
* otherwise `false`

---

# Student Class

## Fields

* `id`
* `name`
* `exams`
* maybe additional fields


## Methods

### `void addExam(Exam exam)`

Adds an exam to the student.

### `double calculateAverageScore()`

* Calculates the average of all exam scores.
* Returns `0` if the student has no exams.

### `boolean hasPassedAllExams()`

* Returns `true` if all exams are passed.
* Returns `false` if at least one exam is failed.
* Returns `false` if the student has no exams.

### `boolean isPassed()`

A student passes if:

* Average score ≥ 60
* AND all exams are passed

Students with no exams automatically fail.

### `toString()`

Must display:

* Student ID
* Name
* Exams
* Average score
* PASS / FAIL status

---

# StudentService Class

Business Logic

## Methods

### `void addStudent(Student student)`

Adds a student to the system.

### `Optional<Student> findStudentById(int id)`

Returns the student with the given ID.

If not found:

* Return `Optional.empty()` (preferred)
* or `null` if `Optional` is not permitted by the instructor.

### `Student findTopStudent()`

Returns the student with the highest average score.

Returns `null` if no valid student exists.

### `void printStudentsWithStatus()`

Example output:

```text
Ali - PASS
Aysel - FAIL
```

# Repository and StudentRepository Classes

Handles input / output and data storage.

---

# Main Menu

```
1. Add student
2. Add exam to student
3. Show all students
4. Show pass/fail status
5. Show top student
0. Exit
```

---

# Business Rules

* Exam score must be between **0 and 100**.
* Exam is passed if **score ≥ 50**.
* Student passes if:

* Average ≥ 60
* AND all exams are passed.
* Students with no exams automatically fail.
* The top student must have at least one exam.

---

# Additional Requirements

* Use encapsulation (`private` fields with public methods).
* Demonstrate composition (`Student` HAS-A `Exams`).
* Use generics where appropriate (e.g., `Repository<T>`).
* Use `Optional` to avoid returning `null` when appropriate.
* Keep the application menu-driven and console-based.