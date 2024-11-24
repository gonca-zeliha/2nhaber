Feature: Navbar testi
  Kullanıcı navbar üzerindeki tüm elemanlara tıklayarak sayfaların doğru açıldığını kontrol eder.

  Scenario: Navbar elemanlarının kontrolü
    Given Kullanıcı 2NHaber sitesini ziyaret eder
    When Kullanıcı navbar üzerindeki tüm elemanlara tıklar
    Then Tüm sayfaların sorunsuz açıldığı kanıtlanır
