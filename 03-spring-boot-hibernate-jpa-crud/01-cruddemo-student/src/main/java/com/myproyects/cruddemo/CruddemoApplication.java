package com.myproyects.cruddemo;

import com.myproyects.cruddemo.dao.StudentDAO;
import com.myproyects.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//CreateStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsBySecondName(studentDAO);
			updateStudent(studentDAO);

		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve the student based on the id: primary key
		int idstudent=1;
		System.out.println("Getting the student by the id "+idstudent);
		Student myStudent=studentDAO.findById(idstudent);
		//change first name to "Guillermo"
		System.out.println("Updating my student");
		myStudent.setFirstName("Hugo");
		//update the student
		studentDAO.update(myStudent);
		//display the updated student
		System.out.println("Updated student :"+myStudent);



	}

	private void queryForStudentsBySecondName(StudentDAO studentDAO) {
		//get a list of student
		List<Student> theStudents=studentDAO.findBySecondName("martinez");
		//display list of student
		for (Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents=studentDAO.findAll();
		//display list of students
		for (Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Sofia", "Peralta","sofy@yahoo.com");

		//save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId= tempStudent.getId();
		System.out.println("Saved student. Generated id: "+theId);

		//retrieve student based on the id: primary key
		System.out.println("Retriving student with id; "+theId);
		Student myStudent=studentDAO.findById(theId);

		//display student
		System.out.println("Found the student; "+myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//Create multiple Students
		System.out.println("Creating 3 new student object ...");
		Student tempStudent1 = new Student("Pedro","Cortazar","pcortazar@yahoo.com");
		Student tempStudent2 = new Student("Galileo","Montijo","gmantijo@yahoo.com");
		Student tempStudent3 = new Student("Veronica","martinez","vmartinez@yahoo.com");
		//Save the students
		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO){
		//create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Hugo","Baltazar","boss@yahoo.com");

		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		//display id the saven student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}

}


