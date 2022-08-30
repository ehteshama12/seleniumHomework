package homework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TestCases {
	
	WebDriver driver;
	
	public void setUp() {

		String key = "webdriver.chrome.driver";
		String path = "C:\\Users\\extre\\OneDrive\\Desktop\\B7-Selenium\\chromedriver.exe";
		System.setProperty(key, path);

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}
	
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
		
	}
	
	//right click 
	
	public void rightClick() throws InterruptedException {
	
	driver.get("https://demo.guru99.com/test/simple_context_menu.html");
	
	WebElement rightClick = driver.findElement(By.xpath("//*[contains(text(), 'right click me')]"));
	
	Actions action = new Actions(driver);
	
	action.contextClick(rightClick).build().perform();

	WebElement copy = driver.findElement(By.xpath("//span[text()= 'Copy']"));
	
	copy.click();
	
	Alert alert = driver.switchTo().alert();
	
	String alertText = alert.getText();
	
	System.out.println("Alert Message: " + alertText);

	Thread.sleep(2000);
	
	alert.accept();
	
	System.out.println("Test Case 1 Done");
	
	}
	
	//double click
	
	public void doubleClick() throws InterruptedException {
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		WebElement doubleClick = driver.findElement(By.xpath("//*[contains(text(), 'Double-Click Me To See Alert')]"));
		
		Actions action = new Actions(driver);
		
		action.doubleClick(doubleClick).build().perform();

		Alert alert = driver.switchTo().alert();
		
		String alertText = alert.getText();
		
		System.out.println("Alert Message: " + alertText);
		
		Thread.sleep(2000);
		
		alert.accept();
		
		System.out.println("Test Case 2 Done");
		
	}
	
	//drag and drop
	
	public void dragAndDrop() throws InterruptedException {
	
	driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	
	WebElement capital1 = driver.findElement(By.xpath("//*[@id='box1']"));
	WebElement capital2 = driver.findElement(By.xpath("//*[@id='box2']"));
	WebElement capital3 = driver.findElement(By.xpath("//*[@id='box3']"));
	WebElement capital4 = driver.findElement(By.xpath("//*[@id='box4']"));
	WebElement capital5 = driver.findElement(By.xpath("//*[@id='box5']"));
	WebElement capital6 = driver.findElement(By.xpath("//*[@id='box6']"));
	WebElement capital7 = driver.findElement(By.xpath("//*[@id='box7']"));
	
	WebElement country1 = driver.findElement(By.xpath("//*[@id='box101']"));
	WebElement country2 = driver.findElement(By.xpath("//*[@id='box102']"));
	WebElement country3 = driver.findElement(By.xpath("//*[@id='box103']"));
	WebElement country4 = driver.findElement(By.xpath("//*[@id='box104']"));
	WebElement country5 = driver.findElement(By.xpath("//*[@id='box105']"));
	WebElement country6 = driver.findElement(By.xpath("//*[@id='box106']"));
	WebElement country7 = driver.findElement(By.xpath("//*[@id='box107']"));
	
	Actions action = new Actions(driver);
	
	action.dragAndDrop(capital1, country1);
	Thread.sleep(1000);
	
	action.dragAndDrop(capital2, country2);
	Thread.sleep(1000);
	
	action.dragAndDrop(capital3, country3);
	Thread.sleep(1000);
	
	action.dragAndDrop(capital4, country4);
	Thread.sleep(1000);
	
	action.dragAndDrop(capital5, country5);
	Thread.sleep(1000);
	
	action.dragAndDrop(capital6, country6);
	Thread.sleep(1000);
	
	action.dragAndDrop(capital7, country7);
	Thread.sleep(1000);
	
	System.out.println("Test Case 3 Done");
	
	}
	
	//add new job
	
	public void addNewJob() throws InterruptedException {
	
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	WebElement username = driver.findElement(By.xpath("//input[contains(@name, 'username')]"));
			
	username.sendKeys("Admin");
	
	WebElement password = driver.findElement(By.xpath("//input[contains(@name, 'password')]"));
	
	password.sendKeys("admin123");
	
	WebElement login = driver.findElement(By.xpath("//*[@type= 'submit']"));
	
	login.click();
	
	WebElement Admin = driver.findElement(By.xpath("//span[text()='Admin']"));
	
	Actions action = new Actions(driver);
	
	action.moveToElement(Admin).click().build().perform();

	WebElement job = driver.findElement(By.xpath("//span[text()='Job ']"));
	
	action.moveToElement(job).click().build().perform();

	WebElement jobTitle = driver.findElement(By.xpath("//*[contains(text(),'Job Titles')]"));
	Thread.sleep(1000);
	
	action.moveToElement(jobTitle).click().build().perform();
	Thread.sleep(1000);
	
	WebElement add = driver.findElement(By.xpath("//button[text()=' Add ']"));
	
	add.click();
	
	WebElement typejobTitle = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input"));

	typejobTitle.sendKeys("SDET");
	
	WebElement jobDescription = driver.findElement(By.xpath("//textarea[@placeholder='Type description here']"));
			
	jobDescription.sendKeys("Software Development Engineer in Test");
			
	WebElement noteField = driver.findElement(By.xpath("//textarea[@placeholder='Add note']"));
	
	noteField.sendKeys("I am qualified for SDET");
	
	WebElement save = driver.findElement(By.xpath("//button[@type='submit']"));
	
	save.click();
	
	Thread.sleep(2000);
	
	String actualEntry = driver.findElement(By.xpath("//*[contains(text(),'SDET')]")).getText();
			
	String expectedEntry = "SDET";
	
	Assert.assertEquals(actualEntry, expectedEntry, "job title did not match");
	
	System.out.println("Test Case 4 Done");
	
	}
	
	//search for employee
	
	public void searchForEmployee() throws InterruptedException {
	
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	WebElement username = driver.findElement(By.xpath("//input[contains(@name, 'username')]"));
			
	username.sendKeys("Admin");
	
	WebElement password = driver.findElement(By.xpath("//input[contains(@name, 'password')]"));
	
	password.sendKeys("admin123");
	
	WebElement login = driver.findElement(By.xpath("//*[@type= 'submit']"));
	
	login.click();
	
	WebElement PIM = driver.findElement(By.xpath("//span[text()='PIM']"));
	
	Actions action = new Actions(driver);
	
	action.moveToElement(PIM).click().build().perform();
	Thread.sleep(1000);
	
	WebElement employeeList = driver.findElement(By.xpath("//*[contains(text(),'Employee List')]"));
	Thread.sleep(1000);
	
	action.moveToElement(employeeList).click().build().perform();
	Thread.sleep(1000);
	
	WebElement idField = driver.findElement(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[2]//div[2]//input"));

	idField.sendKeys("0016");
	
	WebElement empStatus = driver.findElement(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[3]"));
	empStatus.click();
	
	driver.findElement(By.xpath("//div[@role='listbox']//*[contains(text(),'Full-Time Permanent')]")).click();
	Thread.sleep(1000);

	WebElement include = driver.findElement(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[4]"));
	
	driver.findElement(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[4]"));
	
	include.click();
	
	WebElement currAndPastEmp = driver.findElement(By.xpath("//*[contains(text(),'Current and Past Employees')]"));
	
	action.moveToElement(currAndPastEmp).click().build().perform();
	Thread.sleep(1000);
		
	WebElement subUnit = driver.findElement(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[7]"));
	
	action.moveToElement(subUnit).click().build().perform();
	Thread.sleep(1000);
	
	WebElement administration = driver.findElement(By.xpath("//*[contains(text(),'Administration')]"));
	
	action.moveToElement(administration).click().build().perform();
	Thread.sleep(1000);
	
	WebElement search = driver.findElement(By.xpath("//*[contains(@type,'submit')]"));
	
	search.click();
	Thread.sleep(1000);
	
	String actualEntry1 = driver.findElement(By.xpath("//*[contains(text(),'Linda Jane')]")).getText();
	String actualEntry2 = driver.findElement(By.xpath("//*[contains(text(),'Anderson')]")).getText();
	String actualEntry3 = driver.findElement(By.xpath("//*[contains(text(),'VP - Sales & Marketing')]")).getText();
	String actualEntry4 = driver.findElement(By.xpath("//*[contains(text(),'Full-Time Permanent')]")).getText();
	
	String expectedEntry1 = "Linda Jane";
	String expectedEntry2 = "Anderson";
	String expectedEntry3 = "VP - Sales & Marketing";
	String expectedEntry4 = "Full-Time Permanent";
	
	Assert.assertEquals(actualEntry1, expectedEntry1, "First name does not match to Linda Jane");
	Assert.assertEquals(actualEntry2, expectedEntry2, "Last name does not match to Anderson");
	Assert.assertEquals(actualEntry3, expectedEntry3, "Job title does not contain to VP-Sales & Marketing");
	Assert.assertEquals(actualEntry4, expectedEntry4, "Employement status is not Full-Time Permanent or Freelance");
	
	Object actualEntry5 = "Freelance";
	
	Assert.assertTrue(actualEntry4.contains(expectedEntry4) || actualEntry5.equals("Freelance"), "Invalid Status");
	
	WebElement subUnitLength = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[7]/div"));
	
	action.moveToElement(subUnitLength).build().perform();
	
	String actual = "Administrative";
	
	int length = actual.length();
	
	SoftAssert obj = new SoftAssert();
	
	obj.assertEquals(length, 2, "It is not equal to 2");
	
	String supervisor = driver.findElement(By.xpath("//*[contains(text(),'John Smith')]")).getText();
	
	String firstName = supervisor.substring(0,4);
	
	System.out.println(firstName);
	
	System.out.println("Test Case 5 Done");
	
	driver.quit();
	
	obj.assertAll();
	
	}
	
}
