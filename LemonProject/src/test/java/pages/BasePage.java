package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {
    
    protected static WebDriver driver;
    private String CERO = "0";

    //NOTE: Static block to create the driver and use it in all other pages
    static{
        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "/Users/ezequiel.i.schwemmer/Documents/chromedriver");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    private WebElement Find (String locator){
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement (String locator){
        Find(locator).click();
    }

    public void write (String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public String todayDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd");

        Date date = new Date();

        String date1 = dateFormat.format(date);

        return date1;
    }

    public String textForElement(String locator){
        return Find(locator).getText();
    }

    public void selectOptionList(String locator, String locatorOptions, String option) {
        
        if(!option.equals(CERO)){
            // Open the dropdown so the options are visible
            Find(locator).click();
            // Get all of the options
            List<WebElement> options = driver.findElements(By.xpath(locatorOptions));
            // Loop through the options and select the one that matches
            for (WebElement opt : options) {
                System.out.println(opt.getText());
                if (opt.getText().equals(option)) {
                    opt.click();
                    return;
                }
            }
            throw new NoSuchElementException("Can't find " + option + " in dropdown");
        }
 }

    public int stringToInt (String textToConvert) {  
        //I keep only the numerical part of the text
        textToConvert = textToConvert.replaceAll("[^0-9]", "");
        //and convert it to int
        int i = Integer.parseInt(textToConvert);  

        return i;
    }

    public float stringToFloat (String textToConvert) {  
        float i = 0;
            try{
                textToConvert = textToConvert.replace("$", "").replaceAll(",", "");
                i = Float.parseFloat(textToConvert);
            }catch(NumberFormatException e) {
                e.printStackTrace();
            }
        return i;
    }

    public void enabledPayNowButtonAndClick(String locator){
        //This was the only way i found to enable the button
        WebElement button = Find(locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled','disabled')",button);

        button.click();
    }
    
    static public void customFormat(String pattern, float value ) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        myFormatter.format(value);
     }

}
