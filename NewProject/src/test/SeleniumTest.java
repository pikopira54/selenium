package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	
	
        public static void main(String[] args) {
 
        	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        	WebDriver driver = new ChromeDriver();
        	
        	driver.get("https://www.mortgageloan.com/calculator");
        	
        	driver.findElement(By.id("KJE-INTEREST_RATE")).clear();
        	driver.findElement(By.id("KJE-INTEREST_RATE")).sendKeys("5%");
        	driver.findElement(By.id("KJE-TERM")).sendKeys("30");
        	
        	driver.findElement(By.id("KJECalculate")).click();
        	
        	//System.out.println("Geek Name is : "+driver.findElement(By.className("KJEGraphTitle")).getAttribute("innerText"));
        	
        	String expectedMonthlyPayment = "$1,073.64";
        	String expectedTotalPayments = "Total Payments $386,513";
        	String expectedTotalInterest = "Total Interest $186,513";

        	//test Monthly Payment
        	String monthlyPayment = driver.findElement(By.id("KJE-MONTHLY_PAYMENT")).getText();
        	
        	System.out.println("Test 1 : ");
        	
        	if(expectedMonthlyPayment.equals(monthlyPayment))
              	System.out.println("Passed. The expected Montlhy Payment is same as actual --- "+monthlyPayment);
        	else
              	System.out.println("Failed. The expected Montlhy Payment doesn't match the actual --- "+monthlyPayment);

        	//test Total Payments
        	String lines[] = driver.findElement(By.className("KJEGraphTitle")).getText().split("\\r?\\n");
        	
        	String totalPayments = lines[0];
           	String totalInterest = lines[1];
        	
        	System.out.println("Test 2 : ");
        	
        	if(expectedTotalPayments.equals(totalPayments))
              	System.out.println("Passed. The expected Total Payment is same as actual --- "+totalPayments);
        	else
              	System.out.println("Failed. The expected Total Payment doesn't match the actual --- "+totalPayments);

        	//test Total Interest
        	
        	System.out.println("Test 3 : ");
        	
        	if(expectedTotalInterest.equals(totalInterest))
              	System.out.println("Passed. The expected Total Interest is same as actual --- "+totalInterest);
        	else
              	System.out.println("Failed. The expected Total Interest doesn't match the actual --- "+totalInterest);

        	
        	driver.close();
        }
}
