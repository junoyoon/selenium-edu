package org.nhncorp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumJavaScriptAlertTest {
    private ChromeDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver(); // 크롬 시동
    }

    @Test
    public void testAlert() {
        driver.get("https://user.daum.net/finduser/findid.do"); // 다음으로 이동
        driver.findElement(By.id("find_next")).click();
        Alert alert = driver.switchTo().alert();
        assertThat(alert.getText(), is("이름을 입력해 주세요."));
        alert.accept();
    }

    @After
    public void after() {
        driver.quit();
    }

}
