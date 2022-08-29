package homework;

public class TestCaseTests {
	
	public static void main(String[] args) throws InterruptedException {
		
		TestCases obj = new TestCases();
		
		obj.setUp();
		
		obj.rightClick();
		
		obj.doubleClick();;
		
		obj.dragAndDrop();
		
		obj.addNewJob();
		
		obj.searchForEmployee();
		
		obj.tearDown();
		
	}

}