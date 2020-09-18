package tests;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.*;

public class SetupTest extends BaseTests{
    @Test
    public void testOpeningBrowserAndLoadPage(){
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a url!");
    }

    @Test
    public void testLogin(){
        Browser.getCurrentDriver().findElement(By.className("login")).click();
        System.out.println("Clicou em Sign In e direcionou para a página de login");
        System.out.println("Click login");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));
        Browser.getCurrentDriver().findElement(By.id("email")).sendKeys("anderson@gmail.com");
        System.out.println("Preencheu o e-mail");
        Browser.getCurrentDriver().findElement(By.id("passwd")).sendKeys("teste123");
        System.out.println("Preencheu a senha");
        Browser.getCurrentDriver().findElement(By.id("SubmitLogin")).click();
        System.out.println("Clicou em Sign In");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
        System.out.println("Validou a url de minha conta");
        assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
        System.out.println("Validou minha conta no site");
    }

    @Test
    public void testSearch(){

        String quest = "DRESS";
        String questResultQtd = "7";

        //Iniciar as páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();

        //Fazer a pesquisa
        home.doSearch(quest);

        //Validar a Pesquisa
        assertTrue(search.isSearchPage());
        assertEquals(search.getTextLighter().replace("\"",""), quest);
        assertThat(search.getTextHeading_counter(), CoreMatchers.containsString(questResultQtd));

    }

    @Test
    public void testSelectProduct1(){

        String description = "Long printed dress with thin adjustable straps.";

        // Iniciar Páginas
        SearchPage search = new SearchPage();
        ProductPage product = new ProductPage();

        //realizar o testSearch
        testSearch();

        //clicar no primeiro produto
        search.clickProduct_1();

        //validar a página
        assertEquals(product.getTextOur_price_display(), "$28.98");
        assertEquals(product.getTextProduct_reference(),"demo_5");
        assertThat(product.getTextShort_description_content(), CoreMatchers.containsString(description));
    }

    @Test
    public void testAddToCart(){
        //Iniciar Páginas
        ProductPage product = new ProductPage();
        CartPage cart = new CartPage();

        //Realizar testSelectProduct1
        testSelectProduct1();

        //Adicionar produto ao carrinho
        product.clickAdd_to_cart();

        //Seguir para o carrinho
        product.clickProceed_to_checkout();

        //Validar se o produto foi adicionado ao carrinho
        assertTrue(cart.isCartPage());
        assertEquals(cart.getTextCart_ref(), "SKU : demo_5");
        assertEquals(cart.getTextTotal_price(), "$30.98");


    }
}
