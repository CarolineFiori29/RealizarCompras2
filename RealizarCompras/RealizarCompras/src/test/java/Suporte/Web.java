package Suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome() {
    // Abrindo o navegador
    System.setProperty("webdriver.chrome.driver","C:\\Users\\Carol\\Drivers\\chromedriver.exe");
    WebDriver navegador = new ChromeDriver();
    navegador.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);


    // Navegar para a página https://www.saucedemo.com/index.html
    navegador.get("https://www.saucedemo.com/index.html ");

    return navegador;
    }

}

