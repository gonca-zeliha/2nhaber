package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class SearchPage {
    WebDriver driver;

    private final By searchButton = By.cssSelector("button.search-btn"); // Arama butonu
    private final By searchInput = By.cssSelector("input.search-input"); // Arama kutusu
    private final By newsItems = By.cssSelector(".news-list-item"); // Haber listesi

    public SearchPage() {
        this.driver = Driver.getDriver();
    }

    // Arama butonuna tıklama işlemi
    public void clickSearchButton() {
        WebElement searchBtn = driver.findElement(searchButton);
        searchBtn.click();
        System.out.println("Arama butonuna tıklandı.");
    }

    // Arama kutusuna metin yazma ve arama yapma işlemi
    public void enterSearchText(String query) {
        WebElement searchBox = driver.findElement(searchInput);
        searchBox.sendKeys(query);  // Arama metni (İstanbul) yazılır
        searchBox.submit();         // Enter tuşu ile arama yapılır
        System.out.println("Arama yapıldı: " + query);
    }

    // Belirtilen sıradaki haberin detayına gitme
    public void goToNewsDetail(int newsIndex) {
        WebElement news = driver.findElements(newsItems).get(newsIndex - 1); // Haber numarasına göre seçim
        String newsTitle = news.getText(); // Haber başlığını alıyoruz
        news.click(); // Habere tıklıyoruz
        System.out.println("Haber detay sayfasına gidildi: " + newsTitle);
    }
}
