Feature: US1002 kullanici DB Utils ile database baglanabilmelidir

  @DBUtils
  Scenario: TC01 Kullanici DB Utils ile database'deki bilgileri okur

    Given kullanici DB UTils ile HMC veri tabanina baglanir
    And kullanici DB UTils ile "tHOTELROOM" tablosundaki "Price" verilerini alir
    # SELECT Price FROM tHOTELROOM
    And kullanici DB UTils ile "Price" sutunundaki verileri okur