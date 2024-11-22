package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String BaseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup (){ openbrowser(BaseUrl);}

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("computer.tester009@gmail.com");
        driver.findElement(By.xpath("//body/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/input[1]")).sendKeys("Test12345");
        driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[4]/div[1]/button[1]/span[1]")).click();
        String expectedText = "Welcome, Mayuri Patel!";
        WebElement welcome = driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[1]/span[1]"));
        String actualText = welcome.getText();
        Assert.assertEquals("Page not displayed", expectedText, actualText);
    }
        @Test
                public void verifyTheErrorMessageWithInvalidCredentials (){
            driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("computer.tester00@gmail.com");
            driver.findElement(By.xpath("//body/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/input[1]")).sendKeys("Test12345");
            driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[4]/div[1]/button[1]/span[1]")).click();
            String expectedText2 = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
            WebElement errorText = driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect or your account ')]"));
            String actualText2 = errorText.getText();
            Assert.assertEquals("Page not displayed", expectedText2, actualText2);
        }

        @Test
    public void userShouldLogOutSuccessfully (){
            driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("computer.tester009@gmail.com");
            driver.findElement(By.xpath("//body/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/input[1]")).sendKeys("Test12345");
            driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[4]/div[1]/button[1]/span[1]")).click();

            String expectedText = "Welcome, Mayuri Patel!";
            WebElement welcome1 = driver.findElement (By.className("logged-in"));
            String actualText = welcome1.getText();
            Assert.assertEquals("Page not displayed", expectedText, actualText);


            driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/span[1]/button[1]")).click();
            driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/div[1]/ul[1]/li[3]/a[1]")).click();

            String expectedText1 = "You are signed out";
            WebElement  signoutText = driver.findElement(By.xpath("//span[contains(text(),'You are signed out')]"));
            String actualText1 = signoutText.getText();
            Assert.assertEquals("Page not displayed", expectedText, actualText);

        }
    }

