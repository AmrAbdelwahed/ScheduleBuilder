package ca.sheridancollege.abdelwa0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.sheridancollege.abdelwa0.beans.Course;
import ca.sheridancollege.abdelwa0.beans.Professor;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	@Transactional
	 @Modifying
	 @Query("UPDATE Course c SET c.professor = :professor WHERE c.id = :courseId")
	 void assignProfessorToCourse(@Param("professor") Professor professor, @Param("courseId") Long courseId);
	
	Course getCourseById(Long courseId);

}
