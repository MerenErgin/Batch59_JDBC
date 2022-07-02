Feature: US1005 Kullanici databasede update yapar

  Scenario: TC05 Kullanici update yapabilmeli

    Given kullanici DB UTils ile HMC veri tabanina baglanir
    Then tHOTEL tablosunda IDHotel degeri 1035 olan kaydin Email bilgisini "merhaba@gmail.com" yapar
    # update tHOTEL set Email='merhaba@gmail.com' where IDHotel=1035;