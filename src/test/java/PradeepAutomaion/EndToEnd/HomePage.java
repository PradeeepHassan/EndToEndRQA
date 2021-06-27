package PradeepAutomaion.EndToEnd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BaseClass.BaseURL;
import com.qa.diffrentpages.QaAccademyHomePage;
import com.qa.diffrentpages.QaAccademyLoginPage;

public class HomePage extends BaseURL {
	
	
	
//	 public static Logger log =LogManager.getLogger(BaseURL.class.getName());
//		@BeforeTest
//		public void initialize() throws IOException
//		{
//		
//			 driver =intilizedriver();
//
//		}
	
	
	
	@Test(dataProvider = "getData")
	
	public void openBrowser(String USname, String PSword)  {
		
//		intilizedriver();
//		driver.navigate().to(prop.getProperty("URL"));
		driver.manage().window().maximize();
		log.info("browser maximized");
		QaAccademyHomePage qa=new QaAccademyHomePage(driver);
		qa.handlingHomePagePopup();
		qa.clickLoginButton();
		log.info("Its clicked on login button");
		QaAccademyLoginPage qaL=new QaAccademyLoginPage(driver);
		qaL.loginCredential(USname, PSword);
		log.info(" Its entered the log page information");
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object [][] data= new Object [2][2];
		
		data [0][0]="pradeep";
		data [0][1]="pradeep123";
		
		data [1][0]="rupert";
		data [1][1]="rupert123";
		return data;
		
	}
	
	
	
//	@Test
	
//	public void textCheck() throws IOException {
//		
////		intilizedriver();
////		driver.navigate().to(prop.getProperty("URL"));
//		driver.manage().window().maximize();
//		log.info("browser maximized");
//		QaAccademyHomePage qa=new QaAccademyHomePage(driver);
//		qa.handlingHomePagePopup();
//		System.out.println(qa.checkText());
//		Assert.assertEquals(qa.checkText(), "FEATURED COURSES");
//		Assert.assertTrue(qa.contactCheck());
//		log.info("text content checked properly");
//		driver.quit();
//		
//	}
	
//	@AfterTest
//	public void teardown()
//	{
//		
//		driver.close();
//	
//		
//	}


	@Test(dataProvider = "getData1")
	
	public void dataBaseTesting(String USname, String PSword) throws SQLException  {
		
		driver.manage().window().maximize();
		log.info("browser maximized");
		QaAccademyHomePage qa=new QaAccademyHomePage(driver);
		qa.handlingHomePagePopup();
		qa.clickLoginButton();
		log.info("Its clicked on login button");
		QaAccademyLoginPage qaL=new QaAccademyLoginPage(driver);
		qaL.loginCredential(USname, PSword);
		log.info(" Its entered the log page information");
		driver.quit();
		
		
			
		}
	
	
	@DataProvider
	
	public Object[][]  getData1() throws SQLException{
		
		Connection con=DriverManager.getConnection("jdbc:mysql://"+"localhost"+":"+"3306"+"/mm_b2b_customer", "root", "pradeep@123");
		
		Statement s=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=s.executeQuery("SELECT * FROM mm_b2b_customer.customer_mst_old where first_name =\"Rupert\"");
		
		int size=0;
		
		if(rs.last()) {
			
			size=rs.getRow();
			rs.beforeFirst();
		}
		
		
//		rs.last();
//		int size=rs.getRow();
//		rs.beforeFirst();
//		int size=3;
		
//		while(rs.next()) {
//			
//			size++;
//		}
		
		
		Object data1[][]= new Object[size][2];
		
		
			
			for(int i=0; i<size; i++) {
				while(rs.next()) {
				data1[i][0]=rs.getString("first_name");
				data1[i][1]= rs.getString("last_name");
				i++;
				
			
				}
				
			
		}
		
		return data1;
	}
}
