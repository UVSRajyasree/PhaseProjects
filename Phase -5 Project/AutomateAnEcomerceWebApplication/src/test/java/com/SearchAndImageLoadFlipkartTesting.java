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

public class SearchAndImageLoadFlipkartTesting {
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

	    @Test(priority = 1)
	    public void testSearchProduct() throws InterruptedException{
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
	    }

	    @Test(priority = 2)
	    public void testImageLoad() {
	        // Step 4: Check if the images are loaded and visible till the screen height only
	        WebElement firstImage = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[1]/div[1]/div/div/img")); 
            Assert.assertTrue(firstImage.isDisplayed(), "First image is not displayed");

            // Get the screen height
            int screenHeight = driver.manage().window().getSize().getHeight();

	        // Get the image height
	        int imageHeight = firstImage.getSize().getHeight();

	        // Verify if the image height is less than or equal to the screen height
	        Assert.assertTrue(imageHeight <= screenHeight, "Image height is greater than screen height");
	        
	        if (firstImage.isDisplayed()) {
	            // Get the screen height
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            String script = "return window.innerHeight";
	            //Long screenHeight = (Long) js.executeScript(script);
	            System.out.println("Screen height for the loaded images: " + screenHeight + " pixels");
	        } else {
	            System.out.println("Images are not loaded.");
	        }
	    }
	    
	    @AfterClass
	    public void method() {
	    	// Close the browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
