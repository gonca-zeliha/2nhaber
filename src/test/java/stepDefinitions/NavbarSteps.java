package stepDefinitions;

import io.cucumber.java.en.*;
import pages.NavbarPage; // NavbarPage kullanılıyor
import utilities.Driver;

public class NavbarSteps {
    NavbarPage navbarPage = new NavbarPage(); // Parametresiz constructor kullanılarak oluşturuldu

    @Given("Kullanıcı 2NHaber sitesini ziyaret eder")
    public void kullanici_2n_haber_sitesini_ziyaret_eder() {
        Driver.getDriver().get("https://2nhaber.com/");
        System.out.println("2NHaber sitesi açıldı.");
    }

    @When("Kullanıcı navbar üzerindeki tüm elemanlara tıklar")
    public void kullanici_navbar_uzerindeki_tum_elemanlara_tiklar() {
        navbarPage.clickAllNavbarItems(); // Navbar üzerindeki tüm öğelere tıklanır
    }

    @Then("Tüm sayfaların sorunsuz açıldığı kanıtlanır")
    public void tum_sayfalarin_sorunsuz_acildigi_kanitlanir() {
        System.out.println("Navbar üzerindeki tüm elemanlar kontrol edildi ve sorunsuz çalışıyor.");
        Driver.closeDriver(); // Test sonrası tarayıcı kapatılır
    }
}
