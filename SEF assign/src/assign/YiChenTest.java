package assign;

import static org.junit.Assert.*;
import exception.*;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class YiChenTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
		Robot robot = new Robot();
		Driver.resp = "4";
		Driver.main(null);
//		robot.keyPress(KeyEvent.VK_4);
//		robot.keyRelease(KeyEvent.VK_4);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		Driver.cUser = Driver.users.get(0);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@Before
	public void setUp() throws Exception {
		
		System.out.println("before each");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after each");
	}

	@Test
	public void testCreateComplaint1() throws TargetNotFoundException, WrongTargetTypeException {
		Driver.resp ="e1";
		Driver.complaintHandler();
		System.out.println(Driver.complaints.get(Driver.complaints.size() -1).getTarget());
		
		
		
	}
	@Test
	public void testCreateComplaint2() throws TargetNotFoundException, WrongTargetTypeException {
		Driver.resp = "e1";
		Driver.complaintHandler();
		Driver.resp ="e2";
		Driver.complaintHandler();
		System.out.println(Driver.complaints.get(Driver.complaints.size() -1).getTarget());
		
		
	}
	@Test (expected=TargetNotFoundException.class)
	public void testCreateComplaint3() throws TargetNotFoundException, WrongTargetTypeException {
		Driver.resp ="a3";
		Driver.complaintHandler();
		
	}
	@Test (expected=WrongTargetTypeException.class)
	public void testCreateComplaint4() throws TargetNotFoundException, WrongTargetTypeException {
		Driver.resp ="a2";
		Driver.complaintHandler();
		
	}

}
