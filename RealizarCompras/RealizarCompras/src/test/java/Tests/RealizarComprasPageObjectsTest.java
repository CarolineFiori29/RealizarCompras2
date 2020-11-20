package Tests;

import Suporte.Web;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginFormPage;

import static org.junit.Assert.assertEquals;

public class RealizarComprasPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome();
    }

    @Test
    public void testRealizarUmaCompra() {
        String CompleteHeader = new LoginFormPage(navegador)
                .typeUsername("standard_user")
                .typePassword("secret_sauce")
                .clicarLogin()
                .clicarProduto()
                .clicarAddToCart()
                .clicarCarrinho()
                .clicarCheckout()
                .typeFirstName("Caroline")
                .typeLastName("Magalhaes")
                .typePostalCode("03590-060")
                .clicarContinue()
                .clicarFinish()
                .capturarCompleteHeader();

        assertEquals("THANK YOU FOR YOUR ORDER", CompleteHeader);

    }

    @After
    public void tearDown() {
        navegador.quit();
    }

}


