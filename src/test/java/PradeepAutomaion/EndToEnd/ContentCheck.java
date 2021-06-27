package PradeepAutomaion.EndToEnd;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseClass.BaseURL;
import com.qa.diffrentpages.QaAccademyHomePage;

public class ContentCheck extends BaseURL {
	
	
	
	
	@Test
	
public void textCheck() throws IOException {
		
//		intilizedriver();
//		driver.navigate().to(prop.getProperty("URL"));
		driver.manage().window().maximize();
		log.info("browser maximized");
		QaAccademyHomePage qa=new QaAccademyHomePage(driver);
		qa.handlingHomePagePopup();
		System.out.println(qa.checkText());
		Assert.assertEquals(qa.checkText(), "FEATURED COURSES");
		Assert.assertTrue(qa.contactCheck());
		log.info("text content checked properly");
		driver.quit();
		
	}
	
	

}
