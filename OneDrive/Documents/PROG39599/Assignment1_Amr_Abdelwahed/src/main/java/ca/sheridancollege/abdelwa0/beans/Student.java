package ca.sheridancollege.abdelwa0.beans;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String firstName;
	private String lastName;
	
	@ManyToMany()
	@JoinTable(name="Students_Courses",
	joinColumns = @JoinColumn(name="Student_ID"),
	inverseJoinColumns = @JoinColumn(name="Course_ID"))
	private List<Course> courses;
}
