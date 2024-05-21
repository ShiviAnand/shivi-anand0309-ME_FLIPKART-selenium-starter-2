package demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

   // @AfterMethod
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    @Test(enabled = false)
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.flipkart.com/");
        HomePage page =  new HomePage(driver);
        page.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")), "Washing Machine");
        
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
        List<WebElement> rating =  driver.findElements(By.xpath("//div[@class='KzDlHZ']//parent::div//child::div[@class='XQDdHH']"));
        Map<String, Double> map =  new HashMap();
        for(int i = 0; i< list.size(); i++){
            double num = Double.parseDouble(rating.get(i).getText());
          map.put(list.get(i).getText(), num);
        }   
        for(Map.Entry<String, Double> me: map.entrySet()){
            if(me.getValue()<= 4)
            System.out.println(me.getKey()+ ": "+ me.getValue());
        }
        System.out.println("end Test case: testCase02");
    }

    @Test(enabled = false)
    public  void testCase02(){
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.flipkart.com/");
        HomePage page =  new HomePage(driver);
        page.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")), "iPhone");
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
        List<WebElement> rating =  driver.findElements(By.xpath("//div[@class='UkUFwK']//span"));
        
        Map<String, Integer> map =  new HashMap();
        for(int i = 0; i< list.size(); i++){
          String dis =  rating.get(i).getText();
          int num =  Integer.parseInt(dis.replaceAll("[^0-9]", ""));
          map.put(list.get(i).getText(), num);
        }   
        for(Map.Entry<String, Integer> me: map.entrySet()){
            if(me.getValue() > 17)
            System.out.println(me.getKey()+ ": "+ me.getValue());
        }
        System.out.println("end Test case: testCase02");
    }
    @Test
    public  void testCase03()throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.flipkart.com/");
        HomePage page =  new HomePage(driver);
        page.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")), "Coffee Mug");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        page.clickElement(driver.findElement(By.xpath("//section[@class='-5qqlC _2OLUF3']//label[@class='tJjCVx _3DvUAf']//div[@class='_6i1qKy'][contains(text(),'4')]")));
        
        List<WebElement> list = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
        List<WebElement> imgUrl = driver.findElements(By.xpath("//a[@class='wjcEIp']//parent::div//img[@class='DByuf4']"));
        List<WebElement> reviews = driver.findElements(By.xpath("//span[@class='Wphh3N']"));
        for(int i =0;i<5;i++){
            System.out.println(list.get(i).getText());
            System.out.println(imgUrl.get(i).getAttribute("src"));
           
        }
       
        System.out.println("end Test case: testCase03");
    }
        
        
    }


