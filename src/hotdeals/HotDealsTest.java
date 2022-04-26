package hotdeals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class HotDealsTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {

        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyElements("error message","Sale",By.xpath("//h1[contains(text(),'Sale')]"));
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name A - Z')]"));
        verifyElements("error message","Name A - Z",By.xpath("//span[contains(text(),'Name A - Z')]"));
    }
    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyElements("error message","Sale",By.xpath("//h1[contains(text(),'Sale')]"));
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Price Low - High')]"));
        verifyElements("error message","Price Low - High",By.xpath("//span[contains(text(),'Price Low - High')]"));
    }
    @Test
    public void vefirySalesProductsArrangedByRates() throws InterruptedException {

        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyElements("error message","Sale",By.xpath("//h1[contains(text(),'Sale')]"));
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Rates')]"));
        verifyElements("Message not displayed as expected","Rates",By.xpath("//span[contains(text(),'Rates')]"));
    }
    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyElements("error message","Bestsellers",By.xpath("//h1[contains(text(),'Bestsellers')]"));
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name Z - A')]"));
        verifyElements("Message not displayed as expected","Name Z - A",By.xpath("//span[contains(text(),'Name Z - A')]"));

    }
    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyElements("error message","Bestsellers",By.xpath("//h1[contains(text(),'Bestsellers')]"));
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Price High - Low')]"));
        verifyElements("Message not displayed as expected","Price High - Low",By.xpath("//span[contains(text(),'Price High - Low')]"));
    }
    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyElements("error message","Bestsellers",By.xpath("//h1[contains(text(),'Bestsellers')]"));
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Rates')]"));
        verifyElements("Message not displayed as expected","Rates",By.xpath("//span[contains(text(),'Rates')]"));
    }
    @After
    public void tearDown(){
        //  closeBrowser();
    }

}