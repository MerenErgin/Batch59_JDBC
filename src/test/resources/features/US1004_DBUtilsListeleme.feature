Feature: US1004 Kullanici istenen tablodaki istenen field'i listeleyebilir

  Scenario: TC04 Kullanici field listesi yazdirabilmeli

    Given kullanici DB UTils ile HMC veri tabanina baglanir
    And kullanici DB UTils ile "tHOTEL" tablosundaki "Email" verilerini alir
    And kullanici DB UTils ile "Email" sutunundaki verileri okur
    And DBUtil ile tum "Email" degerlerini sira numarasi ile yazdirir