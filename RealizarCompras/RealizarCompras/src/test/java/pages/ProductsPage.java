package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver navegador) {
        super(navegador);
    }


    public SelectPage clicarProduto() {
        navegador.findElement(By.id("item_2_title_link")).click();
        return new SelectPage (navegador);

    }
}
