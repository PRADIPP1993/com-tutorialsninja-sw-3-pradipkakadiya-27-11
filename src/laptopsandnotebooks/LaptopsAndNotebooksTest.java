package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utiltiy;

public class LaptopsAndNotebooksTest extends Utiltiy {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws NumberFormatException {
        //1.1 Mouse hover on Laptops & Notebooks Tab
        driver.findElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]")).click();

        mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        //1.2 Click on “Show All Laptops & Notebooks”

        driver.findElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]")).click();

        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");


        //1.4 Verify the Product price will arrange in High to Low order.

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        driver.findElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]")).click();
        mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        //2.2 Click on Show All Laptops & Notebooks
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        //2.4 Select Product MacBookâ
        clickOnElement(By.xpath("//a[text()='MacBook']"));
        //2.5 Verify the text MacBook
        verifyText("MacBook", (By.xpath("//h1[contains(text(),'MacBook')]")));
        //2.6 Click Add To Cart button
        clickOnElement(By.id("button-cart"));
        //2.7 Verify the message success: You have added MacBook to your shopping cart
        verifyText("Success: You have added MacBook to your shopping cart!\n" +
                "×", (By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        //2.8 Click on link shopping cart display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.9 Verify the text "Shopping Cart"
        verifyText("Shopping Cart", (By.xpath("//a[contains(text(),'Shopping Cart')]")));
        //2.10 Verify the Product name "MacBook"
        verifyText("MacBook", (By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")));
        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        //2.12 Click on Update Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]"));
        //2.13 Verify the message â€œSuccess: You have modified your shopping cart
        verifyText("Success: You have modified your shopping cart!\n" +
                "×", (By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        //2.14 Verify the Total
        verifyText("$1,204.00", (By.xpath("//tbody/tr[1]/td[6]")));
        //2.15 Click on
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 Verify the t
        verifyText("Checkout", (By.xpath("//h1[contains(text(),'Checkout')]")));
        //2.17 Verify the Text
        Thread.sleep(3000);
        verifyText("New Customer", (By.xpath("//h2[contains(text(),'New Customer')]")));
        //2.18 Click on est Checkoutradio button
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]"));
        //2.19 Click on Continue tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"), "pradip");
        sendTextToElement(By.id("input-payment-lastname"), "patel");
        sendTextToElement(By.id("input-payment-email"), "prpradipraidp@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"), "8653502411");
        sendTextToElement(By.id("input-payment-address-1"), "puna");
        sendTextToElement(By.id("input-payment-city"), "London");
        sendTextToElement(By.id("input-payment-postcode"), "HA8 5QL");
        selectByVisibleTextFromDropDown(By.id("input-payment-country"), "Armenia");
        selectByVisibleTextFromDropDown(By.id("input-payment-zone"), "Kotayk'");
        Thread.sleep(2000);
        //2.21 Click on contiue Button
        clickOnElement(By.id("button-guest"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.name("comment"), "Please consider my order ASAP");
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.name("agree"));
        //2.24 Click on Continue button
        clickOnElement(By.id("button-payment-method"));
        //2.25 Verify the message Warning: Payment method required!"
        verifyText("Warning: Payment method required!\n" +
                "×", (By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
    }

    @After
    public void testDown() {
        closeBrowser();
    }
}
