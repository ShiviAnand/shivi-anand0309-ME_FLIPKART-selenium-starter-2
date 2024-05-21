package demo;

import java.time.Duration;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    ChromeDriver driver; 
    HomePage(ChromeDriver driver){
             this.driver = driver;
    }


    public void sendKeys(WebElement ele, String s){
        WebDriverWait wait =  new WebDriverWait(driver , Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.sendKeys(s);
        ele.sendKeys(Keys.ENTER);

    }
    public void clickElement(WebElement ele) throws InterruptedException{
        Thread.sleep(4000);
        WebDriverWait wait =  new WebDriverWait(driver , Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.click();
        
    }  
    public void actionClick(WebElement ele) throws InterruptedException{
        Thread.sleep(4000);
       Actions action = new Actions(driver); 
       action.moveToElement(ele).click();
    }  
}
