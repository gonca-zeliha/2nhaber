package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class NavbarPage {
    WebDriver driver;

    // Parametresiz constructor
    public NavbarPage() {
        this.driver = Driver.getDriver(); // Driver'ı otomatik olarak al
    }

    // Navbar elemanlarını buluyoruz - tüm ana başlıklar
    private final By navbarItems = By.cssSelector("nav a");

    public void clickAllNavbarItems() {
        List<WebElement> elements = driver.findElements(navbarItems);

        if (elements.isEmpty()) {
            System.out.println("Navbar öğesi bulunamadı.");
            return;
        }

        for (WebElement element : elements) {
            try {
                // Sayfayı öğenin üzerine kaydırıyoruz
                new WebDriverWait(driver, Duration.ofSeconds(20))
                        .until(ExpectedConditions.visibilityOf(element)); // Öğenin görünür olmasını bekliyoruz
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", element); // Öğeye kaydır

                // Öğenin tıklanabilir olmasını bekliyoruz
                new WebDriverWait(driver, Duration.ofSeconds(20))
                        .until(ExpectedConditions.elementToBeClickable(element));

                System.out.println("Tıklanıyor: " + element.getText());
                element.click();

                // Sayfa kontrolü ( URL kontrolü)
                if (driver.getCurrentUrl() != null && driver.getCurrentUrl().contains("2nhaber")) {
                    System.out.println("Sayfa açıldı: " + driver.getCurrentUrl());
                } else {
                    System.err.println("Sayfa açılmadı: " + element.getText());
                }

                // Sayfaya geri dön
                driver.navigate().back();

                // Sayfaya geri dönüldükten sonra navbar öğelerinin tekrar görünür olmasını bekleyelim
                new WebDriverWait(driver, Duration.ofSeconds(20))
                        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(navbarItems));

            } catch (Exception e) {
                System.err.println("Hata oluştu: " + e.getMessage());
            }
        }
    }
}
