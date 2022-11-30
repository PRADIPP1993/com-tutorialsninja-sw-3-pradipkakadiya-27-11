package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utiltiy;

public class TopMenuTest extends Utiltiy {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        clickOnElement(By.linkText(menu));
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        driver.findElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]")).click();
        Actions actions = new Actions(driver);
        WebElement Desktops = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(Desktops).click().build().perform();
//1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show All Desktops");

        //1.3 Verify the text ˜Laptops & Notebooks
        verifyText("Desktops", By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
    }


    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        driver.findElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]")).click();

        Actions actions = new Actions(driver);
        WebElement LaptopsNotebooks = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        actions.moveToElement(LaptopsNotebooks).click().build().perform();
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show All Laptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        verifyText("Laptops & Notebooks", By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        driver.findElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]")).click();

        //3.1 Mouse hover on Components Tab and click
        Actions actions = new Actions(driver);
        WebElement Components = driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
        actions.moveToElement(Components).click().build().perform();
        //3.2 call selectMenu method and pass the menu = Show All Components
        selectMenu("Show All Components");
        //3.3 Verify the text Components
        verifyText("Components", By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
