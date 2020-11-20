package Tests;

import Suporte.Web;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class RealizarComprasTest {
    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome();

        // Digitar no campo id "user-name" e preencher com "standard_user"
        navegador.findElement(By.id("user-name")).sendKeys("standard_user");

        // Digitar no campo "password" e preencher com "secret_sauce"
        navegador.findElement(By.id("password")).sendKeys("secret_sauce");

        // CLicar em "LOGIN" que tem o id "login-button"
        navegador.findElement(By.id("login-button")).click();


    }

    @Test
    public void testRealizarUmaCompra() {

        // Clicar em um produto aleatório no campo id
        navegador.findElement(By.id("item_2_title_link")).click();

        // Clicar no botão através do seu XPath "ADD TO CART"
        navegador.findElement(By.xpath("//div[@id=\"inventory_item_container\"]//button[@class=\"btn_primary btn_inventory\"]")).click();

        // Clicar no ícone do carrinho para realizar a finalização da compra
        navegador.findElement(By.id("shopping_cart_container")).click();

        // Avançar para finalizar a compra clicando no botão CHECKOUT
        WebElement linkCheckout = navegador.findElement(By.linkText("CHECKOUT"));
        linkCheckout.click();

        // Clicar no campo id "first name" e preencher com "Caroline"
        navegador.findElement(By.id("first-name")).sendKeys("Caroline");

        // Clicar no campo id "last name" e preencher com "Magalhães"
        navegador.findElement(By.id("last-name")).sendKeys("Magalhães");

        // Clicar no campo id "postal-code" e preencher com "03590-060"
        navegador.findElement(By.id("postal-code")).sendKeys("03590-060");

        // Clicar no botão "CONTINUE" através do seu XPath
        navegador.findElement(By.xpath("//div[@class=\"checkout_buttons\"]//input")).click();

        // Clicar em FINISH para finalizar o pedido
        WebElement linkFinish = navegador.findElement(By.linkText("FINISH"));
        linkFinish.click();

        // Validar a mensagem apresentada na tela “THANK YOU FOR YOUR ORDER”
        WebElement completeheader = navegador.findElement(By.className("complete-header"));
        String mensagem = completeheader.getText();
        assertEquals("THANK YOU FOR YOUR ORDER", mensagem);
    }

    @After
    public void tearDown() {
        // Fechar o navegador
        navegador.quit();

    }
}
