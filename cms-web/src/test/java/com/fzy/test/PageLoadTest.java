package com.fzy.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @program: PageLoadTest
 * @description:
 * @author: fzy
 * @date: 2018-11-04 15:07
 **/
public class PageLoadTest{

    private static final String CHROME_DRIVER="C:/Users/fzy/AppData/Local/Google/Chrome/Application/chromedriver.exe";

    public static void main(String[] args)throws Exception {
        //配置驱动路径
        System.setProperty("webdriver.chrome.driver",CHROME_DRIVER);
        //新建一个WebDriver 的对象，但是new 的是FirefoxDriver的驱动
        WebDriver driver =new ChromeDriver();
        //打开指定的网站
        driver.get("http://yun.pre.choicesaas.cn/index.html#/system/cloud/home?_k=ebmma3");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        //登陆
        driver.findElement(By.id("username")).sendKeys("18660166578");
        driver.findElement(By.id("password")).sendKeys("C123456");
        //登陆
        driver.findElement(By.id("login")).click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.findElement(By.linkText("供应链")).click();

        //退出浏览器
        driver.quit();
    }
}
