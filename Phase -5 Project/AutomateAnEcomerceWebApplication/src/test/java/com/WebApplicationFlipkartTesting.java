package com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebApplicationFlipkartTesting {
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
    public void testOpenFlipkartWebsite() {
        // Navigate to Google
        driver.get("https://www.google.com");
        
        // Navigate to Google
        //driver.get("https://www.flipkart.com/");

        // Perform a search for "Flipkart" on Google
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Flipkart");
        searchBox.sendKeys(Keys.RETURN);

        // Click on the Flipkart link in the search results
        WebElement flipkartLink = driver.findElement(By.partialLinkText("Flipkart"));
        flipkartLink.click();
    }
    
    @Test(priority=2)
    public void testPageLoadTime() {
    	 // Navigate to Google
        driver.get("https://www.google.com");
        
        // Navigate to Google
        //driver.get("https://www.flipkart.com/");

        // Perform a search for "Flipkart" on Google
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Flipkart");
        searchBox.sendKeys(Keys.RETURN);

        long startTime = System.currentTimeMillis();
        // Click on the Flipkart link in the search results
        WebElement flipkartLink = driver.findElement(By.partialLinkText("Flipkart"));
        flipkartLink.click();
        long endTime = System.currentTimeMillis();
        long pageLoadTime = endTime - startTime;
        System.out.println("Page load time: " + pageLoadTime + " milliseconds");
    }
    @AfterClass
    public void method() {
    	// Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

}
