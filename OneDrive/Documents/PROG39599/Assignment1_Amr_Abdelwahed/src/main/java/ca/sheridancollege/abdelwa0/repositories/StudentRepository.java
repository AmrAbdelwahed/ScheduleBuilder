package ca.sheridancollege.abdelwa0.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.sheridancollege.abdelwa0.beans.Course;
import ca.sheridancollege.abdelwa0.beans.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

//	@Transactional
//    @Modifying
//    @Query("UPDATE Student s SET s.courses = :course WHERE s.id = :studentId")
//    void dropStudentFromCourse(@Param("studentId") Long studentId, @Param("course") Course course);
	   @Transactional
	    @Modifying
	    @Query("UPDATE Student s SET s.courses = :courses WHERE s.id = :studentId")
	    void updateStudentCourses(@Param("studentId") Long studentId, @Param("courses") List<Course> courses);

	Student getStudentById(Long studentId);
	
	 @Modifying
	 @Transactional
	 @Query("UPDATE Student s SET s.courses = :course WHERE s.id = :studentId")
	  void assignStudentToCourse(@Param("studentId") Long studentId, @Param("course") Course course);

}
