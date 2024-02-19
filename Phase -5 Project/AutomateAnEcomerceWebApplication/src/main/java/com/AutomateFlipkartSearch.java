package com;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class AutomateFlipkartSearch {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		 // Set the path to the Microsoft Edge WebDriver
        System.setProperty("webdriver.edge.driver", "C:\\Users\\uppal\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        
        // Create a new instance of the Edge driver
        WebDriver driver = new EdgeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();

        //Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Navigate to Google
        driver.get("https://www.google.com");
        
        // Find the search box element
        WebElement searchBox = driver.findElement(By.name("q"));
        
        // Enter the search query
        searchBox.sendKeys("Flipkart");
        
        // Submit the search
        searchBox.sendKeys(Keys.RETURN);
        
        // Pause the execution for 10 seconds
        //Thread.sleep(10000);

        // Get the start time before navigating to the page
        long startTime = System.currentTimeMillis();

        // Find the Flipkart link and click on it
        WebElement flipkartLink = driver.findElement(By.partialLinkText("Flipkart"));
        flipkartLink.click();
        
        // Wait for Flipkart website to load
        Thread.sleep(5000); // Adjust the time based on your network speed and page load time
        
        // Get the end time after the page has loaded
        long endTime = System.currentTimeMillis();

        // Calculate the page load time
        long pageLoadTime = endTime - startTime;

        // Display the page load time in console output
        System.out.println("Page load time: " + pageLoadTime + " milliseconds");
        
        // Once on the Flipkart website, locate the search box and enter the search query "iPhone 13" under the "Mobile" category
        WebElement flipkartSearchBox = driver.findElement(By.name("q"));
        flipkartSearchBox.sendKeys("iPhone 13 mobile");
        flipkartSearchBox.sendKeys(Keys.RETURN);
        
        //After the images loaded, display the screen height for the image and display in the output
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return window.innerHeight";
        Long screenHeight = (Long) js.executeScript(script);
        System.out.println("Screen height for the loaded images: " + screenHeight + " pixels");
        
        // Thread.sleep(10000);
        
        // Scroll the page
        // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Scroll the page
        // js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        
        // Scroll the page
        double initialScrollHeight = Long.parseLong(js.executeScript("return document.body.scrollHeight").toString());
        double currentScrollHeight = 0;
        double newScrollHeight = initialScrollHeight;
        do {
            js.executeScript("window.scrollBy(0, 100)");
            Thread.sleep(500); // Add a delay of 500 milliseconds between each scroll action
            currentScrollHeight = newScrollHeight;
            newScrollHeight = Double.parseDouble(js.executeScript("return window.pageYOffset").toString());
        } while (newScrollHeight != currentScrollHeight);


        // Close the browser
        driver.quit();
	}

}
