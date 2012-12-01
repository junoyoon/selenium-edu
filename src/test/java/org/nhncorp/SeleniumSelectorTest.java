package org.nhncorp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumSelectorTest {

    private ChromeDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver(); // 크롬 시동
    }

    @Test
    public void testIFrame() {
        driver.get("http://blog.daum.net/01039964852"); // 다음으로 이동
        driver.switchTo().frame("BlogMain"); // 하위 프레임으로 먼저 이동
        driver.findElement(By.id("historyStorageForm")).submit();
    }

    @After
    public void after() {
        driver.quit(); // 브라우저 닫기
    }
}
