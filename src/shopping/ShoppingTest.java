package shopping;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ShoppingTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlledRobot() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyElements("error message", "Bestsellers", By.xpath("//h1[contains(text(),'Bestsellers')]"));
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name A - Z')]"));
        mouseHover(By.xpath("//img[@class = 'photo ls-is-cached lazyloaded' and @alt='iPhone 5S']"));
        Thread.sleep(2000);
        mouseHoverAndClick(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-42')]//span[contains(text(),'Add to cart')]"));
        verifyElements("error message", "Product has been added to your cart", By.xpath("//li[@class='info']"));
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("(//a[@class='regular-button cart'])[1]"));
        verifyElements("error message", "Your shopping cart - 1 item", By.xpath("//h1[@id='page-title']"));
        verifyElements("subtotal error message", "299", By.xpath("(//span[@class='part-integer'][normalize-space()='299'])[4]"));
        verifyElements("total integer error message", "309", By.xpath("(//span[normalize-space()='309'])[1]"));
        verifyElements("total decimal error message", "73", By.xpath("(//span[@class='part-decimal'][normalize-space()='73'])[2]"));
        clickOnElement(By.xpath("(//button[contains(@class,'regular-button regular-main-button checkout')])[1]"));
        verifyElements(" error message", "Log in to your account", By.xpath("//h3[contains(text(),'Log in to your account')]"));
        sendTextToElement(By.id("email"), "rajeshkumar45454=@gmail.com");
        clickOnElement(By.xpath("(//button[contains(@class,'regular-button anonymous-continue-button submit')])[1]"));
        verifyElements("error message", "Secure Checkout", By.xpath("(//h1[normalize-space()='Secure Checkout'])[1]"));
        sendTextToElement(By.id("shippingaddress-firstname"), "Peter");
        sendTextToElement(By.id("shippingaddress-lastname"), "Smith");
        sendTextToElement(By.id("shippingaddress-street"), "123 High Street");
        sendTextToElement(By.id("shippingaddress-city"), "London");
        selectByVisibleTextFromDropDown(By.id("shippingaddress-country-code"), "United Kingdom");
        sendTextToElement(By.id("shippingaddress-custom-state"), "London");
        sendTextToElement(By.id("shippingaddress-zipcode"), "EC115QP");
        sendTextToElement(By.id("shippingaddress-phone"), "12345678");

        clickOnElement(By.xpath("//input[@id='create_profile']"));
        sendTextToElement(By.xpath("//input[@id='password']"), "Temp@7000");
        clickOnElement(By.id("method128"));
        clickOnElement(By.id("pmethod6"));
        verifyElements("total integer error message", "Place order: $311.03", By.xpath("(//span[normalize-space()='Place order: $311.03'])[1]"));
        clickOnElement(By.xpath("(//button[@class='btn regular-button regular-main-button place-order submit'])[1]"));
        Thread.sleep(1000);
        //verifyElements("Error message","Thank you for your order",By.id("page-title"));
    }
    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyElements("error message","Bestsellers",By.xpath("//h1[contains(text(),'Bestsellers')]"));
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name A - Z')]"));
        Thread.sleep(2000);
        mouseHover(By.xpath("//a[@class='product-thumbnail next-previous-assigned']/img[@alt='Vinyl Idolz: Ghostbusters']"));
        mouseHoverAndClick(By.xpath("(//button[contains(@class,'regular-button add-to-cart product-add2cart productid-13')])[1]"));
        //mouseHoverAndClick(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-42')]//span[contains(text(),'Add to cart')]"));
        verifyElements("error message","Product has been added to your cart",By.xpath("//li[@class='info']"));
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("(//a[@class='regular-button cart'])[1]"));
        verifyElements("error message","Your shopping cart - 1 item",By.xpath("//h1[@id='page-title']"));
        clickOnElement(By.xpath("(//a[normalize-space()='Empty your cart'])[1]"));
        String message = getTextFromAlert();
        verifyMessageText("Are you sure you want to clear your cart?", message, "Error, Message not displayed as expected");
        Thread.sleep(500);
        acceptAlert();
        Thread.sleep(2000);
        verifyElements("error message","Item(s) deleted from your cart",By.xpath("//li[@class='info']"));
        verifyElements("error","Your cart is empty",By.xpath("//h1[@id='page-title']"));
    }
    @After
    public void tearDown() {
         closeBrowser();
    }
}


