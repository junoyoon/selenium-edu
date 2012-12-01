package org.nhncorp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBasicTest {

    private ChromeDriver driver;
    private WebDriverWait wait;

    @Before
    public void before() {
        driver = new ChromeDriver(); // 크롬 시동
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void testGoogle() {
        driver.get("http://www.google.com"); // 구글로 이동
        driver.findElement(By.name("q")).sendKeys("Selenium"); // 검색 페이지에 검색어 입력
        wait.until(titleContains("selenium")); // 브라우저 타이틀에 selenium이 나타낼때까지 대기
        assertThat(driver.getPageSource(), containsString("Automation")); // 결과검증
    }

    @Test
    public void testGoogleRedirection() {
        // 구글로 이동
        driver.get("http://google.com");
        // 잘 리다이렉션 되었는지 검증
        assertThat(driver.getCurrentUrl(), is("http://www.google.co.kr/"));
    }

    @After
    public void after() {
        driver.quit(); // 브라우저 닫기
    }
}
