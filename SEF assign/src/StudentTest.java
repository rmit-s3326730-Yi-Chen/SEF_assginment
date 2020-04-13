import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTest {
	Student s1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@Before
	public void setUp() throws Exception {
		s1 = new Student("s1","123");
		System.out.println("before each");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after each");
	}

	@Test
	public void testSetType1() {
		s1.setType(0);
		assertEquals(s1.getType(),StudentType.Local);
		System.out.println("test 1");
		
	}
	@Test
	public void testSetType2() {
		s1.setType(1);
		assertEquals(s1.getType(),StudentType.International);
		System.out.println("test 2");
		
	}
	@Test
	public void testSetType3() {
		s1.setType(3);
		assertEquals(s1.getType(),null);
		System.out.println("test 3");
		
	}


}
