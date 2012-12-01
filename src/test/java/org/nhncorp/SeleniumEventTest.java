package org.nhncorp;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumEventTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void testKeyEvent() throws InterruptedException {
        driver.get("http://www.naver.com"); // www.naver.com 으로 이동한뒤
        Actions action = new Actions(driver);
        // Selenium 입력후 Enter 키를 입력
        action.sendKeys(driver.findElement(By.name("query")), "Selenium")
                .sendKeys(Keys.ENTER).build().perform();

    }

    @After
    public void after() {
        driver.quit(); // 브라우저 닫기
    }
}
