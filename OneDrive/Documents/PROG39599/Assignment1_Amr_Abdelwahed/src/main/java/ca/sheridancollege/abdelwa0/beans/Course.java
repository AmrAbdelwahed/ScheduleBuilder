package ca.sheridancollege.abdelwa0.beans;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
public class Course {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	private String code;
	
	@ManyToOne()
	@JoinTable(name="Professor_Courses",
			joinColumns = @JoinColumn(name="Course_ID"),
			inverseJoinColumns = @JoinColumn(name="Professor_ID"))
	private Professor professor;
	
	@ManyToMany(mappedBy="courses")
	private List<Student> students;
}
