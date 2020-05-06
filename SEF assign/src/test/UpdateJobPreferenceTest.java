package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import assign.Applicant;
import assign.JobCategory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UpdateJobPreferenceTest {

	private List<String> jobCategories = new ArrayList<>(
            Arrays.asList("Engineer","Teacher","Nurse","Librarian")
    );
	private List<String> jobPreferences = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	
	public List<String> getJobCategories() {
		return jobCategories;
	}

	public void setJobCategories(List<String> jobCategories) {
		this.jobCategories = jobCategories;
	}

	public List<String> getJobPreferences() {
		return jobPreferences;
	}

	public void setJobPreferences(List<String> jobPreferences) {
		this.jobPreferences = jobPreferences;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("****The test start****");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("****The test finished!****");
	}

	@Test
	public void test1() {
		// add new job preferences named "Engineer" and "Teacher"
		String response = "Engineer";
		String response1 = "Teacher";
	    if (getJobCategories().contains(response)) {
	        this.jobPreferences.add(response);
	        System.out.println("Right input, the job preference has added successfully");
	       assertTrue(response,getJobCategories().contains(response));
	      } else {
	        System.out.println("Wrong input and please try again");
	        assertFalse(response,getJobCategories().contains(response));
	      }
	    if (getJobCategories().contains(response1)) {
	        this.jobPreferences.add(response1);
	        System.out.println("Right input, the job preference has added successfully");
	      } else {
	        System.out.println("Wrong input and please try again");
	        
	      }
		      
	}
	
	
	}


