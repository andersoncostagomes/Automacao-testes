package tests;

        import io.qameta.allure.Feature;
        import io.qameta.allure.Story;
        import org.hamcrest.CoreMatchers;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import pageObjects.*;
        import utils.Browser;
        import utils.Utils;

        import java.util.concurrent.TimeUnit;

        import static org.junit.Assert.*;
        import static utils.Browser.driver;

@Feature("Realizar os testes")
public class SetupTest extends BaseTests{
    @Test
    @Story("Abrir o site")
    public void testOpeningBrowserAndLoadPage(){
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a url!");
    }

    @Test
    @Story("Realizar o login")
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

    @Test
    public void testAcessCategoryTShirts(){
        // Iniciar as páginas
        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();

        // Clicar na categoria T-Shirts
//           home.clickCategoryTShirts();
        Browser.getCurrentDriver().findElement(By.linkText("T-SHIRTS")).click();

        //Validar se ao clicar na categoria T_SHIRTS ocorre o direcionamento correto
        assertTrue(category.isPageTshirts());
    }

    @Test
    public void testAddProductToProductPage(){
        // Acessar a categoria T-Shirts
        testAcessCategoryTShirts();

        //Iniciar as páginas
        CategoryPage category = new CategoryPage();
        ProductPage pdp = new ProductPage();

        // Salva o nome do produto na página de categora
        String nameProductCategory = category.getProductNameCategory();

        //Clicar em More e direcionar para a página do produto
        category.clickProductAddToProductPage();

        // Vadidar se produto está na página de detalhes do produto corretamente
        assertTrue(pdp.getProductNamePDP().equals(nameProductCategory));

    }

    @Test
    public void  testAddProductToCartPage(){
        //Acessar a página de produto
        testAddProductToProductPage();

        // Iniciar as páginas
        ProductPage pdp = new ProductPage();
        CartPage cart = new CartPage();

        //Salvar o nome do produto na página PDP
        String nameProductPDP = pdp.getProductNamePDP();

        //Clicar no botão de Adicionar ao carrinho
        pdp.clickButtonAddToCart();

        //Clicar no botão Proceed To Checkout na modal
        pdp.clickButtonModalProceedToCheckout();

        //Validação do nome do produto no carrinho
        assertTrue(cart.getNameProductCart().equals(nameProductPDP));
    }

    @Test
    public void testCreateNewAccount(){

        //Trocar o e-mail sempre que realizar um teste
        String email = "testauto7@gmail.com";
        String firstName = "Test";
        String lastName = "Auto";
        String password = "test123";
        String day = "9";
        String month = "August";
        String year = "1991";
        String company = "CWI Software";
        String address = "18, Kameria St";
        String city = "Denver";
        String state = "Colorado";
        String code = "12345";
        String mobile = "1122334455";

        //Iniciar Páginas
        HomePage home = new HomePage();
        AuthenticationPage authentication = new AuthenticationPage();
        CreateAccountPage createAccount = new CreateAccountPage();
        MyAccountPage myAccount = new MyAccountPage();

        //Clicar no botão de sign in
        home.clickBtnLogin();
        System.out.println("Clicou no botão sign in");

        //Validar Authentication Page
        assertTrue(authentication.isAuthenticationPage());
        System.out.println("Validou a Authentication Page");

        //Preencher e-mail e clicar no botão create an account
        authentication.submitEmail(email);
        System.out.println("Preecheu o campo e-mail e clicou no botão create an account");

        //Preencher formulário e clicar no botão Register
        createAccount.submitFormulary (firstName, lastName, password, day, month, year, company, address, city, state, code, mobile);
        System.out.println("Preencheu o formulário e clicou no botão Register");

        //Validar a página da conta do usuário
        assertTrue(myAccount.isMyAccountPage());
        assertTrue(myAccount.getTextAccountName().contains(firstName));
        assertEquals(myAccount.getTextInfo_account(), "Welcome to your account. Here you can manage all of your personal information and orders.");
        System.out.println("Validou a página da conta do usuário ");
    }
}
