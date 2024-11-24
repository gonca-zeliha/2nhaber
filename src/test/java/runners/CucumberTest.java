package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",  // Features dosya yolu
        glue = "stepDefinitions",            // Step definitions dosya yolu
        tags = "@Navbar or @Search",         // Yalnızca Navbar ve Search testleri çalış
        plugin = {
                "pretty",                         // Konsolda test çıktısını güzel bir formatta gösterir
                "html:target/cucumber-reports.html" // HTML raporu oluşturur
        }
)
public class CucumberTest {  // Test kelimesi eklendi
        // Bu sınıf, Cucumber testlerini çalıştırmak için kullanılır.
}
