package ca.sheridancollege.abdelwa0.bootstrap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.abdelwa0.beans.Course;
import ca.sheridancollege.abdelwa0.beans.Professor;
import ca.sheridancollege.abdelwa0.beans.Student;
import ca.sheridancollege.abdelwa0.repositories.CourseRepository;
import ca.sheridancollege.abdelwa0.repositories.ProfessorRepository;
import ca.sheridancollege.abdelwa0.repositories.StudentRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner{
	private StudentRepository studentRepo;
	private CourseRepository courseRepo;
	private ProfessorRepository professorRepo;

    List<Professor> professors = new ArrayList<>();
    List<Course> courses = new ArrayList<>();
    List<Student> students = new ArrayList<>();


	@Override
	public void run(String... args) throws Exception {
		createProfessors();
		
			createCourses();

		    createStudents();

	    }

	    private void createStudents() {	
	    	List<Course> courses = courseRepo.findAll();
	    	List<Course> courses1 = courseRepo.findAllById(Arrays.asList(1L, 2L));
	    	List<Course> courses2 = courseRepo.findAllById(Arrays.asList(3L, 4L));
	    	List<Course> courses3 = courseRepo.findAllById(Arrays.asList(5L, 6L));
	    	
	    	studentRepo.saveAll(Arrays.asList(
	    	Student.builder().firstName("John").lastName("John ").courses(courses).build(),
	    	Student.builder().firstName("Emily").lastName("Johnson").courses(courses).build(),
	    	Student.builder().firstName("Michael").lastName("Williams").courses(courses).build(),
	    	Student.builder().firstName("Sarah").lastName("Brown").courses(courses).build(),
	    	Student.builder().firstName("James").lastName("Davis").courses(courses).build(),
	    	Student.builder().firstName("Daniel").lastName("Wilson").courses(courses).build(),
	    	Student.builder().firstName("Emma").lastName("Miller").courses(courses).build(),
	    	Student.builder().firstName("David").lastName("Taylor").courses(courses).build(),
	    	Student.builder().firstName("Sophia").lastName("Anderson").courses(courses).build(),
	    	Student.builder().firstName("Matthew").lastName("Thomas").courses(courses1).build(),
	    	Student.builder().firstName("Ava").lastName("Jackson").courses(courses1).build(),
	    	Student.builder().firstName("Isabella").lastName("Harris").courses(courses1).build(),
	    	Student.builder().firstName("Andrew").lastName("White").courses(courses1).build(),
	    	Student.builder().firstName("Christopher").lastName("Martinez").courses(courses1).build(),
	    	Student.builder().firstName("Mia").lastName("Thompson").courses(courses1).build(),
	    	Student.builder().firstName("Joshua").lastName("Anderson").courses(courses1).build(),
	    	Student.builder().firstName("Charlotte").lastName("Clark").courses(courses1).build(),
	    	Student.builder().firstName("Nicholas").lastName("Lewis").courses(courses1).build(),
	    	Student.builder().firstName("Amelia").lastName("Lee").courses(courses1).build(),
	    	Student.builder().firstName("Ethan").lastName("Walker").courses(courses1).build(),
	    	Student.builder().firstName("Abigail").lastName("Green").courses(courses2).build(),
	    	Student.builder().firstName("Alexander").lastName("King").courses(courses2).build(),
	    	Student.builder().firstName("Elizabeth").lastName("Perez").courses(courses2).build(),
	    	Student.builder().firstName("Ryan").lastName("Robinson").courses(courses2).build(),
	    	Student.builder().firstName("Grace").lastName("Hall").courses(courses2).build(),
	    	Student.builder().firstName("Benjamin").lastName("Young").courses(courses3).build(),
	    	Student.builder().firstName("Chloe").lastName("Baker").courses(courses3).build(),
	    	Student.builder().firstName("William").lastName("Nelson").courses(courses3).build(),
	    	Student.builder().firstName("Harper").lastName("Allen").courses(courses3).build(),
	    	Student.builder().firstName("David").lastName("Miller").courses(courses3).build()
 	        ));
	    }

	    private void createProfessors() {

	    	 professorRepo.saveAll(Arrays.asList(
	    	            Professor.builder().name("Johnson").build(),
	    	            Professor.builder().name("Williams").build(),
	    	            Professor.builder().name("Miller").build()
	    	        ));
	    }

	    private void createCourses() {	
	        List<Professor> professors = professorRepo.findAll();
	        List<Student> students = studentRepo.findAll();
	        
	        Optional<Professor> optionalProfessor1 = professorRepo.findById(1L);
	        Optional<Professor> optionalProfessor2 = professorRepo.findById(2L);
	        Optional<Professor> optionalProfessor3 = professorRepo.findById(3L);
	        Professor prof1 = optionalProfessor1.get();
	        Professor prof2 = optionalProfessor2.get();
	        Professor prof3 = optionalProfessor3.get();
	        
	    	 courseRepo.saveAll(Arrays.asList(
	    	            Course.builder().name("Introduction to Computer Science").code("CS101").professor(prof3).students(new ArrayList<Student>()).build(),
	    	            Course.builder().name("Data Structures and Algorithms").code("CS202").professor(prof1).students(students).build(),
	    	            Course.builder().name("Object-Oriented Programming ").code("CS303").professor(prof2).students(students).build(),
	    	            Course.builder().name("Web Development Fundamentals").code("CS404").professor(prof3).students(students).build(),
	    	            Course.builder().name("Database Management Systems").code("CS505").professor(prof2).students(students).build(),
	    	            Course.builder().name("Software Engineering Principles").code("CS606").professor(prof1).students(students).build()
	    	        ));

	    }
	

}
