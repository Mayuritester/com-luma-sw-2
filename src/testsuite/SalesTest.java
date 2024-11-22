package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SalesTest extends BaseTest {

    String BaseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup (){ openbrowser(BaseUrl);}

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketPage (){
        driver.findElement(By.xpath("//span[contains(text(),'Sale')]")).click();
        driver.findElement(By.xpath("//body/div[2]/main[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
        String expectedText = "Jackets";
        WebElement jackets = driver.findElement(By.xpath("//body/div[2]/main[1]/div[1]/h1[1]/span[1]"));
        String actualText = jackets.getText();
        Assert.assertEquals("not display", actualText,expectedText);

       List<WebElement> itemElements = driver.findElements(By.className("product-image-photo"));
     System.out.println("Total items are " + itemElements.size());

     List<WebElement> items = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        System.out.println("Items" + items.size());

        for (WebElement link : items ){
            System.out.println(link.getText());
        }
//

    }



}
