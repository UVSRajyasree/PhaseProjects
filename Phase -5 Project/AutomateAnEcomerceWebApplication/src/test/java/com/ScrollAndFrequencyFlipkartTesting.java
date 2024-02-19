package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollAndFrequencyFlipkartTesting {
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

    @Test(priority=1)
    public void testScrollFeature() throws InterruptedException{
        // Navigate to Google
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

        // Check if the page has a scroll feature
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isScrollable = (boolean) js.executeScript("return document.documentElement.scrollHeight > document.documentElement.clientHeight;");
        if (isScrollable) {
            System.out.println("The page has a scroll feature.");
        } else {
            System.out.println("The page does not have a scroll feature.");
        }
    }
    
    @Test(priority=2)
    public void testScrollRefreshFrequency() throws InterruptedException{
        // Navigate to Google
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

        // Scroll the page to trigger content refresh
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        long startTime = System.currentTimeMillis();
        double initialScrollHeight = Long.parseLong(js.executeScript("return document.body.scrollHeight").toString());
        double currentScrollHeight = 0;
        double newScrollHeight = initialScrollHeight;
        do {
            js.executeScript("window.scrollBy(0, 100)");
            Thread.sleep(500); // Add a delay of 500 milliseconds between each scroll action
            currentScrollHeight = newScrollHeight;
            newScrollHeight = Double.parseDouble(js.executeScript("return window.pageYOffset").toString());
        } while (newScrollHeight != currentScrollHeight);

        // Measure the time intervals between scroll events
        
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        long endTime = System.currentTimeMillis();

        long scrollInterval = endTime - startTime;
        System.out.println("Content refresh frequency: " + scrollInterval + " milliseconds");
    }


    @AfterClass
    public void method() {
    	 // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
