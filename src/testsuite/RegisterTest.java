package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseURL = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup (){
        openbrowser (baseURL);
    }


    @Test
    public void verifyThatSignInPageDisplay () {
        WebElement createAnAccountLink = driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[3]/a[1]"));
        createAnAccountLink.click();
        String expectedText = "Create New Customer Account";
        WebElement customerAccount = driver.findElement(By.xpath("//span[contains(text(),'Create New Customer Account')]"));
        String actualText = customerAccount.getText();
        Assert.assertEquals("Page not displayed", expectedText, actualText);
    }
@Test
        public void userShouldRegisterAccountSuccessfully (){
            WebElement createAnAccountLink = driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[3]/a[1]"));
            createAnAccountLink.click();
    driver.findElement(By.id("firstname")).sendKeys("Mayuri");
    driver.findElement(By.id("lastname")).sendKeys("Patel");
    driver.findElement(By.id("email_address")).sendKeys("computer.tester009@gmail.com");
    driver.findElement(By.id("password")).sendKeys("Test12345");
    driver.findElement(By.id("password-confirmation")).sendKeys("Test12345");
    driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]/span[1]")).click();
    String expectedText = "Thank you for registering with Main Website Store.";
    WebElement register = driver.findElement(By.xpath("//div[contains(text(),'Thank you for registering with Main Website Store.')]"));
    String actualText = register.getText();
    Assert.assertEquals("Page not displayed", expectedText, actualText);
    driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/span[1]/button[1]")).click();
    driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/div[1]/ul[1]/li[3]/a[1]")).click();
    String expectedText1 = "You are signed out";
    WebElement  signoutText = driver.findElement(By.xpath("//span[contains(text(),'You are signed out')]"));
    String actualText1 = signoutText.getText();
    Assert.assertEquals("Page not displayed", expectedText, actualText);

        }

    }
//@After
//    public void teardown(){
//        driver.quit();
//    }

