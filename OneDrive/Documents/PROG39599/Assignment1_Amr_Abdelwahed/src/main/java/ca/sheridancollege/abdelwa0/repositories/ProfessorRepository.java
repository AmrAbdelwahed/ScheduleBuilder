package ca.sheridancollege.abdelwa0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.sheridancollege.abdelwa0.beans.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	
	 

	Professor getProfessorById(Long professorId);

}
