package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollPageFlipkartTesting {
	private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the Microsoft Edge WebDriver
        System.setProperty("webdriver.edge.driver", "C:\\Users\\uppal\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        // Create a new instance of the Edge driver
        driver = new EdgeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testImageDownloadTiming() throws InterruptedException{
        // Step 1: Navigate to Google
        driver.get("https://www.google.com");
        
        // Navigate to Google
        //driver.get("https://www.flipkart.com/");

        // Perform a search for "Flipkart" on Google
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Flipkart");
        searchBox.sendKeys(Keys.RETURN);

        // Find the Flipkart link and click on it
        WebElement flipkartLink = driver.findElement(By.partialLinkText("Flipkart"));
        flipkartLink.click();
        
        // Wait for Flipkart website to load
        Thread.sleep(5000); // Adjust the time based on your network speed and page load time
        
        
        // Once on the Flipkart website, locate the search box and enter the search query "iPhone 13" under the "Mobile" category
        WebElement flipkartSearchBox = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[2]/div/div/span"));
        WebElement flipkartSearchBoxInMobile = driver.findElement(By.name("q"));
        flipkartSearchBoxInMobile.sendKeys("iPhone 13");
        flipkartSearchBoxInMobile.sendKeys(Keys.RETURN);

        Thread.sleep(5000);
        
        // Scroll to the position of the first image
        WebElement firstImage = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[1]/div[1]/div/div/img"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstImage);

        // Check if the image is present in the DOM before scrolling
        Assert.assertTrue(firstImage.isDisplayed(), "Image is not present in the Document Object Model before scrolling");

        // Scroll down the page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Check if the image is still present in the DOM after scrolling
        Assert.assertTrue(firstImage.isDisplayed(), "Image is not present in the Document Object Model after scrolling");

    }
    
    @Test(priority=2)
    public void testNavigationToBottom() throws InterruptedException{
        // Step 1: Navigate to Google
        driver.get("https://www.google.com");
        
        // Navigate to Google
        //driver.get("https://www.flipkart.com/");

        // Perform a search for "Flipkart" on Google
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Flipkart");
        searchBox.sendKeys(Keys.RETURN);
        
        // Find the Flipkart link and click on it
        WebElement flipkartLink = driver.findElement(By.partialLinkText("Flipkart"));
        flipkartLink.click();

        // Wait for Flipkart website to load
        Thread.sleep(5000); // Adjust the time based on your network speed and page load time
        
        // Once on the Flipkart website, locate the search box and enter the search query "iPhone 13" under the "Mobile" category
        WebElement flipkartSearchBox = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[2]/div/div/span"));
        WebElement flipkartSearchBoxInMobile = driver.findElement(By.name("q"));
        flipkartSearchBoxInMobile.sendKeys("iPhone 13");
        flipkartSearchBoxInMobile.sendKeys(Keys.RETURN);
        Thread.sleep(5000);
        
        // Scroll to the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        double initialScrollHeight = Long.parseLong(js.executeScript("return document.body.scrollHeight").toString());
        double currentScrollHeight = 0;
        double newScrollHeight = initialScrollHeight;
        do {
            js.executeScript("window.scrollBy(0, 100)");
            Thread.sleep(500); // Add a delay of 500 milliseconds between each scroll action
            currentScrollHeight = newScrollHeight;
            newScrollHeight = Double.parseDouble(js.executeScript("return window.pageYOffset").toString());
        } while (newScrollHeight != currentScrollHeight);

        // Check if an element at the bottom of the page is visible
        WebElement bottomElement = driver.findElement(By.xpath("//footer"));
        boolean isBottomVisible = bottomElement.isDisplayed();

        // Verify that the page navigates to the bottom
        Assert.assertTrue(isBottomVisible, "Page did not navigate to the bottom");
    }


    @AfterClass
    public void method() {
    	// Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
