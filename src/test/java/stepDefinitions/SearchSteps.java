package stepDefinitions;

import pages.SearchPage;
import io.cucumber.java.en.*;
import utilities.Driver;

public class SearchSteps {

    SearchPage searchPage = new SearchPage();

    @Given("Kullanıcı 2NHaber ana sayfasını açar")
    public void kullanici_2nhaber_ana_sayfasini_acar() {
        Driver.getDriver().get("https://2nhaber.com/");
        System.out.println("2NHaber ana sayfası açıldı.");
    }

    @When("Kullanıcı arama butonuna tıklar")
    public void kullanici_arama_butonuna_tiklar() {
        searchPage.clickSearchButton();
    }

    @And("Kullanıcı arama kutusuna \"İstanbul\" yazar ve Enter'a basar")
    public void kullanici_arama_kutusuna_istanbul_yazar_ve_enter_a_basar() {
        searchPage.enterSearchText("İstanbul"); // İstanbul yazılır ve arama yapılır
    }

    @Then("Kullanıcı 8. haberin detay sayfasına gider")
    public void kullanici_haberin_detay_sayfasina_gider(int haberIndex) {
        searchPage.goToNewsDetail(haberIndex); // 8. haber ya da belirtilen herhangi bir haber açılır
    }
}
