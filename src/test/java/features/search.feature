Feature: Haber arama
  Kullanıcı arama yaparak belirli bir haberin detay sayfasına gider.

  Scenario: Arama ve haber detayına gitme
    Given Kullanıcı 2NHaber ana sayfasını açar
    When Kullanıcı arama butonuna tıklar
    And Kullanıcı arama kutusuna "İstanbul" yazar ve Enter'a basar
    Then Kullanıcı 8. haberin detay sayfasına gider
