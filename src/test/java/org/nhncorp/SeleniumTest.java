package org.nhncorp;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {
    WebDriver webDriver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(webDriver, 30);
    @Before
    public void before() {
        
        webDriver.get("http://www.google.com"); 
        
        
        WebElement element = webDriver.findElement(By.id("coolestWidgetEvah"));
        
        List<WebElement> cheeses = webDriver.findElements(By.className("cheese"));
        
        WebElement frame = webDriver.findElement(By.tagName("iframe"));
        
        WebElement cheese = webDriver.findElement(By.name("cheese"));
        
        
        // Chrome 브라우저 실행후 구글 페이지로 이동
        
        new WebDriverWait(webDriver, 30).until(ExpectedConditions.titleContains("google"));   
        
    }
    @Test
    public void testGoogle() {
        webDriver.findElement(By.name("q")).sendKeys("Selenium");   // 검색 페이지에 검색어 입력
        webDriver.findElement(By.name("btnG")).click();                     // 검색 버튼 클릭
        wait.until(titleContains("selenium"));                                       // 브라우저 타이틀에 selenium이 나타낼때까지 대기
        assertThat(webDriver.getPageSource(), containsString("Selenium - Web Browser Automation"));    // 결과 검증
    }
    
    @After
    public void after() {
        webDriver.quit(); // 브라우저 닫기
    }
}
