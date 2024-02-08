package ca.sheridancollege.abdelwa0.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.abdelwa0.beans.Course;
import ca.sheridancollege.abdelwa0.beans.Professor;
import ca.sheridancollege.abdelwa0.beans.Student;
import ca.sheridancollege.abdelwa0.repositories.CourseRepository;
import ca.sheridancollege.abdelwa0.repositories.ProfessorRepository;
import ca.sheridancollege.abdelwa0.repositories.StudentRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {
	
	private StudentRepository studentRepo;
	private CourseRepository courseRepo;
	private ProfessorRepository professorRepo;
	
	@GetMapping("/")
	public String getHome(Model model) {
		 model.addAttribute("students", studentRepo.findAll());
	     model.addAttribute("courses", courseRepo.findAll());
	     model.addAttribute("professors", professorRepo.findAll());
	     return "root";	
	 }
	
	@GetMapping("/addStudent")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }
	

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute Student student) {
    	studentRepo.save(student);
        return "redirect:/";
    }
    
    @GetMapping("/addCourse")
    public String getCourse(Model model) {
        model.addAttribute("course", new Course());
        return "addCourse";
    }

    @PostMapping("/addCourse")
    public String addCourse(@ModelAttribute Course course) {
    	courseRepo.save(course);
        return "redirect:/";
    }
    
    @GetMapping("/addProfessor")
    public String getProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "addProfessor";
    }

    @PostMapping("/addProfessor")
    public String addProfessor(@ModelAttribute Professor professor) {
    	professorRepo.save(professor);
        return "redirect:/";
    }
    
    
    //assign professor to courses
    @GetMapping("/assignProfessor")
    public String showAssignProfessorForm(Model model) {
        model.addAttribute("professors", professorRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll());
        return "assignProfessor";
    }

    @PostMapping("/assignProfessor")
    public String assignProfessorToCourse(@RequestParam Long professorId, @RequestParam Long courseId) {
    	Optional<Professor> optionalProfessor = professorRepo.findById(professorId);
        Optional<Course> optionalCourse = courseRepo.findById(courseId);
        
        if (optionalProfessor.isPresent() && optionalCourse.isPresent()) {
            Professor professor = optionalProfessor.get();
            Course course = optionalCourse.get();
            
            if (professor.getId() == null) {
                professor = professorRepo.save(professor);
            }
            
            // Assign the professor to the course
            course.setProfessor(professor);
            courseRepo.save(course);
            
        }
        return "redirect:/";
    }
    
    //assign student to courses
    @GetMapping("/assignStudent")
    public String showAssignStudentForm(Model model) {
        model.addAttribute("students", studentRepo.findAll());
        model.addAttribute("courses", courseRepo.findAll());
        return "assignStudent";
    }

    @PostMapping("/assignStudent")
    public String assignStudentToCourse(@RequestParam Long studentId, @RequestParam Long courseId) {
    	//studentRepo.assignStudentToCourse(studentId, courseId);
    	Optional<Student> optionalStudent = studentRepo.findById(studentId);
        Optional<Course> optionalCourse = courseRepo.findById(courseId);
        
        if (optionalStudent.isPresent() && optionalCourse.isPresent()) {
        	Student student = optionalStudent.get();
            Course course = optionalCourse.get();
            
            if (student.getId() == null) {
            	student = studentRepo.save(student);
            }
            
            // Assign the professor to the course
            List<Course> studentCourses = student.getCourses();
            studentCourses.add(course);
            student.setCourses(studentCourses);
            studentRepo.save(student);
        }
            
        return "redirect:/";
    }

    @GetMapping("/displayCourse/{courseId}")
    public String displayCourse(Model model, @PathVariable Long courseId) {
        Course course = courseRepo.getCourseById(courseId);
        model.addAttribute("course", course);
        return "displayCourse";
    }
    
    @GetMapping("/dropStudent/{studentId}/{courseId}")
    public String dropStudentFromCourse(@PathVariable Long studentId, @PathVariable Long courseId) {

    	Optional<Student> optionalStudent = studentRepo.findById(studentId);
        Optional<Course> optionalCourse = courseRepo.findById(courseId);
        if (optionalStudent.isPresent() && optionalCourse.isPresent()) {
            Student student = optionalStudent.get();
            Course course = optionalCourse.get();

            student.getCourses().remove(course);
            studentRepo.save(student);
        }
        return "redirect:/displayCourse/" + courseId;
    }
    
    @GetMapping("/viewCourses/{studentId}")
    public String viewCourses(Model model, @PathVariable Long studentId) {
        Student student = studentRepo.getStudentById(studentId);
        model.addAttribute("student", student);
        return "viewCourses";
    }
    @GetMapping("/viewClasses/{professorId}")
    public String viewClasses(Model model, @PathVariable Long professorId) {
        Professor professor = professorRepo.getProfessorById(professorId);
        model.addAttribute("professor", professor);
        return "viewClasses";
    }
}
