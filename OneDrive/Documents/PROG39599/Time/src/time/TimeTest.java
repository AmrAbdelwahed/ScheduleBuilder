package time;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.DisplayName.class)
class TimeTest {

	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15", "05:59:59" })
	void testGetHours(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue(hours==5);
	}
	@Test
	void testGetMinutes() {
		int minutes = Time.getTotalMinutes("05:10:20");
		assertTrue(minutes==10);
	}
	@Test
	void testGetSeconds() {
		int seconds = Time.getTotalSeconds("05:10:20");
		assertTrue(seconds==18620);
	}
	
	@Test
	void testGoodGetMilliSeconds() {
		int miiliseconds = Time.getMilliSeconds("12:05:05:05");
		assertTrue(miiliseconds==5);
	}
	@Test //expect false, asserting 9 but 5
	void testBadGetMilliSeconds() {
		assertThrows(StringIndexOutOfBoundsException.class, () ->{Time.getMilliSeconds("12:05:05:0");});
	}
	@Test
	void testBoundaryGetMilliSeconds() {
		int miiliseconds = Time.getMilliSeconds("12:05:05:59");
		assertTrue(miiliseconds==59);
	}
}
//methodologies
/*Waterfall methodology is a sequential development process, each phase wrapping up before the next phase begins.
 * Unified process model runs a development project through four phases: Inception, Elaboration, Construction, and Transition
 * Agile software development contains many frameworks such as Scrum, Extreme Programming, or Feature-Driven Development (FDD)
   Agile software development practices such as pair programming, test-driven development, stand-ups,planning sessions, and sprints.
 * Scrum: is a lightweight framework that helps teams generate value through adaptive solutions for complex problems. Daily scrum
  meetings attended by the product owner, ScrumMaster and the entire Scrum team to discuss requirements and plan short sprints.
 *Extreme Programming: a development framework aims to produce higher quality software, higher quality of life for development team. 
  Uses the concept of pair programming to enhance quality and reduce defects as well as frequent integration tests
  certain roles are required for an extreme programming project to work: Customer, Developer, Manager and Coach
 * */

//TDD
/*Functional testing tests what a system does. It is a form of black-box testing
 * Stories are short descriptions of a feature told from the user perspective
 * We sometimes call these tests acceptance tests 
 * Non-functional requirements are not usually things the users will include in their stories. 
 * lowest level tests are unit tests. They test one unit of code, usually a method, written by developer.
 * Groups of related tests are called a test suite. After unit tests, we have integration tests
 * */


//Git
/*git init
 * echo Git rocks! > MyFile.txt
 * git add MyFile.txt
 * git status
 * git commit -m "First commit, hooray!"
 * */


//Jenkins
/* cd C:\Users\User\OneDrive\Documents\PROG39599\HelloJenkins\src
  javac Hello.java
  java Hello*/
